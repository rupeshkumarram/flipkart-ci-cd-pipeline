package utilities;

import java.util.concurrent.TimeUnit;

import org.influxdb.dto.Point;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExecutionListener implements ITestListener{
	
	public void onTestStart(ITestResult iTestResult) {

    }

    public void onTestSuccess(ITestResult iTestResult) {
        this.sendTestMethodStatus(iTestResult, "PASS");
    }

    public void onTestFailure(ITestResult iTestResult) {
        this.sendTestMethodStatus(iTestResult, "FAIL");
    }

    public void onTestSkipped(ITestResult iTestResult) {
        this.sendTestMethodStatus(iTestResult, "SKIPPED");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {

    }

    public void onFinish(ITestContext iTestContext) {
      //  this.sendTestClassStatus(iTestContext);
    }

    private void sendTestMethodStatus(ITestResult iTestResult, String status) {
        Point point = Point.measurement("status")
                .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
                .tag("name", iTestResult.getName())
                .addField("result", status)
                .build();
        ResultSender.send(point);
    }

	/*
	 * private void sendTestClassStatus(ITestContext iTestContext) { Point point =
	 * Point.measurement("status2") .time(System.currentTimeMillis(),
	 * TimeUnit.MILLISECONDS) .tag("name",
	 * iTestContext.getAllTestMethods()[0].getTestClass().getName())
	 * .addField("duration", (iTestContext.getEndDate().getTime() -
	 * iTestContext.getStartDate().getTime())) .build(); ResultSender.send(point); }
	 */

}

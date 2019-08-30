package webRegression;

import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;

public class DataUploadInInfluxDB {
	
private InfluxDB influxDB;
	
	public InfluxDB getInfluxDB() {
		InfluxDB db = InfluxDBFactory.connect("http://localhost:8086", "root", "root");
		db.setDatabase("selenium");
		return db;
	}

}

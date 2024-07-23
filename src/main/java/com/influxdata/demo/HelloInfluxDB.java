package com.influxdata.demo;

import com.influxdb.v3.client.InfluxDBClient;
import com.influxdb.v3.client.Point;
import com.influxdb.v3.client.query.QueryOptions;
import com.influxdb.v3.client.query.QueryType;

import java.time.Instant;
import java.util.stream.Stream;

public class HelloInfluxDB {
  private static final String HOST_URL = "https://eu-central-1-1.aws.cloud2.influxdata.com"; // URL information is present in the cloud portal
  private static final String DATABASE = "java"; // Database name is the bucket name present in the cloud portal
  private static final char[] API_TOKEN = "API_TOKEN".toCharArray(); // Avoid hard-coding API_TOKEN in production. It is present in the cloud portal.

  // Authenticate, Write and Query data from the serverless InfluxDB
  public static void main(String[] args) {
    try (InfluxDBClient client = InfluxDBClient.getInstance(HOST_URL, API_TOKEN, DATABASE)) {
      writeData(client);
      queryData(client);
    }
    catch (Exception e) {
      System.err.println("An error occurred while connecting with the serverless InfluxDB!");
      e.printStackTrace();
    }
  }

  // Write sample measurement using Point class API
  private static void writeData(InfluxDBClient client) {
    Point point = Point.measurement("temperature")
                       .setTag("location", "London")
                       .setField("value", 30.01)
                       .setTimestamp(Instant.now().minusSeconds(10));
    try {
      client.writePoint(point);
      System.out.println("Data written to the bucket.");
    }
    catch (Exception e) {
      System.err.println("Failed to write data to the bucket.");
      e.printStackTrace();
    }
  }

  // Query the latest 10 measurements using SQL
  private static void queryData(InfluxDBClient client) {
    System.out.printf("--------------------------------------------------------%n");
    System.out.printf("| %-8s | %-8s | %-30s |%n", "location", "value", "time");
    System.out.printf("--------------------------------------------------------%n");

    String sql = "select time,location,value from temperature order by time desc limit 10";
    try (Stream<Object[]> stream = client.query(sql)) {
      stream.forEach(row -> System.out.printf("| %-8s | %-8s | %-30s |%n", row[1], row[2], row[0]));
    }
    catch (Exception e) {
      System.err.println("Failed to query data from the bucket.");
      e.printStackTrace();
    }
  }
}

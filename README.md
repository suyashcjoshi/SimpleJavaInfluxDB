## Integrating with InfluxDB Cloud Serverless with Simple Java Apps

### Pre-requisites:

1. InfluxDB Cloud Serverless Account : You can create one for free from [here](https://cloud2.influxdata.com/signup).
2. Maven and JDK 17 or newer on your local machine.
3. Clone this GitHub repository and open the `HelloInfluxDB.java` file and update the configurations for **HOST_URL**, **DATABASE** and **API_TOKEN** that can be found in your InfluxDB Cloud webportal. It is recommened to store the API_TOKEN securely and not hard code for security reasons.
4. Build the project by running ```mvn clean package```
5. Run the appliocation by typing ```java --add-opens=java.base/java.nio=org.apache.arrow.memory.core,ALL-UNNAMED -jar target/{name of your jar file}.jar```

## What this project does?

This project shows how to connect a simple Java command line application created using [Maven](https://maven.apache.org) and the light weight [InfluxDB v3 client SDK](https://github.com/InfluxCommunity/influxdb3-java) by authenticating and then perform writing and querying of sample data to the cloud hosted bucket. 

The key class is *HelloInfluxDB.java* that has complete logic.

More sophisticated example using SpringBoot and Micronaut frameworks are coming soon!


## Calling InfluxDB Serverless cloud with Simple Java Apps

### Pre-requisites:

1. InfluxDB Account : You can create one for free from here.
2. Maven and JDK 17 or latest on your local machine
3. Clone this GitHub repository and open the `HelloInfluxDB.java` file and update the configurations for **HOST_URL**, **DATABASE** and **API_TOKEN** that can be found in your InfluxDB Cloud webportal. Make sure not to share the API_TOKEN in production or on GitHub, try to keep it for local use only.
4. Build the project by running ```mvn clean package```
5. Run the appliocation by typing ```java --add-opens=java.base/java.nio=org.apache.arrow.memory.core,ALL-UNNAMED -jar target/{name of your jar file}.jar```

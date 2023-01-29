# A Microservice Demo using spring boot & Eureka

## Architecture of this demo microservice

![Untitled drawio](https://user-images.githubusercontent.com/32014166/215334286-938a2ade-5637-4829-a1a4-afc354a09a77.png)



## Java Version
Used open-jdk **version 17** (https://openjdk.org/projects/jdk/17/)

## Build Tool
### We are using maven tool to build the project. You can download & install maven from official website (https://maven.apache.org/install.html)

## Making the build
### Download the source code using git ssh or https from https://github.com/souravkantha/microservice-demo

#### - [x] **Check if maven is installed by putting 'mvn' command in command prompt or terminal**
* Go the root directory i.e; **microservice-demo**
* Use command ```mvn clean package```. Upon successful build creation will show below like screenshot
   
<img width="587" alt="Screenshot 2023-01-29 at 7 35 23 PM" src="https://user-images.githubusercontent.com/32014166/215331454-127e64b5-3063-4677-b775-bce12f81976e.png">

* Start the Eureka Server for service discovery i.e; **microservice-discovery-server** by providing the following command
   ```java -jar microservice-discovery-server/target/discovery-1.0.jar```
   Upon successful start of the discovery server, you should see the something as below
   <img width="1423" alt="Screenshot 2023-01-29 at 7 40 26 PM" src="https://user-images.githubusercontent.com/32014166/215332110-fd1bfd28-e3f0-480e-9ada-768024024d71.png">
* We can access the default dashboard of Eureka Server
  at http://localhost:8761/
  
  <img width="1427" alt="Screenshot 2023-01-29 at 7 45 40 PM" src="https://user-images.githubusercontent.com/32014166/215332375-68bc4f0d-0b99-47de-a6ba-2140a42502a9.png">

* Now, start the VAT microservice in port 8081 & port 8082 using following command

   ```java -jar -Dserver.port=8081 microservice-vat-service/target/vat-1.0.jar```
   
   ```java -jar -Dserver.port=8082 microservice-vat-service/target/vat-1.0.jar```
   

* The VAT microservices will be auto registered to the service discovery and we can see it at http://localhost:8761/

<img width="1430" alt="Screenshot 2023-01-29 at 7 52 43 PM" src="https://user-images.githubusercontent.com/32014166/215332809-6145f341-978b-41bc-bd0c-4f7e53c019fc.png">






FROM openjdk:12-alpine

COPY target/inventoryList-*.jar /inventoryList.jar

EXPOSE: 8080 

ENTRYPOINT ["java" ,"-jar", "inventoryList.jar"]
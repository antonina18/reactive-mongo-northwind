FROM java:9
MAINTAINER M_K_Sowa
COPY reactive-mongo-northwind-1.0-SNAPSHOT.jar /target/reactive-mongo-northwind-1.0-SNAPSHOT.jar
CMD ["java","-jar","/targetreactive-mongo-northwind-1.0-SNAPSHOT.jar"]
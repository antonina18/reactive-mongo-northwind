FROM java:9
MAINTAINER M_K_Sowa
COPY target/reactive-mongo-northwind-1.0-SNAPSHOT.jar reactive-mongo-northwind.jar
CMD ["java","-jar","reactive-mongo-northwind.jar"]
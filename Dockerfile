FROM java:9
MAINTAINER M_K_Sowa
COPY target/reactive-mongo-northwind-1.0-SNAPSHOT.jar reactive-mongo-northwind.jar
ENV JAVA_CONF_DIR=$JAVA_HOME/conf

RUN bash -c '([[ ! -d $JAVA_SECURITY_DIR ]] && ln -s $JAVA_HOME/lib $JAVA_HOME/conf) || (echo "Found java conf dir, package has been fixed, remove this hack"; exit -1)'

CMD ["java","-jar","-Dspring.profiles.active=docker","reactive-mongo-northwind.jar"]
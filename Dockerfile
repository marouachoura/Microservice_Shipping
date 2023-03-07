FROM openjdk:8
LABEL maintainer="maroua"
ADD target/shipping.jar shipping.jar
ENTRYPOINT ["java","-jar","shipping.jar"]
EXPOSE 80
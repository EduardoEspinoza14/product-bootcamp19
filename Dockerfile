FROM openjdk:8
VOLUME /tmp
EXPOSE 80
ADD ./target/product-0.0.1-SNAPSHOT.jar product.jar
ENTRYPOINT ["java", "-jar", "product.jar"]

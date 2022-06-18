FROM openjdk:8
#VOLUME /tmp
EXPOSE 8091
ADD target/product.jar product.jar
ENTRYPOINT ["java", "-jar", "product.jar"]

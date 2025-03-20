FROM maven:latest
LABEL authors="gary"

WORKDIR /app

COPY pom.xml /app/

COPY . /app/

RUN mvn package

CMD ["java", "-jar", "target/shopping.jar"]

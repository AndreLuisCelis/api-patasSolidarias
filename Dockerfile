# Use uma imagem do JDK
FROM openjdk:17-jdk-alpine

# Crie um diretório para a aplicação
WORKDIR /app

# Copie o arquivo JAR da aplicação
COPY target/pataSolidariaApi-0.0.1-SNAPSHOT.jar app.jar

# Expõe a porta que a aplicação Spring Boot usa
EXPOSE 8080

# Comando para iniciar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
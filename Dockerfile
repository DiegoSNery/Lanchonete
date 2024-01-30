FROM amazoncorretto:8u402-alpine3.19-jre

# Instalando pacotes necessários
RUN apk update && \
    apk add openrc --no-cache && \
    apk add mysql mysql-client

# Criando o diretório para o socket
RUN mkdir -p /run/mysql && \
    chown -R mysql:mysql /run/mysql

# Inicializando o serviço MySQL
RUN openrc && \
    touch /run/openrc/softlevel && \
    rc-service mysql start && \
    mysql -e "CREATE DATABASE IF NOT EXISTS lanchonete;" && \
    mysql -e "CREATE USER IF NOT EXISTS 'lanchonete'@'localhost' IDENTIFIED BY '123456';" && \
    mysql -e "GRANT ALL PRIVILEGES ON lanchonete.* TO 'lanchonete'@'localhost';" && \
    mysql -e "FLUSH PRIVILEGES;" && \
    rc-service mysqld stop

WORKDIR /app

COPY target/*.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]

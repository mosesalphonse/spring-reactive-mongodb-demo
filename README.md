# spring-reactive-mongodb-demo

Sample Reactive API for CRUD operation in a Reactive style to connect to MongoDB using Spring Boot

## POC:
* Reactive API using Mono and Flex
* CRUD API for Mong DB

## Prerequisite

* JDK 17
* Maven 3.9
* Docker

Install JDK 17 in Linux:

```

wget https://download.oracle.com/java/17/latest/jdk-17_linux-x64_bin.tar.gz
sudo tar -xvf jdk-17_linux-x64_bin.tar.gz
sudo mv jdk-17.0.8 /opt/

JAVA_HOME='/opt/jdk-17.0.8'
PATH="$JAVA_HOME/bin:$PATH"
export PATH

```

Install Maven 3.9.X in Linux:

```
wget https://dlcdn.apache.org/maven/maven-3/3.9.4/binaries/apache-maven-3.9.4-bin.tar.gz
sudo tar -xvf apache-maven-3.9.4-bin.tar.gz
sudo mv apache-maven-3.9.4 /opt/

export M2_HOME=/opt/apache-maven-3.9.4
export PATH=${M2_HOME}/bin:${PATH}

```


# Run Mongo DB on local using Docker and access it:

```

docker run -p 127.0.0.1:27017:27017/tcp --name mongo -d mongodb/mongodb-community-server:latest

docker exec -it mongo mongosh

```
# Download the code, compile and run in Local (in a seperate terminal):

```
Git clone https://github.com/mosesalphonse/spring-reactive-mongodb-demo.git

cd spring-reactive-mongodb-demo

mvn spring-boot:run

```

# Verify :

1) create terminal using curl /postman/ any http client

```
curl -d '{"code" : "C123986", "name" : "Africa"}' -H "Content-Type: application/json" -X POST http://localhost:8080/api/terminals

```

verify ther terminal list (GET)

```
http://localhost:8080/api/terminals

http://localhost:8080/api/terminals?name=Africa

http://localhost:8080/api/terminals/{id}

http://localhost:8080/api/terminals/enabled

```

Some usefull Mongo command:

```
use {dbname}

show dbs

show collections

db.{collection}.find()

db.{collection}.insert({payload})

db.{collection}.insertMany({payload})

db.{collection}.drop

```



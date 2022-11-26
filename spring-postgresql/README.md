## Spring Boot PostgreSQL

### Swagger : Open API Spesicifation 

1. Add Dependency

```
<dependency>
     <groupId>org.springdoc</groupId>
     <artifactId>springdoc-openapi-ui</artifactId>
     <version>1.6.13</version>
</dependency>
```
2. Create OpenAPI Bean

```
 @Bean
    public OpenAPI customopenAPI(@Value("${application-description}") String description,
                                 @Value("${application-version}") String version){
        return new OpenAPI()
                .info(new Info()
                        .title("Spring Examples API")
                        .version(version)
                        .description(description)
                        .license(new License().name("Spring Example API Lisence")));
    }
```

3.
```
http://localhost:8080/swagger-ui/index.html
```

![image](https://user-images.githubusercontent.com/78444522/204109195-315a74bc-3096-40da-afc9-483f062014a6.png)


### Docker Setup

1.  Docker Image Download

```
docker pull postgres
```

2. Docker Container Run

```
docker run --name <containerName> -e POSTGRES_PASSWORD=<password> -e POSTGRES_USER=<user> -d -p 5432:5432 <imageName
```

3. Connecting to PostgreSQL Database Command Line Windows

```
docker exec -it <containerName` psql -U <username>
```

4. Create New Database


```
CREATE DATABASE springdb;
```

5. List of Databases

```
\l
```
![image](https://user-images.githubusercontent.com/78444522/204109226-8855949f-7114-4dac-9f4d-9f8558d58eb1.png)



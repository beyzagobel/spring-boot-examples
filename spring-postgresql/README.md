## Spring Boot PostgreSQL



### Docker Setup

1.  Docker Image Download

`docker pull postgres`

2. Docker Container Run

`docker run --name <containerName> -e POSTGRES_PASSWORD=<password> -e POSTGRES_USER=<user> -d -p 5432:5432 <imageName`

3. Connecting to PostgreSQL Database Command Line Windows

`docker exec -it <containerName` psql -U <username>

4. Create New Database

`CREATE DATABASE springdb;`

5. List of Databases

`\l`



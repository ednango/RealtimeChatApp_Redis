## Docker setup

### Microsoft SQL Server container running command
```sh
 docker run -d --name chatapp-postgres -e POSTGRES_PASSWORD=123 -e TZ=UTC -e 
PGTZ=UTC -p 5432:5432 postgres:16
```
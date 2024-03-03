run-db:
    docker build -t http4k-todo-mysql:latest .
    docker run -it --name todo-http4k -e MYSQL_ROOT_PASSWORD=root -d http4k-todo-mysql:latest
    docker exec -it /bin/bash
    mysql -u root -p

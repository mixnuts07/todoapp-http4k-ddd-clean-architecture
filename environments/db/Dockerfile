FROM mysql:8.0
ENV MYSQL_DATABASE public
ENV MYSQL_USER user
ENV MYSQL_PASSWORD user
ENV MYSQL_ROOT_PASSWORD root
COPY ./init.sql /docker-entrypoint-initdb.d
EXPOSE 3306:3306
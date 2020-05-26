FROM mysql
EXPOSE 3306
ENV MYSQL_ROOT_PASSWORD=secret
ENV MYSQL_DATABASE votes
ADD CreateDB.sql /docker-entrypoint-initdb.d/

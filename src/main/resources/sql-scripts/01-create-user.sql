CREATE USER 'kanbanuser'@'localhost' identified BY 'kanbanuser';

GRANT ALL privileges ON * . * TO 'kanbanuser'@'localhost';

ALTER USER 'kanbanuser'@'localhost' IDENTIFIED WITH mysql_native_password BY 'kanbanuser';
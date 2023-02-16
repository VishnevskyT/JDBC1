CREATE DATABASE MyNewDB;        -- Завдання 6: Создать базу данных в Workbench и подключить к IntelijIdea и создать тестовую таблицу.
                                -- Заполнить ее данными с помощью запросов MySQL в IntelijIdea. Используя JDBC написать пример выполнения всех запросов.
USE MyNewDB;

DROP DATABASE MyNewDB;

CREATE TABLE TestingTable(
  id INT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(50) NOT NULL,
  author VARCHAR(50) NOT NULL,
  total_pages INT,
  rating DECIMAL (4,2),
  publish_date DATE DEFAULT NULL
);



[![Build Status](https://app.travis-ci.com/bespalov0928/work_dreamjob.svg?branch=main)](https://app.travis-ci.com/bespalov0928/work_dreamjob)

## Описание

### О проекте
Приложение представляет биржу труда.
В системе два типа пользователей: кандидаты и кадровики. 
Кандидаты будут публиковать резюме. 
Кадровики будут публиковать вакансии о работе.

### Стек технологий
* Java 17
* PostgreSQL
* Liquibase
* JSP
* JSTL
* jacoco
* travic


### Сборка и запуск
Сборка
```
mvn liquibase:update
mvn install
```
запуск
```
java -jar target/work_forum-1.0.jar
```

### Как использовать
Регистрация нового пользователя
![ScreenShot](images/reg.png)

Аторизация
![ScreenShot](images/login.png)

Список кандидатов
![ScreenShot](images/listCandidates.png)

Добавление нового кандидата
![ScreenShot](images/createCandidate.png)

Загрузка фото кандидата
![ScreenShot](images/uploadFoto.png)

Список вакансий
![ScreenShot](images/listPosts.png)

Добавление новой вакансии
![ScreenShot](images/createPost.png)

### Контакты
Skype: bespalov0928



## Dog Service API
a collections of API that clone [dog.ceo API](https://dog.ceo/dog-api/) with additional features to create, update, and delete. 

## Features 
- API to fetch data from [dog.ceo API](https://dog.ceo/dog-api/) to local DB
- CRUD Rest API 
  - get list of breeds
  - get list of sub-breed of a breed
  - get dog images by breed-name
  - get dog images by breed-name and sub-breed name
  - add new breed
  - add new sub-breed
  - add new dog image of available breed and sub-breed
  - update and delete breed
  - update and delete sub-breed


# Integration test
[![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/16178423-e2365712-8fc4-4509-8f8a-2bd3fa22056b?action=collection%2Ffork&collection-url=entityId%3D16178423-e2365712-8fc4-4509-8f8a-2bd3fa22056b%26entityType%3Dcollection%26workspaceId%3D21a71018-9661-4b2c-8aa3-1bdf4302da2e)

## Dependencies 
```text
plugins {
	id 'org.springframework.boot' version '2.7.5'
	id 'io.spring.dependency-management' version '1.0.15.RELEASE'
	id 'java'
}

group = 'com.example'
version = '0.0.1-SNAPSHOT'
sourceCompatibility = '17'

dependencies {
	implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
	implementation 'org.springframework.boot:spring-boot-starter-web'
	implementation 'org.springframework.boot:spring-boot-starter-validation'
	implementation 'org.springdoc:springdoc-openapi-ui:1.6.12'
	compileOnly 'org.projectlombok:lombok'
	runtimeOnly 'com.h2database:h2'
	annotationProcessor 'org.projectlombok:lombok'
	testImplementation 'org.springframework.boot:spring-boot-starter-test'
}
```

## Installation and Setup 
- git clone
- run the application 
- read the docs at `localhost://8080/swagger-ui.html`
- run the api to migrate the data
- run available CRUD RestAPI 

## Reflection 
- I finished this project in 3 days
- New things I learn = 
  - serialize and deserialize data according to [dog.ceo API](https://dog.ceo/dog-api/) JSON format.
  - logic for data migration 
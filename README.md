Code challenge
==============

# Tests
`mvn test`

# Run
`mvn spring-boot:run`

# API

GET /api/products (get a list of products) 		
, for example:		
```
curl http://localhost:8080/api/products   
``` 
GET /api/products/1 (get one product from the list)
, for example:		
```
curl http://localhost:8080/api/product/1
```
PUT /api/products/1 (update a single product)
, for example:		
```
curl -X PUT -H "Content-Type: application/json" -d '{"name":"name 5","currentPrice":"567.567","lastUpdate":"1582412771002"}' http://localhost:8080/api/products/5
```
POST /api/products (create a product)
, for example:		
```
curl -X POST -H "Content-Type: application/json" -d '{"name":"name 5","currentPrice":"567.567","lastUpdate":"1582412771000"}' http://localhost:8080/api/products
```

# Docker

## Build jar with all dependencies
```
mvn install
```

## Build
```
docker build -t asel-backend-assignment .
```

## Run
```
docker run -p 8080:8080 -t -i asel-backend-assignment .
```	
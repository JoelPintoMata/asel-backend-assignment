Code challenge
==============

# Tests
`mvn test`

# Run
`mvn spring-boot:run`

# API

GET /api/products (get a list of products) 				
    
    curl http://localhost:8080/api/products

GET /api/products/1 (get one product from the list)

    curl http://localhost:8080/api/product/1

PUT /api/products/1 (update a single product)

POST /api/products (create a product)	
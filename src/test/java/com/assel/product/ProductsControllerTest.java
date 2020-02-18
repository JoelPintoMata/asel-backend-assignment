package com.assel.product;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.net.URL;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductsControllerTest {

    @LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate template;

    @BeforeEach
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + "/");
    }

    @org.junit.jupiter.api.Test
    public void getProducts() {
        ResponseEntity<String> response = template.getForEntity(base.toString(),
                String.class);
        Assert.assertEquals("Greetings from Spring Boot!", response.getBody());
    }

    @org.junit.jupiter.api.Test
    void putProducts() {
    }

    @org.junit.jupiter.api.Test
    void postProducts() {
    }
}
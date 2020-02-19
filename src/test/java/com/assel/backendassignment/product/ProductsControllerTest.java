package com.assel.backendassignment.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductsController.class)
class ProductsControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ProductServiceImpl productService;

    @BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.Test
    public void getProducts() throws Exception {
        List<Product> productList = new ArrayList<Product>();
        Product product1 = new Product();
        product1.setName("name");
        product1.setCurrentPrice("123.456");
        product1.setLastUpdate(Instant.now().toString());
        productList.add(product1);

        given(productService.getProducts())
                .willReturn(productList);
        mvc.perform(MockMvcRequestBuilders.get("/api/products").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
        ;
    }

    @org.junit.jupiter.api.Test
    void putProducts() {
    }

    @org.junit.jupiter.api.Test
    void postProducts() {
    }
}
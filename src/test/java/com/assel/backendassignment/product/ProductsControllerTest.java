package com.assel.backendassignment.product;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
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
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
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

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @org.junit.jupiter.api.Test
    public void getProducts() throws Exception {
        List<Product> productList = new ArrayList<>();
        Product product1 = new Product();
        product1.setName("name");
        product1.setCurrentPrice("123.456");
        product1.setLastUpdate(Instant.now().toString());
        productList.add(product1);

        given(productService.findAll())
                .willReturn(productList);
        mvc.perform(MockMvcRequestBuilders.get("/api/products").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
        ;
    }

    @org.junit.jupiter.api.Test
    public void givenProduct_whenSearchExistingId_thenReturnProduct() throws Exception {
        Product product1 = new Product();
        product1.setName("name 1");
        product1.setCurrentPrice("123.456");
        product1.setLastUpdate(Instant.now().toString());

        given(productService.findById(1L))
                .willReturn(Optional.of(product1));

        mvc.perform(MockMvcRequestBuilders.get("/api/product/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("name 1")))
        ;
    }

    @org.junit.jupiter.api.Test
    void putProducts() {
    }

    @org.junit.jupiter.api.Test
    public void givenProduct_whenSearchNonExistingId_thenReturnZeroProduct() throws Exception {
        Product product1 = new Product();
        product1.setName("name 1");
        product1.setCurrentPrice("123.456");
        product1.setLastUpdate(Instant.now().toString());

        given(productService.findById(1L))
                .willReturn(Optional.ofNullable(new Product()));

        mvc.perform(MockMvcRequestBuilders.get("/api/product/999").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
        ;
    }

    @org.junit.jupiter.api.Test
    void postProducts() throws Exception {
        Product product1 = new Product();
        product1.setName("name 1");
        product1.setCurrentPrice("123.456");
        product1.setLastUpdate(Instant.now().toString());

        given(productService.save(Mockito.any(ProductDTO.class)))
                .willReturn(product1);

        mvc.perform(MockMvcRequestBuilders.post("/api/products")
                .content(asJsonString(product1))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name", is(product1.getName())))
                .andExpect(jsonPath("$.currentPrice", is(product1.getCurrentPrice())))
                .andExpect(jsonPath("$.lastUpdate", is(product1.getLastUpdate())))
        ;
    }
}
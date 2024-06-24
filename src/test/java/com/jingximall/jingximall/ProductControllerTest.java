package com.jingximall.jingximall;

import com.jingximall.jingximall.controllers.ProductController;
import com.jingximall.jingximall.model.Product;
import com.jingximall.jingximall.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductController productController;

    @Test
    public void testListProducts() {
        // Arrange
        Product product1 = new Product(1L, "Laptop", 999.99, "https://example.com/laptop.jpg", true);
        Product product2 = new Product(2L, "Smartphone", 499.99, "https://example.com/smartphone.jpg", true);
        List<Product> productList = Arrays.asList(product1, product2);
        Page<Product> page = new PageImpl<>(productList);

        when(productRepository.findAll(PageRequest.of(0, 15, Sort.by("name").ascending()))).thenReturn(page);

        // Act
        List<Product> result = productController.listProducts(0, 15);

        // Assert
        assertEquals(2, result.size(), "Should return 2 products");
        assertEquals(product1, result.get(0), "First product should be Laptop");
        assertEquals(product2, result.get(1), "Second product should be Smartphone");
    }
}
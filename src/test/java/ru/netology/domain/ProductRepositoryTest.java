package ru.netology.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    Products product1 = new Products(2, 300, "Книга 2");
    Products product2 = new Products(3, 60000, "iPhone11");
    Products product3 = new Products(1, 800, "Книга 1");


    @Test
    void saveProduct() {
        ProductRepository repo = new ProductRepository();

        repo.saveProduct(product3);
        repo.saveProduct(product1);
        repo.saveProduct(product2);

        Products[] expected = {product3, product1, product2};
        Products[] actual = repo.getProduct();

        assertArrayEquals(expected, actual);
    }

    @Test
    void deleteProduct1() {
        ProductRepository repo = new ProductRepository();

        repo.saveProduct(product3);
        repo.saveProduct(product1);
        repo.saveProduct(product2);

        repo.getProduct();
        repo.deleteProduct(2);

        Products[] expected = {product3, product2};
        Products[] actual = repo.getProduct();

        assertArrayEquals(expected, actual);
    }


    @Test
    void deleteProduct2() {
        ProductRepository repo = new ProductRepository();

        repo.saveProduct(product3);
        repo.saveProduct(product1);
        repo.saveProduct(product2);

        repo.getProduct();
        repo.deleteProduct(1);

        Products[] expected = {product1, product2};
        Products[] actual = repo.getProduct();

        assertArrayEquals(expected, actual);
    }


}
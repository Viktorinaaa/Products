package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Products product1 = new Products(2, 300, "Книга 2");
    Products product2 = new Products(3, 60000, "iPhone11");
    Products product3 = new Products(1, 800, "Книга 1");
    Products product4 = new Products(4, 400, "Книга 2");

    /*@Test
    void add() {
        manager.add(product3);
        manager.add(product1);
        manager.add(product2);

        Products[] expected = {product3, product1, product2};
        Products[] actual = manager.getProducts();
        assertArrayEquals(expected, actual);
    }*/

    @BeforeEach
    void setup() {
        manager.add(product3);
        manager.add(product1);
        manager.add(product2);
        manager.add(product4);

        Products[] expected = {product3, product1, product2, product4};
        Products[] actual = manager.getProducts();
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchBy() {
        Products[] expected = {product1, product4};
        Products[] actual = manager.searchBy("Книга 2");
        assertArrayEquals(expected, actual);
    }

    //Поик
    @Test
    void searchByReverseProducts() {
        manager.searchBy("Книга 2");

        Products[] expected = {product4, product1};
        Products[] actual = manager.reverseResult();
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByReverseProduct() {
        manager.searchBy("Книга 1");

        Products[] expected = {product3};
        Products[] actual = manager.reverseResult();
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByReverseNullProducts() {
        manager.searchBy("Книга 4");

        Products[] expected = {};
        Products[] actual = manager.reverseResult();
        assertArrayEquals(expected, actual);
    }


    @Test
    void matches1() {
        boolean expected = true;
        boolean actual = manager.matches(product1, "Книга 2");

        assertEquals(expected, actual);
    }

    @Test
    void matches2() {
        boolean expected = false;
        boolean actual = manager.matches(product2, "Книга 2");

        assertEquals(expected, actual);
    }

}
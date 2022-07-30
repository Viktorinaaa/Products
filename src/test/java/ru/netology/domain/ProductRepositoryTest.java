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

    @Test
    void getAuthor() {
        Book book = new Book(5, 100, "Name 1", "Author 1");

        String actual = book.getAuthor();
        String expected = "Author 1";
        assertEquals(expected, actual);
    }

    @Test
    void getManufacturer() {
        Smartphone smartphone = new Smartphone(2, 100, "Name 1", "Manufacturer 1");

        String actual = smartphone.getManufacturer();
        String expected = "Manufacturer 1";
        assertEquals(expected, actual);
    }

    @Test
    void setManufacturerTest() {
        Smartphone smartphone = new Smartphone(1, 100, "iPhone", "Manufacturer");
        String man = smartphone.getManufacturer();
        smartphone.setManufacturer(man);
        assertEquals(smartphone.getManufacturer(), man);
    }

    @Test
    void setAuthorTest() {
        Book book = new Book(1, 100, "Book", "Author");
        String author = book.getAuthor();
        book.setAuthor(author);
        assertEquals(book.getAuthor(), author);
    }

    @Test
    void setPriceTest() {
        Products product = new Products(1, 100, "Product1");
        int price = product.price;
        product.setPrice();
        assertEquals(product.getPrice(), price);
    }

    @Test
    void setIdTest() {
        Products product = new Products(1, 100, "Product1");
        int id = product.id;
        product.setId(id);
        assertEquals(product.getId(), id);
    }

    @Test
    void setNameTest() {
        Products product = new Products(1, 100, "Product1");
        String name = product.name;
        product.setName(name);
        assertEquals(product.getName(), name);
    }


}
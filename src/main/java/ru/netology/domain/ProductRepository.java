package ru.netology.domain;

public class ProductRepository {
    private Products[] products = new Products[0];

    //Сохранение товара
    public void saveProduct(Products product) {
        Products[] tmp = new Products[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = product;
        products = tmp;
    }


    //Получение сохраненных товаров
    public Products[] getProduct() {
        return products;
    }

    //Удаление товаров по id
    public void deleteProduct(int id) {
        Products[] tmp = new Products[products.length - 1];
        int copyToIndex = 0;
        for (Products product : products) {
            if (product.getId() != id) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
        }
        products = tmp;
    }
}

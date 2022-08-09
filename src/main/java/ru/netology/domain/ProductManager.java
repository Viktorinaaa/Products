package ru.netology.domain;

public class ProductManager {
    private ProductRepository repo;
    private Products[] result = new Products[0]; //возвращает массив найденных товаров

    public ProductManager(ProductRepository repo) {
        this.repo = repo;
    }

    public void add(Products product) {
        repo.saveProduct(product);
    }

    public Products[] getProducts() {
        return repo.getProduct();
    }

    public Products[] searchBy(String text) {
        for (Products product : repo.getProduct()) {
            if (matches(product, text)) {
                Products[] tmp = new Products[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[result.length - 1 - i];
                }
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    public Products[] reverseResult() {
        Products[] reverse = new Products[result.length];
        for (int i = 0; i < reverse.length; i++) {
            reverse[i] = result[result.length - 1 - i];
        }
        return reverse;
    }

    // метод определения соответствия товара product запросу search
    public boolean matches(Products product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
    }
}

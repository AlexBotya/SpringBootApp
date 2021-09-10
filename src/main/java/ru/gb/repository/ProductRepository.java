package ru.gb.repository;

import org.springframework.stereotype.Repository;
import ru.gb.domain.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {
    private List<Product> products;

    public ProductRepository() {
        this.products = new ArrayList<>(
                List.of(
                        new Product(1, "Apples", 100.50F),
                        new Product(2, "Potatoes", 500.50F),
                        new Product(3, "Chickens", 10.99F),
                        new Product(4, "Grapes", 49.99F),
                        new Product(5, "Cucumbers", 19.99F)
                )
        );
    }

    public Optional<Product> findById(int id) {
        return products.stream().filter(p -> p.getId() == id).findFirst();
    }

    public List<Product> findAll() {
        return products;
    }

    public void add(Product product) {
        this.products.add(product);
    }

    public void remove(int id) {
        Product product = findById(id).orElseThrow();
        this.products.remove(product);
    }


    @Override
    public String toString() {
        return "ProductRepository{" +
                "products=" + products +
                '}';
    }
}

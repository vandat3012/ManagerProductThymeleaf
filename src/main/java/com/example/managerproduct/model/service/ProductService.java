package com.example.managerproduct.model.service;

import com.example.managerproduct.model.Product;

import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Map.entry;

public class ProductService implements IProductService {
    private static final Map<Integer,Product> products = new HashMap<>();
    static {
        products.put(1,new Product(1,"meat",200000f,2));
        products.put(2,new Product(2,"flower",100000f,3));
        products.put(3,new Product(3,"rice",300000f,4));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(),product);
    }

    @Override
    public void update(Product product, int id) {
        products.put(id,product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> product = new ArrayList<>();
        for (Map.Entry<Integer, Product> entry: products.entrySet()){
            if (entry.getValue().getName().equalsIgnoreCase(name)){
                product.add(entry.getValue());
            }
        }
        return product;
    }
}

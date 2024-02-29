package com.example.managerproduct.model.service;

import com.example.managerproduct.model.Product;

import java.util.List;

public interface IProductService {
List<Product> findAll();
void save (Product product);
void update (Product product,int id);
void remove (int id);
Product findById (int id);
List<Product> findByName(String name);

}

package com.example.mycommerce.dao;

import com.example.mycommerce.model.MyProduct;

import java.util.List;

public interface MyProductDao {

    boolean create(MyProduct car);

    void update(MyProduct car);

    MyProduct findProductById(Long id);

    List<MyProduct> getAllProducts();

    void remove(MyProduct car);

    void removeProduct(Long id);

    void addProduct(MyProduct product);
}

package com.example.mycommerce.dao;

import com.example.mycommerce.model.MyProduct;

import java.util.List;

public interface MyProductDao {

    boolean create(MyProduct product);

    void update(MyProduct product);

    MyProduct findProductById(Long id);

    List<MyProduct> getAllProducts();

    void remove(MyProduct product);

    void removeProduct(Long id);

    void addProduct(MyProduct product);
}

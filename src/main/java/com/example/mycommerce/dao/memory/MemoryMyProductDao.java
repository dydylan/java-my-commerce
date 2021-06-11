package com.example.mycommerce.dao.memory;

import com.example.mycommerce.dao.MyProductDao;
import com.example.mycommerce.dao.exception.UnknownProductException;
import com.example.mycommerce.model.MyProduct;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class MemoryMyProductDao implements MyProductDao {

    private static List<MyProduct> productList = new ArrayList<>();
    private static Long idSequence = 1L;

    public boolean create(MyProduct product) {
        product.setId(++idSequence);
        return productList.add(product);
    }

    public void update(MyProduct product) {
        int index = getProductIndexById(product.getId());
        if (index > -1) {
            productList.set(index, product);
        } else {
            throw new UnknownProductException(product.getId());
        }
    }

    public MyProduct findProductById(Long id) {
        int index = getProductIndexById(id);
        if (index > -1) {
            MyProduct product = productList.get(index);
            return product;
        } else {
            throw new UnknownProductException(id);
        }
    }

    public List<MyProduct> getAllProducts() {
        return Collections.unmodifiableList(productList);
    }

    public void remove(MyProduct product) {
        removeProduct(product.getId());
    }

    public void removeProduct(Long id) {
        int index = getProductIndexById(id);
        if (index > -1) {
            productList.remove(index);
        } else {
            throw new UnknownProductException(id);
        }
    }

    private int getProductIndexById(Long id) {
        for (int i = 0; i < productList.size(); ++i) {
            MyProduct product = productList.get(i);
            if (product.getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }
}
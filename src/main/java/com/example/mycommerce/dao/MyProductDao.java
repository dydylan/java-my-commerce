package com.example.mycommerce.dao;

import com.example.mycommerce.model.MyProduct;
import com.example.mycommerce.UnknownProductException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyProductDao {
    private static List<MyProduct> products = new ArrayList();
    private static Long idSequence = 1L;

    private MyProductDao() {
    }

    public static void addProduct(MyProduct product) {
        Long var1 = idSequence;
        idSequence = idSequence + 1L;
        product.setId(var1);
        products.add(product);
    }

    public static void updateProduct(MyProduct product) {
        int index = getProductIndexById(product.getId());
        if (index > -1) {
            products.set(index, product);
        } else {
            throw new UnknownProductException(product.getId());
        }
    }

    public static MyProduct findProductById(Long id) {
        int index = getProductIndexById(id);
        if (index > -1) {
            MyProduct product = (MyProduct)products.get(index);
            return product;
        } else {
            throw new UnknownProductException(id);
        }
    }

    public static List<MyProduct> getAllProducts() {
        return Collections.unmodifiableList(products);
    }

    public static void removeProduct(MyProduct product) {
        removeProduct(product.getId());
    }

    public static void removeProduct(Long id) {
        int index = getProductIndexById(id);
        if (index > -1) {
            products.remove(index);
        } else {
            throw new UnknownProductException(id);
        }
    }

    private static int getProductIndexById(Long id) {
        for(int i = 0; i < products.size(); ++i) {
            MyProduct product = (MyProduct)products.get(i);
            if (product.getId().equals(id)) {
                return i;
            }
        }

        return -1;
    }
}
package com.example.mycommerce.dao.memory;

import com.example.mycommerce.dao.MyProductDao;
import com.example.mycommerce.dao.exception.UnknownProductException;
import com.example.mycommerce.model.MyProduct;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class MemoryMyProductDao implements MyProductDao {

    private static List<MyProduct> carList = new ArrayList<>();
    private static Long idSequence = 1L;

    public boolean create(MyProduct car) {
        car.setId(++idSequence);
        return carList.add(car);
    }

    public void update(MyProduct car) {
        int index = getCarIndexById(car.getId());
        if (index > -1) {
            carList.set(index, car);
        } else {
            throw new UnknownProductException(car.getId());
        }
    }

    public MyProduct findProductById(Long id) {
        int index = getCarIndexById(id);
        if (index > -1) {
            MyProduct car = carList.get(index);
            return car;
        } else {
            throw new UnknownProductException(id);
        }
    }

    public List<MyProduct> getAllProducts() {
        return Collections.unmodifiableList(carList);
    }

    public void remove(MyProduct car) {
        removeProduct(car.getId());
    }

    public void removeProduct(Long id) {
        int index = getCarIndexById(id);
        if (index > -1) {
            carList.remove(index);
        } else {
            throw new UnknownProductException(id);
        }
    }

    private int getCarIndexById(Long id) {
        for (int i = 0; i < carList.size(); ++i) {
            MyProduct car = carList.get(i);
            if (car.getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }
}
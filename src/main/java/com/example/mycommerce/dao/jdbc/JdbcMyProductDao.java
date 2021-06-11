package com.example.mycommerce.dao.jdbc;

import com.example.mycommerce.dao.MyProductDao;
import com.example.mycommerce.model.MyProduct;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcMyProductDao implements MyProductDao {

    private final Connection connection;

    public JdbcMyProductDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean create(MyProduct product) {
        int isCreated = 0;
        String query = "INSERT INTO products (name, content, price) VALUES(?,?,?)";
        try (PreparedStatement pst = this.connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            pst.setString(1, product.getName());
            pst.setString(2, product.getContent());
            pst.setObject(3, product.getPrice());
            isCreated = pst.executeUpdate();

            this.connection.commit();

            // Fetching generated id from database during insert
            ResultSet resultSet = pst.getGeneratedKeys();
            resultSet.next();
            Long id = resultSet.getLong(1);

            if (id != null) {
                product.setId(id);
            }

        } catch (SQLException e1) {
            System.out.println("mauvaise ID, rollbacked");
            e1.printStackTrace();
            try {
                this.connection.rollback();
            } catch (SQLException e2) {
                System.out.println("mauvaise ID, no rollback");
                e2.printStackTrace();
            }
        }
        return isCreated > 0;
    }

    @Override
    public void update(MyProduct product) {
        // TODO
    }

    @Override
    public MyProduct findProductById(Long id) {
        String query = "SELECT * FROM products WHERE id = ?";
        MyProduct foundProduct = null;
        try (PreparedStatement pst = this.connection.prepareStatement(query)) {
            pst.setLong(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                foundProduct = mapToProduct(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foundProduct;
    }

    @Override
    public List<MyProduct> getAllProducts() {
        String query = "SELECT * FROM products";
        List<MyProduct> placeList = new ArrayList<>();
        try (Statement st = this.connection.createStatement()) {
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                placeList.add(mapToProduct(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return placeList;
    }

    private MyProduct mapToProduct(ResultSet rs) throws SQLException {
        Long id = rs.getLong("id");
        String name = rs.getString("name");
        String content = rs.getString("name");
        float price = rs.getFloat("price");
        return new MyProduct(id, name, content, price);
    }

    @Override
    public void remove(MyProduct product) {
        // TODO
    }

    @Override
    public void removeProduct(Long id) {
        // TODO
    }

    @Override
    public void addProduct(MyProduct product) {

    }
}
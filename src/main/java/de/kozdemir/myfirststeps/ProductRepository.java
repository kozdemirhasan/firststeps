package de.lubowiecki.firststeps;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductRepository {

    private static final String TABLE = "products";

    public List<Product> find() throws SQLException {

        final String sql =  "SELECT * FROM " + TABLE;

        try(Connection connection = DBUtil.getConnection(); Statement stmt = connection.createStatement()) {
            ResultSet results = stmt.executeQuery(sql); // Anfrage an die Datenbank verschicken

            List<Product> products = new ArrayList<>();
            while(results.next()) { // Ergebnisse von der Datenbank durchlaufen
                products.add(create(results)); // Aus jedem Datensatz ein Produkt-Objekt bauen
            }

            return products;
        }
    }

    public Optional<Product> find(int id) throws SQLException {

        final String sql =  "SELECT * FROM " + TABLE + " WHERE id = " + id;

        try(Connection connection = DBUtil.getConnection(); Statement stmt = connection.createStatement()) {
            ResultSet results = stmt.executeQuery(sql); // Anfrage an die Datenbank verschicken

            if(results.next()) {
                return Optional.of(create(results)); // Datensatz gefunden
            }

            return Optional.empty(); // Kein passender Datensatz in der DB gefunden
        }
    }

    public boolean save(Product product) throws SQLException {

        if(product.getId() > 0) {
            return update(product);
        }
        else {
            return insert(product);
        }
    }

    private boolean insert(Product product) throws SQLException {

        final String sql =  "INSERT INTO " + TABLE + " (id, name, description, price) VALUES(NULL, ?, ?, ?)";

        try(Connection connection = DBUtil.getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, product.getName());
            stmt.setString(2, product.getDescription());
            stmt.setDouble(3, product.getPrice());
            return stmt.executeUpdate() > 0;
        }
    }

    private boolean update(Product product) throws SQLException {
        throw new UnsupportedOperationException("Noch nicht implementiert");
    }

    public boolean delete(Product product) throws SQLException {
        throw new UnsupportedOperationException("Noch nicht implementiert");
    }

    private Product create(ResultSet result) throws SQLException {
        Product product = new Product();
        product.setId(result.getInt("id"));
        product.setName(result.getString("name"));
        product.setDescription(result.getString("description"));
        product.setPrice(result.getDouble("price"));
        return product;
    }
}

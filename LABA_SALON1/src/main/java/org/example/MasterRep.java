package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MasterRep implements IRepository<Masters>{

    public Connection connect() throws SQLException{
        Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/mem:salon", "sa", "");
        if (conn==null){System.out.println("Нет соединения с БД!");
            System.exit(0);
        }
        return conn;
    }
    public Statement createStmt(Connection conn)throws SQLException{
        return conn.createStatement();
    }

    @Override
    public void addObj(Masters master) throws SQLException {
        String query = "INSERT INTO Masters (name, surname, exist) VALUES (?, ?, ?)";
        try (Connection conn = connect();
             PreparedStatement statement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, master.getName());
            statement.setString(2, master.getSurname());
            statement.setBoolean(3, master.getExist());
            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    master.setId_master(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Failed to get generated id for master.");
                }
            }
        }
    }

    @Override
    public void delete(Masters master) throws SQLException {
        String query = "UPDATE Masters SET exist = false WHERE id_master = ?";
        try (PreparedStatement statement = connect().prepareStatement(query)) {
            statement.setInt(1, master.getId_master());
            statement.executeUpdate();
        }

    }

    @Override
    public void update(Masters master) throws SQLException {
        String query = "UPDATE Masters SET name = ?, surname = ?, exist = ? WHERE id_master = ?";
        try (PreparedStatement statement = connect().prepareStatement(query)) {
            statement.setString(1, master.getName());
            statement.setString(2, master.getSurname());
            statement.setBoolean(3, master.getExist());
            statement.setInt(4, master.getId_master());
            statement.executeUpdate();
        }

    }

    @Override
    public List<Masters> getAll() throws SQLException {
        Statement stmt = createStmt(connect());
        ResultSet rs = stmt.executeQuery("SELECT id_master, name, surname, exist FROM masters");
        List<Masters> masters = new ArrayList<>();
        while(rs.next()){
            Masters master = new Masters(rs.getInt("id_master"), rs.getString("name"), rs.getString("surname"), rs.getBoolean("exist"));
            masters.add(master);
        }
        stmt.close();
        return masters;
    }
}


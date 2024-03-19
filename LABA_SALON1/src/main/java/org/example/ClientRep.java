package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientRep implements IRepository<Clients>{
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
    public void addObj(Clients client) throws SQLException {
        String query = "INSERT INTO Clients (name, surname, exist) VALUES (?, ?, ?)";
        try (Connection conn = connect();
             PreparedStatement statement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, client.getName());
            statement.setString(2, client.getSurname());
            statement.setBoolean(3, client.getExist());
            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    client.setId_client(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Failed to get generated id for client.");
                }
            }
        }
    }

    @Override
    public void delete(Clients client)throws SQLException {
        String query = "UPDATE Clients SET exist = false WHERE id_client = ?";
        try (PreparedStatement statement = connect().prepareStatement(query)) {
            statement.setInt(1, client.getId_client());
            statement.executeUpdate();
        }
    }

    @Override
    public void update(Clients client)throws SQLException {
        String query = "UPDATE Clients SET name = ?, surname = ?, exist = ? WHERE id_client = ?";
        try (PreparedStatement statement = connect().prepareStatement(query)) {
            statement.setString(1, client.getName());
            statement.setString(2, client.getSurname());
            statement.setBoolean(3, client.getExist());
            statement.setInt(4, client.getId_client());
            statement.executeUpdate();
        }
    }

    @Override
    public List<Clients> getAll() throws SQLException{
        Statement stmt = createStmt(connect());
        ResultSet rs = stmt.executeQuery("SELECT id_client, name, surname, exist FROM clients");
        List<Clients> clients = new ArrayList<>();
        while(rs.next()){
            Clients client = new Clients(rs.getInt("id_client"),rs.getString("name"), rs.getString("surname"),rs.getBoolean("exist"));
            clients.add(client);
        }
        stmt.close();
        return clients;
    }
}

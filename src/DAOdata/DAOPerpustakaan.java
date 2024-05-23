package DAOdata;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import connection.Connector;
import DAOimplement.DAOImplementPerpustakaan;
import model.DataPerpustakaan;
import javax.swing.JOptionPane;

public class DAOPerpustakaan implements DAOImplementPerpustakaan {

    Connection connection;
    final String select = "SELECT * FROM buku";
    final String insert = "INSERT INTO buku (judul, penulis, rating, harga) VALUES (?, ?, ?, ?);";
    final String update = "UPDATE buku SET penulis = ?, rating= ?, harga= ? WHERE judul = ?;";
    final String delete = "DELETE FROM buku WHERE judul = ?";

    public DAOPerpustakaan() {
        connection = Connector.connection();
    }

    public void insert (DataPerpustakaan dp){
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insert, statement.RETURN_GENERATED_KEYS);
            statement.setString(1, dp.getJudul());
            statement.setString(2, dp.getPenulis());
            statement.setDouble(3, dp.getRating());
            statement.setDouble(4, dp.getHarga());
            statement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan!", "Success", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLIntegrityConstraintViolationException ex) {
            JOptionPane.showMessageDialog(null, "Data gagal ditambahkan: Data dengan primary key tersebut sudah ada.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data gagal ditambahkan: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    @Override
    public void update(DataPerpustakaan dp) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update);
            statement.setString(1, dp.getPenulis());
            statement.setDouble(2, dp.getRating());
            statement.setDouble(3, dp.getHarga());
            statement.setString(4, dp.getJudul());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
    
    public void delete(String judul) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);
            statement.setString(1, judul);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    public void select (DataPerpustakaan dp){}
    @Override
    public List<DataPerpustakaan> getAll() {
        List<DataPerpustakaan> dp = null;
        try {
            dp = new ArrayList<DataPerpustakaan>();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(select);

            while (resultSet.next()) {
                DataPerpustakaan buku = new DataPerpustakaan();
                buku.setJudul(resultSet.getString("judul"));
                buku.setPenulis(resultSet.getString("penulis"));
                buku.setRating(resultSet.getDouble("rating"));
                buku.setHarga(resultSet.getDouble("harga"));
                buku.setId(resultSet.getInt("Id"));
                dp.add(buku);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataPerpustakaan.class.getName()).log(Level.SEVERE, null, ex);
        }
    return dp;
    }
}

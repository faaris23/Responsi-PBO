/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOdataperpustakaan;
import java.sql.*;
import java.util.*;
import model.*;
import connector.koneksi;
import java.util.logging.Level;
import java.util.logging.Logger;
import DAOdataperpustakaan.DAOperpustakaan;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class DAOperpustakaan implements dataperpustakaanimplement {
    
    Connection connection;
    final String select = "select * from buku";
    final String insert = "INSERT INTO buku(judul,penulis,rating,harga) VALUES (?,?,?,?,?);";
    final String update = "update data set penulis=?,rating=?,harga=? where judul=?";
    final String delete = "delete from buku where judul=?;";
    
    public DAOperpustakaan(){
        connection = koneksi.connection();
        
    }

    @Override
    public void insert(dataPerpustakaan p) {
        
        PreparedStatement statement = null;
        
        try{
            statement = connection.prepareStatement(update);
            statement = connection.prepareStatement(insert,Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, p.getPenulis());
            statement.setDouble(2, p.getRatingBuku());
            statement.setDouble(3, p.getHargaAwal());
            
            int total;
            int biayaPerawatan = 500;
            
            total = (int) (p.getHargaAwal() + biayaPerawatan + (p.getRatingBuku() * 100));
            
            statement.setInt(4, total);
            
            statement.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"berhasil di tambahkan","SUKSES ", JOptionPane.INFORMATION_MESSAGE);
    }catch (SQLIntegrityConstraintViolationException ex) {   
            JOptionPane.showMessageDialog(null, "Buku sudah di tambahkan", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            if(statement != null){
                try{
                    statement.close();
                }catch(SQLException ex){
                    ex.printStackTrace();
                }
            }
        }
    }

    
    @Override
    public void delete(String judul) {
       // PreparedStatement statement = null;
        
    }
    
    
    
    
    
    @Override
    public void update(dataPerpustakaan p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<dataPerpustakaan> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

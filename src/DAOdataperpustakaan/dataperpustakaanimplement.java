/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOdataperpustakaan;
import java.util.List;
import model.*;



/**
 *
 * @author LENOVO
 */
public interface dataperpustakaanimplement {
    public void insert(dataPerpustakaan p);
    public void delete(dataPerpustakaan p);
    public void update(dataPerpustakaan p);
    public List<dataPerpustakaan>getAll();
}

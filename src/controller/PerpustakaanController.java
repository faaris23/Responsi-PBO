
package controller;

import java.util.List;
import DAOdata.DAOPerpustakaan;
import DAOimplement.DAOImplementPerpustakaan;
import model.*;
import view.MainView;
import javax.swing.JOptionPane;


public class PerpustakaanController {
    MainView frame;
    DAOImplementPerpustakaan implPerpus;
    List<DataPerpustakaan> dp;
    
    private String deleteValue;
    private Double tmpHasil;
    private Double tmpRating;
    private Double tmpRateResult;
    private boolean insertError = false;
    private boolean updateError = false;
    private boolean deleteError = false;

    private boolean isFormValid() {
        return !frame.getJTxtJudul().getText().isEmpty()
            && !frame.getJTxtPenulis().getText().isEmpty()
            && !frame.getJTxtRating().getText().isEmpty()
            && !frame.getJTxtHargaP().getText().isEmpty();
    }

    public PerpustakaanController (MainView frame){
    this.frame = frame; 
    implPerpus = new DAOPerpustakaan();
    dp = implPerpus.getAll();
    }
    
    public void isitable(){
        dp = implPerpus.getAll();
        ModelTabel mt = new ModelTabel(dp);
        frame.getTableData().setModel(mt);
    }
    public void insert() {
        if (isFormValid()) {
            try {
                DataPerpustakaan buku = new DataPerpustakaan();
                buku.setJudul(frame.getJTxtJudul().getText());
                buku.setPenulis(frame.getJTxtPenulis().getText());
                buku.setRating(Double.parseDouble(frame.getJTxtRating().getText()));
                tmpHasil = Double.parseDouble(frame.getJTxtHargaP().getText());
                tmpRating = Double.parseDouble(frame.getJTxtRating().getText());
                tmpRateResult = (tmpHasil + 500 + (tmpRating*100));
                buku.setHarga(tmpRateResult);
                implPerpus.insert(buku);
                insertError = false;
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid input!", "Warning", JOptionPane.WARNING_MESSAGE);
                ex.printStackTrace();
                insertError = true;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please fill the form!", "Warning", JOptionPane.WARNING_MESSAGE);
            insertError = true;
        }
    }
        public void update() {
          if (isFormValid()) {
            try {
                DataPerpustakaan buku = new DataPerpustakaan();
                buku.setJudul(frame.getJTxtJudul().getText());
                buku.setPenulis(frame.getJTxtPenulis().getText());
                buku.setRating(Double.parseDouble(frame.getJTxtRating().getText()));
                tmpHasil = Double.parseDouble(frame.getJTxtHargaP().getText());
                tmpRating = Double.parseDouble(frame.getJTxtRating().getText());
                tmpRateResult = (tmpHasil + 500 + (tmpRating*100));
                buku.setHarga(tmpRateResult);
                implPerpus.update(buku);
                updateError = false;
                JOptionPane.showMessageDialog(null, "Data Updated!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid input!", "Warning", JOptionPane.WARNING_MESSAGE);
                ex.printStackTrace();
                updateError = true;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please Fill the form!", "Warning", JOptionPane.WARNING_MESSAGE);
            updateError = true;
        }
    }
    
    public void delete() {
        if (isFormValid()) {
            try {
                DataPerpustakaan movie = new DataPerpustakaan();
                deleteValue = frame.getJTxtJudul().getText();
                implPerpus.delete(deleteValue);
                deleteError = false;
                JOptionPane.showMessageDialog(null, "Data Deleted!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException ex) {
               
                JOptionPane.showMessageDialog(null, "Invalid Input!", "Warning", JOptionPane.WARNING_MESSAGE);
                ex.printStackTrace();
                deleteError = true;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please fill the form!", "Warning", JOptionPane.WARNING_MESSAGE);
            deleteError = true;
        }
    }
    
    public boolean isInsertError() {
        return insertError;
    }

    public boolean isUpdateError() {
        return updateError;
    }

    public boolean isDeleteError() {
        return deleteError;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author LENOVO
 */
public class modeltabelperpustakaan extends AbstractTableModel{
    
    List<dataPerpustakaan> dp;
    
    public modeltabelperpustakaan(List<dataPerpustakaan> dp){
        this.dp = dp;
    }

    @Override
    public int getRowCount() {
        return dp.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }
    
    @Override
    public String getColumnName(int column){
      switch(column){
          case 0:
              return "judul";
          case 1:
              return "penulis";
          case 2:
              return "rating";
          case 3:
              return "harga";
          default:
              return null;
      }  
    }
    
    @Override
    public Object getValueAt(int row, int column) {
        switch(column){
          case 0:
              return dp.get(row).getJudulBuku();
          case 1:
              return dp.get(row).getPenulis();
          case 2:
              return dp.get(row).getRatingBuku();
          case 3:
              return dp.get(row).getHargaPinjam();
          default:
              return null;
      }  
   }
   
}

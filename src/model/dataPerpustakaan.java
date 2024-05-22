/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author LENOVO
 */
public class dataPerpustakaan {
    private String judulBuku;
    private String penulis;
    private double ratingBuku;
    private double hargaAwal;
    private double hargaPinjam;
    
    
    //GETTER
    public String getJudulBuku(){
        return judulBuku;
    }
    public String getPenulis(){
        return penulis;
    }
    public double getRatingBuku(){
        return ratingBuku;
    }
    public double getHargaAwal(){
        return hargaAwal;
    }
    public double getHargaPinjam(){
        return hargaPinjam;
    }
    
    //SETTER
    public void setJudulBuku(String judulBuku){
        this.judulBuku = judulBuku;
        
    }
    public void setPenulis(String penulis){
        this.penulis = penulis;
        
    }
    public void setRatingBuku(double ratingBuku){
        this.ratingBuku = ratingBuku;
        
    }
    public void sethargaAwal(double hargaAwal){
        this.hargaAwal = hargaAwal;
        
    }
    public void setHargaPinjam(double hargaPinjam){
        this.hargaPinjam = hargaPinjam;
        
    }
}

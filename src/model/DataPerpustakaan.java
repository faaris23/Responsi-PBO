
package model;


public class DataPerpustakaan {
    private String judul;
    private String penulis;
    private Double rating;
    private Double harga;
    private Integer id_buku;




    //GETTER
    public String getJudul() {
        return judul;
    }
    public String getPenulis() {
        return penulis;
    }
    public Double getRating() {
        return rating;
    }
    public Double getHarga() {
        return harga;
    }
    public Integer getId() {
        return id_buku;
    }


    
    //SETTER
    public void setJudul(String judul) {
        this.judul = judul;
    }
    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }
    public void setRating(Double rating) {
        this.rating = rating;
    }
    public void setHarga(Double harga) {
        this.harga = harga;
    }
    public void setId(Integer id) {
        this.id_buku = id;
    }
    
        
}

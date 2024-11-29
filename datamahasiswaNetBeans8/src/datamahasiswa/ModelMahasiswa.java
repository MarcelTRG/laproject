/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package datamahasiswa;

public class ModelMahasiswa {
    private String npm;
    private String nama;
    private int tinggi;
    private boolean pindahan;
    
    public ModelMahasiswa(String npm, String nama, int tinggi, boolean pindahan){
        this.npm = npm;
        this.nama = nama;
        this.tinggi = tinggi;
        this.pindahan = pindahan;
    }
    
    public String getNPM(){
        return npm;
    }
    public String getNama(){
        return nama;
    }
    public void setNama(String nama){
        this.nama = nama;
    }
    public int getTinggi(){
        return tinggi;
    }
    public void setTinggi(int tinggi){
        this.tinggi = tinggi;
    }
    public Boolean isPindahan(){
        return pindahan;
    }
    public void setPindahan(boolean pindahan){
        this.pindahan = pindahan;
    }
}

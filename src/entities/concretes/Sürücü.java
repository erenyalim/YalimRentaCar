package entities.concretes;

import entities.abstracts.İnsan;

public class Sürücü extends İnsan {
    private String tckimlikNo;
    private String ehliyetNo;
    private String plaka;
    private String alıştarihi;
    private String dönüştarihi;
    private int id;

    public Sürücü(){
    }

    public Sürücü(String firstName, String lastName,int id, String tckimlikNo,String ehliyetNo,String plaka, String alıştarihi, String dönüştarihi) {
        super(firstName, lastName);
        this.id = id;
        this.tckimlikNo = tckimlikNo;
        this.ehliyetNo = ehliyetNo;
        this.plaka = plaka;
        this.alıştarihi = alıştarihi;
        this.dönüştarihi = dönüştarihi;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTckimlikNo() {
        return tckimlikNo;
    }

    public void setTckimlikNo(String tckimlikNo) {
        this.tckimlikNo = tckimlikNo;
    }

    public String getEhliyetNo() {
        return ehliyetNo;
    }

    public void setEhliyetNo(String ehliyetNo) {
        this.ehliyetNo = ehliyetNo;
    }

    public String getPlaka() {
        return plaka;
    }

    public void setPlaka(String plaka) {
        this.plaka = plaka;
    }

    public String getAlıştarihi() {
        return alıştarihi;
    }

    public void setAlıştarihi(String alıştarihi) {
        this.alıştarihi = alıştarihi;
    }

    public String getDönüştarihi() {
        return dönüştarihi;
    }

    public void setDönüştarihi(String dönüştarihi) {
        this.dönüştarihi = dönüştarihi;
    }
}

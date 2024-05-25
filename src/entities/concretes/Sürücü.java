package entities.concretes;

import entities.abstracts.İnsan;

public class Sürücü extends İnsan {
    private String tckimlikNo;
    private String ehliyetNo;
    private int id;

    public Sürücü(){

    }

    public Sürücü(String firstName, String lastName,int id, String tckimlikNo,String ehliyetNo) {
        super(firstName, lastName);
        this.id = id;
        this.tckimlikNo = tckimlikNo;
        this.ehliyetNo = ehliyetNo;
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

}

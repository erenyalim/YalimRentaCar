package entities.concretes;

import java.util.Locale.Category;

public class Araç {
	private int id;
	private String marka;
	private String model;
	private String gövdetipi;
	private String yakitTürü;
	private String vites;
	private int price;
	private String plaka;
	
	public Araç() {
		super();
	}

	public Araç(int id, String marka, String model, String gövdetipi, String yakitTürü, String vites, int price,
			String plaka) {
		super();
		this.id = id;
		this.marka = marka;
		this.model = model;
		this.gövdetipi = gövdetipi;
		this.yakitTürü = yakitTürü;
		this.vites = vites;
		this.price = price;
		this.plaka = plaka;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarka() {
		return marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getgövdetipi() {
		return gövdetipi;
	}

	public void setgövdetipi(String gövdetipi) {
		this.gövdetipi = gövdetipi;
	}

	public String getYakitTürü() {
		return yakitTürü;
	}

	public void setYakitTürü(String yakitTürü) {
		this.yakitTürü = yakitTürü;
	}

	public String getVites() {
		return vites;
	}

	public void setVite(String vites) {
		this.vites = vites;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPlaka() {
		return plaka;
	}

	public void setPlaka(String plaka) {
		this.plaka = plaka;
	}
	
	
	
	
}

package entities.concretes;

import java.sql.Date;

import entities.abstracts.İnsan;

public class Müşteri extends İnsan {
	private int customerId;
	private long tckimlikNo;
	private Date dogumTarihi;
	private int ehliyetNo;
	
	public Müşteri() {
		super();
	}

	public Müşteri(int customerId, long tckimlikNo, Date dogumTarihi, int ehliyetNo) {
		super();
		this.customerId = customerId;
		this.tckimlikNo = tckimlikNo;
		this.dogumTarihi = dogumTarihi;
		this.ehliyetNo = ehliyetNo;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public long getTckimlikNo() {
		return tckimlikNo;
	}

	public void setTckimlikNo(long tckimlikNo) {
		this.tckimlikNo = tckimlikNo;
	}

	public Date getDogumTarihi() {
		return dogumTarihi;
	}

	public void setDogumTarihi(Date dogumTarihi) {
		this.dogumTarihi = dogumTarihi;
	}

	public int getEhliyetNo() {
		return ehliyetNo;
	}

	public void setEhliyetNo(int ehliyetNo) {
		this.ehliyetNo = ehliyetNo;
	}

	//OVERRIDE
	
	@Override
	public String getFirstName() {
		// TODO Auto-generated method stub
		return super.getFirstName();
	}

	@Override
	public void setFirstName(String firstName) {
		// TODO Auto-generated method stub
		super.setFirstName(firstName);
	}

	@Override
	public String getLastName() {
		// TODO Auto-generated method stub
		return super.getLastName();
	}

	@Override
	public void setLastName(String lastName) {
		// TODO Auto-generated method stub
		super.setLastName(lastName);
	}

	@Override
	public String getUserName() {
		// TODO Auto-generated method stub
		return super.getUserName();
	}

	@Override
	public void setUserName(String userName) {
		// TODO Auto-generated method stub
		super.setUserName(userName);
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return super.getPassword();
	}

	@Override
	public void setPassword(String password) {
		// TODO Auto-generated method stub
		super.setPassword(password);
	}

	
	
	
}
	
	
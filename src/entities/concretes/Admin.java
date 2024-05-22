package entities.concretes;

import entities.abstracts.İnsan;

public class Admin extends İnsan {
	private int adminId;

	public Admin() {
	}

	public Admin(int adminId) {

		this.adminId = adminId;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

}

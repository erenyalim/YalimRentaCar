package Main;
import GUI.AdminEkrani;
import GUI.AdminGiriş;
import GUI.AraçSeçim;
import GUI.GirisEkrani;
import GUI.Hakkimizda;
import GUI.KiralamaEkranı;
import GUI.KullanıcıGiriş;
import GUI.SürücüDetay;
import GUI.ÖdemeEkranı;
import GUI.ÜyeOl;
import GUI.ŞifremiUnuttum;

public class Main {

	public static void main(String[] args) {
		
		// Giriş ekranı 
		GirisEkrani girisEkrani = new GirisEkrani();
				
		// Admin giriş 
		//AdminGiriş adminGiriş = new AdminGiriş();
		
		// Kullanıcı giriş ekranı 
		//KullanıcıGiriş kullanıcıGiriş = new KullanıcıGiriş();

		//Üye ol ekranı 
		//ÜyeOl üyeOl = new ÜyeOl();

		//Şifremi unuttum
		//ŞifremiUnuttum şifremiUnuttum = new ŞifremiUnuttum();
		
		//Hakkimzida
		//Hakkimizda hakkimizda = new Hakkimizda();
		
		//Kiralama ekranı
		//KiralamaEkranı kiralamaEkranı = new KiralamaEkranı("İsim");
		
		//Araç Seçimi
		AraçSeçim araçSeçim = new AraçSeçim(5,"İsim");
		
		//Sürücü Detay
		//SürücüDetay sürücüDetay = new SürücüDetay();
		
		//Ödeme ekranı 
		//ÖdemeEkranı ödemeEkranı = new ÖdemeEkranı();
		
		//Admin Ekranı
		//AdminEkrani adminEkrani = new AdminEkrani();
	}

}

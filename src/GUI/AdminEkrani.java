package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class AdminEkrani extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMarka;
	private JTextField txtModel;
	private JComboBox boxkasaTipi;
	private JComboBox boxvites;
	private JTextField txtGnlkcret;
	private JButton btnAracEkle;
	private JLabel lblAdminEkle;
	private JTextField txtKullancAd;
	private JTextField txtparola;
	private JButton btnAdminEkle;
	private JTextField txtPlaka;
	private JLabel araçekle;
	private JButton btncik;
	private JComboBox boxyakittürü;
	private JLabel lblVites;

	public AdminEkrani() {

		// FRAME
		setResizable(false);
		setTitle("Yalım Rent a Car");
		setIconImage(Toolkit.getDefaultToolkit().getImage("YalımRentaCar.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setForeground(Color.DARK_GRAY);
		contentPane.setBackground(Color.DARK_GRAY);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btncik = new JButton("Çıkış yap");

		btncik.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GirisEkrani girisEkrani = new GirisEkrani();
				setVisible(false);
			}
		});

		btncik.setForeground(Color.BLACK);
		btncik.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		btncik.setBackground(Color.ORANGE);
		btncik.setBounds(1143, 11, 111, 40);
		contentPane.add(btncik);

		// Araç Ekle
		araçekle = new JLabel("Araç Ekle");
		araçekle.setForeground(new Color(163, 139, 61));
		araçekle.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 25));
		araçekle.setBounds(117, 49, 121, 30);
		contentPane.add(araçekle);

		txtMarka = new JTextField();
		txtMarka.setText("Marka");
		txtMarka.setForeground(Color.LIGHT_GRAY);
		txtMarka.setFont(new Font("Yu Gothic Medium", Font.BOLD | Font.ITALIC, 12));
		txtMarka.setColumns(10);
		txtMarka.setBounds(80, 90, 190, 21);
		contentPane.add(txtMarka);

		txtModel = new JTextField();
		txtModel.setText("Model");
		txtModel.setForeground(Color.LIGHT_GRAY);
		txtModel.setFont(new Font("Yu Gothic Medium", Font.BOLD | Font.ITALIC, 12));
		txtModel.setColumns(10);
		txtModel.setBounds(80, 122, 190, 21);
		contentPane.add(txtModel);

		String[] kasaTipi = { "Sedan", "SUV", "Coupe", "Hatchback", "Cabrio" };
		boxkasaTipi = new JComboBox(kasaTipi);
		boxkasaTipi.setSelectedIndex(-1);
		boxkasaTipi.setBounds(80, 176, 190, 21);
		contentPane.add(boxkasaTipi);

		String[] yakittürü = { "Benzin", "Dizel", "Elektrikli" };
		boxyakittürü = new JComboBox(yakittürü);
		boxyakittürü.setSelectedIndex(-1);
		boxyakittürü.setBounds(80, 234, 190, 21);
		contentPane.add(boxyakittürü);

		String[] vites = { "Otomatik", "Manuel" };
		boxvites = new JComboBox(vites);
		boxvites.setSelectedIndex(-1);
		boxvites.setBounds(80, 292, 190, 21);
		contentPane.add(boxvites);

		txtGnlkcret = new JTextField();
		txtGnlkcret.setText("Günlük Ücret");
		txtGnlkcret.setForeground(Color.LIGHT_GRAY);
		txtGnlkcret.setFont(new Font("Yu Gothic Medium", Font.BOLD | Font.ITALIC, 12));
		txtGnlkcret.setColumns(10);
		txtGnlkcret.setBounds(80, 333, 190, 21);
		contentPane.add(txtGnlkcret);

		txtPlaka = new JTextField();
		txtPlaka.setText("Plaka");
		txtPlaka.setForeground(Color.LIGHT_GRAY);
		txtPlaka.setFont(new Font("Yu Gothic Medium", Font.BOLD | Font.ITALIC, 12));
		txtPlaka.setColumns(10);
		txtPlaka.setBounds(80, 365, 190, 21);
		contentPane.add(txtPlaka);

		btnAracEkle = new JButton("Aracı Ekle");

		btnAracEkle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				BufferedReader br = null;
				FileReader fr = null;
				int tempId = 0;
				boolean found = false;

				try {
					fr = new FileReader("araç.txt");
					br = new BufferedReader(fr);
					String line;
					String[] strArray;

					while ((line = br.readLine()) != null) {
						strArray = line.split(",");
						int Id = Integer.parseInt(strArray[0]);
						if (Id > tempId) {
							tempId = Id;
						}
						if ((strArray[8].equals(txtPlaka.getText().trim()))) {
							found = true;
							JOptionPane.showMessageDialog(AdminEkrani.this, "Bu araç daha önce eklenmiştir.");
							break;

						}
					}

				} catch (IOException e) {

					System.out.println("Dosya okuma hatası oluştu.");
				} finally {
					if (fr != null) {
						try {
							fr.close();
						} catch (IOException exp) {
							System.out.println("Okuma işlemi başarılı ancak kapatma işlemi başarısız.");
						}
					}
				}
				if (found == false) {
					FileWriter fWriter = null;
					try {
						if (boxkasaTipi.getSelectedItem() != null && boxvites.getSelectedItem() != null
								&& boxyakittürü.getSelectedItem() != null) {
							tempId++;
							String temp = tempId + "," + txtMarka.getText().trim() + "," + txtModel.getText().trim() + ","
									+ boxkasaTipi.getSelectedItem().toString().trim() + ","
									+ boxyakittürü.getSelectedItem().toString().trim() + ","
									+ boxvites.getSelectedItem().toString().trim() + "," + txtGnlkcret.getText().trim()
									+ "," + " " + "," + txtPlaka.getText().trim() + "\r\n";
							fWriter = new FileWriter("araç.txt", true);
							fWriter.write(temp);
							JOptionPane.showMessageDialog(AdminEkrani.this, "Yeni araç eklendi.");
							dispose();
							AdminEkrani adminEkrani = new AdminEkrani();
						}
						else {
							JOptionPane.showMessageDialog(AdminEkrani.this, "Lütfen gerekli alanları doldurun.");
						}
					}

					catch (IOException exp) {
						System.out.println("Araç ekleme işlemi başarısız.");
					} finally {
						if (fWriter != null) {
							try {
								fWriter.close();
							} catch (IOException exp) {
								System.out.println("Kapatma başarısız.");
							}
						}
					}
				}
			}
		});

		btnAracEkle.setForeground(Color.BLACK);
		btnAracEkle.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		btnAracEkle.setBackground(Color.ORANGE);
		btnAracEkle.setBounds(80, 408, 111, 40);
		contentPane.add(btnAracEkle);

		lblAdminEkle = new JLabel("Admin Ekle");
		lblAdminEkle.setForeground(new Color(163, 139, 61));
		lblAdminEkle.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 25));
		lblAdminEkle.setBounds(444, 49, 150, 30);
		contentPane.add(lblAdminEkle);

		txtKullancAd = new JTextField();
		txtKullancAd.setText("Kullanıcı Adı");
		txtKullancAd.setForeground(Color.LIGHT_GRAY);
		txtKullancAd.setFont(new Font("Yu Gothic Medium", Font.BOLD | Font.ITALIC, 12));
		txtKullancAd.setColumns(10);
		txtKullancAd.setBounds(416, 90, 190, 21);
		contentPane.add(txtKullancAd);

		txtparola = new JTextField();
		txtparola.setText("Şifre");
		txtparola.setForeground(Color.LIGHT_GRAY);
		txtparola.setFont(new Font("Yu Gothic Medium", Font.BOLD | Font.ITALIC, 12));
		txtparola.setColumns(10);
		txtparola.setBounds(416, 122, 190, 21);
		contentPane.add(txtparola);

		btnAdminEkle = new JButton("Admin Ekle");

		btnAdminEkle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				BufferedReader br = null;
				FileReader fr = null;
				int tempId = 0;
				boolean found = false;

				try {
					fr = new FileReader("admin.txt");
					br = new BufferedReader(fr);
					String line;
					String[] strArray;

					while ((line = br.readLine()) != null) {
						strArray = line.split(",");
						int Id = Integer.parseInt(strArray[0]);
						if (Id > tempId) {
							tempId = Id;
						}
						if ((strArray[1].equals(txtKullancAd.getText().trim()))) {
							found = true;
							JOptionPane.showMessageDialog(AdminEkrani.this, "Bu kullanıcı adı daha önce alınmış.");
							break;

						}
					}

				} catch (IOException e) {

					System.out.println("Dosya okuma hatası oluştu.");
				} finally {
					if (fr != null) {
						try {
							fr.close();
						} catch (IOException exp) {
							System.out.println("Okuma işlemi başarılı ancak kapatma işlemi başarısız.");
						}
					}
				}
				if (found == false) {
					FileWriter fWriter = null;
					try {
						tempId++;
						String temp = tempId + "," + txtKullancAd.getText().trim() + "," + txtparola.getText().trim()
								+ "," + "\r\n";
						fWriter = new FileWriter("admin.txt", true);
						fWriter.write(temp);
						JOptionPane.showMessageDialog(AdminEkrani.this, "Yeni admin eklendi.");
					} catch (IOException exp) {
						System.out.println("Admin ekleme işlemi başarısız.");
					} finally {
						if (fWriter != null) {
							try {
								fWriter.close();
							} catch (IOException exp) {
								System.out.println("Kapatma başarısız.");
							}
						}
					}
				}
			}
		});

		btnAdminEkle.setForeground(Color.BLACK);
		btnAdminEkle.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		btnAdminEkle.setBackground(Color.ORANGE);
		btnAdminEkle.setBounds(416, 166, 111, 40);
		contentPane.add(btnAdminEkle);

		JLabel lblKasaTipi = new JLabel("Kasa Tipi :");
		lblKasaTipi.setForeground(new Color(163, 139, 61));
		lblKasaTipi.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		lblKasaTipi.setBounds(80, 154, 62, 14);
		contentPane.add(lblKasaTipi);

		JLabel lblYaktTr = new JLabel("Yakıt Türü: ");
		lblYaktTr.setForeground(new Color(163, 139, 61));
		lblYaktTr.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		lblYaktTr.setBounds(80, 208, 65, 14);
		contentPane.add(lblYaktTr);

		lblVites = new JLabel("Vites : ");
		lblVites.setForeground(new Color(163, 139, 61));
		lblVites.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		lblVites.setBounds(80, 267, 65, 14);
		contentPane.add(lblVites);

		setVisible(true);
	}
}

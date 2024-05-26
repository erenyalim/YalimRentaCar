package GUI;

import com.toedter.calendar.JDateChooser;

import java.awt.Color;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JCheckBox;

import javax.swing.ImageIcon;
import javax.swing.JTextField;

import java.awt.event.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.awt.Cursor;
import java.text.DateFormat;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.JPasswordField;

public class ÜyeOl extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JDateChooser doğumtarihi;
	private JTextField txtSoyad;
	private JTextField txtAd;
	private JTextField txtTcKimlikNo;
	private JTextField txtKullaniciadi;

	private JLabel kullanicikayitLabel;
	private JButton btnUyeol;
	private JCheckBox chckbox1;
	private JCheckBox chckbox2;
	private JButton btnGeriDn;
	private JLabel line;
	private JLabel labelparola;
	private JPasswordField parolafield;

	public ÜyeOl() {

		// Frame
		setResizable(false);
		setTitle("Yalım Rent a Car / Kullanıcı Kayıt");
		setIconImage(Toolkit.getDefaultToolkit().getImage("YalımRentaCar.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);

		contentPane = new JPanel();
		contentPane.setName("");
		contentPane.setForeground(Color.DARK_GRAY);
		contentPane.setBackground(Color.DARK_GRAY);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Kullanıcı Kayıt Yazı
		kullanicikayitLabel = new JLabel("Kullanıcı Kayıt");
		kullanicikayitLabel.setBounds(521, 27, 221, 36);
		kullanicikayitLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		kullanicikayitLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 30));
		kullanicikayitLabel.setForeground(Color.ORANGE);
		contentPane.add(kullanicikayitLabel);

		// Line
		line = new JLabel();
		line.setForeground(Color.ORANGE);
		line.setIcon(new ImageIcon("Line.png"));
		line.setBounds(0, 86, 1264, 6);
		contentPane.add(line);

		// Üye Ol Buton
		btnUyeol = new JButton("Üye Ol");

		// Üye Ol Buton dosya okuma yazma / checkbox kontrolü
		btnUyeol.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				BufferedReader br = null;
				FileReader fr = null;
				int tempId = 0;
				boolean found = false;
				try {
					fr = new FileReader("müşteri.txt");
					br = new BufferedReader(fr);
					String line;
					String[] strArray;

					while ((line = br.readLine()) != null) {
						strArray = line.split(",");
						tempId = Integer.parseInt(strArray[0]);
						if ((strArray[1].equals(txtTcKimlikNo.getText().trim()))) {
							found = true;
							JOptionPane.showMessageDialog(ÜyeOl.this, "Bu kullanıcı zaten mevcut.");
							break;

						}
						if ((strArray[5].equals(txtKullaniciadi.getText().trim()))) {
							found = true;
							JOptionPane.showMessageDialog(ÜyeOl.this, "Bu kullancı adı alınmış.");
							break;

						}
					}

				} catch (IOException e) {
					// TODO Auto-generated catch block
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
				if (chckbox1.isSelected() && chckbox2.isSelected()) {
					if (found == false) {
						FileWriter fWriter = null;
						try {
							tempId++;
							Date date = doğumtarihi.getDate();
							String strDate = DateFormat.getDateInstance().format(date);
							String temp = tempId + "," + txtTcKimlikNo.getText().trim() + "," + txtAd.getText().trim() + "," + txtSoyad.getText().trim() + "," + strDate + "," + txtKullaniciadi.getText().trim() + "," + new String(parolafield.getPassword()) + "\r\n";
							java.util.Arrays.fill(parolafield.getPassword(), '0'); 
							fWriter = new FileWriter("müşteri.txt", true);
							fWriter.write(temp);
							JOptionPane.showMessageDialog(ÜyeOl.this, "Kayıt olma başarılı.");

						} catch (IOException exp) {
							System.out.println("Kayıt olma işlemi başarısız.");
						} finally {
							if (fWriter != null) {
								try {
									fWriter.close();
									KullanıcıGiriş kullanıcıGiriş = new KullanıcıGiriş();
			                        setVisible(false);
								} catch (IOException exp) {
									System.out.println("Kapatma başarısız.");
								}
							}
						}
					}
				} else {
					JOptionPane.showMessageDialog(ÜyeOl.this,
							"Üyelik işlemi için gerekli koşulları kabul etmeniz gerekmektedir.");
				}

			}
		});

		btnUyeol.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		btnUyeol.setBackground(Color.ORANGE);
		btnUyeol.setForeground(Color.BLACK);
		btnUyeol.setBounds(483, 480, 117, 36);
		contentPane.add(btnUyeol);

		// Doğum Tarihi

		doğumtarihi = new JDateChooser();
		doğumtarihi.setBounds(483, 246, 297, 36);
		doğumtarihi.setDateFormatString("dd MMM yyyy");
		contentPane.add(doğumtarihi);

		// Soyad
		txtSoyad = new JTextField();
		txtSoyad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (txtSoyad.getText().equals("Soyad")) {
					txtSoyad.setText("");
					txtSoyad.setForeground(Color.LIGHT_GRAY);
				}
			}
		});

		txtSoyad.setText("Soyad");
		txtSoyad.setForeground(Color.LIGHT_GRAY);
		txtSoyad.setFont(new Font("Yu Gothic Medium", Font.BOLD, 18));
		txtSoyad.setColumns(10);
		txtSoyad.setBounds(483, 199, 297, 36);
		contentPane.add(txtSoyad);

		// Ad
		txtAd = new JTextField();
		txtAd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (txtAd.getText().equals("Ad")) {
					txtAd.setText("");
					txtAd.setForeground(Color.LIGHT_GRAY);
				}
			}
		});

		txtAd.setText("Ad");
		txtAd.setForeground(Color.LIGHT_GRAY);
		txtAd.setFont(new Font("Yu Gothic Medium", Font.BOLD, 18));
		txtAd.setColumns(10);
		txtAd.setBounds(483, 152, 297, 36);
		contentPane.add(txtAd);

		// T.C Kimlik Numarası
		
		txtTcKimlikNo = new JTextField();
		txtTcKimlikNo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (txtTcKimlikNo.getText().equals("T.C Kimlik Numarası")) {
					txtTcKimlikNo.setText("");
					txtTcKimlikNo.setForeground(Color.LIGHT_GRAY);
				}
			}
		});

		txtTcKimlikNo.setText("T.C Kimlik Numarası");
		txtTcKimlikNo.setForeground(Color.LIGHT_GRAY);
		txtTcKimlikNo.setFont(new Font("Yu Gothic Medium", Font.BOLD, 18));
		txtTcKimlikNo.setColumns(10);
		txtTcKimlikNo.setBounds(483, 105, 297, 36);
		contentPane.add(txtTcKimlikNo);

		txtTcKimlikNo.addKeyListener((KeyListener) new KeyAdapter() {
					public void keyTyped(KeyEvent e) {
						char c = e.getKeyChar();
						if (txtTcKimlikNo.getText().length() >= 11) {
							e.consume();
						}
						if(!Character.isDigit(c)) {
							e.consume();
						}
					}
				}
		);

		// Kullanıcı adı
		txtKullaniciadi = new JTextField();
		txtKullaniciadi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (txtKullaniciadi.getText().equals("Kullanıcı Adı")) {
					txtKullaniciadi.setText("");
					txtKullaniciadi.setForeground(Color.LIGHT_GRAY);
				}
			}
		});
		
		txtKullaniciadi.setText("Kullanıcı Adı");
		txtKullaniciadi.setForeground(Color.LIGHT_GRAY);
		txtKullaniciadi.setFont(new Font("Yu Gothic Medium", Font.BOLD, 18));
		txtKullaniciadi.setColumns(10);
		txtKullaniciadi.setBounds(483, 293, 297, 36);
		contentPane.add(txtKullaniciadi);

		// Geri dön buton
		btnGeriDn = new JButton("Geri Dön");
		btnGeriDn.setForeground(Color.BLACK);
		btnGeriDn.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		btnGeriDn.setBackground(Color.ORANGE);
		btnGeriDn.setBounds(663, 480, 117, 36);
		contentPane.add(btnGeriDn);
		// Giriş ekranına dönme
		btnGeriDn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == btnGeriDn) {

					GirisEkrani girisEkrani = new GirisEkrani();
					setVisible(false);

				}
			}
		});

		// Check Boxs
		chckbox1 = new JCheckBox("Kiralama Koşulları kabul ediyorum.");
		chckbox1.setForeground(Color.BLACK);
		chckbox1.setBackground(Color.ORANGE);
		chckbox1.setBounds(483, 439, 297, 23);
		contentPane.add(chckbox1);

		chckbox2 = new JCheckBox("KVKK Aydınlatma Metni'ni okudum ve anladım.");
		chckbox2.setBackground(Color.ORANGE);
		chckbox2.setForeground(Color.BLACK);
		chckbox2.setBounds(483, 413, 297, 23);
		contentPane.add(chckbox2);
		
		labelparola = new JLabel("Parola : ");
		labelparola.setForeground(new Color(163, 139, 61));
		labelparola.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		labelparola.setBounds(483, 340, 65, 14);
		contentPane.add(labelparola);
		
		parolafield = new JPasswordField();
		parolafield.setBounds(483, 358, 297, 36);
		contentPane.add(parolafield);

		setVisible(true);
	}
}
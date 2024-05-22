package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ŞifremiUnuttum extends JFrame {

	private JPanel contentPane;
	private JTextField txtTcKimlikNo;
	private JTextField txtKullaniciadi;
	private JLabel sifremiunuttumLabel;
	private JButton btnGeriDn;
	private JLabel line;
	private JButton btnsifregoster;

	public ŞifremiUnuttum() {
		
		setResizable(false);
		setTitle("Yalım Rent a Car / Şifremi Unuttum");
		setIconImage(Toolkit.getDefaultToolkit().getImage("YalımRentaCar.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setForeground(Color.DARK_GRAY);
		contentPane.setBackground(Color.DARK_GRAY);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		line = new JLabel();
		line.setForeground(Color.ORANGE);
		line.setIcon(new ImageIcon("Line.png"));
		line.setBounds(0, 86, 1264, 6);
		contentPane.add(line);
		
		sifremiunuttumLabel = new JLabel("Şifremi Unuttum ! ");
		sifremiunuttumLabel.setBounds(503, 27, 257, 36);
		sifremiunuttumLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		sifremiunuttumLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 30));
		sifremiunuttumLabel.setForeground(Color.ORANGE);
		contentPane.add(sifremiunuttumLabel);
		
		
		txtTcKimlikNo = new JTextField();
		txtTcKimlikNo.setBackground(Color.WHITE);
		txtTcKimlikNo.setText("T.C Kimlik Numarası");
		txtTcKimlikNo.setForeground(Color.LIGHT_GRAY);
		txtTcKimlikNo.setFont(new Font("Yu Gothic Medium", Font.BOLD, 18));
		txtTcKimlikNo.setColumns(10);
		txtTcKimlikNo.setBounds(483, 129, 297, 36);
		contentPane.add(txtTcKimlikNo);
		
		txtKullaniciadi = new JTextField();
		txtKullaniciadi.setText("Kullanıcı Adı");
		txtKullaniciadi.setForeground(Color.LIGHT_GRAY);
		txtKullaniciadi.setFont(new Font("Yu Gothic Medium", Font.BOLD, 18));
		txtKullaniciadi.setColumns(10);
		txtKullaniciadi.setBounds(483, 176, 297, 36);
		contentPane.add(txtKullaniciadi);
		
		btnGeriDn = new JButton("Geri Dön");
		btnGeriDn.setForeground(Color.BLACK);
		btnGeriDn.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		btnGeriDn.setBackground(Color.ORANGE);
		btnGeriDn.setBounds(638, 237, 142, 36);
		contentPane.add(btnGeriDn);
		
		btnGeriDn.addActionListener(new ActionListener() {


            public void actionPerformed(ActionEvent e) {

                if(e.getSource()==btnGeriDn) {

                	KullanıcıGiriş kullanıcıGiriş = new KullanıcıGiriş();
                    setVisible(false);

                }
            }});
		
		btnsifregoster = new JButton("Şifremi Göster");
		btnsifregoster.setForeground(Color.BLACK);
		btnsifregoster.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		btnsifregoster.setBackground(Color.ORANGE);
		btnsifregoster.setBounds(483, 237, 142, 36);
		contentPane.add(btnsifregoster);
		
		btnsifregoster.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        FileReader fr = null;
		        BufferedReader br = null;
		        boolean found = false;
		        try {
		            fr = new FileReader("müşteri.txt");
		            br = new BufferedReader(fr);
		            String line;
		            String[] strArray;
		            while ((line = br.readLine()) != null) {
		                strArray = line.split(",");
		                if ((strArray[1].equals(txtTcKimlikNo.getText().trim()))
		                        && (strArray[5].equals(txtKullaniciadi.getText().trim()))) {
		                    found = true;
		                    JOptionPane.showMessageDialog(ŞifremiUnuttum.this, "Şifreniz : " + strArray[6]);
		                    break;
		                } 
		            }
		            if (!found) {
		                JOptionPane.showMessageDialog(ŞifremiUnuttum.this, "Kullanıcı bulunamadı. Lütfen üye olun.");
		            }
		        } catch (Exception ex) {
		            System.out.println("Dosya okuma başarısız.");
		        } finally {
		            if (fr != null) {
		                try {
		                    fr.close();
		                    if (found) {
		                        KullanıcıGiriş kullanıcıGiriş = new KullanıcıGiriş();
		                        setVisible(false);
		                    }
		                } catch (Exception exp) {
		                    System.out.println("Okuma operasyonu başarılı ancak kapatma başarısız...");
		                }
		            }
		        }
		    }
		});
		
		setVisible(true);
		
	}
}
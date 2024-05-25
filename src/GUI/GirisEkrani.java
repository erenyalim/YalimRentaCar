package GUI;


import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Container;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.Font;
import java.awt.event.MouseEvent;

public class GirisEkrani extends JFrame {
	//Abstracts
	private JPanel contentPane;
	private JLabel logoLabel;
	private JButton btnAdmin;
	private JButton btnGiris;
	private JButton btnUye;;
	private JLabel yalimrentLabel;
	private JButton btnHakkimizda;
	private JLabel arabalarLabel;
	private JLabel lineLabel;
	private JLabel sloganLabel;
	
	//Frame
	public GirisEkrani() {
		
		Container cp = getContentPane();
		
		//Frame
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
		
		//Logo
		logoLabel = new JLabel("");
		logoLabel.setIcon(new ImageIcon("YalımRentaCar.png"));
		logoLabel.setBounds(-60, 23, 393, 329);
		contentPane.add(logoLabel);
		
		//Admin Giriş Buton
		btnAdmin = new JButton("Admin Giriş");
		btnAdmin.addActionListener(new ActionListener() {


            public void actionPerformed(ActionEvent e) {

                if(e.getSource()==btnAdmin) {

                	AdminGiriş adminGiriş = new AdminGiriş();
                    setVisible(false);

                }
            }});
		btnAdmin.setToolTipText("");
		btnAdmin.setForeground(new Color(70, 70, 70));
		btnAdmin.setBackground(new Color(255, 200, 0));
		btnAdmin.setBounds(1141, 23, 113, 35);
		contentPane.add(btnAdmin);
		
		// Giriş Ekranı to Admin Giriş
		btnAdmin.addActionListener(new ActionListener() {


            public void actionPerformed(ActionEvent e) {

                if(e.getSource()==btnAdmin) {

                	AdminGiriş admingiriş = new AdminGiriş();
                    setVisible(false);

                }
            }});
		
		//Admin buton renk değişim ayarı
		btnAdmin.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent e) {
            	btnAdmin.setBackground(new Color(238, 232, 170)); // Hover için renk değişimi
            }

            public void mouseExited(MouseEvent e) {
            	btnAdmin.setBackground(new Color(255, 215, 0)); // Mouse çekildiğinde renk resetlenir.
            }
        });
		
		//Müşteri Giriş Buton
		btnGiris = new JButton("Giriş Yap");
		btnGiris.setToolTipText("");
		btnGiris.setForeground(new Color(70, 70, 70));
		btnGiris.setBackground(Color.ORANGE);
		btnGiris.setBounds(895, 23, 113, 35);
		contentPane.add(btnGiris);
		
		// Giriş ekranı to Kullanıcı Giriş
		btnGiris.addActionListener(new ActionListener() {


            public void actionPerformed(ActionEvent e) {

                if(e.getSource()==btnGiris) {

                	KullanıcıGiriş kullanıcıGiriş = new KullanıcıGiriş();
                    setVisible(false);

                }
            }});
		
		//Müşteri giriş buton renk değişim ayarı
		btnGiris.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent e) {
            	btnGiris.setBackground(new Color(238, 232, 170)); // Hover için renk değişimi
            }

            public void mouseExited(MouseEvent e) {
            	btnGiris.setBackground(new Color(255, 215, 0)); // Mouse çekildiğinde renk resetlenir.
            }
        });
		
		//Üye Ol Buton
		btnUye = new JButton("Üye Ol");
		btnUye.setToolTipText("");
		btnUye.setForeground(new Color(70, 70, 70));
		btnUye.setBackground(Color.ORANGE);
		btnUye.setBounds(1018, 23, 113, 35);
		contentPane.add(btnUye);
		
		// Giriş Ekranı to Üye ol 
		btnUye.addActionListener(new ActionListener() {


            public void actionPerformed(ActionEvent e) {

                if(e.getSource()==btnUye) {

                	ÜyeOl üyeOl = new ÜyeOl();
                    setVisible(false);

                }
            }});
		
		//Üye ol buton renk değişim ayarı
		btnUye.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent e) {
            	btnUye.setBackground(new Color(238, 232, 170)); // Hover için renk değişimi
            }

            public void mouseExited(MouseEvent e) {
            	btnUye.setBackground(new Color(255, 215, 0)); // Mouse çekildiğinde renk resetlenir.
            }
        });
		
		// Yalım Rent a Car Başlık
		yalimrentLabel = new JLabel("Yalım Rent a Car ");
		yalimrentLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 30));
		yalimrentLabel.setForeground(new Color(163, 139, 61));
		yalimrentLabel.setBounds(501,23,268,35);
		contentPane.add(yalimrentLabel);
		
		// Hakkımızda butonu
		JButton btnHakkimizda = new JButton("Hakkımızda");
		btnHakkimizda.setBorderPainted(false);
		btnHakkimizda.setBackground(Color.DARK_GRAY);
		btnHakkimizda.setForeground(Color.ORANGE);
		btnHakkimizda.setBounds(10, 620, 171, 50);
		contentPane.add(btnHakkimizda);
		
		// Giriş ekranı to Hakkimizda 
		btnHakkimizda.addActionListener(new ActionListener() {


            public void actionPerformed(ActionEvent e) {

                if(e.getSource()==btnHakkimizda) {

                	Hakkimizda girisEkrani = new Hakkimizda();
                    setVisible(false);

                }
            }});
		
		// Araba resim
		arabalarLabel = new JLabel("");
		arabalarLabel.setIcon(new ImageIcon("arabalargiris.png"));
		arabalarLabel.setForeground(Color.DARK_GRAY);
		arabalarLabel.setBounds(392, 104, 915, 476);
		contentPane.add(arabalarLabel);
		
		// Line 
		JLabel lineLabel = new JLabel();
		lineLabel.setIcon(new ImageIcon("Line.png"));
		lineLabel.setBounds(0, 230, 1275, 193);
		contentPane.add(lineLabel);
		
		// Slogan 
		JLabel sloganLabel = new JLabel("\" Yol Arkadaşınız... \"");
		sloganLabel.setForeground(new Color(163, 139, 61));
		sloganLabel.setFont(new Font("Cascadia Code", Font.ITALIC, 15));
		sloganLabel.setBounds(519, 58, 206, 35);
		contentPane.add(sloganLabel);
		
		setVisible(true);
		
	
	}
}


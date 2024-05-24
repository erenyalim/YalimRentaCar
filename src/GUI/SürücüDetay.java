package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import entities.concretes.Araç;

import javax.swing.JButton;

public class SürücüDetay extends JFrame {

	private JPanel contentPane;
	private JLabel line;
	private JTextField tcNo;
	private JTextField ehliyetNo;
	private JTextField txtAd;
	private JTextField txtSoyad;
	private JLabel sürücüDetaylari;
	private JButton btnkaydet;
	private JButton btngeridön;
	private long toplamfiyat;
	
	public SürücüDetay(long günSayisi, String hoşgeldinkullanici,Araç selectedAraç) {
		
		setResizable(false);
		setTitle("Yalım Rent a Car / Sürücü Detay");
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

		tcNo = new JTextField();
		tcNo.setText("T.C Kimlik Numarası");
		tcNo.setForeground(Color.LIGHT_GRAY);
		tcNo.setFont(new Font("Yu Gothic Medium", Font.BOLD, 18));
		tcNo.setColumns(10);
		tcNo.setBounds(483, 120, 297, 36);
		contentPane.add(tcNo);
		
		tcNo = new JTextField();
		tcNo.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	                if (tcNo.getText().equals("T.C Kimlik Numarası")) {
	                	tcNo.setText("");
	                	tcNo.setForeground(Color.LIGHT_GRAY);
	                }
	            }
	        });

		ehliyetNo = new JTextField();
		ehliyetNo.setText("Ehliyet Numarası");
		ehliyetNo.setForeground(Color.LIGHT_GRAY);
		ehliyetNo.setFont(new Font("Yu Gothic Medium", Font.BOLD, 18));
		ehliyetNo.setColumns(10);
		ehliyetNo.setBounds(483, 167, 297, 36);
		contentPane.add(ehliyetNo);
		
		ehliyetNo = new JTextField();
		ehliyetNo.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	                if (ehliyetNo.getText().equals("Ehliyet Numarası")) {
	                	ehliyetNo.setText("");
	                	ehliyetNo.setForeground(Color.LIGHT_GRAY);
	                }
	            }
	        });

		txtAd = new JTextField();
		txtAd.setText("Ad");
		txtAd.setForeground(Color.LIGHT_GRAY);
		txtAd.setFont(new Font("Yu Gothic Medium", Font.BOLD, 18));
		txtAd.setColumns(10);
		txtAd.setBounds(483, 214, 297, 36);
		contentPane.add(txtAd);
		txtAd.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (txtAd.getText().equals("Ad")) {
                	txtAd.setText("");
                	txtAd.setForeground(Color.LIGHT_GRAY);
                }
            }
        });

		txtSoyad = new JTextField();
		txtSoyad.setText("Soyad");
		txtSoyad.setForeground(Color.LIGHT_GRAY);
		txtSoyad.setFont(new Font("Yu Gothic Medium", Font.BOLD, 18));
		txtSoyad.setColumns(10);
		txtSoyad.setBounds(483, 261, 297, 36);
		contentPane.add(txtSoyad);
		txtSoyad.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (txtSoyad.getText().equals("Soyad")) {
                	txtSoyad.setText("");
                	txtSoyad.setForeground(Color.LIGHT_GRAY);
                }
            }
        });

		sürücüDetaylari = new JLabel("Sürücü Detayları");
		sürücüDetaylari.setBounds(531, 39, 201, 36);
		sürücüDetaylari.setAlignmentX(Component.CENTER_ALIGNMENT);
		sürücüDetaylari.setFont(new Font("Arial", Font.ITALIC, 25));
		sürücüDetaylari.setForeground(Color.ORANGE);
		contentPane.add(sürücüDetaylari);

		btnkaydet = new JButton("Kaydet");
		btnkaydet.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        AraçSeçim araçSeçim = new AraçSeçim(günSayisi, hoşgeldinkullanici);
		        setVisible(false);
		    }
		});
		btnkaydet.setForeground(Color.BLACK);
		btnkaydet.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		btnkaydet.setBackground(Color.ORANGE);
		btnkaydet.setBounds(483, 326, 134, 36);
		contentPane.add(btnkaydet);

		btngeridön = new JButton("Geri Dön");
		btngeridön.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        AraçSeçim araçSeçim = new AraçSeçim(günSayisi, hoşgeldinkullanici);
		        setVisible(false);
		    }
		});

		btngeridön.setForeground(Color.BLACK);
		btngeridön.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		btngeridön.setBackground(Color.ORANGE);
		btngeridön.setBounds(646, 326, 134, 36);
		contentPane.add(btngeridön);
		

		setVisible(true);
	}
}
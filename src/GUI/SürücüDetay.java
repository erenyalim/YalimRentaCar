package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class SürücüDetay extends JFrame {
	
	private JPanel contentPane;
	private JLabel line;
	private JTextField tcNo;
	private JTextField ehliyetNo;
	private JTextField txtAd;
	private JTextField txtSoyad;
	private JLabel sürücüDetaylari;
	
	public SürücüDetay() {
		
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
		tcNo.setBounds(60, 150, 297, 36);
		contentPane.add(tcNo);

		ehliyetNo = new JTextField();
		ehliyetNo.setText("Ehliyet Numarası");
		ehliyetNo.setForeground(Color.LIGHT_GRAY);
		ehliyetNo.setFont(new Font("Yu Gothic Medium", Font.BOLD, 18));
		ehliyetNo.setColumns(10);
		ehliyetNo.setBounds(60, 197, 297, 36);
		contentPane.add(ehliyetNo);
		
		txtAd = new JTextField();
		txtAd.setText("Ad");
		txtAd.setForeground(Color.LIGHT_GRAY);
		txtAd.setFont(new Font("Yu Gothic Medium", Font.BOLD, 18));
		txtAd.setColumns(10);
		txtAd.setBounds(60, 244, 297, 36);
		contentPane.add(txtAd);

		txtSoyad = new JTextField();
		txtSoyad.setText("Soyad");
		txtSoyad.setForeground(Color.LIGHT_GRAY);
		txtSoyad.setFont(new Font("Yu Gothic Medium", Font.BOLD, 18));
		txtSoyad.setColumns(10);
		txtSoyad.setBounds(60, 291, 297, 36);
		contentPane.add(txtSoyad);
		
		sürücüDetaylari = new JLabel("Sürücü Detayları");
		sürücüDetaylari.setBounds(531, 39, 201, 36);
		sürücüDetaylari.setAlignmentX(Component.CENTER_ALIGNMENT);
		sürücüDetaylari.setFont(new Font("Arial", Font.ITALIC, 25));
		sürücüDetaylari.setForeground(Color.ORANGE);
		contentPane.add(sürücüDetaylari);
		
		setVisible(true);
	}
}

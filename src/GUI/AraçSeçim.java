package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.JList;

public class AraçSeçim extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btngeri;

	public AraçSeçim() {
		
		setResizable(false);
		setTitle("Yalım Rent a Car");
		setIconImage(Toolkit.getDefaultToolkit().getImage("YalımRentaCar.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setForeground(Color.DARK_GRAY);
		contentPane.setBackground(Color.DARK_GRAY);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btngeri = new JButton("GeriDön");
		btngeri.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				KiralamaEkranı kiralamaEkranı = new KiralamaEkranı();
				setVisible(false);
			}
		});
		btngeri.setForeground(Color.BLACK);
		btngeri.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		btngeri.setBackground(Color.ORANGE);
		btngeri.setBounds(1143, 11, 111, 40);
		contentPane.add(btngeri);
		
		setVisible(true);

	}
}

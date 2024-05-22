package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class AdminGiriş extends JFrame {

	private JPanel contentPane;
	private JTextField txtKullancAd;
	private JTextField txtsifre;
	private JLabel admingirisLabel;
	private JButton btnGirisyap;
	private JButton btnGeriDn;
	private JLabel line;


	public AdminGiriş() {
				//Frame
				setResizable(false);
				setTitle("Yalım Rent a Car / Admin Giriş");
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
				
				
				admingirisLabel = new JLabel("Admin Giriş");
				admingirisLabel.setBounds(542, 27, 180, 36);
				admingirisLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
				admingirisLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 30));
				admingirisLabel.setForeground(Color.ORANGE);
				contentPane.add(admingirisLabel);
				
				btnGirisyap = new JButton("Giriş Yap");
				btnGirisyap.addActionListener(new ActionListener() {
				    @Override
				    public void actionPerformed(ActionEvent e) {
				        FileReader fr = null;
				        BufferedReader br = null;
				        boolean found = false;
				        try {
				            fr = new FileReader("admin.txt");
				            br = new BufferedReader(fr);
				            String line;
				            String[] strArray;
				            while ((line = br.readLine()) != null) {
				                strArray = line.split(",");
				                if ((strArray[1].equals(txtKullancAd.getText().trim()))
				                        && (strArray[2].equals(txtsifre.getText().trim()))) {
				                    found = true;
				                    break;
				                } 
				            }
				            if (!found) {
				                JOptionPane.showMessageDialog(AdminGiriş.this, "Bilgilerinizi kontrol edin.");
				            } 
				            
				        } catch (Exception ex) {
				            System.out.println("Dosya okuma başarısız.");
				        } finally {
				            if (fr != null) {
				                try {
				                    fr.close();
				                    if (found) {
				                        AdminEkrani adminEkrani = new AdminEkrani();
				                        setVisible(false);
				                    }
				                } catch (Exception exp) {
				                    System.out.println("Okuma operasyonu başarılı ancak kapatma başarısız...");
				                }
				            }
				        }
				    }
				});
				btnGirisyap.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
				btnGirisyap.setBackground(Color.ORANGE);
				btnGirisyap.setForeground(Color.BLACK);
				btnGirisyap.setBounds(483, 219, 117, 36);
				contentPane.add(btnGirisyap);
				
				btnGirisyap.addMouseListener(new MouseAdapter() {

		            public void mouseEntered(MouseEvent e) {
		            	btnGirisyap.setBackground(new Color(238, 232, 170)); // Hover için renk değişimi
		            }

		            public void mouseExited(MouseEvent e) {
		            	btnGirisyap.setBackground(new Color(255, 215, 0)); // Mouse çekildiğinde renk resetlenir.
		            }
		        });
				
				btnGeriDn = new JButton("Geri Dön");
				btnGeriDn.setForeground(Color.BLACK);
				btnGeriDn.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
				btnGeriDn.setBackground(Color.ORANGE);
				btnGeriDn.setBounds(663, 219, 117, 36);
				contentPane.add(btnGeriDn);
				
				btnGeriDn.addMouseListener(new MouseAdapter() {

		            public void mouseEntered(MouseEvent e) {
		            	btnGeriDn.setBackground(new Color(238, 232, 170)); // Hover için renk değişimi
		            }

		            public void mouseExited(MouseEvent e) {
		            	btnGeriDn.setBackground(new Color(255, 215, 0)); // Mouse çekildiğinde renk resetlenir.
		            }
		        });
				
				
				btnGeriDn.addActionListener(new ActionListener() {


		            public void actionPerformed(ActionEvent e) {

		                if(e.getSource()==btnGeriDn) {

		                	GirisEkrani girisEkrani = new GirisEkrani();
		                    setVisible(false);

		                }
		            }});

				
				txtKullancAd = new JTextField();
				
				txtKullancAd.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if (txtKullancAd.getText().equals("Kullanıcı adı")) {
							txtKullancAd.setText("");
							txtKullancAd.setForeground(Color.LIGHT_GRAY);
						}
					}
				});
				
				txtKullancAd.setText("Kullanıcı adı");
				txtKullancAd.setForeground(Color.LIGHT_GRAY);
				txtKullancAd.setFont(new Font("Yu Gothic Medium", Font.BOLD, 18));
				txtKullancAd.setColumns(10);
				txtKullancAd.setBounds(483, 112, 297, 36);
				contentPane.add(txtKullancAd);
				
				txtsifre = new JTextField();
				txtsifre.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if (txtsifre.getText().equals("Parola")) {
							txtsifre.setText("");
							txtsifre.setForeground(Color.LIGHT_GRAY);
						}
					}
				});
				
				txtsifre.setText("Parola");
				txtsifre.setForeground(Color.LIGHT_GRAY);
				txtsifre.setFont(new Font("Yu Gothic Medium", Font.BOLD, 18));
				txtsifre.setColumns(10);
				txtsifre.setBounds(483, 159, 297, 36);
				contentPane.add(txtsifre);
				
				setVisible(true);
	}
}
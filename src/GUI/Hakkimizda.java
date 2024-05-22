package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Hakkimizda extends JFrame {

	private JPanel contentPane;
	private JLabel hakkimizdaLabel;
	private JTextPane txtpnHakkimizda;
	private JLabel logoLabel;
	private JButton btnGeriDn;
	
	public Hakkimizda() {
		
		setResizable(false);
		setTitle("Yalım Rent a Car / Hakkimizda ");
		setIconImage(Toolkit.getDefaultToolkit().getImage("YalımRentaCar.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setForeground(Color.DARK_GRAY);
		contentPane.setBackground(Color.DARK_GRAY);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		hakkimizdaLabel = new JLabel("HAKKIMIZDA  ");
		hakkimizdaLabel.setFont(new Font("Arial", Font.ITALIC, 30));
		hakkimizdaLabel.setForeground(new Color(163, 139, 61));
		hakkimizdaLabel.setBounds(20,11,268,35);
		contentPane.add(hakkimizdaLabel);
		
		txtpnHakkimizda = new JTextPane();
		txtpnHakkimizda.setBackground(Color.DARK_GRAY);
		txtpnHakkimizda.setForeground(Color.ORANGE);
		txtpnHakkimizda.setFont(new Font("Tahoma", Font.ITALIC, 15));
		txtpnHakkimizda.setEnabled(false);
		txtpnHakkimizda.setEditable(false);
		txtpnHakkimizda.setText("Yalım Rent a Car, müşterilerine güvenilir ve kaliteli araç kiralama hizmetleri sunan öncü bir firmadır. "
				+ "Kurulduğumuz günden bu yana, müşteri memnuniyeti ve güvenilirlik ilkelerimizin temelinde ilerliyoruz.\r\n\r\nMisyonumuz, "
				+ "her zaman müşterilerimize en iyi hizmeti sunmak ve seyahat deneyimlerini daha konforlu ve keyifli hale getirmektir. "
				+ "Geniş araç filomuzla, müşterilerimizin her ihtiyacına uygun seçenekler sunuyoruz. Güvenlik ve kalite standartlarımızı "
				+ "her zaman en üst düzeyde tutarak, müşterilerimizin seyahatlerini sorunsuz bir şekilde tamamlamalarını sağlıyoruz.\r\n\r\n"
				+ "Yalım Rent a Car olarak, müşterilerimizin beklentilerini aşmayı ve her zaman en iyi hizmeti sunmayı taahhüt ediyoruz. "
				+ "Profesyonel ve deneyimli ekibimizle birlikte, müşterilerimizin her türlü talebine hızlı ve etkili bir şekilde cevap veriyoruz.\r\n\r\n"
				+ "Bizimle seyahat ettiğinizde, kalite, güvenlik ve müşteri memnuniyeti konusunda en yüksek standartları bulacaksınız. Yalım Rent a Car olarak, "
				+ "sizlere unutulmaz bir araç kiralama deneyimi yaşatmak için buradayız.");
		
		// Text dosyası oluştur ve oradan oku.
		
		txtpnHakkimizda.setBounds(20, 57, 957, 272);
		contentPane.add(txtpnHakkimizda);
		
		logoLabel = new JLabel();
		logoLabel.setForeground(Color.WHITE);
		logoLabel.setIcon(new ImageIcon("YalımRentaCar.png"));
		logoLabel.setBounds(392, 333, 479, 337);
		contentPane.add(logoLabel);
		
		btnGeriDn = new JButton("Geri Dön");
		btnGeriDn.setForeground(Color.BLACK);
		btnGeriDn.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		btnGeriDn.setBackground(Color.ORANGE);
		btnGeriDn.setBounds(1139, 634, 115, 36);
		contentPane.add(btnGeriDn);
		
		btnGeriDn.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent e) {
            	btnGeriDn.setBackground(new Color(238, 232, 170)); // Hover için renk değişimi
            }

            public void mouseExited(MouseEvent e) {
            	btnGeriDn.setBackground(new Color(255, 215, 0)); // Mouse çekildiğinde renk resetlenir.
            }
        });
		
		// Hakkimizda to Giriş ekranı
		btnGeriDn.addActionListener(new ActionListener() {


            public void actionPerformed(ActionEvent e) {

                if(e.getSource()==btnGeriDn) {

                	GirisEkrani girisEkrani = new GirisEkrani();
                    setVisible(false);

                }
            }});
		
		
		setVisible(true);
	}
}

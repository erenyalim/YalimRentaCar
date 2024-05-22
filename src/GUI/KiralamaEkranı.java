package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import javax.swing.*;

import com.toedter.calendar.JDateChooser;

public class KiralamaEkranı extends JFrame {
	 
	private JPanel contentPane;
	private JButton teklifleriGöster;
	private JLabel line;
	private JButton btncik;
	private JLabel labelalis;
	private JLabel labeldönüs;
	private JComboBox<String> comboAlis;
	private JComboBox<String> comboDönüs;
	private JLabel alistarihi;
	private JLabel donustarihi;
	private JDateChooser dateChooserAlis;
	private JDateChooser dateChooserDonüs;
	private JLabel lblHosgeldin;
	private JLabel lblYalmRentA;
	private String hoşgeldinkullanici;

	public KiralamaEkranı(String hoşgeldinkullanici) {
		this.hoşgeldinkullanici = hoşgeldinkullanici;
		
		// Frame
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

		line = new JLabel();
		line.setForeground(Color.ORANGE);
		line.setIcon(new ImageIcon("Line.png"));
		line.setBounds(0, 86, 1264, 6);
		contentPane.add(line);

		teklifleriGöster = new JButton("Teklifleri Göster");
		teklifleriGöster.setForeground(Color.BLACK);
		teklifleriGöster.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		teklifleriGöster.setBackground(Color.ORANGE);
		teklifleriGöster.setBounds(836, 275, 209, 49);
		contentPane.add(teklifleriGöster);
		
		teklifleriGöster.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == teklifleriGöster) { // getsource hangi nesneden geldiğini belirler. burda e actionı btncik dan mı geldiğini kontrol ediyor.
					LocalDate alisTarihi = dateChooserAlis.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			        LocalDate donusTarihi = dateChooserDonüs.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			        long gunSayisi = ChronoUnit.DAYS.between(alisTarihi, donusTarihi);
			        AraçSeçim araçSeçim = new AraçSeçim(gunSayisi, gethoşgeldinkullanici());
					setVisible(false);
				}
			}
		});

		btncik = new JButton("Çıkış yap");
		btncik.setForeground(Color.BLACK);
		btncik.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		btncik.setBackground(Color.ORANGE);
		btncik.setBounds(1143, 21, 111, 40);
		contentPane.add(btncik);

		btncik.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btncik) { // getsource hangi nesneden geldiğini belirler. burda e actionı btncik  dan mı geldiğini kontrol ediyor.
					GirisEkrani girisEkrani = new GirisEkrani();
					setVisible(false);
				}
			}
		});

		labelalis = new JLabel("Alış Yeri : ");
		labelalis.setForeground(Color.ORANGE);
		labelalis.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		labelalis.setAlignmentX(0.5f);
		labelalis.setBounds(135, 159, 76, 21);
		contentPane.add(labelalis);

		labeldönüs = new JLabel("Dönüş Yeri :");
		labeldönüs.setForeground(Color.ORANGE);
		labeldönüs.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		labeldönüs.setAlignmentX(0.5f);
		labeldönüs.setBounds(367, 159, 82, 21);
		contentPane.add(labeldönüs);

		String[] strAlis = { "İstanbul Beylikdüzü", "İstanbul Sarıyer", "İstanbul Kadıköy", "İstanbul Florya", "İstanbul Beşiktaş" };
		comboAlis = new JComboBox<>(strAlis);
		comboAlis.setBackground(Color.WHITE);
		comboAlis.setSelectedIndex(-1);
		comboAlis.setForeground(Color.BLACK);
		comboAlis.setBounds(135, 191, 209, 40);
		contentPane.add(comboAlis);

		String[] strDönüs = { "İstanbul Beylikdüzü", "İstanbul Sarıyer", "İstanbul Kadıköy", "İstanbul Florya", "İstanbul Beşiktaş" };
		comboDönüs = new JComboBox<>(strDönüs);
		comboDönüs.setBackground(Color.WHITE);
		comboDönüs.setSelectedIndex(-1);
		comboDönüs.setBounds(367, 191, 209, 40);
		contentPane.add(comboDönüs);

		// Date Chooser
		dateChooserAlis = new JDateChooser();
		dateChooserAlis.setDateFormatString("dd mm yyyy");
		dateChooserAlis.getCalendarButton().setBackground(Color.ORANGE);
		dateChooserAlis.setBackground(Color.DARK_GRAY);
		dateChooserAlis.setBounds(602, 191, 209, 40);
		contentPane.add(dateChooserAlis);

		dateChooserDonüs = new JDateChooser();
		dateChooserDonüs.setBackground(Color.DARK_GRAY);
		dateChooserDonüs.getCalendarButton().setBackground(Color.ORANGE);
		dateChooserDonüs.setBounds(836, 191, 209, 40);
		contentPane.add(dateChooserDonüs);

		// Labels
		alistarihi = new JLabel("Alış Tarihi : ");
		alistarihi.setForeground(Color.ORANGE);
		alistarihi.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		alistarihi.setAlignmentX(0.5f);
		alistarihi.setBounds(602, 159, 82, 21);
		contentPane.add(alistarihi);
		
		donustarihi = new JLabel("Dönüş Tarihi : ");
		donustarihi.setForeground(Color.ORANGE);
		donustarihi.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		donustarihi.setAlignmentX(0.5f);
		donustarihi.setBounds(836, 159, 82, 21);
		contentPane.add(donustarihi);

		lblHosgeldin = new JLabel("Hoşgeldin, " + hoşgeldinkullanici);
		lblHosgeldin.setForeground(Color.ORANGE);
		lblHosgeldin.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 30));
		lblHosgeldin.setAlignmentX(0.5f);
		lblHosgeldin.setBounds(27, 21, 317, 40);
		contentPane.add(lblHosgeldin);

		lblYalmRentA = new JLabel("Araç Kiralama - Yalım Rent a Car ");
		lblYalmRentA.setForeground(Color.ORANGE);
		lblYalmRentA.setFont(new Font("Cascadia Code", Font.BOLD | Font.ITALIC, 12));
		lblYalmRentA.setAlignmentX(0.5f);
		lblYalmRentA.setBounds(135, 127, 249, 21);
		contentPane.add(lblYalmRentA);

		JButton btnKiralkAralarm = new JButton("Kiralık Araçlarım");
		btnKiralkAralarm.setForeground(Color.BLACK);
		btnKiralkAralarm.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		btnKiralkAralarm.setBackground(Color.ORANGE);
		btnKiralkAralarm.setBounds(135, 406, 209, 49);
		contentPane.add(btnKiralkAralarm);

		setVisible(true);
	}
	
    public String gethoşgeldinkullanici() {
		return hoşgeldinkullanici;
	}
}
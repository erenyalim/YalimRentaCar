package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import entities.concretes.Araç;

public class ÖdemeEkranı extends JFrame {

    private JPanel contentPane;
    private JLabel ödeme;
    private JTextField kartNo;
    private JTextField cvv;
    private JComboBox<String> ay;
    private JComboBox<String> yil;
    private JButton btngeridön;
    private JButton btnödemeYap;
    private JLabel line;
    private JLabel labelay;
    private JLabel labelyil;
    private JLabel lblKartNumaras;
    private JLabel lblCvv;
    private String hoşgeldinkullanici;
    private long günSayisi;
    private long toplamfiyat;
    protected Araç selectedAraç;
    private JLabel lbldenecekTutar;
    private String alıştarihi;
    private String dönüştarihi;

    public ÖdemeEkranı(long günSayisi, String hoşgeldinkullanici, long toplamFiyat,Araç selectedAraç) {
        this.hoşgeldinkullanici = hoşgeldinkullanici;
        this.günSayisi = günSayisi;
        this.toplamfiyat = toplamFiyat;
        this.selectedAraç = selectedAraç;


        setResizable(false);
        setTitle("Yalım Rent a Car");
        setIconImage(Toolkit.getDefaultToolkit().getImage("YalımRentaCar.png"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1280, 720);
        contentPane = new JPanel();
        contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        contentPane.setForeground(Color.DARK_GRAY);
        contentPane.setBackground(Color.DARK_GRAY);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        line = new JLabel();
        line.setForeground(Color.ORANGE);
        line.setIcon(new ImageIcon("Line.png"));
        line.setBounds(0, 86, 1264, 6);
        contentPane.add(line);

        ödeme = new JLabel("Ödeme");
        ödeme.setBounds(574, 27, 115, 36);
        ödeme.setAlignmentX(Component.CENTER_ALIGNMENT);
        ödeme.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 30));
        ödeme.setForeground(Color.ORANGE);
        contentPane.add(ödeme);

        kartNo = new JTextField();
        kartNo.setForeground(Color.LIGHT_GRAY);
        kartNo.setFont(new Font("Yu Gothic Medium", Font.BOLD, 18));
        kartNo.setColumns(10);
        kartNo.setBounds(192, 162, 297, 36);
        contentPane.add(kartNo);
        kartNo.addKeyListener((KeyListener) new KeyAdapter() {
                    public void keyTyped(KeyEvent e) {
                        char c = e.getKeyChar();
                        if (kartNo.getText().length() >= 16) {
                            e.consume();
                        }
                        if(!Character.isDigit(c)) {
                            e.consume();
                        }
                    }
                }
        );

        cvv = new JTextField();
        cvv.setForeground(Color.LIGHT_GRAY);
        cvv.setFont(new Font("Yu Gothic Medium", Font.BOLD, 18));
        cvv.setColumns(10);
        cvv.setBounds(752, 162, 124, 36);
        contentPane.add(cvv);
        cvv.addKeyListener((KeyListener) new KeyAdapter() {
                    public void keyTyped(KeyEvent e) {
                        char c = e.getKeyChar();
                        if (cvv.getText().length() >= 4) {
                            e.consume();
                        }
                        if(!Character.isDigit(c)) {
                            e.consume();
                        }
                    }
                }
        );

        String[] aylar = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
        ay = new JComboBox<>(aylar);
        ay.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        ay.setEditable(true);
        ay.setBounds(502, 162, 115, 36);
        contentPane.add(ay);

        String[] yillar = {"2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039"};
        yil = new JComboBox<>(yillar);
        yil.setBounds(627, 162, 115, 36);
        contentPane.add(yil);

        btngeridön = new JButton("Geri Dön");
        btngeridön.setForeground(Color.BLACK);
        btngeridön.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
        btngeridön.setBackground(Color.ORANGE);
        btngeridön.setBounds(759, 237, 117, 36);
        contentPane.add(btngeridön);
        btngeridön.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SürücüDetay sürücüDetay = new SürücüDetay(günSayisi, hoşgeldinkullanici, selectedAraç,alıştarihi,dönüştarihi);
                sürücüDetay.setVisible(true);
                dispose();  // Bu pencereyi kapat
            }
        });

        btngeridön.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                btngeridön.setBackground(new Color(238, 232, 170)); // Hover için renk değişimi
            }

            public void mouseExited(MouseEvent e) {
                btngeridön.setBackground(new Color(255, 215, 0)); // Mouse çekildiğinde renk resetlenir.
            }
        });

        btnödemeYap = new JButton("Ödeme Yap");
        btnödemeYap.setForeground(Color.BLACK);
        btnödemeYap.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
        btnödemeYap.setBackground(Color.ORANGE);
        btnödemeYap.setBounds(627, 237, 117, 36);
        contentPane.add(btnödemeYap);

        btnödemeYap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileReader fr = null;
                BufferedReader br = null;
                boolean found = false;
                try {
                    fr = new FileReader("kartbilgileri.txt");
                    br = new BufferedReader(fr);
                    String line;
                    String[] strArray;
                    while ((line = br.readLine()) != null) {
                        strArray = line.split(",");
                        if ((strArray.length >= 3)
                                && strArray[0].equals(kartNo.getText().trim())
                                && strArray[1].equals(ay.getSelectedItem())
                                && strArray[2].equals(yil.getSelectedItem())) {
                            found = true;
                            JOptionPane.showMessageDialog(ÖdemeEkranı.this, "Ödemeniz başarıyla alınmıştır. Yalım Rent a Car'ı tercih ettiğiniz için teşekkür ederiz. Aracınızı tercih ettiğiniz bayimizden teslim alabilirsiniz.");
                            KiralamaEkranı kiralamaEkranı = new KiralamaEkranı(hoşgeldinkullanici);
                            setVisible(false);
                            break;
                        }
                    }
                    if (!found) {
                        JOptionPane.showMessageDialog(ÖdemeEkranı.this, "Ödeme alınamadı. Kart bilgilerinizi kontrol edip tekrar deneyiniz.");
                    }
                } catch (Exception ex) {
                    System.out.println("Dosya okuma başarısız.");
                } finally {
                    try {
                        if (br != null) br.close();
                        if (fr != null) fr.close();
                    } catch (Exception exp) {
                        System.out.println("Okuma operasyonu başarılı ancak kapatma başarısız...");
                    }
                }
            }
        });

        labelay = new JLabel("Ay : ");
        labelay.setForeground(Color.ORANGE);
        labelay.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 10));
        labelay.setAlignmentX(0.5f);
        labelay.setBounds(502, 135, 30, 21);
        contentPane.add(labelay);

        labelyil = new JLabel("Yıl : ");
        labelyil.setForeground(Color.ORANGE);
        labelyil.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 10));
        labelyil.setAlignmentX(0.5f);
        labelyil.setBounds(627, 135, 30, 21);
        contentPane.add(labelyil);

        lblKartNumaras = new JLabel("Kart Numarası : ");
        lblKartNumaras.setForeground(Color.ORANGE);
        lblKartNumaras.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 10));
        lblKartNumaras.setAlignmentX(0.5f);
        lblKartNumaras.setBounds(192, 130, 92, 21);
        contentPane.add(lblKartNumaras);

        lblCvv = new JLabel("CVV : ");
        lblCvv.setForeground(Color.ORANGE);
        lblCvv.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 10));
        lblCvv.setAlignmentX(0.5f);
        lblCvv.setBounds(752, 130, 92, 21);
        contentPane.add(lblCvv);

        lbldenecekTutar = new JLabel("Ödenecek Tutar : " + getToplamfiyat() + "TL");
        lbldenecekTutar.setForeground(Color.ORANGE);
        lbldenecekTutar.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 10));
        lbldenecekTutar.setAlignmentX(0.5f);
        lbldenecekTutar.setBounds(192, 249, 425, 21);
        contentPane.add(lbldenecekTutar);

        setVisible(true);
    }

    public String gethoşgeldinkullanici() {
        return hoşgeldinkullanici;
    }

    public long getToplamfiyat() {
        return selectedAraç.getPrice()*günSayisi;
    }
}
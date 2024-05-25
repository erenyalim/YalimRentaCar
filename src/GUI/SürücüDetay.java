package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
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
    private long toplamFiyat;
    private Araç selectedAraç;
    private long günSayisi;
    private String hoşgeldinkullanici;
    private String alışTarihi;  // Yeni değişken
    private String dönüşTarihi;  // Yeni değişken

    public SürücüDetay(long günSayisi, String hoşgeldinkullanici, Araç selectedAraç,String alışTarihi,String dönüşTarihi) {
        this.günSayisi = günSayisi;
        this.hoşgeldinkullanici = hoşgeldinkullanici;
        this.selectedAraç = selectedAraç;
        this.alışTarihi = alışTarihi;
        this.dönüşTarihi = dönüşTarihi;

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
        tcNo.setBounds(483, 119, 297, 36);
        contentPane.add(tcNo);

        tcNo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (tcNo.getText().equals("T.C Kimlik Numarası")) {
                    tcNo.setText("");
                    tcNo.setForeground(Color.LIGHT_GRAY);
                }
            }
        });

        tcNo.addKeyListener((KeyListener) new KeyAdapter() {
                    public void keyTyped(KeyEvent e) {
                        char c = e.getKeyChar();
                        if (tcNo.getText().length() >= 11) {
                            e.consume();
                        }
                        if(!Character.isDigit(c)) {
                            e.consume();
                        }
                    }
                }
        );

        ehliyetNo = new JTextField();
        ehliyetNo.setText("Ehliyet Numarası");
        ehliyetNo.setForeground(Color.LIGHT_GRAY);
        ehliyetNo.setFont(new Font("Yu Gothic Medium", Font.BOLD, 18));
        ehliyetNo.setColumns(10);
        ehliyetNo.setBounds(483, 166, 297, 36);
        contentPane.add(ehliyetNo);
        ehliyetNo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (ehliyetNo.getText().equals("Ehliyet Numarası")) {
                    ehliyetNo.setText("");
                    ehliyetNo.setForeground(Color.LIGHT_GRAY);
                }
            }
        });

        ehliyetNo.addKeyListener((KeyListener) new KeyAdapter() {
                    public void keyTyped(KeyEvent e) {
                        char c = e.getKeyChar();
                        if (ehliyetNo.getText().length() >= 6) {
                            e.consume();
                        }
                        if(!Character.isDigit(c)) {
                            e.consume();
                        }
                    }
                }
        );

        txtAd = new JTextField();
        txtAd.setText("Ad");
        txtAd.setForeground(Color.LIGHT_GRAY);
        txtAd.setFont(new Font("Yu Gothic Medium", Font.BOLD, 18));
        txtAd.setColumns(10);
        txtAd.setBounds(483, 213, 297, 36);
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
        txtSoyad.setBounds(483, 260, 297, 36);
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
        btnkaydet.setForeground(Color.BLACK);
        btnkaydet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                BufferedReader br = null;
                FileReader fr = null;
                int tempId = 0;
                boolean found = false;

                try {
                    fr = new FileReader("sürücü.txt");
                    br = new BufferedReader(fr);
                    String line;
                    String[] strArray;

                    while ((line = br.readLine()) != null) {
                        strArray = line.split(",");
                        int Id = Integer.parseInt(strArray[0]);
                        if (Id > tempId) {
                            tempId = Id;
                        }
                    }
                } catch (IOException e) {
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
                if (!found) {
                    FileWriter fWriter = null;
                    try {
                        tempId++;
                        String temp = tempId + "," + tcNo.getText().trim() + "," + ehliyetNo.getText().trim() + "," + txtAd.getText().trim() + "," + txtSoyad.getText().trim() + "," + selectedAraç.getPlaka()+ "," + alışTarihi + "," + dönüşTarihi + "," + "\r\n";
                        fWriter = new FileWriter("sürücü.txt", true);
                        fWriter.write(temp);
                        JOptionPane.showMessageDialog(SürücüDetay.this, "Sürücü bilgileri kayıt edildi.");
                        ÖdemeEkranı ödeme = new ÖdemeEkranı(günSayisi, hoşgeldinkullanici, toplamFiyat,selectedAraç);
                        setVisible(false);

                    } catch (IOException exp) {
                        System.out.println("Araç ekleme işlemi başarısız.");
                    } finally {
                        if (fWriter != null) {
                            try {
                                fWriter.close();
                            } catch (IOException exp) {
                                System.out.println("Kapatma başarısız.");
                            }
                        }
                    }
                }
            }
        });

        btnkaydet.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
        btnkaydet.setBackground(Color.ORANGE);
        btnkaydet.setBounds(483, 307, 134, 36);
        contentPane.add(btnkaydet);

        btngeridön = new JButton("Geri Dön");
        btngeridön.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btngeridön) {
                    AraçSeçim girisEkrani = new AraçSeçim(günSayisi,hoşgeldinkullanici,alışTarihi,dönüşTarihi);
                    setVisible(false);
                }
            }
        });
        btngeridön.setForeground(Color.BLACK);
        btngeridön.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
        btngeridön.setBackground(Color.ORANGE);
        btngeridön.setBounds(646, 307, 134, 36);
        contentPane.add(btngeridön);

        setVisible(true);
    }

    public long getGünSayisi() {
        return günSayisi;
    }

    public String getHoşgeldinkullanici() {
        return hoşgeldinkullanici;
    }
}
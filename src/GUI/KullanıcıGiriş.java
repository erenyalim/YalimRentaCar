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

public class KullanıcıGiriş extends JFrame {

    private JPanel contentPane;
    private JTextField txtParola;
    private JTextField txtkullaniciadi;
    private JLabel kullanicigirisLabel;
    private JButton btnGirisyap;
    private JButton btnGeriDn;
    private JButton btnSifremiUnuttum;
    private JLabel line;
    private String hoşgeldinkullanici;

    public KullanıcıGiriş() {
        // Frame
        setResizable(false);
        setTitle("Yalım Rent a Car / Kullancı Giriş");
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
        line.setBounds(10, 74, 1264, 6);
        contentPane.add(line);

        kullanicigirisLabel = new JLabel("Kullanıcı Giriş");
        kullanicigirisLabel.setBounds(521, 27, 221, 36);
        kullanicigirisLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        kullanicigirisLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 30));
        kullanicigirisLabel.setForeground(Color.ORANGE);
        contentPane.add(kullanicigirisLabel);

        btnGirisyap = new JButton("Giriş Yap");
        btnGirisyap.addActionListener(new ActionListener() {
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
                        if ((strArray.length > 6) && (strArray[5].equals(txtkullaniciadi.getText().trim()))
                                && (strArray[6].equals(txtParola.getText().trim()))) {
                            found = true;
                            hoşgeldinkullanici = strArray[2];
                            break;
                        }
                    }
                    if (!found) {
                        JOptionPane.showMessageDialog(KullanıcıGiriş.this, "Kullanıcı bulunamadı. Lütfen üye olun.");
                    }

                } catch (Exception ex) {
                    System.out.println("Dosya okuma başarısız.");
                } finally {
                    if (fr != null) {
                        try {
                            fr.close();
                            if (found) {
                                KiralamaEkranı kiralamaEkranı = new KiralamaEkranı(hoşgeldinkullanici);
                                kiralamaEkranı.setVisible(true); // Bu satırı ekliyoruz
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
        btnGirisyap.setBounds(486, 217, 117, 36);
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
        btnGeriDn.setBounds(662, 217, 117, 36);
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
                if (e.getSource() == btnGeriDn) {
                    GirisEkrani girisEkrani = new GirisEkrani();
                    setVisible(false);
                }
            }
        });

        // Parola textfield
        txtParola = new JTextField();
        txtParola.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (txtParola.getText().equals("Parola")) {
                    txtParola.setText("");
                    txtParola.setForeground(Color.LIGHT_GRAY);
                }
            }
        });

        txtParola.setText("Parola");
        txtParola.setForeground(Color.LIGHT_GRAY);
        txtParola.setFont(new Font("Yu Gothic Medium", Font.BOLD, 18));
        txtParola.setColumns(10);
        txtParola.setBounds(482, 158, 297, 36);
        contentPane.add(txtParola);

        // kullaniciadi textfield
        txtkullaniciadi = new JTextField();
        txtkullaniciadi.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (txtkullaniciadi.getText().equals("Kullanıcı Adı")) {
                    txtkullaniciadi.setText("");
                    txtkullaniciadi.setForeground(Color.LIGHT_GRAY);
                }
            }
        });
        txtkullaniciadi.setText("Kullanıcı Adı");
        txtkullaniciadi.setForeground(Color.LIGHT_GRAY);
        txtkullaniciadi.setFont(new Font("Yu Gothic Medium", Font.BOLD, 18));
        txtkullaniciadi.setColumns(10);
        txtkullaniciadi.setBounds(482, 111, 297, 36);
        contentPane.add(txtkullaniciadi);

        btnSifremiUnuttum = new JButton("Şifremi Unuttum");
        btnSifremiUnuttum.setForeground(Color.BLACK);
        btnSifremiUnuttum.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
        btnSifremiUnuttum.setBackground(Color.ORANGE);
        btnSifremiUnuttum.setBounds(548, 272, 167, 36);
        contentPane.add(btnSifremiUnuttum);

        btnSifremiUnuttum.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                btnSifremiUnuttum.setBackground(new Color(238, 232, 170)); // Hover için renk değişimi
            }

            public void mouseExited(MouseEvent e) {
                btnSifremiUnuttum.setBackground(new Color(255, 215, 0)); // Mouse çekildiğinde renk resetlenir.
            }
        });

        btnSifremiUnuttum.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnSifremiUnuttum) {
                    ŞifremiUnuttum şifermiUnuttum = new ŞifremiUnuttum();
                    setVisible(false);
                }
            }
        });

        setVisible(true);
    }

    public String gethoşgeldinkullanici() {
        return hoşgeldinkullanici;
    }
}
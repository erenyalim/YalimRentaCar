package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import entities.concretes.Araç;
import javax.swing.ScrollPaneConstants;

public class AraçSeçim extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JButton btnGeri;
    private long gunSayisi;
    private DefaultTableModel araçTabloModel;
    private String hoşgeldinkullanici;
    private String alışTarihi;
    private String dönüşTarihi;

    public AraçSeçim(long günSayisi, String hoşgeldinkullanici, String alışTarihi, String dönüşTarihi) {
        this.gunSayisi = günSayisi;
        this.hoşgeldinkullanici = hoşgeldinkullanici;
        this.alışTarihi = alışTarihi;
        this.dönüşTarihi = dönüşTarihi;

        setResizable(false);
        setTitle("Yalım Rent a Car");
        setIconImage(Toolkit.getDefaultToolkit().getImage("YalımRentaCar.png"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1280, 720);
        contentPane = new JPanel();
        contentPane.setBackground(Color.DARK_GRAY);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        btnGeri = new JButton("Geri Dön");
        btnGeri.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                KiralamaEkranı kiralamaEkranı = new KiralamaEkranı(getHoşgeldinKullanici());
                setVisible(false);
            }
        });
        btnGeri.setForeground(Color.BLACK);
        btnGeri.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
        btnGeri.setBackground(Color.ORANGE);
        btnGeri.setBounds(1143, 11, 111, 40);
        contentPane.add(btnGeri);

        JLabel lblTeklifler = new JLabel("Teklifler");
        lblTeklifler.setForeground(Color.ORANGE);
        lblTeklifler.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 30));
        lblTeklifler.setBounds(566, 25, 200, 40);
        contentPane.add(lblTeklifler);

        String[] araçTabloBaşlıkları = {"Marka", "Model", "Gövde Tipi", "Yakıt Türü", "Vites", "Günlük Fiyat", "Plaka", "Toplam Fiyat", "Seç"};
        araçTabloModel = new DefaultTableModel(araçTabloBaşlıkları, 0);

        JTable table = new JTable(araçTabloModel) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 8;
            }
        };
        table.setRowHeight(30);
        table.getTableHeader().setReorderingAllowed(false);
        table.setRowSelectionAllowed(false);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(50, 80, 1180, 500);
        contentPane.add(scrollPane);

        TableColumnModel columnModel = table.getColumnModel();
        for (int i = 0; i < columnModel.getColumnCount(); i++) {
            columnModel.getColumn(i).setResizable(false);
        }

        List<Araç> araçListesi = araçlarıTxtOku();
        for (Araç arac : araçListesi) {
            long toplamFiyat = arac.getPrice() * gunSayisi;
            araçTabloModel.addRow(new Object[]{arac.getMarka(), arac.getModel(), arac.getgövdetipi(), arac.getYakitTürü(), arac.getVites(), arac.getPrice() + "TL", arac.getPlaka(), toplamFiyat + "TL", "Seç"});
        }

        table.getColumn("Seç").setCellRenderer(new ButtonRenderer());
        table.getColumn("Seç").setCellEditor(new ButtonEditor(new JButton(), araçListesi, günSayisi, hoşgeldinkullanici, alışTarihi, dönüşTarihi));

        setVisible(true);
    }

    private List<Araç> araçlarıTxtOku() {
        List<Araç> araçListesi = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("araç.txt"))) {
            String satir;
            while ((satir = br.readLine()) != null) {
                String[] araçBilgileri = satir.split(",");
                String marka = araçBilgileri[1];
                String model = araçBilgileri[2];
                String gövdeTipi = araçBilgileri[3];
                String yakitTürü = araçBilgileri[4];
                String vites = araçBilgileri[5];
                int gunlukFiyat = Integer.parseInt(araçBilgileri[6]);
                String plaka = araçBilgileri[8];
                Araç arac = new Araç(marka, model, gövdeTipi, yakitTürü, vites, gunlukFiyat, plaka);
                araçListesi.add(arac);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return araçListesi;
    }

    public String getHoşgeldinKullanici() {
        return hoşgeldinkullanici;
    }

    class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer() {
            setOpaque(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null) ? "Seç" : value.toString());
            return this;
        }
    }

    class ButtonEditor extends AbstractCellEditor implements TableCellEditor, ActionListener {
        private JButton button;
        private boolean isPushed;
        private List<Araç> araçListesi;
        private long günSayisi;
        private String hoşgeldinkullanici;
        private String alışTarihi;
        private String dönüşTarihi;

        public ButtonEditor(JButton button, List<Araç> araçListesi, long günSayisi, String hoşgeldinkullanici, String alışTarihi, String dönüşTarihi) {
            this.button = button;
            this.button.setOpaque(true);
            this.button.addActionListener(this);
            this.araçListesi = araçListesi;
            this.günSayisi = günSayisi;
            this.hoşgeldinkullanici = hoşgeldinkullanici;
            this.alışTarihi = alışTarihi;
            this.dönüşTarihi = dönüşTarihi;
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            button.setText((value == null) ? "Seç" : value.toString());
            isPushed = true;
            return button;
        }

        @Override
        public Object getCellEditorValue() {
            if (isPushed) {
                int selectedRow = ((JTable) button.getParent()).getSelectedRow();
                Araç selectedAraç = araçListesi.get(selectedRow);
                SürücüDetay sürücüDetay = new SürücüDetay(günSayisi, hoşgeldinkullanici, selectedAraç);
                setVisible(false);
                dispose();
            }
            isPushed = false;
            return button.getText();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            fireEditingStopped();
        }
    }
}

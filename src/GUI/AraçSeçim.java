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
import java.util.EventObject;
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
import javax.swing.event.CellEditorListener;

public class AraçSeçim extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JButton btngeri;
    private long gunSayisi;
    private DefaultTableModel Araçtablo;
    private String hoşgeldinkullanici;
	public Araç selectedAraç;

    public AraçSeçim(long günSayisi, String hoşgeldinkullanici) {
        this.gunSayisi = günSayisi;
        this.hoşgeldinkullanici = hoşgeldinkullanici;

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
                KiralamaEkranı kiralamaEkranı = new KiralamaEkranı(gethoşgeldinkullanici());
                setVisible(false);
            }
        });
        btngeri.setForeground(Color.BLACK);
        btngeri.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
        btngeri.setBackground(Color.ORANGE);
        btngeri.setBounds(1143, 11, 111, 40);
        contentPane.add(btngeri);

        JLabel lblTeklifler = new JLabel("Teklifler");
        lblTeklifler.setForeground(Color.ORANGE);
        lblTeklifler.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 30));
        lblTeklifler.setAlignmentX(0.5f);
        lblTeklifler.setBounds(566, 25, 200, 40);
        contentPane.add(lblTeklifler);

        String[] araçtabloisimler = {"Marka", "Model", "Gövde Tipi", "Yakıt Türü", "Vites", "Günlük Fiyat", "Plaka", "Toplam Fiyat", "Seç"};
        Araçtablo = new DefaultTableModel(araçtabloisimler, 0);

        JTable table = new JTable(Araçtablo) {
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

        List<Araç> araçListesi = araçlartxtOku();
        for (Araç arac : araçListesi) {
            long toplamFiyat = arac.getPrice() * gunSayisi;
            Araçtablo.addRow(new Object[]{arac.getMarka(), arac.getModel(), arac.getgövdetipi(), arac.getYakitTürü(), arac.getVites(), arac.getPrice() + "TL", arac.getPlaka(), toplamFiyat + "TL", "Seç"});
        }

        table.getColumn("Seç").setCellRenderer(new ButtonRenderer());
        table.getColumn("Seç").setCellEditor(new ButtonEditor(new JButton(), araçListesi, günSayisi, hoşgeldinkullanici));

        
        setVisible(true);
    }

    private List<Araç> araçlartxtOku() {
        List<Araç> aracListesi = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("araç.txt"))) {
            String satir;
            while ((satir = br.readLine()) != null) {
                String[] Araç = satir.split(",");
                String marka = Araç[1];
                String model = Araç[2];
                String gövdetipi = Araç[3];
                String yakittürü = Araç[4];
                String vites = Araç[5];
                int gunlukFiyat = Integer.parseInt(Araç[6]);
                String plaka = Araç[8];
                Araç arac = new Araç(marka, model, gövdetipi, yakittürü, vites, gunlukFiyat, plaka);
                aracListesi.add(arac);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return aracListesi;
    }

    public String gethoşgeldinkullanici() {
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
        private String label;
        private boolean isPushed;
        private List<Araç> araçListesi;
        private long günSayisi;
        private String hoşgeldinkullanici;

        public ButtonEditor(JButton button, List<Araç> araçListesi, long günSayisi, String hoşgeldinkullanici) {
            this.button = button;
            this.button.setOpaque(true);
            this.button.addActionListener(this);
            this.araçListesi = araçListesi;
            this.günSayisi = günSayisi;
            this.hoşgeldinkullanici = hoşgeldinkullanici;
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            label = (value == null) ? "Seç" : value.toString();
            button.setText(label);
            isPushed = true;
            return button;
        }

        @Override
        public Object getCellEditorValue() {
            if (isPushed) {
                int selectedRow = ((JTable) button.getParent()).getSelectedRow();
                Araç selectedAraç = araçListesi.get(selectedRow);
                SürücüDetay sürücüDetay =new SürücüDetay(günSayisi, hoşgeldinkullanici, selectedAraç);
                setVisible(false);
                dispose();
            }
            isPushed = false;
            return label;
        }
        
        

        @Override
        public boolean stopCellEditing() {
            isPushed = false;
            return super.stopCellEditing();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            fireEditingStopped();
            // Seç butonuna tıklandığında sürücü detay ekranını aç
            SürücüDetay sürücüDetay = new SürücüDetay(günSayisi, hoşgeldinkullanici, selectedAraç);
            setVisible(false);
        }

        @Override
        public boolean isCellEditable(EventObject anEvent) {
            return true;
        }

        @Override
        public boolean shouldSelectCell(EventObject anEvent) {
            return false;
        }

        @Override
        public void cancelCellEditing() {
        }

        @Override
        public void addCellEditorListener(CellEditorListener l) {
        }

        @Override
        public void removeCellEditorListener(CellEditorListener l) {
        }
    }
}
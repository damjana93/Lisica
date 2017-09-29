package lisica;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuBar;

public class MainFrame extends javax.swing.JFrame {
     private static int HEIGHT = 600;
    private static int WIDTH = 800;
    private JMenuBar menuTable = new JMenuBar();
    private MainPanel panel = new MainPanel();

    // static je da moze da ga pokupi Panel za dimenzije
    public static int getHEIGHT() {
        return HEIGHT;
    }

    public static int getWIDTH() {
        return WIDTH;
    }

    public MainFrame() {
        setSize(WIDTH, HEIGHT);                    //postavlja dimenzije na ove gore velicine
        setResizable(false);                        //da se ne moze mjenjati velicina  
        setVisible(true);                           //da je vidljivo 
        setDefaultCloseOperation(EXIT_ON_CLOSE);    // da se na X gasi
        setLocationRelativeTo(null);
        setJMenuBar(setMB());
        add(panel);
        validate();
        panel.grabFocus();
        repaint();
        pack();
    }

    public JMenuBar setMB() {
        javax.swing.JMenu novaIgra = new javax.swing.JMenu("Nova igra F2");
        javax.swing.JMenu izlaz = new javax.swing.JMenu("Izlaz");

        novaIgra.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                panel.StartGame();
            }
        });

        izlaz.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int answer;
                answer = javax.swing.JOptionPane.showConfirmDialog(null,
                        "Da li ste sigurni da zelite da izadjete?",
                        "Pitanje?", javax.swing.JOptionPane.YES_NO_OPTION,
                        javax.swing.JOptionPane.WARNING_MESSAGE);
                if (answer == javax.swing.JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

        menuTable.add(novaIgra);
        menuTable.add(izlaz);

        return menuTable;
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class HomePage extends JFrame implements ActionListener{
    Font poppins;
    JLabel lbl1, lbl2;
    JButton cScan, priority, rRobin;

    public HomePage() {
        super("Home Page");
        setLayout(null);

        try{
            poppins = Font.createFont(Font.TRUETYPE_FONT, new File("Poppins-SemiBold.otf"));
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Poppins-SemiBold.otf")));
        }

        catch(IOException | FontFormatException e){

        }

        lbl1 = new JLabel("Choose CPU & Disk");
        lbl1.setForeground(Color.decode("#474184"));
        lbl1.setFont(poppins.deriveFont(45f));
        lbl1.setBounds(134, 99, 431, 68);

        lbl2 = new JLabel("Scheduling Algorithms");
        lbl2.setForeground(Color.decode("#474184"));
        lbl2.setFont(poppins.deriveFont(45f));
        lbl2.setBounds(89, 167, 522, 68);

        cScan = new JButton("Circular Scan");
        cScan.setForeground(Color.decode("#FFFFFF"));
        cScan.setBackground(Color.decode("#6A659F"));
        cScan.setBorderPainted(false);
        cScan.setFont(poppins.deriveFont(30f));
        cScan.setBounds(217, 281, 265, 80);
        cScan.addActionListener(this);

        priority = new JButton("Priority (NP)");
        priority.setForeground(Color.decode("#FFFFFF"));
        priority.setBackground(Color.decode("#6A659F"));
        priority.setBorderPainted(false);
        priority.setFont(poppins.deriveFont(30f));
        priority.setBounds(217, 397, 265, 80);
        priority.addActionListener(this);

        rRobin = new JButton("Round Robin");
        rRobin.setForeground(Color.decode("#FFFFFF"));
        rRobin.setBackground(Color.decode("#6A659F"));
        rRobin.setBorderPainted(false);
        rRobin.setFont(poppins.deriveFont(30f));
        rRobin.setBounds(217, 513, 265, 80);
        rRobin.addActionListener(this);

        add(lbl1);
        add(lbl2);
        add(cScan);
        add(priority);
        add(rRobin);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.decode("#ebeafc"));
        setVisible(true);
        setSize(700,750);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == rRobin) {
            RoundRobin roundRobin = new RoundRobin();
            this.dispose();
        }

        else if (e.getSource() == priority) {
            PriorityNonPreemp priorityNonPreemp = new PriorityNonPreemp();
            this.dispose();

        }

        else if (e.getSource() == cScan) {
            CircularScan circularScan = new CircularScan();
            this.dispose();

        }
    }
}

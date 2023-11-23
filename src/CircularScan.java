import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class CircularScan extends JFrame implements ActionListener {

    Font poppins;

    JLabel lbl1, lbl2, lbl3, lbl4, lbl5, lbl6, lbl7;

    JTextField tfield1, tfield2, tfield3, tfield4, tfield5;

    JButton btnEnter, btnBack, btnGenerate, btnClear;

    public CircularScan() {
        super("Circular Scan");
        setLayout(null);

        try {
            poppins = Font.createFont(Font.TRUETYPE_FONT, new File("Poppins-SemiBold.otf"));
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Poppins-SemiBold.otf")));
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }

        lbl1 = new JLabel("Circular Scan");
        lbl1.setForeground(Color.decode("#474184"));
        lbl1.setFont(poppins.deriveFont(40f));
        lbl1.setBounds(212, 52, 275, 60);

        lbl2 = new JLabel("No. of input processes:");
        lbl2.setForeground(Color.decode("#474184"));
        lbl2.setFont(poppins.deriveFont(18f));
        lbl2.setBounds(130, 141, 220, 23);

        tfield1 = new JTextField();
        tfield1.setForeground(Color.decode("#FFFFFF"));
        tfield1.setBackground(Color.decode("#6A659F"));
        tfield1.setBorder(null);
        tfield1.setFont(poppins.deriveFont(18f));
        tfield1.setBounds(360, 132, 65, 40);

        lbl3 = new JLabel("<html><i>Input individual arrival time:</i></html>");
        lbl3.setForeground(Color.decode("#474184"));
        lbl3.setFont(poppins.deriveFont(15f));
        lbl3.setBounds(145, 190, 217, 23);

        lbl4 = new JLabel("<html><i>Input current position:</i></html>");
        lbl4.setForeground(Color.decode("#474184"));
        lbl4.setFont(poppins.deriveFont(15f));
        lbl4.setBounds(375, 277, 170, 23);

        tfield2 = new JTextField();
        tfield2.setForeground(Color.decode("#FFFFFF"));
        tfield2.setBackground(Color.decode("#6A659F"));
        tfield2.setBorder(null);
        tfield2.setFont(poppins.deriveFont(15f));
        tfield2.setBounds(555, 272, 50, 30);

        lbl5 = new JLabel("<html><i>Input track size:</i></html>");
        lbl5.setForeground(Color.decode("#474184"));
        lbl5.setFont(poppins.deriveFont(15f));
        lbl5.setBounds(375, 322, 121, 23);

        tfield3 = new JTextField();
        tfield3.setForeground(Color.decode("#FFFFFF"));
        tfield3.setBackground(Color.decode("#6A659F"));
        tfield3.setBorder(null);
        tfield3.setFont(poppins.deriveFont(15f));
        tfield3.setBounds(511, 318, 50, 30);

        lbl6 = new JLabel("<html><i>Input seek rate:</i></html>");
        lbl6.setForeground(Color.decode("#474184"));
        lbl6.setFont(poppins.deriveFont(15f));
        lbl6.setBounds(375, 371, 120, 23);

        tfield4 = new JTextField();
        tfield4.setForeground(Color.decode("#FFFFFF"));
        tfield4.setBackground(Color.decode("#6A659F"));
        tfield4.setBorder(null);
        tfield4.setFont(poppins.deriveFont(18f));
        tfield4.setBounds(511, 364, 50, 30);

        lbl7 = new JLabel("<html><i>Input alpha:</i></html>");
        lbl7.setForeground(Color.decode("#474184"));
        lbl7.setFont(poppins.deriveFont(15f));
        lbl7.setBounds(375, 416, 95, 23);

        tfield5 = new JTextField();
        tfield5.setForeground(Color.decode("#FFFFFF"));
        tfield5.setBackground(Color.decode("#6A659F"));
        tfield5.setBorder(null);
        tfield5.setFont(poppins.deriveFont(18f));
        tfield5.setBounds(486, 410, 50, 30);

        btnEnter = new JButton("Enter");
        btnEnter.setForeground(Color.decode("#FFFFFF"));
        btnEnter.setBackground(Color.decode("#6A659F"));
        btnEnter.setBorderPainted(false);
        btnEnter.setFont(poppins.deriveFont(15f));
        btnEnter.setBounds(455, 132, 75, 40);
        btnEnter.addActionListener(this);

        btnBack = new JButton("Back");
        btnBack.setForeground(Color.decode("#FFFFFF"));
        btnBack.setBackground(Color.decode("#6A659F"));
        btnBack.setBorderPainted(false);
        btnBack.setFont(poppins.deriveFont(20f));
        btnBack.setBounds(20, 24, 100, 40);
        btnBack.addActionListener(this);

        btnGenerate = new JButton("Generate");
        btnGenerate.setForeground(Color.decode("#FFFFFF"));
        btnGenerate.setBackground(Color.decode("#6A659F"));
        btnGenerate.setBorderPainted(false);
        btnGenerate.setFont(poppins.deriveFont(20f));
        btnGenerate.setBounds(178, 635, 150, 40);
        btnGenerate.addActionListener(this);

        btnClear = new JButton("Clear");
        btnClear.setForeground(Color.decode("#FFFFFF"));
        btnClear.setBackground(Color.decode("#6A659F"));
        btnClear.setBorderPainted(false);
        btnClear.setFont(poppins.deriveFont(20f));
        btnClear.setBounds(371, 635, 150, 40);
        btnClear.addActionListener(this);

        add(lbl1);
        add(lbl2);
        add(lbl3);
        add(lbl4);
        add(lbl5);
        add(lbl6);
        add(lbl7);
        add(tfield1);
        add(tfield2);
        add(tfield3);
        add(tfield4);
        add(tfield5);
        add(btnEnter);
        add(btnBack);
        add(btnGenerate);
        add(btnClear);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.decode("#ebeafc"));
        setVisible(true);
        setSize(700, 750);
        setLocationRelativeTo(null);

        btnGenerate.addActionListener(this);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(RoundRobin::new);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnEnter) {
            int numOfProcesses = Integer.parseInt(tfield1.getText());
            addLabelsAndTextFields(numOfProcesses);
            revalidate();
            repaint();
        }

        if (e.getSource() == btnBack) {
            HomePage homePage = new HomePage();
            this.dispose();
        }

        if (e.getSource() == btnGenerate) {
            CircularScanResult circularScanResult = new CircularScanResult();
            this.dispose();
        }

    }

    private void addLabelsAndTextFields(int numOfProcesses) {
        int labelXOffset = 185; // X coordinate for labels
        int textFieldXOffset = 240; // X coordinate for text fields

        for (int i = 1; i <= numOfProcesses; i++) {
            // Arrival Time (AT) labels and text fields
            JLabel locLabel = new JLabel("Loc " + i + ":");
            locLabel.setForeground(Color.decode("#474184"));
            locLabel.setFont(poppins.deriveFont(15f));
            locLabel.setBounds(labelXOffset, 240 + (i - 1) * 39, 45, 23);
            add(locLabel);

            JTextField locTextField = new JTextField();
            locTextField.setForeground(Color.decode("#FFFFFF"));
            locTextField.setBackground(Color.decode("#6A659F"));
            locTextField.setBorder(null);
            locTextField.setFont(poppins.deriveFont(15f));
            locTextField.setBounds(textFieldXOffset, 233 + (i - 1) * 39, 50, 30);
            add(locTextField);
        }
    }
}

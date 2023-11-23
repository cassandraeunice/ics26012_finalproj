import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class PriorityNonPreemp extends JFrame implements ActionListener {

    Font poppins;

    JLabel lbl1, lbl2, lbl3, lbl4, lbl5, lbl6;

    JTextField tfield1, tfield2;

    JButton btnEnter, btnBack, btnGenerate, btnClear;

    public PriorityNonPreemp() {

        super("Priority (Non-Preemptive)");
        setLayout(null);

        try {
            poppins = Font.createFont(Font.TRUETYPE_FONT, new File("Poppins-SemiBold.otf"));
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Poppins-SemiBold.otf")));
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }

        lbl1 = new JLabel("Priority (Non-Preemptive)");
        lbl1.setForeground(Color.decode("#474184"));
        lbl1.setFont(poppins.deriveFont(35f));
        lbl1.setBounds(108, 75, 470, 53);

        lbl2 = new JLabel("No. of input processes:");
        lbl2.setForeground(Color.decode("#474184"));
        lbl2.setFont(poppins.deriveFont(13f));
        lbl2.setBounds(30, 166, 165, 20);

        tfield1 = new JTextField();
        tfield1.setForeground(Color.decode("#FFFFFF"));
        tfield1.setBackground(Color.decode("#6A659F"));
        tfield1.setBorder(null);
        tfield1.setFont(poppins.deriveFont(18f));
        tfield1.setBounds(190, 154, 63, 40);

        lbl5 = new JLabel("Input individual priority number:");
        lbl5.setForeground(Color.decode("#474184"));
        lbl5.setFont(poppins.deriveFont(13f));
        lbl5.setBounds(270, 166, 220, 20);

        tfield2 = new JTextField();
        tfield2.setForeground(Color.decode("#FFFFFF"));
        tfield2.setBackground(Color.decode("#6A659F"));
        tfield2.setBorder(null);
        tfield2.setFont(poppins.deriveFont(18f));
        tfield2.setBounds(495, 156, 63, 40);

        lbl3 = new JLabel("<html><i>Input individual arrival time:</i></html>");
        lbl3.setForeground(Color.decode("#474184"));
        lbl3.setFont(poppins.deriveFont(12f));
        lbl3.setBounds(21, 222, 190, 20);

        lbl4 = new JLabel("<html><i>Input individual burst time:</i></html>");
        lbl4.setForeground(Color.decode("#474184"));
        lbl4.setFont(poppins.deriveFont(12f));
        lbl4.setBounds(246, 221, 180, 20);

        lbl6 = new JLabel("<html><i>Input individual priority number:</i></html>");
        lbl6.setForeground(Color.decode("#474184"));
        lbl6.setFont(poppins.deriveFont(12f));
        lbl6.setBounds(463, 222, 216, 20);

        btnEnter = new JButton("Enter");
        btnEnter.setForeground(Color.decode("#FFFFFF"));
        btnEnter.setBackground(Color.decode("#6A659F"));
        btnEnter.setBorderPainted(false);
        btnEnter.setFont(poppins.deriveFont(14f));
        btnEnter.setBounds(577, 155, 73, 40);
        btnEnter.addActionListener(this);

        btnBack = new JButton("Back");
        btnBack.setForeground(Color.decode("#FFFFFF"));
        btnBack.setBackground(Color.decode("#6A659F"));
        btnBack.setBorderPainted(false);
        btnBack.setFont(poppins.deriveFont(20f));
        btnBack.setBounds(17, 17, 100, 40);
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
        add(tfield1);
        add(tfield2);
        add(btnEnter);
        add(btnBack);
        add(btnGenerate);
        add(btnClear);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.decode("#ebeafc"));
        setVisible(true);
        setSize(700, 750);
        setLocationRelativeTo(null);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(RoundRobin::new);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnEnter) {
            int numOfProcesses = Integer.parseInt(tfield1.getText());
            int numberOfPrio = Integer.parseInt(tfield2.getText());
            addLabelsAndTextFields(numOfProcesses, numberOfPrio);
            revalidate();
            repaint();
        }

        if (e.getSource() == btnBack) {
            HomePage homePage = new HomePage();
            this.dispose();
        }

        if (e.getSource() == btnGenerate) {
            PriorityNonPreempResult priorityNonPreempResult = new PriorityNonPreempResult();
            this.dispose();
        }

    }

    private void addLabelsAndTextFields(int numOfProcesses, int numberOfPrio) {
        int labelXOffset = 60; // X coordinate for labels
        int textFieldXOffset = 102; // X coordinate for text fields

        for (int i = 1; i <= numOfProcesses; i++) {
            // Arrival Time (AT) labels and text fields
            JLabel atLabel = new JLabel("AT" + i + ":");
            atLabel.setForeground(Color.decode("#474184"));
            atLabel.setFont(poppins.deriveFont(15f));
            atLabel.setBounds(labelXOffset, 267 + (i - 1) * 39, 35, 23);
            add(atLabel);

            JTextField atTextField = new JTextField();
            atTextField.setForeground(Color.decode("#FFFFFF"));
            atTextField.setBackground(Color.decode("#6A659F"));
            atTextField.setBorder(null);
            atTextField.setFont(poppins.deriveFont(15f));
            atTextField.setBounds(textFieldXOffset, 263 + (i - 1) * 39, 50, 30);
            add(atTextField);

            // Burst Time (BT) labels and text fields
            JLabel btLabel = new JLabel("BT" + i + ":");
            btLabel.setForeground(Color.decode("#474184"));
            btLabel.setFont(poppins.deriveFont(15f));
            btLabel.setBounds(labelXOffset + 223, 267 + (i - 1) * 39, 35, 23);
            add(btLabel);

            JTextField btTextField = new JTextField();
            btTextField.setForeground(Color.decode("#FFFFFF"));
            btTextField.setBackground(Color.decode("#6A659F"));
            btTextField.setBorder(null);
            btTextField.setFont(poppins.deriveFont(15f));
            btTextField.setBounds(textFieldXOffset + 219, 263 + (i - 1) * 39, 50, 30);
            add(btTextField);

            }

                for (int i = 1; i <= numberOfPrio; i++) {
                // Number of Prio
                JLabel prioLabel = new JLabel("Prio" + i + ":");
                prioLabel.setForeground(Color.decode("#474184"));
                prioLabel.setFont(poppins.deriveFont(15f));
                prioLabel.setBounds(labelXOffset + 445, 267 + (i - 1) * 39, 45, 23);
                add(prioLabel);

                JTextField prioTextField = new JTextField();
                prioTextField.setForeground(Color.decode("#FFFFFF"));
                prioTextField.setBackground(Color.decode("#6A659F"));
                prioTextField.setBorder(null);
                prioTextField.setFont(poppins.deriveFont(15f));
                prioTextField.setBounds(textFieldXOffset + 451, 268 + (i - 1) * 39, 50, 30);
                add(prioTextField);

        }
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class CircularScanResult extends JFrame implements ActionListener {

    Font poppins;
    JLabel lbl1;
    JButton btnBack, btnClear;

    JTextArea rRobinResult;

    public CircularScanResult() {
        super("Circular Scan Result");
        setLayout(null);

        try {
            poppins = Font.createFont(Font.TRUETYPE_FONT, new File("Poppins-SemiBold.otf"));
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Poppins-SemiBold.otf")));
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }

        lbl1 = new JLabel("Circular Scan Results");
        lbl1.setForeground(Color.decode("#474184"));
        lbl1.setFont(poppins.deriveFont(40f));
        lbl1.setBounds(134, 75, 435, 60);

        btnBack = new JButton("Back");
        btnBack.setForeground(Color.decode("#FFFFFF"));
        btnBack.setBackground(Color.decode("#6A659F"));
        btnBack.setBorderPainted(false);
        btnBack.setFont(poppins.deriveFont(20f));
        btnBack.setBounds(20, 24, 100, 40);
        btnBack.addActionListener(this);

        rRobinResult = new JTextArea();
        rRobinResult.setForeground(Color.decode("#FFFFFF"));
        rRobinResult.setBackground(Color.decode("#6A659F"));
        rRobinResult.setBorder(null);
        rRobinResult.setFont(poppins.deriveFont(15f));
        rRobinResult.setBounds(50, 145, 600, 500);

        btnClear = new JButton("Clear");
        btnClear.setForeground(Color.decode("#FFFFFF"));
        btnClear.setBackground(Color.decode("#6A659F"));
        btnClear.setBorderPainted(false);
        btnClear.setFont(poppins.deriveFont(20f));
        btnClear.setBounds(275, 660, 150, 40);
        btnClear.addActionListener(this);

        add(lbl1);
        add(btnBack);
        add(btnClear);
        add(rRobinResult);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.decode("#ebeafc"));
        setVisible(true);
        setSize(700, 750);
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBack) {
            CircularScan circularScan = new CircularScan();
            this.dispose();
        }
    }
}

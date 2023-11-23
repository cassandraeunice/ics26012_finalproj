import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class PriorityNonPreempResult extends JFrame implements ActionListener {

    Font poppins;
    JLabel lbl1;
    JButton btnBack, btnClear;

    JTextArea prioResult;

    public PriorityNonPreempResult() {
        super("Priority (Non-Preemptive) Results");
        setLayout(null);

        try {
            poppins = Font.createFont(Font.TRUETYPE_FONT, new File("Poppins-SemiBold.otf"));
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Poppins-SemiBold.otf")));
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }

        lbl1 = new JLabel("Priority (Non-Preemptive) Results");
        lbl1.setForeground(Color.decode("#474184"));
        lbl1.setFont(poppins.deriveFont(34f));
        lbl1.setBounds(53, 81, 595, 53);

        btnBack = new JButton("Back");
        btnBack.setForeground(Color.decode("#FFFFFF"));
        btnBack.setBackground(Color.decode("#6A659F"));
        btnBack.setBorderPainted(false);
        btnBack.setFont(poppins.deriveFont(20f));
        btnBack.setBounds(20, 24, 100, 40);
        btnBack.addActionListener(this);

        prioResult = new JTextArea();
        prioResult.setForeground(Color.decode("#FFFFFF"));
        prioResult.setBackground(Color.decode("#6A659F"));
        prioResult.setBorder(null);
        prioResult.setFont(poppins.deriveFont(15f));
        prioResult.setBounds(50, 145, 600, 500);

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
        add(prioResult);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.decode("#ebeafc"));
        setVisible(true);
        setSize(700, 750);
        setLocationRelativeTo(null);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBack) {
            PriorityNonPreemp priorityNonPreemp = new PriorityNonPreemp();
            this.dispose();
        }
    }
}

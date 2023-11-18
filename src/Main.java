import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Main extends JFrame implements ActionListener {
    JLabel lbl1, lbl2;
    JButton start;
    Font poppins;

    public Main() {
        super("Startup Page");
        setLayout(null);

        try{
            poppins = Font.createFont(Font.TRUETYPE_FONT, new File("Poppins-SemiBold.otf"));
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Poppins-SemiBold.otf")));
        }

        catch(IOException | FontFormatException e){

        }

        lbl1 = new JLabel("CPU and Disk");
        lbl1.setForeground(Color.decode("#474184"));
        lbl1.setFont(poppins.deriveFont(40f));
        lbl1.setBounds(216, 219, 268, 60);

        lbl2 = new JLabel("Scheduling Algorithms");
        lbl2.setForeground(Color.decode("#474184"));
        lbl2.setFont(poppins.deriveFont(40f));
        lbl2.setBounds(118, 279, 464, 60);

        start = new JButton("START");
        start.setForeground(Color.decode("#FFFFFF"));
        start.setBackground(Color.decode("#6A659F"));
        start.setBorderPainted(false);
        start.setFont(poppins.deriveFont(25f));
        start.setBounds(280, 405, 140, 50);
        start.addActionListener(this);

        add(lbl1);
        add(lbl2);
        add(start);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.decode("#ebeafc"));
        setVisible(true);
        setSize(700,700);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == start) {

            HomePage homePage = new HomePage();
            this.dispose();
        }
    }
}
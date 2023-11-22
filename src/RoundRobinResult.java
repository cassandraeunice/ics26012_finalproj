import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class RoundRobinResult extends JFrame implements ActionListener {

    Font poppins;
    JLabel lbl1;
    JButton btnBack, btnClear;

    JTextArea rRobinResult;

    public RoundRobinResult(LinkedList<Integer> waitingTime, double avgWaitingTime, double avgTurnaroundTime) {
        super("Round Robin Results");
        setLayout(null);

        try {
            poppins = Font.createFont(Font.TRUETYPE_FONT, new File("Poppins-SemiBold.otf"));
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Poppins-SemiBold.otf")));
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }

        lbl1 = new JLabel("Round Robin Results");
        lbl1.setForeground(Color.decode("#474184"));
        lbl1.setFont(poppins.deriveFont(40f));
        lbl1.setBounds(143, 72, 414, 60);

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
        rRobinResult.setBounds(50, 157, 600, 500);
        displayResults(waitingTime, avgWaitingTime, avgTurnaroundTime);

        add(lbl1);
        add(btnBack);
        add(rRobinResult);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.decode("#ebeafc"));
        setVisible(true);
        setSize(700, 750);
        setLocationRelativeTo(null);
    }

    private void displayResults(LinkedList<Integer> waitingTime, double avgWaitingTime, double avgTurnaroundTime) {
        StringBuilder resultText = new StringBuilder("Waiting time:\n");
        for (int i = 0; i < waitingTime.size(); i++) {
            resultText.append("\tP").append(i + 1).append(": ").append(waitingTime.get(i)).append("\n");
        }
        resultText.append("Average Waiting Time: ").append(avgWaitingTime).append("\nAverage Turnaround Time: ").append(avgTurnaroundTime);
        rRobinResult.setText(resultText.toString());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBack) {
            // Handle the "Back" button action
            dispose(); // Close the current window
            // You might want to open the previous window or perform other actions here
        }
    }
}
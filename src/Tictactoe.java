import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Tictactoe extends JFrame implements ActionListener {
    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel headerPanel = new JPanel();
    JPanel leftPanel = new JPanel();
    JPanel rightPanel = new JPanel();
    JPanel bottomPanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JLabel title = new JLabel();
    JLabel winX = new JLabel();
    JLabel winO = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player;

    //constructor
    Tictactoe() {
        //initial frame
        frame.setTitle("Tic Tac Toe");
        frame.setSize(1000,600);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setUndecorated(true);
        frame.setLayout(new BorderLayout(10,0));
        frame.getContentPane().setBackground(Color.decode("#313552"));
        frame.setVisible(true);

        headerPanel();
        leftPanel();
        centerPanel();
        rightPanel();
        bottomPanel();
        startGame();
    }

    //Component
    public void headerPanel() {
        title.setBackground(Color.decode("#313552"));
        title.setForeground(Color.white);
        title.setFont(new Font("Segoe Print", Font.BOLD,30));
        title.setPreferredSize(new Dimension(0, 100));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setText("Match Begins in 4 Seconds...");
        title.setOpaque(true);

        headerPanel.setLayout(new BorderLayout());
        headerPanel.add(title);
        frame.add(headerPanel, BorderLayout.NORTH);
    }

    public void leftPanel() {
        JPanel panel = new JPanel();
        JPanel panel1 = new JPanel();
        JLabel label = new JLabel();
        JLabel label1 = new JLabel();

        panel.setBackground(Color.decode("#313552"));
        panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
        panel.setAlignmentY(CENTER_ALIGNMENT);

        panel1.setBackground(Color.decode("#313552"));
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        panel1.setAlignmentY(CENTER_ALIGNMENT);
        panel1.setBorder(new EmptyBorder(0, 10, 0, 0));

        label.setBackground(Color.decode("#313552"));
        label.setForeground(Color.decode("#B8405E"));
        label.setFont(new Font("MV Boli", Font.BOLD,60));
        label.setAlignmentX(CENTER_ALIGNMENT);
        label.setVerticalTextPosition(JLabel.CENTER);
        label.setText("X");
        label.setOpaque(true);
        panel1.add(label);

        label1.setBackground(Color.decode("#313552"));
        label1.setForeground(Color.white);
        label1.setFont(new Font("Segoe Print", Font.BOLD,25));
        label1.setAlignmentX(CENTER_ALIGNMENT);
        label1.setText("Player Wins");
        label1.setOpaque(true);
        panel1.add(label1);

        winX.setBackground(Color.decode("#313552"));
        winX.setForeground(Color.white);
        winX.setFont(new Font("Segoe Print", Font.BOLD,40));
        winX.setAlignmentX(CENTER_ALIGNMENT);
        winX.setText("0");
        winX.setOpaque(true);
        panel1.add(winX);

        panel.add(panel1);

        leftPanel.setLayout(new BorderLayout());
        leftPanel.add(panel);

        frame.add(leftPanel, BorderLayout.WEST);
    }

    public void centerPanel() {
        buttonPanel.setLayout(new GridLayout(3,3,10,10));
        buttonPanel.setBackground(Color.decode("#313552"));
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            buttonPanel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli",Font.BOLD, 100));
            buttons[i].setFocusable(false);
            buttons[i].setContentAreaFilled(false);
            buttons[i].setBackground(Color.decode("#313552"));
            buttons[i].setFocusPainted(false);
            buttons[i].setBorder(new LineBorder(Color.decode("#EEE6CE")));
            buttons[i].addActionListener(this);
        }
        frame.add(buttonPanel);
    }

    public void rightPanel() {
        JPanel panel = new JPanel();
        JPanel panel1 = new JPanel();
        JLabel label = new JLabel();
        JLabel label1 = new JLabel();

        panel.setBackground(Color.decode("#313552"));
        panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
        panel.setAlignmentY(CENTER_ALIGNMENT);

        panel1.setBackground(Color.decode("#313552"));
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        panel1.setAlignmentY(CENTER_ALIGNMENT);
        panel1.setBorder(new EmptyBorder(0, 0, 0, 10));

        label.setBackground(Color.decode("#313552"));
        label.setForeground(Color.decode("#2EB086"));
        label.setFont(new Font("MV Boli", Font.BOLD,60));
        label.setAlignmentX(CENTER_ALIGNMENT);
        label.setVerticalTextPosition(JLabel.CENTER);
        label.setText("O");
        label.setOpaque(true);
        panel1.add(label);

        label1.setBackground(Color.decode("#313552"));
        label1.setForeground(Color.white);
        label1.setFont(new Font("Segoe Print", Font.BOLD,25));
        label1.setAlignmentX(CENTER_ALIGNMENT);
        label1.setText("Player Wins");
        label1.setOpaque(true);
        panel1.add(label1);

        winO.setBackground(Color.decode("#313552"));
        winO.setForeground(Color.white);
        winO.setFont(new Font("Segoe Print", Font.BOLD,40));
        winO.setAlignmentX(CENTER_ALIGNMENT);
        winO.setText("0");
        winO.setOpaque(true);
        panel1.add(winO);

        panel.add(panel1);

        rightPanel.setLayout(new BorderLayout());
        rightPanel.add(panel);

        frame.add(rightPanel, BorderLayout.EAST);
    }

    public void bottomPanel() {
        JPanel panel = new JPanel();
        JPanel panel1 = new JPanel();
        JButton button = new JButton("Start Game");
        JButton button1 = new JButton("Close Game");

        panel.setBackground(Color.decode("#313552"));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setAlignmentY(CENTER_ALIGNMENT);
        panel.setBorder(new EmptyBorder(10, 0, 10, 0));

        panel1.setBackground(Color.decode("#313552"));

        button.setFont(new Font("Segoe Print", Font.PLAIN, 16));
        button.setBackground(Color.decode("#2EB086"));
        button.setForeground(Color.white);
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setAlignmentX(CENTER_ALIGNMENT);
        panel1.add(button);

        button1.setFont(new Font("Segoe Print", Font.PLAIN, 16));
        button1.setBackground(Color.decode("#B8405E"));
        button1.setForeground(Color.white);
        button1.setOpaque(true);
        button1.setBorderPainted(false);
        button1.setFocusPainted(false);
        button1.setAlignmentX(CENTER_ALIGNMENT);
        panel1.add(button1);

        panel.add(panel1);

        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.add(panel);

        frame.add(bottomPanel, BorderLayout.SOUTH);
    }

    public void startGame() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (random.nextInt(2) == 0) {
            player = true;
            title.setText("Player X playing");
        } else {
            player = false;
            title.setText("Player O playing");
        }
    }

    public void checkWin() {
        int [][] similar = {
                {0,1,2}, {3,4,5}, {6,7,8},
                {0,3,6}, {1,4,7}, {2,5,8},
                {0,4,8}, {2,4,6}
        };

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < similar.length; j++) {
                int btn1 = similar[j][0];
                int btn2 = similar[j][1];
                int btn3 = similar[j][2];
                String compare = i == 0 ? "X" : "O";
                if (buttons[btn1].getText().equals(compare) && buttons[btn2].getText().equals(compare) && buttons[btn3].getText().equals(compare)) {
                    winner(btn1,btn2,btn3,compare);
                }
            }
        }
    }

    public void winner(int a, int b, int c, String type) {
        buttons[a].setContentAreaFilled(true);
        buttons[b].setContentAreaFilled(true);
        buttons[c].setContentAreaFilled(true);
        buttons[a].setBackground(Color.decode("#2EB086"));
        buttons[b].setBackground(Color.decode("#2EB086"));
        buttons[c].setBackground(Color.decode("#2EB086"));

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        title.setText("Player " + type +  " Wins");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                if (player) {
                    if (buttons[i].getText().equals("")) {
                        buttons[i].setForeground(Color.decode("#2EB086"));
                        buttons[i].setText("X");
                        player = false;
                        title.setText("Player O playing");
                        checkWin();
                    }
                } else {
                    if (buttons[i].getText().equals("")) {
                        buttons[i].setForeground(Color.decode("#B8405E"));
                        buttons[i].setText("O");
                        player = true;
                        title.setText("Player X playing");
                        checkWin();
                    }
                }
            }
        }
    }
}

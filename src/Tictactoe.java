import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Tictactoe extends JFrame implements ActionListener {
    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel headerPanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JLabel title = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player;

    //constructor
    Tictactoe() {
        frame.setTitle("Tic Tac Toe");
        frame.setSize(800,800);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        title.setBackground(new Color(25,25,25));
        title.setForeground(new Color(25,255,0));
        title.setFont(new Font("Ink Free", Font.BOLD,75));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setText("Tic-Tac-Toe");
        title.setOpaque(true);

        headerPanel.setLayout(new BorderLayout());
        headerPanel.setBounds(0,0,800,100);

        buttonPanel.setLayout(new GridLayout(3,3));
        buttonPanel.setBackground(new Color(150,150,150));

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            buttonPanel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli",Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        headerPanel.add(title);
        frame.add(headerPanel, BorderLayout.NORTH);
        frame.add(buttonPanel);

        startGame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                if (player) {
                    if (buttons[i].getText().equals("")) {
                        buttons[i].setForeground(new Color(255,0,0));
                        buttons[i].setText("X");
                        player = false;
                        title.setText("Player O playing");
                        checkWin();
                    }
                } else {
                    if (buttons[i].getText().equals("")) {
                        buttons[i].setForeground(new Color(0,0,255));
                        buttons[i].setText("O");
                        player = true;
                        title.setText("Player X playing");
                        checkWin();
                    }
                }
            }
        }
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
                System.out.println(btn1 + btn2 + btn3);
                if (buttons[btn1].getText().equals(compare) && buttons[btn2].getText().equals(compare) && buttons[btn3].getText().equals(compare)) {
                    winner(btn1,btn2,btn3,compare);
                }
            }
        }
    }

    public void winner(int a, int b, int c, String type) {
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        title.setText("Player " + type +  " Wins");
    }
}

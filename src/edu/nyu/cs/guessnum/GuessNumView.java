package edu.nyu.cs.guessnum;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GuessNumView implements GuessNumListener {

  private GuessNumModel model;
  private JFrame frame = new JFrame();
  private JButton button = new JButton("Guess");
  private JTextField textField = new JTextField();
  private JTextArea textArea = new JTextArea();

  public GuessNumView(GuessNumModel model) {
    this.model = model;
    model.addListener(this);
    JPanel panel = new JPanel();
    JPanel bottomPanel = new JPanel();

    bottomPanel.setLayout(new BorderLayout());
    panel.setLayout(new BorderLayout());

    bottomPanel.add(button, BorderLayout.EAST);
    bottomPanel.add(textField, BorderLayout.CENTER);

    panel.add(bottomPanel, BorderLayout.SOUTH);
    panel.add(new JScrollPane(textArea), BorderLayout.CENTER);

    frame.getContentPane().setLayout(new BorderLayout());
    frame.getContentPane().add(panel, BorderLayout.CENTER);

    frame.setSize(200,200);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        buttonPressed();
      }
    });
  }

  private void buttonPressed() {
    int num = Integer.parseInt(textField.getText());
    model.guess(num);
  }

  @Override
  public void gameStart() {
    textArea.append("Game started\n");
  }

  @Override
  public void guessHigh(int guess) {
    textArea.append("Guess High: " + guess + "\n");
  }

  @Override
  public void guessLow(int guess) {
    textArea.append("Guess Low: " + guess + "\n");
  }

  @Override
  public void guessCorrect(int guess) {
    textArea.append("Correct!!! Guess: " + guess + "\n");
  }

}

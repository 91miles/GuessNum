package edu.nyu.cs.guessnum;

public class GuessNumApp {

  private void go() {
    GuessNumModel model = new GuessNumModel();
    new GuessNumView(model);
    new GuessNumView(model);
    new GuessNumLogger(model);
    model.startGame();
  }
  
  public static void main(String[] args) {
    new GuessNumApp().go();
  }

}
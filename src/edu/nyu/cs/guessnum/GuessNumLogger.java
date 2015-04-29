package edu.nyu.cs.guessnum;

public class GuessNumLogger implements GuessNumListener {

  public GuessNumLogger(GuessNumModel model) {
    model.addListener(this);
  }

  @Override
  public void gameStart() {
    System.out.println("Game started.");
  }

  @Override
  public void guessHigh(int guess) {
    System.out.println("Guess high: " + guess);
  }

  @Override
  public void guessLow(int guess) {
    System.out.println("Guess low: " + guess);
  }

  @Override
  public void guessCorrect(int guess) {
    System.out.println("Guess correct! " + guess);
  }

}
package edu.nyu.cs.guessnum;

public interface GuessNumListener {

  public void gameStart();
  public void guessHigh(int guess);
  public void guessLow(int guess);
  public void guessCorrect(int guess);

}
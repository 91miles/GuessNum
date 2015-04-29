package edu.nyu.cs.guessnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GuessNumModel {
  private int number;

  private List<GuessNumListener> listeners =
      new ArrayList<GuessNumListener>();

  public void startGame() {
    resetNum();
    fireGameStartEvent();
  }

  private void resetNum() {
    number = new Random().nextInt(100);
  }

  public void guess(int guessNumber) {
    if (guessNumber == number) {
      fireGameGuessCorrectEvent(guessNumber);

    } else if (guessNumber > number) {
      fireGameHighEvent(guessNumber);
    } else {
      fireGameLowEvent(guessNumber);
    }
  }


  private void fireGameLowEvent(int guessNumber) {
    for (GuessNumListener listener : listeners) {
      listener.guessLow(guessNumber);
    }
  }

  private void fireGameHighEvent(int guessNumber) {
    for (GuessNumListener listener : listeners) {
      listener.guessHigh(guessNumber);
    }
  }

  private void fireGameGuessCorrectEvent(int guessNumber) {
    for (GuessNumListener listener : listeners) {
      listener.guessCorrect(guessNumber);
    }
  }

  private void fireGameStartEvent() {
    for (GuessNumListener listener : listeners) {
      listener.gameStart();
    }
  }

  public void addListener(GuessNumListener listener) {
    listeners.add(listener);
  }

  public void removeListener(GuessNumListener listener) {

  }
}
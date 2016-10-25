package at.fhooe.guetz.bikeapp.entities;

import at.fhooe.guetz.bikeapp.R;

/**
 * Value class to communicate errors
 */
public enum Error {
  GENERAL(R.string.error_general);

  private final int errorMsg;

  Error(int errorMsg) {
    this.errorMsg = errorMsg;
  }

  public int getErrorMsg() {
    return errorMsg;
  }
}

package jp.co.yahoo.ad_api_sample.util;

/**
 * Created by ttakami on 2016/04/28.
 */
public class JobTimeoutException extends RuntimeException {

  public JobTimeoutException(String message) {
    super(message);
  }

  public JobTimeoutException(String message, Throwable cause) {
    super(message, cause);
  }
}

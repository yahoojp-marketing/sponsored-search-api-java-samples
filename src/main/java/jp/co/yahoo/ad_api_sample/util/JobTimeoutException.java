package jp.co.yahoo.ad_api_sample.util;

public class JobTimeoutException extends RuntimeException {

  public JobTimeoutException(String message) {
    super(message);
  }

  public JobTimeoutException(String message, Throwable cause) {
    super(message, cause);
  }
}

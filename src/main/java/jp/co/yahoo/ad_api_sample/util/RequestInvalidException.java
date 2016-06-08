package jp.co.yahoo.ad_api_sample.util;

public class RequestInvalidException extends RuntimeException {

  public RequestInvalidException(String message) {
    super(message);
  }

  public RequestInvalidException(String message, Throwable cause) {
    super(message, cause);
  }
}

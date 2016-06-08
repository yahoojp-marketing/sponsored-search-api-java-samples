package jp.co.yahoo.ad_api_sample.util;

public class ApiConfigException extends RuntimeException {

  public ApiConfigException(String message) {
    super(message);
  }

  public ApiConfigException(String message, Throwable cause) {
    super(message, cause);
  }
}

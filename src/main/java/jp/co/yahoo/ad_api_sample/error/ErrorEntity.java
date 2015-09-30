package jp.co.yahoo.ad_api_sample.error;

import java.util.List;

public interface ErrorEntity {

  String getCode();

  String getMessage();

  /*
   * String getRequestKey(); List<String> getRequestValue();
   */

  List<ErrorDetailEntity> getErrorDetail();


}

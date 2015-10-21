package jp.co.yahoo.ad_api_sample.error;

import java.util.List;

public interface ErrorDetailEntity {

  String getRequestKey();

  List<String> getRequestValues();
}

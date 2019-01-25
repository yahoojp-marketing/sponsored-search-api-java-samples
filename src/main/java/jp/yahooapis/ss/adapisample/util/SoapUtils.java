/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.ss.adapisample.util;

import jp.yahooapis.ss.v201901.Error;
import jp.yahooapis.ss.v201901.ReturnValue;

import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.xml.namespace.QName;
import javax.xml.ws.Holder;
import javax.xml.ws.Service;
import javax.xml.ws.wsaddressing.W3CEndpointReferenceBuilder;

/**
 * Utility method collection for Java Sample Program.
 */
public class SoapUtils {

  /**
   * API Version
   */
  private static String API_VERSION;
  /**
   * XML Name Space
   */
  private static String API_NAMESPACE;
  /**
   * location server name
   */
  private static String LOCATION;
  /**
   * API License
   */
  private static String API_LICENSE;
  /**
   * API Account
   */
  private static String API_ACCOUNT;
  /**
   * API Password
   */
  private static String API_PASSWORD;
  /**
   * OnbehalfOf Account
   */
  private static String ONBEHALF_ACCOUNT = null;
  /**
   * OnbehalfOf Password
   */
  private static String ONBEHALF_PASSWORD = null;
  /**
   * Account ID
   */
  private static long ACCOUNT_ID;
  /**
   * location cache
   */
  private static Properties locationCacheProp;
  /**
   * file for location cache
   */
  private static File locationCacheFile;

  /*
   * static initializer
   */
  static {
    try {

      SslOption.init();

      /*
       * read setting
       */
      boolean failed = false;
      List<String> errorMessages = new ArrayList<>();
      ResourceBundle bundle = ResourceBundle.getBundle("api_config");
      if (bundle.containsKey("API_VERSION")) {
        API_VERSION = bundle.getString("API_VERSION");
      } else {
        errorMessages.add("Error : Fail to get API_VERSION from api_config.properties.");
        failed = true;
      }
      if (bundle.containsKey("API_NS")) {
        API_NAMESPACE = bundle.getString("API_NS");
      } else {
        errorMessages.add("Error : Fail to get API_NS from api_config.properties.");
        failed = true;
      }
      if (bundle.containsKey("LOCATION")) {
        LOCATION = bundle.getString("LOCATION");
      } else {
        errorMessages.add("Error : Fail to get LOCATION from api_config.properties.");
        failed = true;
      }
      if (bundle.containsKey("LICENSE")) {
        API_LICENSE = bundle.getString("LICENSE");
      } else {
        errorMessages.add("Error : Fail to get LICENSE from api_config.properties.");
        failed = true;
      }
      if (bundle.containsKey("APIACCOUNTID")) {
        API_ACCOUNT = bundle.getString("APIACCOUNTID");
      } else {
        errorMessages.add("Error : Fail to get APIACCOUNTID from api_config.properties.");
        failed = true;
      }
      if (bundle.containsKey("APIACCOUNTPASSWORD")) {
        API_PASSWORD = bundle.getString("APIACCOUNTPASSWORD");
      } else {
        errorMessages.add("Error : Fail to get APIACCOUNTPASSWORD from api_config.properties.");
        failed = true;
      }
      if (bundle.containsKey("ONBEHALFOFACCOUNTID")) {
        ONBEHALF_ACCOUNT = bundle.getString("ONBEHALFOFACCOUNTID");
      }
      if (bundle.containsKey("ONBEHALFOFPASSWORD")) {
        ONBEHALF_PASSWORD = bundle.getString("ONBEHALFOFPASSWORD");
      }
      if (bundle.containsKey("ACCOUNTID")) {
        ACCOUNT_ID = Long.parseLong(bundle.getString("ACCOUNTID"));
      } else {
        errorMessages.add("Error : Fail to get ACCOUNTID from api_config.properties.");
        failed = true;
      }

      // setting error
      if (failed) {
        throw new ApiConfigException(String.join("\n", errorMessages));
      }

      /*
       * read location cache
       */
      // read cache properties file
      locationCacheProp = new Properties();
      locationCacheFile = new File(new File(".").getAbsolutePath(), "location_cache.properties");
      if (locationCacheFile.exists()) {
        locationCacheProp.load(new FileInputStream(locationCacheFile));
      }
    } catch (Exception e) {
      throw new ApiConfigException("Error : Fail to get api_config.properties file.", e);
    }
  }

  /**
   * get Account ID from config file.
   *
   * @return account ID.
   */
  public static long getAccountId() {
    return ACCOUNT_ID;
  }

  /**
   * get API VERSION from config file.
   *
   * @return API VERSION.
   */
  public static String getAPI_VERSION() {
    return API_VERSION;
  }

  /**
   * get API XML NAMESPACE from config file.
   *
   * @return API XML NAMESPACE.
   */
  public static String getAPI_NAMESPACE() {
    return API_NAMESPACE;
  }

  /**
   * get API LICENSE from config file.
   *
   * @return API LICENSE.
   */
  public static String getAPI_LICENSE() {
    return API_LICENSE;
  }

  /**
   * get API ACCOUNT from config file.
   *
   * @return API ACCOUNT.
   */
  public static String getAPI_ACCOUNT() {
    return API_ACCOUNT;
  }

  /**
   * get API PASSWORD from config file.
   *
   * @return API PASSWORD.
   */
  public static String getAPI_PASSWORD() {
    return API_PASSWORD;
  }

  /**
   * get ONBEHALF_ACCOUNT ID from config file.
   *
   * @return ONBEHALF ACCOUNT ID.
   */
  public static String getONBEHALF_ACCOUNT() {
    return ONBEHALF_ACCOUNT;
  }

  /**
   * get ONBEHALF_ACCOUNT PASSWORD from config file.
   *
   * @return ONBEHALF ACCOUNT PASSWORD.
   */
  public static String getONBEHALF_PASSWORD() {
    return ONBEHALF_PASSWORD;
  }

  /**
   * get service endpoint URL.
   *
   * @param serviceName SOAP API service name
   * @return endpoint URL
   */
  public static URL getServiceEndPointURL(String serviceName) throws Exception {
    URL url = new URL("https://" + getLocation(getAccountId()) + "/services/" + getAPI_VERSION() + "/" + serviceName);
    return url;
  }

  /**
   * get location for accountId.
   *
   * @return colocation server name for accountId.
   */
  public static String getLocation(long accountId) throws Exception {
    String cachedLocation = locationCacheProp.getProperty(Long.toString(accountId));
    if (cachedLocation != null) {
      // return cached location
      return cachedLocation;
    }
    // save location to cache
    cachedLocation = new SoapLocationFactory(getAccountId()).getSoapLocation();
    locationCacheProp.setProperty(Long.toString(accountId), cachedLocation);
    locationCacheProp.store(new FileOutputStream(locationCacheFile), "cache of location for accountId.");
    // display response
    System.out.println("accountId:[" + accountId + "]/Location:[" + cachedLocation + "]");
    System.out.println("---------");
    return cachedLocation;
  }

  /**
   * get location server url
   *
   * @return https://LOCATION/services/API_VERSION/serviceName
   * @see LOCATION
   * @see API_VERSION
   */
  public static String getLocationServer(String serviceName) {
    return "https://" + LOCATION + "/services/" + getAPI_VERSION() + "/" + serviceName;
  }

  /**
   * get wsdl url
   *
   * @return https://LOCATION/services/API_VERSION/serviceName?wsdl
   * @see LOCATION
   * @see API_VERSION
   */
  public static String getWsdlUrl(String serviceName) {
    return getLocationServer(serviceName) + "?wsdl";
  }


  /**
   * ServiceInterface object create
   *
   * @param <T> *ServiceInterface.class
   * @param <?  extends Service> *Service.class
   * @return ServiceInterface object
   * @throws Exception class type is invalid.
   */
  public static <T> T createServiceInterface(Class<T> serviceInterface, Class<? extends Service> serviceClass) throws Exception {

    String clazzName = serviceInterface.getSimpleName();

    if (clazzName.endsWith("ServiceInterface")) {
      String serviceName = clazzName.substring(0, clazzName.indexOf("Interface"));
      // create WsdlURL
      URL wsdlLocation = new URL(getWsdlUrl(serviceName));
      Service serviceProxy = Service.create(wsdlLocation, new QName(getAPI_NAMESPACE() + "/" + clazzName.substring(0, clazzName.indexOf("ServiceInterface")), serviceClass.getSimpleName()));
      serviceProxy.setHandlerResolver(SoapClientHandler.createHadlerResolver());

      // create EndPointURL
      W3CEndpointReferenceBuilder builder = new W3CEndpointReferenceBuilder();
      URL serviceEndPointURL = getServiceEndPointURL(serviceName);
      builder.address(serviceEndPointURL.toString());
      System.out.println("============================================");
      System.out.println(serviceName + " EndPoint URL = " + serviceEndPointURL.toString());
      System.out.println("============================================");

      // return ServiceInterface object
      return serviceProxy.getPort(builder.build(), serviceInterface);
    }

    throw new Exception("Invalid ServiceInterface");
  }

  /**
   * get current timestamp value.(yyyyMMddHHmmss)
   *
   * @return current timestamp string.
   */
  public static String getCurrentTimestamp() {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    return dateFormat.format(new Date());
  }

  /**
   * download data from url.
   *
   * @param downloadUrlStr download url
   * @param filename       save file name(not path, file name only).
   */
  public static void download(String downloadUrlStr, String filename) throws Exception {
    File downloadDir = new File(new File(".", "download").getAbsolutePath());
    if (!downloadDir.exists()) {
      downloadDir.mkdirs();
    }
    File filepath = new File(downloadDir, filename);

    System.out.println("------------------------------------");
    System.out.println("Start download.");
    System.out.println("DOWNLOAD_URL  = " + downloadUrlStr);
    System.out.println("DOWNLOAD_FILE = " + filepath.getAbsolutePath());
    System.out.println("------------------------------------");

    InputStream is = null;
    FileOutputStream fos = null;
    try {
      URL downloadURL = new URL(downloadUrlStr);
      // get InputStream from download URL.
      is = downloadURL.openConnection().getInputStream();
      // create file output stream
      fos = new FileOutputStream(filepath, false);
      // download
      int b;
      while ((b = is.read()) != -1) {
        fos.write(b);
      }
    } finally {
      if (is != null) {
        is.close();
      }
      if (fos != null) {
        fos.close();
      }
    }
  }

  private static final String BOUNDARY = "abcdefghijklmnopqrstuvwxyzabcdefghijklmn";

  /**
   * upload data to url.
   *
   * @param uploadUrlStr upload url
   * @param filename     save file name(not path, file name only).
   * @param contentType  upload file Content-Type for set HTTP Header.
   * @return upload BulkJob Id.
   */
  public static String upload(String uploadUrlStr, String filename, String contentType) throws Exception {
    File uploadDir = new File(new File(".", "upload").getAbsolutePath());
    File uploadFile = new File(uploadDir, filename);
    if (!uploadFile.exists()) {
      throw new FileNotFoundException("upload file not found. file=" + uploadFile.getAbsolutePath());
    }

    HttpURLConnection uploadUrlConnection = null;
    DataOutputStream dos = null;
    InputStream is = null;
    try {
      URL uploadUrl = new URL(uploadUrlStr);
      URLConnection con = uploadUrl.openConnection();
      if (con instanceof HttpURLConnection) {

        // setup HttpURLConnection
        uploadUrlConnection = (HttpURLConnection) con;
        uploadUrlConnection.setDoOutput(true);
        uploadUrlConnection.setRequestMethod("POST");
        uploadUrlConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);

        // setup post data
        dos = new DataOutputStream(uploadUrlConnection.getOutputStream());
        dos.writeBytes("--");
        dos.writeBytes(BOUNDARY);
        dos.writeBytes("\r\n");

        dos.writeBytes("Content-Disposition: form-data;");
        dos.writeBytes("name=\"BulkUpload\";");
        dos.writeBytes("filename=" + filename + "\r\n");
        dos.writeBytes("Content-Type: " + contentType + "\r\n");
        dos.writeBytes("\r\n");

        BufferedInputStream in = new BufferedInputStream(new FileInputStream(uploadFile));
        int buff = 0;
        while ((buff = in.read()) != -1) {
          dos.write(buff);
        }
        dos.writeBytes("\r\n");

        dos.writeBytes("--");
        dos.writeBytes(BOUNDARY);
        dos.writeBytes("--");

        // POST
        System.out.println("------------------------------------");
        System.out.println("Start upload.");
        System.out.println("UPLOAD_URL  = " + uploadUrlStr);
        System.out.println("UPLOAD_FILE = " + uploadFile.getAbsolutePath());
        System.out.println("------------------------------------");
        dos.flush();

        // get response
        is = uploadUrlConnection.getInputStream();
        StringWriter response = new StringWriter();
        int b;
        while ((b = is.read()) != -1) {
          response.write(b);
        }

        System.out.println("Upload HTTP Response\n");
        System.out.println(response + "\n");
        return response.toString();

      } else {
        throw new RuntimeException("Illegal upload URL. protocol is not http or https. url=" + uploadUrlStr);
      }

    } finally {
      if (dos != null) {
        dos.close();
      }
      if (uploadUrlConnection != null) {
        uploadUrlConnection.disconnect();
      }
    }
  }

  public static void checkSoapError(Holder<List<Error>> errorHolder) throws Exception {
    if (errorHolder.value != null && errorHolder.value.size() > 0) {
      throw new Exception("Error");
    }
    if (errorHolder.value == null) {
      throw new Exception("NoDataResponse");
    }
  }

  public static <T extends ReturnValue> void checkSoapError(Holder<List<Error>> errorHolder, List<T> returnValueList) throws Exception {
    checkSoapError(errorHolder);
    for (ReturnValue values : returnValueList) {
      if (!values.isOperationSucceeded()) {
        throw new Exception("OperationFailed");
      }
    }
  }
}

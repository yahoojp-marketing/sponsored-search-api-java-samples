package jp.co.yahoo.ad_api_sample.util;

import java.net.URL;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.ws.Holder;
import javax.xml.ws.Service;
import javax.xml.ws.wsaddressing.W3CEndpointReferenceBuilder;

import jp.yahooapis.ss.V6.LocationService.Error;
import jp.yahooapis.ss.V6.LocationService.LocationReturnValue;
import jp.yahooapis.ss.V6.LocationService.LocationService;
import jp.yahooapis.ss.V6.LocationService.LocationServiceInterface;



public class SoapLocationFactory {

  private final long accountId;

  private static final String SERVICE_NAME = "LocationService";

  public SoapLocationFactory(long accountId) {
    super();
    this.accountId = accountId;
  }

  public String getSoapLocation() throws Exception {

    // create EndPoint URL
    Service serviceProxy = Service.create(new URL(SoapUtils.getWsdlUrl(SERVICE_NAME)), new QName(SoapUtils.getAPI_NAMESPACE(), LocationService.class.getSimpleName()));
    serviceProxy.setHandlerResolver(SoapClientHandler.createHadlerResolver());
    W3CEndpointReferenceBuilder builder = new W3CEndpointReferenceBuilder();
    String locationServer = SoapUtils.getLocationServer(SERVICE_NAME);
    builder.address(locationServer);

    System.out.println("========================================================================================");
    System.out.println("LocationService EndPoint URL = " + locationServer.toString());
    System.out.println("========================================================================================");

    LocationServiceInterface service = serviceProxy.getPort(builder.build(), LocationServiceInterface.class);

    Holder<LocationReturnValue> rvalHolder = new Holder<LocationReturnValue>();
    Holder<List<Error>> errorHolder = new Holder<List<Error>>();
    service.get(accountId, rvalHolder, errorHolder);
    if (errorHolder.value != null && !errorHolder.value.isEmpty()) {
      for (Error error : errorHolder.value) {
        System.out.println("code = " + error.getCode());
        System.out.println("message = " + error.getMessage());
        System.out.println("---------");
      }
      throw new Exception("LocationService Error !!");
    }

    return rvalHolder.value.getValue();
  }

}

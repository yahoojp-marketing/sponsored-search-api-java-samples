package jp.co.yahoo.ad_api_sample.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.PortInfo;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class SoapClientHandler implements SOAPHandler<SOAPMessageContext> {

  public static HandlerResolver createHadlerResolver() {
    return new HandlerResolver() {

      @SuppressWarnings("rawtypes")
      @Override
      public List<Handler> getHandlerChain(PortInfo portInfo) {
        return Arrays.asList((Handler) new SoapClientHandler());
      }
    };
  }

  @Override
  public void close(MessageContext arg0) {}

  @Override
  public boolean handleFault(SOAPMessageContext arg0) {
    return false;
  }

  /**
   * set SoapRequestHeader SoapRequestHeader's xml element
   * 
   * <pre>
   * <soapenv:Header>
   *   <RequestHeader>
   *     <license>xxxx-xxxx-xxxx-xxxx(from api_config.properties)</license>
   *     <apiAccountId>xxxx-xxxx-xxxx-xxxx(from api_config.properties)</apiAccountId>
   *     <apiAccountPassword>xxxx(from api_config.properties)</apiAccountPassword>
   *     <!-- The following settings is optional -->
   *     <onBehalfOfAccountId>xxxxxxx(from api_config.properties)</onBehalfOfAccountId>
   *     <onBehalfOfPassword>xxxxxxx(from api_config.properties)</onBehalfOfPassword>
   *     <accountId>xxxxxxx(from api_config.properties)</accountId>
   *   </RequestHeader>
   * </soapenv:Header>
   * </pre>
   */
  @Override
  public boolean handleMessage(SOAPMessageContext context) {
    try {
      Boolean outboundProperty = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
      // for Request
      if (outboundProperty.booleanValue()) {
        SOAPMessage msg = context.getMessage();
        SOAPEnvelope envelope = msg.getSOAPPart().getEnvelope();
        if (envelope.getHeader() != null) {
          envelope.getHeader().detachNode();
        }
        SOAPHeader header = envelope.addHeader();
        SOAPHeaderElement headerElement = header.addHeaderElement(new QName(SoapUtils.getAPI_NAMESPACE(), "RequestHeader"));
        headerElement.addChildElement(envelope.createName("license")).setValue(SoapUtils.getAPI_LICENSE());
        headerElement.addChildElement(envelope.createName("apiAccountId")).setValue(SoapUtils.getAPI_ACCOUNT());
        headerElement.addChildElement(envelope.createName("apiAccountPassword")).setValue(SoapUtils.getAPI_PASSWORD());
        if (useOnBeahlfAccount()) {
          headerElement.addChildElement(envelope.createName("onBehalfOfAccountId")).setValue(SoapUtils.getONBEHALF_ACCOUNT());
          headerElement.addChildElement(envelope.createName("onBehalfOfPassword")).setValue(SoapUtils.getONBEHALF_PASSWORD());
          headerElement.addChildElement(envelope.createName("accountId")).setValue(String.valueOf(SoapUtils.getAccountId()));
        }
      }

    } catch (SOAPException ex) {
      ex.printStackTrace();
      return false;
    }
    return true;
  }

  @Override
  public Set<QName> getHeaders() {
    return Collections.emptySet();
  }

  private boolean useOnBeahlfAccount() {
    return (SoapUtils.getONBEHALF_ACCOUNT() != null && SoapUtils.getONBEHALF_PASSWORD() != null);
  }

}

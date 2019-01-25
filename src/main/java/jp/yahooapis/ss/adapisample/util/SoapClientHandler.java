/**
 * Copyright (C) 2019 Yahoo Japan Corporation. All Rights Reserved.
 */
package jp.yahooapis.ss.adapisample.util;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.PortInfo;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

/**
 * Utility method collection for Java Sample Program.
 */
public class SoapClientHandler implements SOAPHandler<SOAPMessageContext> {

  public static HandlerResolver createHadlerResolver() {
    return new HandlerResolver() {

      @SuppressWarnings("rawtypes")
      @Override
      public List<Handler> getHandlerChain(PortInfo portInfo) {
        return Collections.singletonList((Handler) new SoapClientHandler());
      }
    };
  }

  @Override
  public void close(MessageContext arg0) {
  }

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
      SOAPMessage msg = context.getMessage();

      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
      String timestamp = dateFormat.format(new Date());

      if (outboundProperty) {
        SOAPEnvelope envelope = msg.getSOAPPart().getEnvelope();
        if (envelope.getHeader() != null) {
          envelope.getHeader().detachNode();
        }
        envelope.setPrefix("SOAP-ENV");
        envelope.getBody().setPrefix("SOAP-ENV");
        envelope.removeNamespaceDeclaration("S");
        envelope.addNamespaceDeclaration("ns1", SoapUtils.getAPI_NAMESPACE());
        SOAPHeader header = envelope.addHeader();
        header.setPrefix("SOAP-ENV");

        SOAPHeaderElement headerElement = header.addHeaderElement(new QName(SoapUtils.getAPI_NAMESPACE(), "RequestHeader", "ns1"));
        headerElement.addChildElement("license", "ns1").setValue(SoapUtils.getAPI_LICENSE());
        headerElement.addChildElement("apiAccountId", "ns1").setValue(SoapUtils.getAPI_ACCOUNT());
        headerElement.addChildElement("apiAccountPassword", "ns1").setValue(SoapUtils.getAPI_PASSWORD());
        if (useOnBehalfAccount()) {
          headerElement.addChildElement("onBehalfOfAccountId", "ns1").setValue(SoapUtils.getONBEHALF_ACCOUNT());
          headerElement.addChildElement("onBehalfOfPassword", "ns1").setValue(SoapUtils.getONBEHALF_PASSWORD());
          headerElement.addChildElement("accountId", "ns1").setValue(String.valueOf(SoapUtils.getAccountId()));
        }
        msg.saveChanges();
        System.out.println("--------------------------------------------");
        System.out.println("[" + timestamp + "] : SOAP Request");
        System.out.println("--------------------------------------------");
      } else {
        System.out.println("--------------------------------------------");
        System.out.println("[" + timestamp + "] : SOAP Response");
        System.out.println("--------------------------------------------");
      }

      ByteArrayOutputStream bytesOutputStream = new ByteArrayOutputStream();
      msg.writeTo(bytesOutputStream);

      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = factory.newDocumentBuilder();
      InputStream soapMessageBytes = new ByteArrayInputStream(bytesOutputStream.toByteArray());
      Document document = builder.parse(soapMessageBytes);
      Transformer transformer = TransformerFactory.newInstance().newTransformer();
      transformer.setOutputProperty(OutputKeys.INDENT, "yes");
      transformer.setOutputProperty(OutputKeys.METHOD, "xml");
      transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

      StringWriter stringWriter = new StringWriter();
      transformer.transform(new DOMSource(document), new StreamResult(stringWriter));
      System.out.println(stringWriter.toString());

    } catch (ParserConfigurationException e) {
      e.printStackTrace();
      return false;
    } catch (IOException e) {
      e.printStackTrace();
      return false;
    } catch (TransformerConfigurationException e) {
      e.printStackTrace();
      return false;
    } catch (TransformerException e) {
      e.printStackTrace();
      return false;
    } catch (SAXException e) {
      e.printStackTrace();
      return false;
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

  private boolean useOnBehalfAccount() {
    return (SoapUtils.getONBEHALF_ACCOUNT() != null && SoapUtils.getONBEHALF_PASSWORD() != null);
  }
}

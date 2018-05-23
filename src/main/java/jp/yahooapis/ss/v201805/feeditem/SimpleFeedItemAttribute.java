
package jp.yahooapis.ss.v201805.feeditem;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SimpleFeedItemAttribute complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SimpleFeedItemAttribute">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V201805/FeedItem}FeedItemAttribute">
 *       &lt;sequence>
 *         &lt;element name="feedAttributeValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reviewFeedAttributeValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SimpleFeedItemAttribute", propOrder = {
    "feedAttributeValue",
    "reviewFeedAttributeValue"
})
public class SimpleFeedItemAttribute
    extends FeedItemAttribute
{

    protected String feedAttributeValue;
    protected String reviewFeedAttributeValue;

    /**
     * Gets the value of the feedAttributeValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeedAttributeValue() {
        return feedAttributeValue;
    }

    /**
     * Sets the value of the feedAttributeValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeedAttributeValue(String value) {
        this.feedAttributeValue = value;
    }

    /**
     * Gets the value of the reviewFeedAttributeValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReviewFeedAttributeValue() {
        return reviewFeedAttributeValue;
    }

    /**
     * Sets the value of the reviewFeedAttributeValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReviewFeedAttributeValue(String value) {
        this.reviewFeedAttributeValue = value;
    }

}

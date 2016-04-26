
package jp.yahooapis.ss.V6.FeedItemService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FeedItemAttribute complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FeedItemAttribute">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="placeholderField" type="{http://ss.yahooapis.jp/V6}PlaceholderField" minOccurs="0"/>
 *         &lt;element name="feedAttributeId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="feedAttributeValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reviewFeedAttributeValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FeedItemAttribute", propOrder = {
    "placeholderField",
    "feedAttributeId",
    "feedAttributeValue",
    "reviewFeedAttributeValue"
})
public class FeedItemAttribute {

    @XmlSchemaType(name = "string")
    protected PlaceholderField placeholderField;
    protected Long feedAttributeId;
    protected String feedAttributeValue;
    protected String reviewFeedAttributeValue;

    /**
     * Gets the value of the placeholderField property.
     * 
     * @return
     *     possible object is
     *     {@link PlaceholderField }
     *     
     */
    public PlaceholderField getPlaceholderField() {
        return placeholderField;
    }

    /**
     * Sets the value of the placeholderField property.
     * 
     * @param value
     *     allowed object is
     *     {@link PlaceholderField }
     *     
     */
    public void setPlaceholderField(PlaceholderField value) {
        this.placeholderField = value;
    }

    /**
     * Gets the value of the feedAttributeId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFeedAttributeId() {
        return feedAttributeId;
    }

    /**
     * Sets the value of the feedAttributeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFeedAttributeId(Long value) {
        this.feedAttributeId = value;
    }

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

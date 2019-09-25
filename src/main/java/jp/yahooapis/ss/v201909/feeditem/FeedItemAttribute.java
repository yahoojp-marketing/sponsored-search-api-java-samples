
package jp.yahooapis.ss.v201909.feeditem;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
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
 *         &lt;element name="placeholderField" type="{http://ss.yahooapis.jp/V201909/FeedItem}FeedItemPlaceholderField" minOccurs="0"/>
 *         &lt;element name="feedAttributeId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
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
    "feedAttributeId"
})
@XmlSeeAlso({
    SimpleFeedItemAttribute.class,
    MultipleFeedItemAttribute.class
})
public abstract class FeedItemAttribute {

    @XmlSchemaType(name = "string")
    protected FeedItemPlaceholderField placeholderField;
    protected Long feedAttributeId;

    /**
     * Gets the value of the placeholderField property.
     * 
     * @return
     *     possible object is
     *     {@link FeedItemPlaceholderField }
     *     
     */
    public FeedItemPlaceholderField getPlaceholderField() {
        return placeholderField;
    }

    /**
     * Sets the value of the placeholderField property.
     * 
     * @param value
     *     allowed object is
     *     {@link FeedItemPlaceholderField }
     *     
     */
    public void setPlaceholderField(FeedItemPlaceholderField value) {
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

}

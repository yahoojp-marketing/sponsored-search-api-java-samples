
package jp.yahooapis.ss.v201909.feedfolder;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FeedAttribute complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FeedAttribute">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="feedAttributeId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="feedAttributeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="placeholderField" type="{http://ss.yahooapis.jp/V201909/FeedFolder}FeedFolderPlaceholderField" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FeedAttribute", propOrder = {
    "feedAttributeId",
    "feedAttributeName",
    "placeholderField"
})
public class FeedAttribute {

    protected Long feedAttributeId;
    protected String feedAttributeName;
    @XmlSchemaType(name = "string")
    protected FeedFolderPlaceholderField placeholderField;

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
     * Gets the value of the feedAttributeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeedAttributeName() {
        return feedAttributeName;
    }

    /**
     * Sets the value of the feedAttributeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeedAttributeName(String value) {
        this.feedAttributeName = value;
    }

    /**
     * Gets the value of the placeholderField property.
     * 
     * @return
     *     possible object is
     *     {@link FeedFolderPlaceholderField }
     *     
     */
    public FeedFolderPlaceholderField getPlaceholderField() {
        return placeholderField;
    }

    /**
     * Sets the value of the placeholderField property.
     * 
     * @param value
     *     allowed object is
     *     {@link FeedFolderPlaceholderField }
     *     
     */
    public void setPlaceholderField(FeedFolderPlaceholderField value) {
        this.placeholderField = value;
    }

}

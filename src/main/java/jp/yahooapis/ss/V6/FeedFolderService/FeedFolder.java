
package jp.yahooapis.ss.V6.FeedFolderService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FeedFolder complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FeedFolder">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="feedFolderId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="feedFolderName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="feedAttribute" type="{http://ss.yahooapis.jp/V6}FeedAttribute" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="placeholderType" type="{http://ss.yahooapis.jp/V6}PlaceholderType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FeedFolder", propOrder = {
    "accountId",
    "feedFolderId",
    "feedFolderName",
    "feedAttribute",
    "placeholderType"
})
public class FeedFolder {

    protected long accountId;
    protected Long feedFolderId;
    protected String feedFolderName;
    protected List<FeedAttribute> feedAttribute;
    @XmlSchemaType(name = "string")
    protected PlaceholderType placeholderType;

    /**
     * Gets the value of the accountId property.
     * 
     */
    public long getAccountId() {
        return accountId;
    }

    /**
     * Sets the value of the accountId property.
     * 
     */
    public void setAccountId(long value) {
        this.accountId = value;
    }

    /**
     * Gets the value of the feedFolderId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFeedFolderId() {
        return feedFolderId;
    }

    /**
     * Sets the value of the feedFolderId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFeedFolderId(Long value) {
        this.feedFolderId = value;
    }

    /**
     * Gets the value of the feedFolderName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeedFolderName() {
        return feedFolderName;
    }

    /**
     * Sets the value of the feedFolderName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeedFolderName(String value) {
        this.feedFolderName = value;
    }

    /**
     * Gets the value of the feedAttribute property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the feedAttribute property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFeedAttribute().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FeedAttribute }
     * 
     * 
     */
    public List<FeedAttribute> getFeedAttribute() {
        if (feedAttribute == null) {
            feedAttribute = new ArrayList<FeedAttribute>();
        }
        return this.feedAttribute;
    }

    /**
     * Gets the value of the placeholderType property.
     * 
     * @return
     *     possible object is
     *     {@link PlaceholderType }
     *     
     */
    public PlaceholderType getPlaceholderType() {
        return placeholderType;
    }

    /**
     * Sets the value of the placeholderType property.
     * 
     * @param value
     *     allowed object is
     *     {@link PlaceholderType }
     *     
     */
    public void setPlaceholderType(PlaceholderType value) {
        this.placeholderType = value;
    }

}

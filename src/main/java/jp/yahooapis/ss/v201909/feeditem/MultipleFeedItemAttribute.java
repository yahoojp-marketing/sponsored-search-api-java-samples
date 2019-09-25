
package jp.yahooapis.ss.v201909.feeditem;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MultipleFeedItemAttribute complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MultipleFeedItemAttribute">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V201909/FeedItem}FeedItemAttribute">
 *       &lt;sequence>
 *         &lt;element name="feedAttributeValues" type="{http://ss.yahooapis.jp/V201909/FeedItem}FeedAttributeValue" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="isRemove" type="{http://ss.yahooapis.jp/V201909/FeedItem}IsRemove" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MultipleFeedItemAttribute", propOrder = {
    "feedAttributeValues",
    "isRemove"
})
public class MultipleFeedItemAttribute
    extends FeedItemAttribute
{

    protected List<FeedAttributeValue> feedAttributeValues;
    @XmlSchemaType(name = "string")
    protected IsRemove isRemove;

    /**
     * Gets the value of the feedAttributeValues property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the feedAttributeValues property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFeedAttributeValues().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FeedAttributeValue }
     * 
     * 
     */
    public List<FeedAttributeValue> getFeedAttributeValues() {
        if (feedAttributeValues == null) {
            feedAttributeValues = new ArrayList<FeedAttributeValue>();
        }
        return this.feedAttributeValues;
    }

    /**
     * Gets the value of the isRemove property.
     * 
     * @return
     *     possible object is
     *     {@link IsRemove }
     *     
     */
    public IsRemove getIsRemove() {
        return isRemove;
    }

    /**
     * Sets the value of the isRemove property.
     * 
     * @param value
     *     allowed object is
     *     {@link IsRemove }
     *     
     */
    public void setIsRemove(IsRemove value) {
        this.isRemove = value;
    }

}

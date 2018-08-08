
package jp.yahooapis.ss.v201808.feeditem;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Location complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Location">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="targetId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="type" type="{http://ss.yahooapis.jp/V201808/FeedItem}CriterionTypeFeedItem" minOccurs="0"/>
 *         &lt;element name="geoTargetingRestriction" type="{http://ss.yahooapis.jp/V201808/FeedItem}FeedItemGeoRestriction" minOccurs="0"/>
 *         &lt;element name="isRemove" type="{http://ss.yahooapis.jp/V201808/FeedItem}IsRemove" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Location", propOrder = {
    "targetId",
    "type",
    "geoTargetingRestriction",
    "isRemove"
})
public class Location {

    protected String targetId;
    @XmlSchemaType(name = "string")
    protected CriterionTypeFeedItem type;
    @XmlSchemaType(name = "string")
    protected FeedItemGeoRestriction geoTargetingRestriction;
    @XmlSchemaType(name = "string")
    protected IsRemove isRemove;

    /**
     * Gets the value of the targetId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTargetId() {
        return targetId;
    }

    /**
     * Sets the value of the targetId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTargetId(String value) {
        this.targetId = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link CriterionTypeFeedItem }
     *     
     */
    public CriterionTypeFeedItem getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link CriterionTypeFeedItem }
     *     
     */
    public void setType(CriterionTypeFeedItem value) {
        this.type = value;
    }

    /**
     * Gets the value of the geoTargetingRestriction property.
     * 
     * @return
     *     possible object is
     *     {@link FeedItemGeoRestriction }
     *     
     */
    public FeedItemGeoRestriction getGeoTargetingRestriction() {
        return geoTargetingRestriction;
    }

    /**
     * Sets the value of the geoTargetingRestriction property.
     * 
     * @param value
     *     allowed object is
     *     {@link FeedItemGeoRestriction }
     *     
     */
    public void setGeoTargetingRestriction(FeedItemGeoRestriction value) {
        this.geoTargetingRestriction = value;
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

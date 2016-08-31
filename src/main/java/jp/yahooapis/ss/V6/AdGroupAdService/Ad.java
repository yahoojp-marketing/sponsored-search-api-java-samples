
package jp.yahooapis.ss.V6.AdGroupAdService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Ad complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Ad">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="type" type="{http://ss.yahooapis.jp/V6}AdType" minOccurs="0"/>
 *         &lt;element name="advancedUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="additionalAdvancedUrls" type="{http://ss.yahooapis.jp/V6}AdGroupAdAdditionalAdvancedUrls" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="advancedMobileUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="additionalAdvancedMobileUrls" type="{http://ss.yahooapis.jp/V6}AdGroupAdAdditionalAdvancedMobileUrls" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="trackingUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="customParameters" type="{http://ss.yahooapis.jp/V6}CustomParameters" minOccurs="0"/>
 *         &lt;element name="advanced" type="{http://ss.yahooapis.jp/V6}Advanced" minOccurs="0"/>
 *         &lt;element name="url" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="displayUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="headline" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Ad", propOrder = {
    "type",
    "advancedUrl",
    "additionalAdvancedUrls",
    "advancedMobileUrl",
    "additionalAdvancedMobileUrls",
    "trackingUrl",
    "customParameters",
    "advanced",
    "url",
    "displayUrl",
    "headline",
    "description"
})
@XmlSeeAlso({
    MobileAd.class,
    AppAd.class,
    TextAd2 .class
})
public class Ad {

    @XmlSchemaType(name = "string")
    protected AdType type;
    protected String advancedUrl;
    protected List<AdGroupAdAdditionalAdvancedUrls> additionalAdvancedUrls;
    protected String advancedMobileUrl;
    protected List<AdGroupAdAdditionalAdvancedMobileUrls> additionalAdvancedMobileUrls;
    protected String trackingUrl;
    protected CustomParameters customParameters;
    @XmlSchemaType(name = "string")
    protected Advanced advanced;
    protected String url;
    protected String displayUrl;
    protected String headline;
    protected String description;

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link AdType }
     *     
     */
    public AdType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdType }
     *     
     */
    public void setType(AdType value) {
        this.type = value;
    }

    /**
     * Gets the value of the advancedUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdvancedUrl() {
        return advancedUrl;
    }

    /**
     * Sets the value of the advancedUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdvancedUrl(String value) {
        this.advancedUrl = value;
    }

    /**
     * Gets the value of the additionalAdvancedUrls property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the additionalAdvancedUrls property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdditionalAdvancedUrls().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AdGroupAdAdditionalAdvancedUrls }
     * 
     * 
     */
    public List<AdGroupAdAdditionalAdvancedUrls> getAdditionalAdvancedUrls() {
        if (additionalAdvancedUrls == null) {
            additionalAdvancedUrls = new ArrayList<AdGroupAdAdditionalAdvancedUrls>();
        }
        return this.additionalAdvancedUrls;
    }

    /**
     * Gets the value of the advancedMobileUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdvancedMobileUrl() {
        return advancedMobileUrl;
    }

    /**
     * Sets the value of the advancedMobileUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdvancedMobileUrl(String value) {
        this.advancedMobileUrl = value;
    }

    /**
     * Gets the value of the additionalAdvancedMobileUrls property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the additionalAdvancedMobileUrls property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdditionalAdvancedMobileUrls().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AdGroupAdAdditionalAdvancedMobileUrls }
     * 
     * 
     */
    public List<AdGroupAdAdditionalAdvancedMobileUrls> getAdditionalAdvancedMobileUrls() {
        if (additionalAdvancedMobileUrls == null) {
            additionalAdvancedMobileUrls = new ArrayList<AdGroupAdAdditionalAdvancedMobileUrls>();
        }
        return this.additionalAdvancedMobileUrls;
    }

    /**
     * Gets the value of the trackingUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrackingUrl() {
        return trackingUrl;
    }

    /**
     * Sets the value of the trackingUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrackingUrl(String value) {
        this.trackingUrl = value;
    }

    /**
     * Gets the value of the customParameters property.
     * 
     * @return
     *     possible object is
     *     {@link CustomParameters }
     *     
     */
    public CustomParameters getCustomParameters() {
        return customParameters;
    }

    /**
     * Sets the value of the customParameters property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomParameters }
     *     
     */
    public void setCustomParameters(CustomParameters value) {
        this.customParameters = value;
    }

    /**
     * Gets the value of the advanced property.
     * 
     * @return
     *     possible object is
     *     {@link Advanced }
     *     
     */
    public Advanced getAdvanced() {
        return advanced;
    }

    /**
     * Sets the value of the advanced property.
     * 
     * @param value
     *     allowed object is
     *     {@link Advanced }
     *     
     */
    public void setAdvanced(Advanced value) {
        this.advanced = value;
    }

    /**
     * Gets the value of the url property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the value of the url property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrl(String value) {
        this.url = value;
    }

    /**
     * Gets the value of the displayUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDisplayUrl() {
        return displayUrl;
    }

    /**
     * Sets the value of the displayUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDisplayUrl(String value) {
        this.displayUrl = value;
    }

    /**
     * Gets the value of the headline property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHeadline() {
        return headline;
    }

    /**
     * Sets the value of the headline property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHeadline(String value) {
        this.headline = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

}

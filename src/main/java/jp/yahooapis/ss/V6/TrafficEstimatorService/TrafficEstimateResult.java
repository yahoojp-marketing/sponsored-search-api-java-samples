
package jp.yahooapis.ss.V6.TrafficEstimatorService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TrafficEstimateResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TrafficEstimateResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="type" type="{http://ss.yahooapis.jp/V6}EstimateResultType"/>
 *         &lt;element name="keyword" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="matchType" type="{http://ss.yahooapis.jp/V6}KeywordMatchType" minOccurs="0"/>
 *         &lt;element name="bid" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="impressions" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="clicks" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="rank" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="cpc" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TrafficEstimateResult", propOrder = {
    "type",
    "keyword",
    "matchType",
    "bid",
    "impressions",
    "clicks",
    "rank",
    "cpc"
})
@XmlSeeAlso({
    TotalEstimateResult.class,
    SmartPhoneEstimateResult.class,
    WapMobileEstimateResult.class,
    DesktopEstimateResult.class
})
public class TrafficEstimateResult {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected EstimateResultType type;
    protected String keyword;
    @XmlSchemaType(name = "string")
    protected KeywordMatchType matchType;
    protected Long bid;
    protected Double impressions;
    protected Double clicks;
    protected Double rank;
    protected Double cpc;

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link EstimateResultType }
     *     
     */
    public EstimateResultType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link EstimateResultType }
     *     
     */
    public void setType(EstimateResultType value) {
        this.type = value;
    }

    /**
     * Gets the value of the keyword property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     * Sets the value of the keyword property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKeyword(String value) {
        this.keyword = value;
    }

    /**
     * Gets the value of the matchType property.
     * 
     * @return
     *     possible object is
     *     {@link KeywordMatchType }
     *     
     */
    public KeywordMatchType getMatchType() {
        return matchType;
    }

    /**
     * Sets the value of the matchType property.
     * 
     * @param value
     *     allowed object is
     *     {@link KeywordMatchType }
     *     
     */
    public void setMatchType(KeywordMatchType value) {
        this.matchType = value;
    }

    /**
     * Gets the value of the bid property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBid() {
        return bid;
    }

    /**
     * Sets the value of the bid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBid(Long value) {
        this.bid = value;
    }

    /**
     * Gets the value of the impressions property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getImpressions() {
        return impressions;
    }

    /**
     * Sets the value of the impressions property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setImpressions(Double value) {
        this.impressions = value;
    }

    /**
     * Gets the value of the clicks property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getClicks() {
        return clicks;
    }

    /**
     * Sets the value of the clicks property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setClicks(Double value) {
        this.clicks = value;
    }

    /**
     * Gets the value of the rank property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getRank() {
        return rank;
    }

    /**
     * Sets the value of the rank property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setRank(Double value) {
        this.rank = value;
    }

    /**
     * Gets the value of the cpc property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getCpc() {
        return cpc;
    }

    /**
     * Sets the value of the cpc property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setCpc(Double value) {
        this.cpc = value;
    }

}

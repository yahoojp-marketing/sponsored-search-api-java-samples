
package jp.yahooapis.ss.V6.AdGroupBidMultiplierService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PlatformBidMultiplierList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PlatformBidMultiplierList">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V6}BidMultiplierList">
 *       &lt;sequence>
 *         &lt;element name="bidMultipliers" type="{http://ss.yahooapis.jp/V6}PlatformBidMultiplier" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PlatformBidMultiplierList", propOrder = {
    "bidMultipliers"
})
public class PlatformBidMultiplierList
    extends BidMultiplierList
{

    protected List<PlatformBidMultiplier> bidMultipliers;

    /**
     * Gets the value of the bidMultipliers property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bidMultipliers property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBidMultipliers().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PlatformBidMultiplier }
     * 
     * 
     */
    public List<PlatformBidMultiplier> getBidMultipliers() {
        if (bidMultipliers == null) {
            bidMultipliers = new ArrayList<PlatformBidMultiplier>();
        }
        return this.bidMultipliers;
    }

}

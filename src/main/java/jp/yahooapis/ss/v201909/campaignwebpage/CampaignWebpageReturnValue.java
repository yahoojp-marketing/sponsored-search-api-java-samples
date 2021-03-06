
package jp.yahooapis.ss.v201909.campaignwebpage;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import jp.yahooapis.ss.v201909.ListReturnValue;


/**
 * <p>Java class for CampaignWebpageReturnValue complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CampaignWebpageReturnValue">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V201909}ListReturnValue">
 *       &lt;sequence>
 *         &lt;element name="values" type="{http://ss.yahooapis.jp/V201909/CampaignWebpage}CampaignWebpageValues" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CampaignWebpageReturnValue", propOrder = {
    "values"
})
public class CampaignWebpageReturnValue
    extends ListReturnValue
{

    protected List<CampaignWebpageValues> values;

    /**
     * Gets the value of the values property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the values property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getValues().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CampaignWebpageValues }
     * 
     * 
     */
    public List<CampaignWebpageValues> getValues() {
        if (values == null) {
            values = new ArrayList<CampaignWebpageValues>();
        }
        return this.values;
    }

}


package jp.yahooapis.ss.v201909.campaigntarget;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import jp.yahooapis.ss.v201909.ListReturnValue;


/**
 * <p>Java class for CampaignTargetReturnValue complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CampaignTargetReturnValue">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V201909}ListReturnValue">
 *       &lt;sequence>
 *         &lt;element name="values" type="{http://ss.yahooapis.jp/V201909/CampaignTarget}CampaignTargetValues" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CampaignTargetReturnValue", propOrder = {
    "values"
})
public class CampaignTargetReturnValue
    extends ListReturnValue
{

    protected List<CampaignTargetValues> values;

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
     * {@link CampaignTargetValues }
     * 
     * 
     */
    public List<CampaignTargetValues> getValues() {
        if (values == null) {
            values = new ArrayList<CampaignTargetValues>();
        }
        return this.values;
    }

}

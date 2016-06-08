
package jp.yahooapis.ss.V6.AdGroupAdService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MobileAd complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MobileAd">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V6}Ad">
 *       &lt;sequence>
 *         &lt;element name="markupLanguages" type="{http://ss.yahooapis.jp/V6}MarkupLanguageType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="mobileCarriers" type="{http://ss.yahooapis.jp/V6}CarrierName" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MobileAd", propOrder = {
    "markupLanguages",
    "mobileCarriers"
})
public class MobileAd
    extends Ad
{

    @XmlSchemaType(name = "string")
    protected List<MarkupLanguageType> markupLanguages;
    @XmlSchemaType(name = "string")
    protected List<CarrierName> mobileCarriers;

    /**
     * Gets the value of the markupLanguages property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the markupLanguages property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMarkupLanguages().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MarkupLanguageType }
     * 
     * 
     */
    public List<MarkupLanguageType> getMarkupLanguages() {
        if (markupLanguages == null) {
            markupLanguages = new ArrayList<MarkupLanguageType>();
        }
        return this.markupLanguages;
    }

    /**
     * Gets the value of the mobileCarriers property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mobileCarriers property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMobileCarriers().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CarrierName }
     * 
     * 
     */
    public List<CarrierName> getMobileCarriers() {
        if (mobileCarriers == null) {
            mobileCarriers = new ArrayList<CarrierName>();
        }
        return this.mobileCarriers;
    }

}

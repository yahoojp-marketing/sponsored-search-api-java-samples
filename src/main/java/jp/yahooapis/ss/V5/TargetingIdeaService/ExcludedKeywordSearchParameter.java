
package jp.yahooapis.ss.V5.TargetingIdeaService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ExcludedKeywordSearchParameter complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExcludedKeywordSearchParameter">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V5}SearchParameter">
 *       &lt;sequence>
 *         &lt;element name="keywords" type="{http://ss.yahooapis.jp/V5}ProposalKeyword" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExcludedKeywordSearchParameter", propOrder = {
    "keywords"
})
public class ExcludedKeywordSearchParameter
    extends SearchParameter
{

    @XmlElement(required = true)
    protected List<ProposalKeyword> keywords;

    /**
     * Gets the value of the keywords property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the keywords property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKeywords().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProposalKeyword }
     * 
     * 
     */
    public List<ProposalKeyword> getKeywords() {
        if (keywords == null) {
            keywords = new ArrayList<ProposalKeyword>();
        }
        return this.keywords;
    }

}


package jp.yahooapis.ss.v201901.targetingidea;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SearchParameter complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SearchParameter">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="searchParameterUse" type="{http://ss.yahooapis.jp/V201901/TargetingIdea}SearchParameterUse"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SearchParameter", propOrder = {
    "searchParameterUse"
})
@XmlSeeAlso({
    RelatedToUrlSearchParameter.class,
    RelatedToKeywordSearchParameter.class
})
public abstract class SearchParameter {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected SearchParameterUse searchParameterUse;

    /**
     * Gets the value of the searchParameterUse property.
     * 
     * @return
     *     possible object is
     *     {@link SearchParameterUse }
     *     
     */
    public SearchParameterUse getSearchParameterUse() {
        return searchParameterUse;
    }

    /**
     * Sets the value of the searchParameterUse property.
     * 
     * @param value
     *     allowed object is
     *     {@link SearchParameterUse }
     *     
     */
    public void setSearchParameterUse(SearchParameterUse value) {
        this.searchParameterUse = value;
    }

}

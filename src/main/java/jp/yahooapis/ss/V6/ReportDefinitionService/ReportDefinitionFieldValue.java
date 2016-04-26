
package jp.yahooapis.ss.V6.ReportDefinitionService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReportDefinitionFieldValue complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReportDefinitionFieldValue">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V6}ReturnValue">
 *       &lt;sequence>
 *         &lt;element name="fields" type="{http://ss.yahooapis.jp/V6}ReportFieldAttribute" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReportDefinitionFieldValue", propOrder = {
    "fields"
})
public class ReportDefinitionFieldValue
    extends ReturnValue
{

    protected List<ReportFieldAttribute> fields;

    /**
     * Gets the value of the fields property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fields property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFields().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReportFieldAttribute }
     * 
     * 
     */
    public List<ReportFieldAttribute> getFields() {
        if (fields == null) {
            fields = new ArrayList<ReportFieldAttribute>();
        }
        return this.fields;
    }

}

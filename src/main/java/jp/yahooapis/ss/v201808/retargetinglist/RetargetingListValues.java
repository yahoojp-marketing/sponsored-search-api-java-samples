
package jp.yahooapis.ss.v201808.retargetinglist;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import jp.yahooapis.ss.v201808.ReturnValue;


/**
 * <p>Java class for RetargetingListValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RetargetingListValues">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V201808}ReturnValue">
 *       &lt;sequence>
 *         &lt;element name="targetList" type="{http://ss.yahooapis.jp/V201808/RetargetingList}TargetingList" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RetargetingListValues", propOrder = {
    "targetList"
})
public class RetargetingListValues
    extends ReturnValue
{

    protected TargetingList targetList;

    /**
     * Gets the value of the targetList property.
     * 
     * @return
     *     possible object is
     *     {@link TargetingList }
     *     
     */
    public TargetingList getTargetList() {
        return targetList;
    }

    /**
     * Sets the value of the targetList property.
     * 
     * @param value
     *     allowed object is
     *     {@link TargetingList }
     *     
     */
    public void setTargetList(TargetingList value) {
        this.targetList = value;
    }

}

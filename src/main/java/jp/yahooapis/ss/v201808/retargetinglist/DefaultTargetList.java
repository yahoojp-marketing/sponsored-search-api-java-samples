
package jp.yahooapis.ss.v201808.retargetinglist;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DefaultTargetList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DefaultTargetList">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V201808/RetargetingList}TargetingList">
 *       &lt;sequence>
 *         &lt;element name="tag" type="{http://ss.yahooapis.jp/V201808/RetargetingList}Tag" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DefaultTargetList", propOrder = {
    "tag"
})
public class DefaultTargetList
    extends TargetingList
{

    protected Tag tag;

    /**
     * Gets the value of the tag property.
     * 
     * @return
     *     possible object is
     *     {@link Tag }
     *     
     */
    public Tag getTag() {
        return tag;
    }

    /**
     * Sets the value of the tag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Tag }
     *     
     */
    public void setTag(Tag value) {
        this.tag = value;
    }

}

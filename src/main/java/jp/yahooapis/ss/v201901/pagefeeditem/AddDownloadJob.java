
package jp.yahooapis.ss.v201901.pagefeeditem;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="operations" type="{http://ss.yahooapis.jp/V201901/PageFeedItem}PageFeedItemDownloadJobOperation"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "operations"
})
@XmlRootElement(name = "addDownloadJob")
public class AddDownloadJob {

    @XmlElement(required = true)
    protected PageFeedItemDownloadJobOperation operations;

    /**
     * Gets the value of the operations property.
     * 
     * @return
     *     possible object is
     *     {@link PageFeedItemDownloadJobOperation }
     *     
     */
    public PageFeedItemDownloadJobOperation getOperations() {
        return operations;
    }

    /**
     * Sets the value of the operations property.
     * 
     * @param value
     *     allowed object is
     *     {@link PageFeedItemDownloadJobOperation }
     *     
     */
    public void setOperations(PageFeedItemDownloadJobOperation value) {
        this.operations = value;
    }

}

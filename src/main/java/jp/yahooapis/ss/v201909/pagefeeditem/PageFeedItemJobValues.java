
package jp.yahooapis.ss.v201909.pagefeeditem;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import jp.yahooapis.ss.v201909.ReturnValue;


/**
 * <p>Java class for PageFeedItemJobValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PageFeedItemJobValues">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V201909}ReturnValue">
 *       &lt;sequence>
 *         &lt;element name="job" type="{http://ss.yahooapis.jp/V201909/PageFeedItem}PageFeedItemJob" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PageFeedItemJobValues", propOrder = {
    "job"
})
public class PageFeedItemJobValues
    extends ReturnValue
{

    protected PageFeedItemJob job;

    /**
     * Gets the value of the job property.
     * 
     * @return
     *     possible object is
     *     {@link PageFeedItemJob }
     *     
     */
    public PageFeedItemJob getJob() {
        return job;
    }

    /**
     * Sets the value of the job property.
     * 
     * @param value
     *     allowed object is
     *     {@link PageFeedItemJob }
     *     
     */
    public void setJob(PageFeedItemJob value) {
        this.job = value;
    }

}

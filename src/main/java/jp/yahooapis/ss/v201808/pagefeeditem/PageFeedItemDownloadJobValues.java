
package jp.yahooapis.ss.v201808.pagefeeditem;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import jp.yahooapis.ss.v201808.ReturnValue;


/**
 * <p>Java class for PageFeedItemDownloadJobValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PageFeedItemDownloadJobValues">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V201808}ReturnValue">
 *       &lt;sequence>
 *         &lt;element name="job" type="{http://ss.yahooapis.jp/V201808/PageFeedItem}PageFeedItemDownloadJob" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PageFeedItemDownloadJobValues", propOrder = {
    "job"
})
public class PageFeedItemDownloadJobValues
    extends ReturnValue
{

    protected PageFeedItemDownloadJob job;

    /**
     * Gets the value of the job property.
     * 
     * @return
     *     possible object is
     *     {@link PageFeedItemDownloadJob }
     *     
     */
    public PageFeedItemDownloadJob getJob() {
        return job;
    }

    /**
     * Sets the value of the job property.
     * 
     * @param value
     *     allowed object is
     *     {@link PageFeedItemDownloadJob }
     *     
     */
    public void setJob(PageFeedItemDownloadJob value) {
        this.job = value;
    }

}

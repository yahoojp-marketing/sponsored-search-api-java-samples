
package jp.yahooapis.ss.v201901.pagefeeditem;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import jp.yahooapis.ss.v201901.ReturnValue;


/**
 * <p>Java class for PageFeedItemReviewSummaryValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PageFeedItemReviewSummaryValues">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V201901}ReturnValue">
 *       &lt;sequence>
 *         &lt;element name="reviewSummary" type="{http://ss.yahooapis.jp/V201901/PageFeedItem}PageFeedItemReviewSummary" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PageFeedItemReviewSummaryValues", propOrder = {
    "reviewSummary"
})
public class PageFeedItemReviewSummaryValues
    extends ReturnValue
{

    protected PageFeedItemReviewSummary reviewSummary;

    /**
     * Gets the value of the reviewSummary property.
     * 
     * @return
     *     possible object is
     *     {@link PageFeedItemReviewSummary }
     *     
     */
    public PageFeedItemReviewSummary getReviewSummary() {
        return reviewSummary;
    }

    /**
     * Sets the value of the reviewSummary property.
     * 
     * @param value
     *     allowed object is
     *     {@link PageFeedItemReviewSummary }
     *     
     */
    public void setReviewSummary(PageFeedItemReviewSummary value) {
        this.reviewSummary = value;
    }

}


package jp.yahooapis.ss.v201808.pagefeeditem;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import jp.yahooapis.ss.v201808.ReturnValue;


/**
 * <p>Java class for PageFeedItemReturnValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PageFeedItemReturnValues">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V201808}ReturnValue">
 *       &lt;sequence>
 *         &lt;element name="pageFeedItem" type="{http://ss.yahooapis.jp/V201808/PageFeedItem}PageFeedItem" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PageFeedItemReturnValues", propOrder = {
    "pageFeedItem"
})
public class PageFeedItemReturnValues
    extends ReturnValue
{

    protected PageFeedItem pageFeedItem;

    /**
     * Gets the value of the pageFeedItem property.
     * 
     * @return
     *     possible object is
     *     {@link PageFeedItem }
     *     
     */
    public PageFeedItem getPageFeedItem() {
        return pageFeedItem;
    }

    /**
     * Sets the value of the pageFeedItem property.
     * 
     * @param value
     *     allowed object is
     *     {@link PageFeedItem }
     *     
     */
    public void setPageFeedItem(PageFeedItem value) {
        this.pageFeedItem = value;
    }

}

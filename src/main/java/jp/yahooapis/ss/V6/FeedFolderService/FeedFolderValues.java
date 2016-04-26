
package jp.yahooapis.ss.V6.FeedFolderService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FeedFolderValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FeedFolderValues">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V6}ReturnValue">
 *       &lt;sequence>
 *         &lt;element name="feedFolder" type="{http://ss.yahooapis.jp/V6}FeedFolder" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FeedFolderValues", propOrder = {
    "feedFolder"
})
public class FeedFolderValues
    extends ReturnValue
{

    protected FeedFolder feedFolder;

    /**
     * Gets the value of the feedFolder property.
     * 
     * @return
     *     possible object is
     *     {@link FeedFolder }
     *     
     */
    public FeedFolder getFeedFolder() {
        return feedFolder;
    }

    /**
     * Sets the value of the feedFolder property.
     * 
     * @param value
     *     allowed object is
     *     {@link FeedFolder }
     *     
     */
    public void setFeedFolder(FeedFolder value) {
        this.feedFolder = value;
    }

}

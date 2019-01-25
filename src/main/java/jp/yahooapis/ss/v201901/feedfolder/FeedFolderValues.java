
package jp.yahooapis.ss.v201901.feedfolder;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import jp.yahooapis.ss.v201901.ReturnValue;


/**
 * <p>Java class for FeedFolderValues complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FeedFolderValues">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ss.yahooapis.jp/V201901}ReturnValue">
 *       &lt;sequence>
 *         &lt;element name="feedFolder" type="{http://ss.yahooapis.jp/V201901/FeedFolder}FeedFolder" minOccurs="0"/>
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

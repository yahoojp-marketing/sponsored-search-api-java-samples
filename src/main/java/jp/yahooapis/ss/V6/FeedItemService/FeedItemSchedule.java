
package jp.yahooapis.ss.V6.FeedItemService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FeedItemSchedule complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FeedItemSchedule">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dayOfWeek" type="{http://ss.yahooapis.jp/V6}DayOfWeek" minOccurs="0"/>
 *         &lt;element name="startHour" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="startMinute" type="{http://ss.yahooapis.jp/V6}MinuteOfHour" minOccurs="0"/>
 *         &lt;element name="endHour" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="endMinute" type="{http://ss.yahooapis.jp/V6}MinuteOfHour" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FeedItemSchedule", propOrder = {
    "dayOfWeek",
    "startHour",
    "startMinute",
    "endHour",
    "endMinute"
})
public class FeedItemSchedule {

    @XmlSchemaType(name = "string")
    protected DayOfWeek dayOfWeek;
    protected Long startHour;
    @XmlSchemaType(name = "string")
    protected MinuteOfHour startMinute;
    protected Long endHour;
    @XmlSchemaType(name = "string")
    protected MinuteOfHour endMinute;

    /**
     * Gets the value of the dayOfWeek property.
     * 
     * @return
     *     possible object is
     *     {@link DayOfWeek }
     *     
     */
    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    /**
     * Sets the value of the dayOfWeek property.
     * 
     * @param value
     *     allowed object is
     *     {@link DayOfWeek }
     *     
     */
    public void setDayOfWeek(DayOfWeek value) {
        this.dayOfWeek = value;
    }

    /**
     * Gets the value of the startHour property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getStartHour() {
        return startHour;
    }

    /**
     * Sets the value of the startHour property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setStartHour(Long value) {
        this.startHour = value;
    }

    /**
     * Gets the value of the startMinute property.
     * 
     * @return
     *     possible object is
     *     {@link MinuteOfHour }
     *     
     */
    public MinuteOfHour getStartMinute() {
        return startMinute;
    }

    /**
     * Sets the value of the startMinute property.
     * 
     * @param value
     *     allowed object is
     *     {@link MinuteOfHour }
     *     
     */
    public void setStartMinute(MinuteOfHour value) {
        this.startMinute = value;
    }

    /**
     * Gets the value of the endHour property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getEndHour() {
        return endHour;
    }

    /**
     * Sets the value of the endHour property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setEndHour(Long value) {
        this.endHour = value;
    }

    /**
     * Gets the value of the endMinute property.
     * 
     * @return
     *     possible object is
     *     {@link MinuteOfHour }
     *     
     */
    public MinuteOfHour getEndMinute() {
        return endMinute;
    }

    /**
     * Sets the value of the endMinute property.
     * 
     * @param value
     *     allowed object is
     *     {@link MinuteOfHour }
     *     
     */
    public void setEndMinute(MinuteOfHour value) {
        this.endMinute = value;
    }

}

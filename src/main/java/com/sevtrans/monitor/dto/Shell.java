//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.01.16 at 11:04:23 PM MSK 
//


package com.sevtrans.monitor.dto;

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
 *         &lt;element name="msgType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="customer" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;choice>
 *           &lt;element name="product" type="{http://www.sevtrans.com}Product"/>
 *           &lt;element name="order" type="{http://www.sevtrans.com}Order"/>
 *           &lt;element name="deliveryOrder" type="{http://www.sevtrans.com}DeliveryOrder"/>
 *         &lt;/choice>
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
    "msgType",
    "customer",
    "product",
    "order",
    "deliveryOrder"
})
@XmlRootElement(name = "Shell")
public class Shell {

    @XmlElement(required = true)
    protected String msgType;
    protected int customer;
    protected Product product;
    protected Order order;
    protected DeliveryOrder deliveryOrder;

    /**
     * Gets the value of the msgType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsgType() {
        return msgType;
    }

    /**
     * Sets the value of the msgType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMsgType(String value) {
        this.msgType = value;
    }

    /**
     * Gets the value of the customer property.
     * 
     */
    public int getCustomer() {
        return customer;
    }

    /**
     * Sets the value of the customer property.
     * 
     */
    public void setCustomer(int value) {
        this.customer = value;
    }

    /**
     * Gets the value of the product property.
     * 
     * @return
     *     possible object is
     *     {@link Product }
     *     
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Sets the value of the product property.
     * 
     * @param value
     *     allowed object is
     *     {@link Product }
     *     
     */
    public void setProduct(Product value) {
        this.product = value;
    }

    /**
     * Gets the value of the order property.
     * 
     * @return
     *     possible object is
     *     {@link Order }
     *     
     */
    public Order getOrder() {
        return order;
    }

    /**
     * Sets the value of the order property.
     * 
     * @param value
     *     allowed object is
     *     {@link Order }
     *     
     */
    public void setOrder(Order value) {
        this.order = value;
    }

    /**
     * Gets the value of the deliveryOrder property.
     * 
     * @return
     *     possible object is
     *     {@link DeliveryOrder }
     *     
     */
    public DeliveryOrder getDeliveryOrder() {
        return deliveryOrder;
    }

    /**
     * Sets the value of the deliveryOrder property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeliveryOrder }
     *     
     */
    public void setDeliveryOrder(DeliveryOrder value) {
        this.deliveryOrder = value;
    }

}

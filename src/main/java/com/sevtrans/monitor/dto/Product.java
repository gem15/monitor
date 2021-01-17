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
import javax.xml.bind.annotation.XmlType;


/**
 * Справочник товаров
 * 
 * <p>Java class for Product complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Product">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="article" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="upc" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="uofm" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="storageLife" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="storageCondition" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="productType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Product", propOrder = {
    "article",
    "name",
    "upc",
    "uofm",
    "storageLife",
    "storageCondition",
    "productType"
})
public class Product {

    @XmlElement(required = true)
    protected String article;
    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String upc;
    @XmlElement(required = true)
    protected String uofm;
    protected int storageLife;
    @XmlElement(required = true)
    protected String storageCondition;
    @XmlElement(required = true)
    protected String productType;

    /**
     * Gets the value of the article property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArticle() {
        return article;
    }

    /**
     * Sets the value of the article property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArticle(String value) {
        this.article = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the upc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUpc() {
        return upc;
    }

    /**
     * Sets the value of the upc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUpc(String value) {
        this.upc = value;
    }

    /**
     * Gets the value of the uofm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUofm() {
        return uofm;
    }

    /**
     * Sets the value of the uofm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUofm(String value) {
        this.uofm = value;
    }

    /**
     * Gets the value of the storageLife property.
     * 
     */
    public int getStorageLife() {
        return storageLife;
    }

    /**
     * Sets the value of the storageLife property.
     * 
     */
    public void setStorageLife(int value) {
        this.storageLife = value;
    }

    /**
     * Gets the value of the storageCondition property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStorageCondition() {
        return storageCondition;
    }

    /**
     * Sets the value of the storageCondition property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStorageCondition(String value) {
        this.storageCondition = value;
    }

    /**
     * Gets the value of the productType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductType() {
        return productType;
    }

    /**
     * Sets the value of the productType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductType(String value) {
        this.productType = value;
    }

}

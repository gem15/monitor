/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Gennady
 * License Type: Purchased
 */
package com.sevtrans.monitor.model;

import java.io.Serializable;
import javax.persistence.*;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="_Order_Detail")
@SuppressWarnings({ "all", "unchecked" })
public class _OrderDetail implements Serializable {
	public _OrderDetail() {
	}
	
	@Column(name="Id", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="COM_SEVTRANS_MONITOR_MODEL__ORDERDETAIL_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="COM_SEVTRANS_MONITOR_MODEL__ORDERDETAIL_ID_GENERATOR", strategy="native")	
	private int id;
	
	@ManyToOne(targetEntity=com.sevtrans.monitor.model._Order.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="OrderId", referencedColumnName="Id", nullable=false) }, foreignKey=@ForeignKey(name="FK_Order_Det553326"))	
	private com.sevtrans.monitor.model._Order _Order;
	
	@Column(name="Line_No", nullable=false, length=10)	
	private int lineNo;
	
	@Column(name="Article", nullable=false, length=255)	
	private String article;
	
	@Column(name="Qty", nullable=false)	
	private double qty;
	
	@Column(name="Um", nullable=true, length=255)	
	private String um;
	
	@Column(name="Mark2", nullable=true, length=255)	
	private String mark2;
	
	public void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setLineNo(int value) {
		this.lineNo = value;
	}
	
	public int getLineNo() {
		return lineNo;
	}
	
	public void setArticle(String value) {
		this.article = value;
	}
	
	public String getArticle() {
		return article;
	}
	
	public void setQty(double value) {
		this.qty = value;
	}
	
	public double getQty() {
		return qty;
	}
	
	public void setUm(String value) {
		this.um = value;
	}
	
	public String getUm() {
		return um;
	}
	
	public void setMark2(String value) {
		this.mark2 = value;
	}
	
	public String getMark2() {
		return mark2;
	}
	
	public void set_Order(com.sevtrans.monitor.model._Order value) {
		this._Order = value;
	}
	
	public com.sevtrans.monitor.model._Order get_Order() {
		return _Order;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}

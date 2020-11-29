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
@Table(name="Orders")
@SuppressWarnings({ "all", "unchecked" })
public class Orders implements Serializable {
	public Orders() {
	}
	
	@Column(name="Id", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="COM_SEVTRANS_MONITOR_MODEL_ORDERS_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="COM_SEVTRANS_MONITOR_MODEL_ORDERS_ID_GENERATOR", strategy="native")	
	private int id;
	
	@Column(name="Comment", nullable=false, length=255)	
	private String comment;
	
	@OneToMany(mappedBy="orders", targetEntity=com.sevtrans.monitor.model.OrderDetail.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set orderDetail = new java.util.HashSet();
	
	public void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setComment(String value) {
		this.comment = value;
	}
	
	public String getComment() {
		return comment;
	}
	
	public void setOrderDetail(java.util.Set value) {
		this.orderDetail = value;
	}
	
	public java.util.Set getOrderDetail() {
		return orderDetail;
	}
	
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}

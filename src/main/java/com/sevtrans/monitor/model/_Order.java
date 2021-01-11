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
@Table(name="_Orders")
@SuppressWarnings({ "all", "unchecked" })
public class _Order implements Serializable {
	public _Order() {
	}
	
	@Column(name="Id", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="COM_SEVTRANS_MONITOR_MODEL__ORDER_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="COM_SEVTRANS_MONITOR_MODEL__ORDER_ID_GENERATOR", strategy="native")	
	private int id;
	
	@Column(name="Order_No", nullable=true, length=255)	
	private String orderNo;
	
	@Column(name="Order_Date", nullable=true)	
	@Temporal(TemporalType.DATE)	
	private java.util.Date orderDate;
	
	@Column(name="Manager", nullable=true, length=255)	
	private String manager;
	
	@Column(name="Customer", nullable=true, length=255)	
	private String customer;
	
	@Column(name="Order_Type", nullable=true, length=255)	
	private String orderType;
	
	@Column(name="Type_Of_Delivery", nullable=true, length=255)	
	private String TypeOfDelivery;
	
	@Column(name="Planned_Date", nullable=true)	
	@Temporal(TemporalType.DATE)	
	private java.util.Date plannedDate;
	
	@Column(name="Contractor", nullable=false, length=255)	
	private String contractor;
	
	@Column(name="Vn", nullable=false, length=10)	
	private int vn;
	
	@Column(name="License_Plate", nullable=true, length=255)	
	private String licensePlate;
	
	@Column(name="Driver", nullable=true, length=255)	
	private String driver;
	
	@OneToMany(mappedBy="_Order", targetEntity=com.sevtrans.monitor.model._OrderDetail.class)	
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
	
	public void setOrderNo(String value) {
		this.orderNo = value;
	}
	
	public String getOrderNo() {
		return orderNo;
	}
	
	public void setOrderDate(java.util.Date value) {
		this.orderDate = value;
	}
	
	public java.util.Date getOrderDate() {
		return orderDate;
	}
	
	public void setManager(String value) {
		this.manager = value;
	}
	
	public String getManager() {
		return manager;
	}
	
	public void setCustomer(String value) {
		this.customer = value;
	}
	
	public String getCustomer() {
		return customer;
	}
	
	public void setOrderType(String value) {
		this.orderType = value;
	}
	
	public String getOrderType() {
		return orderType;
	}
	
	public void setTypeOfDelivery(String value) {
		this.TypeOfDelivery = value;
	}
	
	public String getTypeOfDelivery() {
		return TypeOfDelivery;
	}
	
	public void setPlannedDate(java.util.Date value) {
		this.plannedDate = value;
	}
	
	public java.util.Date getPlannedDate() {
		return plannedDate;
	}
	
	public void setContractor(String value) {
		this.contractor = value;
	}
	
	public String getContractor() {
		return contractor;
	}
	
	public void setVn(int value) {
		this.vn = value;
	}
	
	public int getVn() {
		return vn;
	}
	
	public void setLicensePlate(String value) {
		this.licensePlate = value;
	}
	
	public String getLicensePlate() {
		return licensePlate;
	}
	
	public void setDriver(String value) {
		this.driver = value;
	}
	
	public String getDriver() {
		return driver;
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

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

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import java.io.Serializable;
import javax.persistence.*;
/**
 * Иерархический Словарь (все словари системы ИПТК в одной таблице)
 */
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="sv_hvoc", schema="public")
@SuppressWarnings({ "all", "unchecked" })
public class Shvoc implements Serializable {
	public Shvoc() {
	}
	
	@Column(name="val_id", nullable=false,length = 38)
/*
	@Id
	@GeneratedValue(generator="COM_SEVTRANS_MONITOR_MODEL_SHVOC_VAL_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="COM_SEVTRANS_MONITOR_MODEL_SHVOC_VAL_ID_GENERATOR",
			strategy="sequence", parameters={ @org.hibernate.annotations.Parameter(name="sequence", value="seqq") })
*/
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqq")
	@GenericGenerator(
			name = "seqq",
			strategy = "com.sevtrans.monitor.model.StringPrefixedSequenceIdGenerator",
			parameters = {
					@Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "50"),
					@Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "0102"),
					@Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%d") })//"%010d"
	private String Val_id;
	
	@Column(name="hvoc_val_id", nullable=true, length=38)	
	private String Hvoc_val_id;
	
	@Column(name="voc_id", nullable=true, length=6)	
	private String Voc_id;
	
	@Column(name="val_full", nullable=true, length=1000)	
	private String Val_full;
	
	@Column(name="val_short", nullable=true, length=30)	
	private String Val_short;
	
	@Column(name="val_state", nullable=true, length=20)	
	private String Val_state;
	
	@Column(name="val_changes", nullable=true, length=20)	
	private String Val_changes;
	
	@Column(name="tools", nullable=true, length=4000)	
	private String Tools;
	
	@Column(name="data_begin", nullable=true)
	private java.sql.Timestamp Data_begin;
	
	@Column(name="data_end", nullable=true)	
	private java.sql.Timestamp Data_end;
	
	@Column(name="master_val_id", nullable=true, length=38)	
	private String Master_val_id;
	
	@Column(name="police_code", nullable=true, length=38)	
	private String Police_code;
	
	/**
	 * Уникальный № записи
	 */
	public void setVal_id(String value) {
		this.Val_id = value;
	}
	
	/**
	 * Уникальный № записи
	 */
	public String getVal_id() {
		return Val_id;
	}
	
	public String getORMID() {
		return getVal_id();
	}
	
	/**
	 * Ссылка на VAL_ID родительской записи в таблице Словарей
	 */
	public void setHvoc_val_id(String value) {
		this.Hvoc_val_id = value;
	}
	
	/**
	 * Ссылка на VAL_ID родительской записи в таблице Словарей
	 */
	public String getHvoc_val_id() {
		return Hvoc_val_id;
	}
	
	/**
	 * Код Словаря ( 6 символов )
	 */
	public void setVoc_id(String value) {
		this.Voc_id = value;
	}
	
	/**
	 * Код Словаря ( 6 символов )
	 */
	public String getVoc_id() {
		return Voc_id;
	}
	
	/**
	 * Полное словарное значение
	 */
	public void setVal_full(String value) {
		this.Val_full = value;
	}
	
	/**
	 * Полное словарное значение
	 */
	public String getVal_full() {
		return Val_full;
	}
	
	/**
	 * Краткое словарное значение
	 */
	public void setVal_short(String value) {
		this.Val_short = value;
	}
	
	/**
	 * Краткое словарное значение
	 */
	public String getVal_short() {
		return Val_short;
	}
	
	/**
	 * 'Deleted', 'Active', 'Old'
	 */
	public void setVal_state(String value) {
		this.Val_state = value;
	}
	
	/**
	 * 'Deleted', 'Active', 'Old'
	 */
	public String getVal_state() {
		return Val_state;
	}
	
	/**
	 * 'Allowed', 'Forbidden'
	 */
	public void setVal_changes(String value) {
		this.Val_changes = value;
	}
	
	/**
	 * 'Allowed', 'Forbidden'
	 */
	public String getVal_changes() {
		return Val_changes;
	}
	
	public void setTools(String value) {
		this.Tools = value;
	}
	
	public String getTools() {
		return Tools;
	}
	
	public void setData_begin(java.sql.Timestamp value) {
		this.Data_begin = value;
	}
	
	public java.sql.Timestamp getData_begin() {
		return Data_begin;
	}
	
	public void setData_end(java.sql.Timestamp value) {
		this.Data_end = value;
	}
	
	public java.sql.Timestamp getData_end() {
		return Data_end;
	}
	
	public void setMaster_val_id(String value) {
		this.Master_val_id = value;
	}
	
	public String getMaster_val_id() {
		return Master_val_id;
	}
	
	public void setPolice_code(String value) {
		this.Police_code = value;
	}
	
	public String getPolice_code() {
		return Police_code;
	}
	
	public String toString() {
		return String.valueOf(getVal_id());
	}
	
}

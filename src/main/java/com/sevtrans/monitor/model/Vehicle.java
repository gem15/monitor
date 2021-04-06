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
@Table(name="kb_tir", schema="public", indexes={ @Index(columnList="id") })
@SuppressWarnings({ "all", "unchecked" })
public class Vehicle implements Serializable {
	public Vehicle() {
	}
	
	@Column(name="id", nullable=false, length=38)	
	@Id	
	@GeneratedValue(generator="COM_SEVTRANS_MONITOR_MODEL_VEHICLE_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="COM_SEVTRANS_MONITOR_MODEL_VEHICLE_ID_GENERATOR", strategy="sequence", parameters={ @org.hibernate.annotations.Parameter(name="sequence", value="seqq") })	
	private String Id;
	
	@Column(name="fk_id", nullable=true, length=38)	
	private String Fk_id;
	
	@ManyToOne(targetEntity= Shvoc.class, fetch=FetchType.LAZY)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="id_iper", referencedColumnName="val_id", nullable=false) }, foreignKey=@ForeignKey(name="transportationType"))	
	private Shvoc transportationType;
	
	@Column(name="id_per", nullable=true, length=38)	
	private String Id_per;
	
	@Column(name="id_dog", nullable=true, length=38)	
	private String Id_dog;
	
	@ManyToOne(targetEntity= Shvoc.class, fetch=FetchType.LAZY)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="id_trans", referencedColumnName="val_id", nullable=false) }, foreignKey=@ForeignKey(name="transportType"))	
	private Shvoc transportType;
	
	@Column(name="id_tip_tr", nullable=true, length=38)	
	private String Id_tip_tr;
	
	@Column(name="ob_tr", nullable=true, length=38)	
	private String Ob_tr;
	
	@Column(name="st_fraht", nullable=true, length=22)	
	private String St_fraht;
	
	@Column(name="n_avto", nullable=true, length=40)	
	private String N_avto;
	
	@Column(name="n_pric", nullable=true, length=40)	
	private String N_pric;
	
	@Column(name="vodit", nullable=true, length=100)	
	private String Vodit;
	
	@Column(name="n_tir", nullable=true, length=100)	
	private String N_tir;
	
	@Column(name="ves_tir", nullable=true, precision=7, scale=0)	
	private java.math.BigDecimal Ves_tir;
	
	@Column(name="ves_am", nullable=true, precision=7, scale=0)	
	private java.math.BigDecimal Ves_am;
	
	@Column(name="cm_n", nullable=true, length=10)	
	private String Cm_n;
	
	@Column(name="ora_user_edit_row_name", nullable=true, length=30)	
	private String Ora_user_edit_row_name;
	
	@Column(name="ora_user_edit_row_date", nullable=true)	
	private java.sql.Timestamp Ora_user_edit_row_date;
	
	@Column(name="ora_user_edit_row_lock", nullable=false, precision=131089, scale=0)	
	private java.math.BigDecimal Ora_user_edit_row_lock;
	
	@Column(name="ves_pric", nullable=true, precision=7, scale=0)	
	private java.math.BigDecimal Ves_pric;
	
	@Column(name="ves_br_cmr", nullable=true, precision=7, scale=0)	
	private java.math.BigDecimal Ves_br_cmr;
	
	@Column(name="ves_nt_cmr", nullable=true, precision=7, scale=0)	
	private java.math.BigDecimal Ves_nt_cmr;
	
	@Column(name="usl", nullable=true, length=2000)	
	private String Usl;
	
	@Column(name="n_poruch", nullable=true, length=20)	
	private String N_poruch;
	
	@Column(name="dt_poruch", nullable=true)	
	private java.sql.Timestamp Dt_poruch;
	
	@Column(name="marka_ts", nullable=true, length=15)	
	private String Marka_ts;
	
	@Column(name="n_poruch_z", nullable=true, length=20)	
	private String N_poruch_z;
	
	@Column(name="dt_poruch_z", nullable=true)	
	private java.sql.Timestamp Dt_poruch_z;
	
	@Column(name="row_creator", nullable=true, length=30)	
	private String Row_creator;
	
	@Column(name="row_creation_time", nullable=true)	
	private java.sql.Timestamp Row_creation_time;
	
	@Column(name="n_cont", nullable=true, length=150)	
	private String N_cont;
	
	@Column(name="n_gtd", nullable=true, length=100)	
	private String N_gtd;
	
	@Column(name="n_skl", nullable=true, length=50)	
	private String N_skl;
	
	@Column(name="mest", nullable=true, length=10)	
	private String Mest;
	
	@Column(name="n_pack", nullable=true, length=15)	
	private String N_pack;
	
	@Column(name="id_klient", nullable=true, precision=6, scale=0)	
	private java.math.BigDecimal Id_klient;
	
	@Column(name="id_svh", nullable=true, length=38)	
	private String Id_svh;
	
	@Column(name="id_osm", nullable=true, length=38)	
	private String Id_osm;
	
	@Column(name="id_exp", nullable=true, length=38)	
	private String Id_exp;
	
	@Column(name="id_exp_knt", nullable=true, length=38)	
	private String Id_exp_knt;
	
	@Column(name="id_yam", nullable=true, length=38)	
	private String Id_yam;
	
	@Column(name="id_adr", nullable=true, length=38)	
	private String Id_adr;
	
	@Column(name="dt_dost", nullable=true)	
	private java.sql.Timestamp Dt_dost;
	
	@Column(name="is_cycle", nullable=true, length=38)	
	private String Is_cycle;
	
	@Column(name="tel_am", nullable=true, length=40)	
	private String Tel_am;
	
	@Column(name="ves_ts", nullable=true, precision=10, scale=2)	
	private java.math.BigDecimal Ves_ts;
	
	public void setId(String value) {
		this.Id = value;
	}
	
	public String getId() {
		return Id;
	}
	
	public String getORMID() {
		return getId();
	}
	
	public void setN_tir(String value) {
		this.N_tir = value;
	}
	
	public String getN_tir() {
		return N_tir;
	}
	
	public void setId_per(String value) {
		this.Id_per = value;
	}
	
	public String getId_per() {
		return Id_per;
	}
	
	public void setN_avto(String value) {
		this.N_avto = value;
	}
	
	public String getN_avto() {
		return N_avto;
	}
	
	public void setVodit(String value) {
		this.Vodit = value;
	}
	
	public String getVodit() {
		return Vodit;
	}
	
	public void setId_svh(String value) {
		this.Id_svh = value;
	}
	
	public String getId_svh() {
		return Id_svh;
	}
	
	public void setFk_id(String value) {
		this.Fk_id = value;
	}
	
	public String getFk_id() {
		return Fk_id;
	}
	
	public void setId_dog(String value) {
		this.Id_dog = value;
	}
	
	public String getId_dog() {
		return Id_dog;
	}
	
	public void setId_tip_tr(String value) {
		this.Id_tip_tr = value;
	}
	
	public String getId_tip_tr() {
		return Id_tip_tr;
	}
	
	public void setOb_tr(String value) {
		this.Ob_tr = value;
	}
	
	public String getOb_tr() {
		return Ob_tr;
	}
	
	public void setSt_fraht(String value) {
		this.St_fraht = value;
	}
	
	public String getSt_fraht() {
		return St_fraht;
	}
	
	public void setN_pric(String value) {
		this.N_pric = value;
	}
	
	public String getN_pric() {
		return N_pric;
	}
	
	public void setVes_tir(java.math.BigDecimal value) {
		this.Ves_tir = value;
	}
	
	public java.math.BigDecimal getVes_tir() {
		return Ves_tir;
	}
	
	public void setVes_am(java.math.BigDecimal value) {
		this.Ves_am = value;
	}
	
	public java.math.BigDecimal getVes_am() {
		return Ves_am;
	}
	
	public void setCm_n(String value) {
		this.Cm_n = value;
	}
	
	public String getCm_n() {
		return Cm_n;
	}
	
	public void setOra_user_edit_row_name(String value) {
		this.Ora_user_edit_row_name = value;
	}
	
	public String getOra_user_edit_row_name() {
		return Ora_user_edit_row_name;
	}
	
	public void setOra_user_edit_row_date(java.sql.Timestamp value) {
		this.Ora_user_edit_row_date = value;
	}
	
	public java.sql.Timestamp getOra_user_edit_row_date() {
		return Ora_user_edit_row_date;
	}
	
	public void setOra_user_edit_row_lock(java.math.BigDecimal value) {
		this.Ora_user_edit_row_lock = value;
	}
	
	public java.math.BigDecimal getOra_user_edit_row_lock() {
		return Ora_user_edit_row_lock;
	}
	
	public void setVes_pric(java.math.BigDecimal value) {
		this.Ves_pric = value;
	}
	
	public java.math.BigDecimal getVes_pric() {
		return Ves_pric;
	}
	
	public void setVes_br_cmr(java.math.BigDecimal value) {
		this.Ves_br_cmr = value;
	}
	
	public java.math.BigDecimal getVes_br_cmr() {
		return Ves_br_cmr;
	}
	
	public void setVes_nt_cmr(java.math.BigDecimal value) {
		this.Ves_nt_cmr = value;
	}
	
	public java.math.BigDecimal getVes_nt_cmr() {
		return Ves_nt_cmr;
	}
	
	public void setUsl(String value) {
		this.Usl = value;
	}
	
	public String getUsl() {
		return Usl;
	}
	
	public void setN_poruch(String value) {
		this.N_poruch = value;
	}
	
	public String getN_poruch() {
		return N_poruch;
	}
	
	public void setDt_poruch(java.sql.Timestamp value) {
		this.Dt_poruch = value;
	}
	
	public java.sql.Timestamp getDt_poruch() {
		return Dt_poruch;
	}
	
	public void setMarka_ts(String value) {
		this.Marka_ts = value;
	}
	
	public String getMarka_ts() {
		return Marka_ts;
	}
	
	public void setN_poruch_z(String value) {
		this.N_poruch_z = value;
	}
	
	public String getN_poruch_z() {
		return N_poruch_z;
	}
	
	public void setDt_poruch_z(java.sql.Timestamp value) {
		this.Dt_poruch_z = value;
	}
	
	public java.sql.Timestamp getDt_poruch_z() {
		return Dt_poruch_z;
	}
	
	public void setRow_creator(String value) {
		this.Row_creator = value;
	}
	
	public String getRow_creator() {
		return Row_creator;
	}
	
	public void setRow_creation_time(java.sql.Timestamp value) {
		this.Row_creation_time = value;
	}
	
	public java.sql.Timestamp getRow_creation_time() {
		return Row_creation_time;
	}
	
	public void setN_cont(String value) {
		this.N_cont = value;
	}
	
	public String getN_cont() {
		return N_cont;
	}
	
	public void setN_gtd(String value) {
		this.N_gtd = value;
	}
	
	public String getN_gtd() {
		return N_gtd;
	}
	
	public void setN_skl(String value) {
		this.N_skl = value;
	}
	
	public String getN_skl() {
		return N_skl;
	}
	
	public void setMest(String value) {
		this.Mest = value;
	}
	
	public String getMest() {
		return Mest;
	}
	
	public void setN_pack(String value) {
		this.N_pack = value;
	}
	
	public String getN_pack() {
		return N_pack;
	}
	
	public void setId_klient(java.math.BigDecimal value) {
		this.Id_klient = value;
	}
	
	public java.math.BigDecimal getId_klient() {
		return Id_klient;
	}
	
	public void setId_osm(String value) {
		this.Id_osm = value;
	}
	
	public String getId_osm() {
		return Id_osm;
	}
	
	public void setId_exp(String value) {
		this.Id_exp = value;
	}
	
	public String getId_exp() {
		return Id_exp;
	}
	
	public void setId_exp_knt(String value) {
		this.Id_exp_knt = value;
	}
	
	public String getId_exp_knt() {
		return Id_exp_knt;
	}
	
	public void setId_yam(String value) {
		this.Id_yam = value;
	}
	
	public String getId_yam() {
		return Id_yam;
	}
	
	public void setId_adr(String value) {
		this.Id_adr = value;
	}
	
	public String getId_adr() {
		return Id_adr;
	}
	
	public void setDt_dost(java.sql.Timestamp value) {
		this.Dt_dost = value;
	}
	
	public java.sql.Timestamp getDt_dost() {
		return Dt_dost;
	}
	
	public void setIs_cycle(String value) {
		this.Is_cycle = value;
	}
	
	public String getIs_cycle() {
		return Is_cycle;
	}
	
	public void setTel_am(String value) {
		this.Tel_am = value;
	}
	
	public String getTel_am() {
		return Tel_am;
	}
	
	public void setVes_ts(java.math.BigDecimal value) {
		this.Ves_ts = value;
	}
	
	public java.math.BigDecimal getVes_ts() {
		return Ves_ts;
	}
	
	public void setTransportationType(Shvoc value) {
		this.transportationType = value;
	}
	
	public Shvoc getTransportationType() {
		return transportationType;
	}
	
	public void setTransportType(Shvoc value) {
		this.transportType = value;
	}
	
	public Shvoc getTransportType() {
		return transportType;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}

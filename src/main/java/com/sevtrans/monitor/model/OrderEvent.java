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

import java.io.Serializable;
import javax.persistence.*;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="kb_sost", schema="public", indexes={ @Index(columnList="id") })
@SuppressWarnings({ "all", "unchecked" })
public class OrderEvent implements Serializable {
	public OrderEvent() {
	}

	@Column(name="id", nullable=false, length=38)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqq")
	@GenericGenerator(name = "seqq", strategy = "com.sevtrans.monitor.model.StringPrefixedSequenceIdGenerator",	parameters = {@org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "50"),	@org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "0102"), @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%d") })
	private String Id;
	
	@Column(name="fk_id", nullable=true, length=38)	
	private String Fk_id;
	
	@ManyToOne(targetEntity= Order.class, fetch=FetchType.LAZY)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="id_obsl", referencedColumnName="id", nullable=false) }, foreignKey=@ForeignKey(name="FKkb_sost823000"))	
	private Order order;
	
	@Column(name="id_sost", nullable=true, length=38)	
	private String Id_sost;
	
	@Column(name="id_tir", nullable=true, length=38)	
	private String Id_tir;
	
	@Column(name="id_gtd", nullable=true, length=38)	
	private String Id_gtd;
	
	@Column(name="id_isp", nullable=true, length=38)	
	private String Id_isp;
	
	@Column(name="id_du", nullable=true, length=38)	
	private String Id_du;
	
	@Column(name="id_ttn", nullable=true, length=38)	
	private String Id_ttn;
	
	@Column(name="dt_sost", nullable=true)	
	private java.sql.Timestamp Dt_sost;
	
	@Column(name="dt_sost_end", nullable=true)	
	private java.sql.Timestamp Dt_sost_end;
	
	@Column(name="sost_doc", nullable=true, length=100)	
	private String Sost_doc;
	
	@Column(name="sost_prm", nullable=true, length=4000)	
	private String Sost_prm;
	
	@Column(name="cnt_usl", nullable=true, precision=16, scale=4)	
	private java.math.BigDecimal Cnt_usl;
	
	@Column(name="kpogr", nullable=true, precision=16, scale=6)	
	private java.math.BigDecimal Kpogr;
	
	@Column(name="ves_gruz", nullable=true, precision=10, scale=2)	
	private java.math.BigDecimal Ves_gruz;
	
	@Column(name="ora_user_edit_row_name", nullable=true, length=30)	
	private String Ora_user_edit_row_name;
	
	@Column(name="ora_user_edit_row_date", nullable=true)	
	private java.sql.Timestamp Ora_user_edit_row_date;
	
	@Column(name="ora_user_edit_row_lock", nullable=false, precision=131089, scale=0)	
	private java.math.BigDecimal Ora_user_edit_row_lock = java.math.BigDecimal.valueOf(0);
	
	@Column(name="vol_gruz", nullable=true, precision=10, scale=2)	
	private java.math.BigDecimal Vol_gruz;
	
	@Column(name="id_sch1", nullable=true, length=38)	
	private String Id_sch1;
	
	@Column(name="id_vol", nullable=true, length=38)	
	private String Id_vol;
	
	@Column(name="id_sch2", nullable=true, length=38)	
	private String Id_sch2;
	
	@Column(name="id_val", nullable=true, length=38)	
	private String Id_val;
	
	@Column(name="fakt_st", nullable=true, precision=20, scale=4)	
	private java.math.BigDecimal Fakt_st;
	
	@Column(name="kurs", nullable=true, precision=12, scale=4)	
	private java.math.BigDecimal Kurs;
	
	@Column(name="cnt_usl2", nullable=true, precision=16, scale=4)	
	private java.math.BigDecimal Cnt_usl2;
	
	@Column(name="kpogr2", nullable=true, precision=16, scale=6)	
	private java.math.BigDecimal Kpogr2;
	
	@Column(name="ves_gruz2", nullable=true, precision=10, scale=2)	
	private java.math.BigDecimal Ves_gruz2;
	
	@Column(name="vol_gruz2", nullable=true, precision=10, scale=2)	
	private java.math.BigDecimal Vol_gruz2;
	
	@Column(name="id_vol2", nullable=true, length=38)	
	private String Id_vol2;
	
	@Column(name="fakt_st2", nullable=true, precision=20, scale=4)	
	private java.math.BigDecimal Fakt_st2;
	
	@Column(name="kurs2", nullable=true, precision=12, scale=4)	
	private java.math.BigDecimal Kurs2;
	
	@Column(name="sum_all", nullable=true, precision=20, scale=4)	
	private java.math.BigDecimal Sum_all;
	
	@Column(name="sum_all2", nullable=true, precision=20, scale=4)	
	private java.math.BigDecimal Sum_all2;
	
	@Column(name="fakt_usd2", nullable=true, precision=20, scale=4)	
	private java.math.BigDecimal Fakt_usd2;
	
	@Column(name="fakt_usd", nullable=true, precision=20, scale=4)	
	private java.math.BigDecimal Fakt_usd;
	
	@Column(name="cnt_usl1", nullable=true, precision=16, scale=4)	
	private java.math.BigDecimal Cnt_usl1;
	
	@Column(name="kpogr1", nullable=true, precision=16, scale=6)	
	private java.math.BigDecimal Kpogr1;
	
	@Column(name="ves_gruz1", nullable=true, precision=10, scale=2)	
	private java.math.BigDecimal Ves_gruz1;
	
	@Column(name="vol_gruz1", nullable=true, precision=10, scale=2)	
	private java.math.BigDecimal Vol_gruz1;
	
	@Column(name="id_vol1", nullable=true, length=38)	
	private String Id_vol1;
	
	@Column(name="fakt_st1", nullable=true, precision=20, scale=4)	
	private java.math.BigDecimal Fakt_st1;
	
	@Column(name="p_marsh", nullable=true, length=100)	
	private String P_marsh;
	
	@Column(name="fl_marsh", nullable=true, length=150)	
	private String Fl_marsh;
	
	@Column(name="row_creator", nullable=true, length=30)	
	private String Row_creator;
	
	@Column(name="row_creation_time", nullable=true)	
	private java.sql.Timestamp Row_creation_time;
	
	@Column(name="kurs_usd", nullable=true, precision=12, scale=4)	
	private java.math.BigDecimal Kurs_usd;
	
	@Column(name="id_val2", nullable=true, length=38)	
	private String Id_val2;
	
	@Column(name="kurs_usd2", nullable=true, precision=12, scale=4)	
	private java.math.BigDecimal Kurs_usd2;
	
	@Column(name="id_fl", nullable=true, length=38)	
	private String Id_fl;
	
	@Column(name="mest", nullable=true, precision=6, scale=0)	
	private java.math.BigDecimal Mest;
	
	@Column(name="g32_old", nullable=true, precision=4, scale=0)	
	private java.math.BigDecimal G32_old;
	
	@Column(name="id_call", nullable=true, length=38)	
	private String Id_call;
	
	@Column(name="id_tk", nullable=true, length=38)	
	private String Id_tk;
	
	@Column(name="id_podr", nullable=true, length=38)	
	private String Id_podr;
	
	@Column(name="id_strn", nullable=true, length=38)	
	private String Id_strn;
	
	@Column(name="id_doc", nullable=true, length=38)	
	private String Id_doc;
	
	@Column(name="id_dog", nullable=true, length=38)	
	private String Id_dog;
	
	@Column(name="dt_doc", nullable=true)	
	private java.sql.Timestamp Dt_doc;
	
	@Column(name="id_svh", nullable=true, length=38)	
	private String Id_svh;
	
	@Column(name="id_tzs", nullable=true, length=38)	
	private String Id_tzs;
	
	@Column(name="id_stt", nullable=true, length=38)	
	private String Id_stt;
	
	@Column(name="ng_cox", nullable=true)	
	private Integer Ng_cox;
	
	@Column(name="ngv_cox", nullable=true, precision=2, scale=0)	
	private java.math.BigDecimal Ngv_cox;
	
	@Column(name="kngv_cox", nullable=true, precision=10, scale=4)	
	private java.math.BigDecimal Kngv_cox;
	
	@Column(name="id_dok", nullable=true, length=38)	
	private String Id_dok;
	
	@Column(name="id_upak", nullable=true, length=38)	
	private String Id_upak;
	
	@Column(name="marker2", nullable=true, length=255)	
	private String Marker2;
	
	@Column(name="marker3", nullable=true, length=1200)	
	private String Marker3;
	
	@Column(name="id_pack_def", nullable=true, length=38)	
	private String Id_pack_def;
	
	@Column(name="ei", nullable=true, length=38)	
	private String Ei;
	
	@Column(name="storage_cond_id", nullable=true, length=38)	
	private String Storage_cond_id;
	
	@Column(name="eo_ves_ot", nullable=true, length=38)	
	private String Eo_ves_ot;
	
	@Column(name="eo_ves_do", nullable=true, length=38)	
	private String Eo_ves_do;
	
	@Column(name="ves_fact", nullable=true, precision=1, scale=0)	
	private java.math.BigDecimal Ves_fact;
	
	@Column(name="alg", nullable=true, precision=1, scale=0)	
	private java.math.BigDecimal Alg;
	
	@Column(name="tip_coef", nullable=true, length=38)	
	private String Tip_coef;
	
	@Column(name="uei", nullable=true, length=38)	
	private String Uei;
	
	@Column(name="g32", nullable=true, length=32)	
	private String G32;
	
	@Column(name="cnt_uei", nullable=true, precision=16, scale=4)	
	private java.math.BigDecimal Cnt_uei;
	
	public void setId(String value) {
		this.Id = value;
	}
	
	public String getId() {
		return Id;
	}
	
	public String getORMID() {
		return getId();
	}
	
	public void setFk_id(String value) {
		this.Fk_id = value;
	}
	
	public String getFk_id() {
		return Fk_id;
	}
	
	public void setId_sost(String value) {
		this.Id_sost = value;
	}
	
	public String getId_sost() {
		return Id_sost;
	}
	
	public void setId_tir(String value) {
		this.Id_tir = value;
	}
	
	public String getId_tir() {
		return Id_tir;
	}
	
	public void setId_gtd(String value) {
		this.Id_gtd = value;
	}
	
	public String getId_gtd() {
		return Id_gtd;
	}
	
	public void setId_isp(String value) {
		this.Id_isp = value;
	}
	
	public String getId_isp() {
		return Id_isp;
	}
	
	public void setId_du(String value) {
		this.Id_du = value;
	}
	
	public String getId_du() {
		return Id_du;
	}
	
	public void setId_ttn(String value) {
		this.Id_ttn = value;
	}
	
	public String getId_ttn() {
		return Id_ttn;
	}
	
	public void setDt_sost(java.sql.Timestamp value) {
		this.Dt_sost = value;
	}
	
	public java.sql.Timestamp getDt_sost() {
		return Dt_sost;
	}
	
	public void setDt_sost_end(java.sql.Timestamp value) {
		this.Dt_sost_end = value;
	}
	
	public java.sql.Timestamp getDt_sost_end() {
		return Dt_sost_end;
	}
	
	public void setSost_doc(String value) {
		this.Sost_doc = value;
	}
	
	public String getSost_doc() {
		return Sost_doc;
	}
	
	public void setSost_prm(String value) {
		this.Sost_prm = value;
	}
	
	public String getSost_prm() {
		return Sost_prm;
	}
	
	public void setCnt_usl(java.math.BigDecimal value) {
		this.Cnt_usl = value;
	}
	
	public java.math.BigDecimal getCnt_usl() {
		return Cnt_usl;
	}
	
	public void setKpogr(java.math.BigDecimal value) {
		this.Kpogr = value;
	}
	
	public java.math.BigDecimal getKpogr() {
		return Kpogr;
	}
	
	public void setVes_gruz(java.math.BigDecimal value) {
		this.Ves_gruz = value;
	}
	
	public java.math.BigDecimal getVes_gruz() {
		return Ves_gruz;
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
	
	public void setVol_gruz(java.math.BigDecimal value) {
		this.Vol_gruz = value;
	}
	
	public java.math.BigDecimal getVol_gruz() {
		return Vol_gruz;
	}
	
	public void setId_sch1(String value) {
		this.Id_sch1 = value;
	}
	
	public String getId_sch1() {
		return Id_sch1;
	}
	
	public void setId_vol(String value) {
		this.Id_vol = value;
	}
	
	public String getId_vol() {
		return Id_vol;
	}
	
	public void setId_sch2(String value) {
		this.Id_sch2 = value;
	}
	
	public String getId_sch2() {
		return Id_sch2;
	}
	
	public void setId_val(String value) {
		this.Id_val = value;
	}
	
	public String getId_val() {
		return Id_val;
	}
	
	public void setFakt_st(java.math.BigDecimal value) {
		this.Fakt_st = value;
	}
	
	public java.math.BigDecimal getFakt_st() {
		return Fakt_st;
	}
	
	public void setKurs(java.math.BigDecimal value) {
		this.Kurs = value;
	}
	
	public java.math.BigDecimal getKurs() {
		return Kurs;
	}
	
	public void setCnt_usl2(java.math.BigDecimal value) {
		this.Cnt_usl2 = value;
	}
	
	public java.math.BigDecimal getCnt_usl2() {
		return Cnt_usl2;
	}
	
	public void setKpogr2(java.math.BigDecimal value) {
		this.Kpogr2 = value;
	}
	
	public java.math.BigDecimal getKpogr2() {
		return Kpogr2;
	}
	
	public void setVes_gruz2(java.math.BigDecimal value) {
		this.Ves_gruz2 = value;
	}
	
	public java.math.BigDecimal getVes_gruz2() {
		return Ves_gruz2;
	}
	
	public void setVol_gruz2(java.math.BigDecimal value) {
		this.Vol_gruz2 = value;
	}
	
	public java.math.BigDecimal getVol_gruz2() {
		return Vol_gruz2;
	}
	
	public void setId_vol2(String value) {
		this.Id_vol2 = value;
	}
	
	public String getId_vol2() {
		return Id_vol2;
	}
	
	public void setFakt_st2(java.math.BigDecimal value) {
		this.Fakt_st2 = value;
	}
	
	public java.math.BigDecimal getFakt_st2() {
		return Fakt_st2;
	}
	
	public void setKurs2(java.math.BigDecimal value) {
		this.Kurs2 = value;
	}
	
	public java.math.BigDecimal getKurs2() {
		return Kurs2;
	}
	
	public void setSum_all(java.math.BigDecimal value) {
		this.Sum_all = value;
	}
	
	public java.math.BigDecimal getSum_all() {
		return Sum_all;
	}
	
	public void setSum_all2(java.math.BigDecimal value) {
		this.Sum_all2 = value;
	}
	
	public java.math.BigDecimal getSum_all2() {
		return Sum_all2;
	}
	
	public void setFakt_usd2(java.math.BigDecimal value) {
		this.Fakt_usd2 = value;
	}
	
	public java.math.BigDecimal getFakt_usd2() {
		return Fakt_usd2;
	}
	
	public void setFakt_usd(java.math.BigDecimal value) {
		this.Fakt_usd = value;
	}
	
	public java.math.BigDecimal getFakt_usd() {
		return Fakt_usd;
	}
	
	public void setCnt_usl1(java.math.BigDecimal value) {
		this.Cnt_usl1 = value;
	}
	
	public java.math.BigDecimal getCnt_usl1() {
		return Cnt_usl1;
	}
	
	public void setKpogr1(java.math.BigDecimal value) {
		this.Kpogr1 = value;
	}
	
	public java.math.BigDecimal getKpogr1() {
		return Kpogr1;
	}
	
	public void setVes_gruz1(java.math.BigDecimal value) {
		this.Ves_gruz1 = value;
	}
	
	public java.math.BigDecimal getVes_gruz1() {
		return Ves_gruz1;
	}
	
	public void setVol_gruz1(java.math.BigDecimal value) {
		this.Vol_gruz1 = value;
	}
	
	public java.math.BigDecimal getVol_gruz1() {
		return Vol_gruz1;
	}
	
	public void setId_vol1(String value) {
		this.Id_vol1 = value;
	}
	
	public String getId_vol1() {
		return Id_vol1;
	}
	
	public void setFakt_st1(java.math.BigDecimal value) {
		this.Fakt_st1 = value;
	}
	
	public java.math.BigDecimal getFakt_st1() {
		return Fakt_st1;
	}
	
	public void setP_marsh(String value) {
		this.P_marsh = value;
	}
	
	public String getP_marsh() {
		return P_marsh;
	}
	
	public void setFl_marsh(String value) {
		this.Fl_marsh = value;
	}
	
	public String getFl_marsh() {
		return Fl_marsh;
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
	
	public void setKurs_usd(java.math.BigDecimal value) {
		this.Kurs_usd = value;
	}
	
	public java.math.BigDecimal getKurs_usd() {
		return Kurs_usd;
	}
	
	public void setId_val2(String value) {
		this.Id_val2 = value;
	}
	
	public String getId_val2() {
		return Id_val2;
	}
	
	public void setKurs_usd2(java.math.BigDecimal value) {
		this.Kurs_usd2 = value;
	}
	
	public java.math.BigDecimal getKurs_usd2() {
		return Kurs_usd2;
	}
	
	public void setId_fl(String value) {
		this.Id_fl = value;
	}
	
	public String getId_fl() {
		return Id_fl;
	}
	
	public void setMest(java.math.BigDecimal value) {
		this.Mest = value;
	}
	
	public java.math.BigDecimal getMest() {
		return Mest;
	}
	
	public void setG32_old(java.math.BigDecimal value) {
		this.G32_old = value;
	}
	
	public java.math.BigDecimal getG32_old() {
		return G32_old;
	}
	
	public void setId_call(String value) {
		this.Id_call = value;
	}
	
	public String getId_call() {
		return Id_call;
	}
	
	public void setId_tk(String value) {
		this.Id_tk = value;
	}
	
	public String getId_tk() {
		return Id_tk;
	}
	
	public void setId_podr(String value) {
		this.Id_podr = value;
	}
	
	public String getId_podr() {
		return Id_podr;
	}
	
	public void setId_strn(String value) {
		this.Id_strn = value;
	}
	
	public String getId_strn() {
		return Id_strn;
	}
	
	public void setId_doc(String value) {
		this.Id_doc = value;
	}
	
	public String getId_doc() {
		return Id_doc;
	}
	
	public void setId_dog(String value) {
		this.Id_dog = value;
	}
	
	public String getId_dog() {
		return Id_dog;
	}
	
	public void setDt_doc(java.sql.Timestamp value) {
		this.Dt_doc = value;
	}
	
	public java.sql.Timestamp getDt_doc() {
		return Dt_doc;
	}
	
	public void setId_svh(String value) {
		this.Id_svh = value;
	}
	
	public String getId_svh() {
		return Id_svh;
	}
	
	public void setId_tzs(String value) {
		this.Id_tzs = value;
	}
	
	public String getId_tzs() {
		return Id_tzs;
	}
	
	public void setId_stt(String value) {
		this.Id_stt = value;
	}
	
	public String getId_stt() {
		return Id_stt;
	}
	
	public void setNg_cox(int value) {
		setNg_cox(new Integer(value));
	}
	
	public void setNg_cox(Integer value) {
		this.Ng_cox = value;
	}
	
	public Integer getNg_cox() {
		return Ng_cox;
	}
	
	public void setNgv_cox(java.math.BigDecimal value) {
		this.Ngv_cox = value;
	}
	
	public java.math.BigDecimal getNgv_cox() {
		return Ngv_cox;
	}
	
	public void setKngv_cox(java.math.BigDecimal value) {
		this.Kngv_cox = value;
	}
	
	public java.math.BigDecimal getKngv_cox() {
		return Kngv_cox;
	}
	
	public void setId_dok(String value) {
		this.Id_dok = value;
	}
	
	public String getId_dok() {
		return Id_dok;
	}
	
	public void setId_upak(String value) {
		this.Id_upak = value;
	}
	
	public String getId_upak() {
		return Id_upak;
	}
	
	public void setMarker2(String value) {
		this.Marker2 = value;
	}
	
	public String getMarker2() {
		return Marker2;
	}
	
	public void setMarker3(String value) {
		this.Marker3 = value;
	}
	
	public String getMarker3() {
		return Marker3;
	}
	
	public void setId_pack_def(String value) {
		this.Id_pack_def = value;
	}
	
	public String getId_pack_def() {
		return Id_pack_def;
	}
	
	public void setEi(String value) {
		this.Ei = value;
	}
	
	public String getEi() {
		return Ei;
	}
	
	public void setStorage_cond_id(String value) {
		this.Storage_cond_id = value;
	}
	
	public String getStorage_cond_id() {
		return Storage_cond_id;
	}
	
	public void setEo_ves_ot(String value) {
		this.Eo_ves_ot = value;
	}
	
	public String getEo_ves_ot() {
		return Eo_ves_ot;
	}
	
	public void setEo_ves_do(String value) {
		this.Eo_ves_do = value;
	}
	
	public String getEo_ves_do() {
		return Eo_ves_do;
	}
	
	public void setVes_fact(java.math.BigDecimal value) {
		this.Ves_fact = value;
	}
	
	public java.math.BigDecimal getVes_fact() {
		return Ves_fact;
	}
	
	public void setAlg(java.math.BigDecimal value) {
		this.Alg = value;
	}
	
	public java.math.BigDecimal getAlg() {
		return Alg;
	}
	
	public void setTip_coef(String value) {
		this.Tip_coef = value;
	}
	
	public String getTip_coef() {
		return Tip_coef;
	}
	
	public void setUei(String value) {
		this.Uei = value;
	}
	
	public String getUei() {
		return Uei;
	}
	
	public void setG32(String value) {
		this.G32 = value;
	}
	
	public String getG32() {
		return G32;
	}
	
	public void setCnt_uei(java.math.BigDecimal value) {
		this.Cnt_uei = value;
	}
	
	public java.math.BigDecimal getCnt_uei() {
		return Cnt_uei;
	}
	
	public void setOrder(Order value) {
		this.order = value;
	}
	
	public Order getOrder() {
		return order;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}

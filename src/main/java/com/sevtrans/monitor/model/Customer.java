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
@Table(name="kb_zak", schema="public", indexes={ @Index(columnList="id") })
@SuppressWarnings({ "all", "unchecked" })
public class Customer implements Serializable {
	public Customer() {
	}
	
	@Column(name="id", nullable=false, length=38)	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqq")
	@GenericGenerator(name = "seqq", strategy = "com.sevtrans.monitor.model.StringPrefixedSequenceIdGenerator",	parameters = {@org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "50"),	@org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "0102"), @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%d") })
	private String Id;
	
	@Column(name="fk_id", nullable=true, length=38)	
	private String Fk_id;
	
	@ManyToOne(targetEntity=com.sevtrans.monitor.model.Shvoc.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="id_tip_zak", referencedColumnName="val_id", nullable=false) }, foreignKey=@ForeignKey(name="FKkb_zak886772"))	
	private com.sevtrans.monitor.model.Shvoc customerType;
	
	@Column(name="id_tip_zak2", nullable=true, length=38)	
	private String Id_tip_zak2;
	
	@Column(name="inn_zak", nullable=true, length=13)	
	private String Inn_zak;
	
	@Column(name="id_klient", nullable=true)	
	private int clientID;
	
	@Column(name="id_kopf", nullable=true, length=38)	
	private String Id_kopf;
	
	@Column(name="n_zak", nullable=true, length=256)	
	private String n_zak;
	
	@Column(name="naimen", nullable=true, length=256)	
	private String naimen;
	
	@Column(name="id_strana", nullable=true, length=38)	
	private String Id_strana;
	
	@Column(name="p_ind", nullable=true, precision=6, scale=0)	
	private java.math.BigDecimal P_ind;
	
	@Column(name="ur_adr", nullable=true, length=300)	
	private String ur_adr;
	
	@Column(name="fio", nullable=true, length=100)	
	private String Fio;
	
	@Column(name="tlf", nullable=true, length=60)	
	private String Tlf;
	
	@Column(name="fax", nullable=true, length=60)	
	private String Fax;
	
	@Column(name="email", nullable=true, length=500)	
	private String Email;
	
	@Column(name="web", nullable=true, length=60)	
	private String Web;
	
	@Column(name="fio_knt", nullable=true, length=3000)	
	private String Fio_knt;
	
	@Column(name="rs", nullable=true, length=20)	
	private String Rs;
	
	@Column(name="brs", nullable=true, length=70)	
	private String Brs;
	
	@Column(name="ks", nullable=true, length=20)	
	private String Ks;
	
	@Column(name="bks", nullable=true, length=70)	
	private String Bks;
	
	@Column(name="bik", nullable=true, length=10)	
	private String Bik;
	
	@Column(name="okpo", nullable=true, precision=8, scale=0)	
	private java.math.BigDecimal Okpo;
	
	@Column(name="okonx", nullable=true, length=70)	
	private String Okonx;
	
	@Column(name="id_okonx", nullable=true, length=38)	
	private String Id_okonx;
	
	@Column(name="account", nullable=true, length=40)	
	private String Account;
	
	@Column(name="baccount", nullable=true, length=70)	
	private String Baccount;
	
	@Column(name="swift", nullable=true, length=40)	
	private String Swift;
	
	@Column(name="licen", nullable=true, length=20)	
	private String Licen;
	
	@Column(name="dt_licen", nullable=true)	
	private java.sql.Timestamp Dt_licen;
	
	@Column(name="prim", nullable=true, length=500)	
	private String Prim;
	
	@Column(name="id_ved", nullable=true, length=38)	
	private String Id_ved;
	
	@Column(name="ora_user_edit_row_name", nullable=true, length=30)	
	private String Ora_user_edit_row_name;
	
	@Column(name="ora_user_edit_row_date", nullable=true)	
	private java.sql.Timestamp Ora_user_edit_row_date;
	
	@Column(name="ora_user_edit_row_lock", nullable=false, precision=131089, scale=0)	
	private java.math.BigDecimal Ora_user_edit_row_lock;
	
	@Column(name="dt_reg", nullable=true)	
	private java.sql.Timestamp Dt_reg;
	
	@Column(name="fio_rec", nullable=true, length=100)	
	private String Fio_rec;
	
	@Column(name="id_ist", nullable=true, length=38)	
	private String Id_ist;
	
	@Column(name="id_fl", nullable=true, length=38)	
	private String Id_fl;
	
	@Column(name="dt_end", nullable=true)	
	private java.sql.Timestamp Dt_end;
	
	@Column(name="kpp_zak", nullable=true, precision=9, scale=0)	
	private java.math.BigDecimal Kpp_zak;
	
	@Column(name="row_creator", nullable=true, length=30)	
	private String Row_creator;
	
	@Column(name="row_creation_time", nullable=true)	
	private java.sql.Timestamp Row_creation_time;
	
	@Column(name="n_eng", nullable=true, length=150)	
	private String N_eng;
	
	@Column(name="adr_eng", nullable=true, length=300)	
	private String Adr_eng;
	
	@Column(name="c_account", nullable=true, length=20)	
	private String C_account;
	
	@Column(name="bacc_int", nullable=true, length=70)	
	private String Bacc_int;
	
	@Column(name="swift_int", nullable=true, length=40)	
	private String Swift_int;
	
	@Column(name="fio_rod", nullable=true, length=100)	
	private String Fio_rod;
	
	@Column(name="id_usr", nullable=true, length=38)	
	private String Id_usr;
	
	@Column(name="tlf_smst", nullable=true, length=100)	
	private String Tlf_smst;
	
	@Column(name="rus_sms", nullable=true, precision=1, scale=0)	
	private java.math.BigDecimal Rus_sms;
	
	@Column(name="tir_vod", nullable=true, precision=1, scale=0)	
	private java.math.BigDecimal Tir_vod;
	
	@Column(name="dt_licen_end", nullable=true)	
	private java.sql.Timestamp Dt_licen_end;
	
	@Column(name="ins_mail", nullable=true, precision=1, scale=0)	
	private java.math.BigDecimal Ins_mail;
	
	@Column(name="kod_no", nullable=true, length=100)	
	private String Kod_no;
	
	@Column(name="is_car", nullable=true, precision=1, scale=0)	
	private java.math.BigDecimal Is_car;
	
	@Column(name="is_sup", nullable=true, precision=1, scale=0)	
	private java.math.BigDecimal Is_sup;
	
	@Column(name="is_holder", nullable=true, precision=1, scale=0)	
	private java.math.BigDecimal Is_holder;
	
	@Column(name="is_cust", nullable=true, precision=1, scale=0)	
	private java.math.BigDecimal Is_cust;
	
	@Column(name="id_wms", nullable=true, length=20)	
	private String Id_wms;
	
	@Column(name="id_info", nullable=true, length=12)	
	private String Id_info;
	
	@Column(name="prf_wms", nullable=true, length=3)	
	private String prf_wms;
	
	@Column(name="dn_dost", nullable=true, precision=2, scale=0)	
	private java.math.BigDecimal Dn_dost;
	
	@Column(name="id_no_accept", nullable=true, length=38)	
	private String Id_no_accept;
	
	@Column(name="p_in", nullable=true, precision=5, scale=2)	
	private java.math.BigDecimal P_in;
	
	@Column(name="p_out", nullable=true, precision=5, scale=2)	
	private java.math.BigDecimal P_out;
	
	@Column(name="p_kol", nullable=true)	
	private Integer P_kol;
	
	@Column(name="list_reg", nullable=true, precision=1, scale=0)	
	private java.math.BigDecimal List_reg;
	
	@Column(name="am_ord", nullable=true, precision=3, scale=0)	
	private java.math.BigDecimal Am_ord;
	
	@Column(name="dov_inf", nullable=true, length=4000)	
	private String Dov_inf;
	
	@Column(name="id_svh", nullable=true, length=38)	
	private String Id_svh;
	
	public void setId(String value) {
		this.Id = value;
	}
	
	public String getId() {
		return Id;
	}
	
	public String getORMID() {
		return getId();
	}
	
	public void setId_wms(String value) {
		this.Id_wms = value;
	}
	
	public String getId_wms() {
		return Id_wms;
	}
	
	public void setId_svh(String value) {
		this.Id_svh = value;
	}
	
	public String getId_svh() {
		return Id_svh;
	}
	
	public void setPrf_wms(String value) {
		this.prf_wms = value;
	}
	
	public String getPrf_wms() {
		return prf_wms;
	}
	
	public void setId_usr(String value) {
		this.Id_usr = value;
	}
	
	public String getId_usr() {
		return Id_usr;
	}
	
	public void setClientID(int value) {
		this.clientID = value;
	}
	
	public int getClientID() {
		return clientID;
	}
	
	public void setN_zak(String value) {
		this.n_zak = value;
	}
	
	public String getN_zak() {
		return n_zak;
	}
	
	public void setNaimen(String value) {
		this.naimen = value;
	}
	
	public String getNaimen() {
		return naimen;
	}
	
	public void setUr_adr(String value) {
		this.ur_adr = value;
	}
	
	public String getUr_adr() {
		return ur_adr;
	}
	
	public void setFk_id(String value) {
		this.Fk_id = value;
	}
	
	public String getFk_id() {
		return Fk_id;
	}
	
	public void setId_tip_zak2(String value) {
		this.Id_tip_zak2 = value;
	}
	
	public String getId_tip_zak2() {
		return Id_tip_zak2;
	}
	
	public void setInn_zak(String value) {
		this.Inn_zak = value;
	}
	
	public String getInn_zak() {
		return Inn_zak;
	}
	
	public void setId_kopf(String value) {
		this.Id_kopf = value;
	}
	
	public String getId_kopf() {
		return Id_kopf;
	}
	
	public void setId_strana(String value) {
		this.Id_strana = value;
	}
	
	public String getId_strana() {
		return Id_strana;
	}
	
	public void setP_ind(java.math.BigDecimal value) {
		this.P_ind = value;
	}
	
	public java.math.BigDecimal getP_ind() {
		return P_ind;
	}
	
	public void setFio(String value) {
		this.Fio = value;
	}
	
	public String getFio() {
		return Fio;
	}
	
	public void setTlf(String value) {
		this.Tlf = value;
	}
	
	public String getTlf() {
		return Tlf;
	}
	
	public void setFax(String value) {
		this.Fax = value;
	}
	
	public String getFax() {
		return Fax;
	}
	
	public void setEmail(String value) {
		this.Email = value;
	}
	
	public String getEmail() {
		return Email;
	}
	
	public void setWeb(String value) {
		this.Web = value;
	}
	
	public String getWeb() {
		return Web;
	}
	
	public void setFio_knt(String value) {
		this.Fio_knt = value;
	}
	
	public String getFio_knt() {
		return Fio_knt;
	}
	
	public void setRs(String value) {
		this.Rs = value;
	}
	
	public String getRs() {
		return Rs;
	}
	
	public void setBrs(String value) {
		this.Brs = value;
	}
	
	public String getBrs() {
		return Brs;
	}
	
	public void setKs(String value) {
		this.Ks = value;
	}
	
	public String getKs() {
		return Ks;
	}
	
	public void setBks(String value) {
		this.Bks = value;
	}
	
	public String getBks() {
		return Bks;
	}
	
	public void setBik(String value) {
		this.Bik = value;
	}
	
	public String getBik() {
		return Bik;
	}
	
	public void setOkpo(java.math.BigDecimal value) {
		this.Okpo = value;
	}
	
	public java.math.BigDecimal getOkpo() {
		return Okpo;
	}
	
	public void setOkonx(String value) {
		this.Okonx = value;
	}
	
	public String getOkonx() {
		return Okonx;
	}
	
	public void setId_okonx(String value) {
		this.Id_okonx = value;
	}
	
	public String getId_okonx() {
		return Id_okonx;
	}
	
	public void setAccount(String value) {
		this.Account = value;
	}
	
	public String getAccount() {
		return Account;
	}
	
	public void setBaccount(String value) {
		this.Baccount = value;
	}
	
	public String getBaccount() {
		return Baccount;
	}
	
	public void setSwift(String value) {
		this.Swift = value;
	}
	
	public String getSwift() {
		return Swift;
	}
	
	public void setLicen(String value) {
		this.Licen = value;
	}
	
	public String getLicen() {
		return Licen;
	}
	
	public void setDt_licen(java.sql.Timestamp value) {
		this.Dt_licen = value;
	}
	
	public java.sql.Timestamp getDt_licen() {
		return Dt_licen;
	}
	
	public void setPrim(String value) {
		this.Prim = value;
	}
	
	public String getPrim() {
		return Prim;
	}
	
	public void setId_ved(String value) {
		this.Id_ved = value;
	}
	
	public String getId_ved() {
		return Id_ved;
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
	
	public void setDt_reg(java.sql.Timestamp value) {
		this.Dt_reg = value;
	}
	
	public java.sql.Timestamp getDt_reg() {
		return Dt_reg;
	}
	
	public void setFio_rec(String value) {
		this.Fio_rec = value;
	}
	
	public String getFio_rec() {
		return Fio_rec;
	}
	
	public void setId_ist(String value) {
		this.Id_ist = value;
	}
	
	public String getId_ist() {
		return Id_ist;
	}
	
	public void setId_fl(String value) {
		this.Id_fl = value;
	}
	
	public String getId_fl() {
		return Id_fl;
	}
	
	public void setDt_end(java.sql.Timestamp value) {
		this.Dt_end = value;
	}
	
	public java.sql.Timestamp getDt_end() {
		return Dt_end;
	}
	
	public void setKpp_zak(java.math.BigDecimal value) {
		this.Kpp_zak = value;
	}
	
	public java.math.BigDecimal getKpp_zak() {
		return Kpp_zak;
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
	
	public void setN_eng(String value) {
		this.N_eng = value;
	}
	
	public String getN_eng() {
		return N_eng;
	}
	
	public void setAdr_eng(String value) {
		this.Adr_eng = value;
	}
	
	public String getAdr_eng() {
		return Adr_eng;
	}
	
	public void setC_account(String value) {
		this.C_account = value;
	}
	
	public String getC_account() {
		return C_account;
	}
	
	public void setBacc_int(String value) {
		this.Bacc_int = value;
	}
	
	public String getBacc_int() {
		return Bacc_int;
	}
	
	public void setSwift_int(String value) {
		this.Swift_int = value;
	}
	
	public String getSwift_int() {
		return Swift_int;
	}
	
	public void setFio_rod(String value) {
		this.Fio_rod = value;
	}
	
	public String getFio_rod() {
		return Fio_rod;
	}
	
	public void setTlf_smst(String value) {
		this.Tlf_smst = value;
	}
	
	public String getTlf_smst() {
		return Tlf_smst;
	}
	
	public void setRus_sms(java.math.BigDecimal value) {
		this.Rus_sms = value;
	}
	
	public java.math.BigDecimal getRus_sms() {
		return Rus_sms;
	}
	
	public void setTir_vod(java.math.BigDecimal value) {
		this.Tir_vod = value;
	}
	
	public java.math.BigDecimal getTir_vod() {
		return Tir_vod;
	}
	
	public void setDt_licen_end(java.sql.Timestamp value) {
		this.Dt_licen_end = value;
	}
	
	public java.sql.Timestamp getDt_licen_end() {
		return Dt_licen_end;
	}
	
	public void setIns_mail(java.math.BigDecimal value) {
		this.Ins_mail = value;
	}
	
	public java.math.BigDecimal getIns_mail() {
		return Ins_mail;
	}
	
	public void setKod_no(String value) {
		this.Kod_no = value;
	}
	
	public String getKod_no() {
		return Kod_no;
	}
	
	public void setIs_car(java.math.BigDecimal value) {
		this.Is_car = value;
	}
	
	public java.math.BigDecimal getIs_car() {
		return Is_car;
	}
	
	public void setIs_sup(java.math.BigDecimal value) {
		this.Is_sup = value;
	}
	
	public java.math.BigDecimal getIs_sup() {
		return Is_sup;
	}
	
	public void setIs_holder(java.math.BigDecimal value) {
		this.Is_holder = value;
	}
	
	public java.math.BigDecimal getIs_holder() {
		return Is_holder;
	}
	
	public void setIs_cust(java.math.BigDecimal value) {
		this.Is_cust = value;
	}
	
	public java.math.BigDecimal getIs_cust() {
		return Is_cust;
	}
	
	public void setId_info(String value) {
		this.Id_info = value;
	}
	
	public String getId_info() {
		return Id_info;
	}
	
	public void setDn_dost(java.math.BigDecimal value) {
		this.Dn_dost = value;
	}
	
	public java.math.BigDecimal getDn_dost() {
		return Dn_dost;
	}
	
	public void setId_no_accept(String value) {
		this.Id_no_accept = value;
	}
	
	public String getId_no_accept() {
		return Id_no_accept;
	}
	
	public void setP_in(java.math.BigDecimal value) {
		this.P_in = value;
	}
	
	public java.math.BigDecimal getP_in() {
		return P_in;
	}
	
	public void setP_out(java.math.BigDecimal value) {
		this.P_out = value;
	}
	
	public java.math.BigDecimal getP_out() {
		return P_out;
	}
	
	public void setP_kol(int value) {
		setP_kol(new Integer(value));
	}
	
	public void setP_kol(Integer value) {
		this.P_kol = value;
	}
	
	public Integer getP_kol() {
		return P_kol;
	}
	
	public void setList_reg(java.math.BigDecimal value) {
		this.List_reg = value;
	}
	
	public java.math.BigDecimal getList_reg() {
		return List_reg;
	}
	
	public void setAm_ord(java.math.BigDecimal value) {
		this.Am_ord = value;
	}
	
	public java.math.BigDecimal getAm_ord() {
		return Am_ord;
	}
	
	public void setDov_inf(String value) {
		this.Dov_inf = value;
	}
	
	public String getDov_inf() {
		return Dov_inf;
	}
	
	public void setCustomerType(com.sevtrans.monitor.model.Shvoc value) {
		this.customerType = value;
	}
	
	public com.sevtrans.monitor.model.Shvoc getCustomerType() {
		return customerType;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}

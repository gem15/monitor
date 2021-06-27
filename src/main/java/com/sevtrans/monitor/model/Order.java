/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * <p>
 * This is an automatic generated file. It will be regenerated every time
 * you generate persistence class.
 * <p>
 * Modifying its content may cause the program not work, or your work may lost.
 * <p>
 * Licensee: Gennady
 * License Type: Purchased
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
@org.hibernate.annotations.Proxy(lazy = false)
@Table(name = "kb_spros", schema = "public", indexes = {@Index(columnList = "id")})
@SuppressWarnings({"all", "unchecked"})
public class Order implements Serializable {
    public Order() {
    }

    @Column(name = "id", nullable = false, length = 38)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqq")
    @GenericGenerator(name = "seqq", strategy = "com.sevtrans.monitor.model.StringPrefixedSequenceIdGenerator", parameters = {@org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "50"), @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "0102"), @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%d")})
    private String Id;

    @Column(name = "fk_id", nullable = true, length = 38)
    private String Fk_id;

    @Column(name = "n_zakaza", nullable = true, length = 15)
    private String N_zakaza;

    @Column(name = "dt_zakaz", nullable = true)
    private java.sql.Timestamp dt_zakaz;

    @ManyToOne(targetEntity = Customer.class, fetch = FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value = {@JoinColumn(name = "id_zak", referencedColumnName = "id", nullable = false)}, foreignKey = @ForeignKey(name = "Customer"))
    private Customer customer;

    @ManyToOne(targetEntity = Customer.class, fetch = FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value = {@JoinColumn(name = "id_pok", referencedColumnName = "id", nullable = false)}, foreignKey = @ForeignKey(name = "Contractor"))
    private Customer contractor;

    @Column(name = "id_dpok", nullable = true, length = 38)
    private String Id_dpok;

    @Column(name = "fio_knt", nullable = true, length = 100)
    private String Fio_knt;

    @Column(name = "usl", nullable = true, length = 500)
    private String Usl;

    @Column(name = "ora_user_edit_row_name", nullable = true, length = 30)
    private String Ora_user_edit_row_name;

    @Column(name = "ora_user_edit_row_date", nullable = true)
    private java.sql.Timestamp Ora_user_edit_row_date;

    @Column(name = "ora_user_edit_row_lock", nullable = false, precision = 131089, scale = 0)
    private java.math.BigDecimal Ora_user_edit_row_lock = java.math.BigDecimal.valueOf(0);

    @ManyToOne(targetEntity = Shvoc.class, fetch = FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value = {@JoinColumn(name = "id_kat", referencedColumnName = "val_id", nullable = false)}, foreignKey = @ForeignKey(name = "goodsCategory"))
    private Shvoc goodsCategory;

    @Column(name = "npost", nullable = true, length = 100)
    private String Npost;

    @ManyToOne(targetEntity = Vehicle.class, fetch = FetchType.LAZY)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})
    @JoinColumns(value = {@JoinColumn(name = "id_tir", referencedColumnName = "id", nullable = false)}, foreignKey = @ForeignKey(name = "FKkb_spros221410"))
    private Vehicle vehicle;

    @Column(name = "row_creator", nullable = true, length = 30)
    private String Row_creator;

    @Column(name = "row_creation_time", nullable = true)
    private java.sql.Timestamp Row_creation_time;

    @Column(name = "kpost", nullable = true, precision = 3, scale = 0)
    private java.math.BigDecimal Kpost;

    @Column(name = "id_spros", nullable = true, length = 38)
    private String Id_spros;

    @Column(name = "kr", nullable = true, length = 1)
    private String Kr;

    @Column(name = "n_tir", nullable = true, length = 100)
    private String N_tir;

    @Column(name = "n_gtd", nullable = true, length = 100)
    private String N_gtd;

    @Column(name = "n_skl", nullable = true, length = 50)
    private String N_skl;

    @Column(name = "mest", nullable = true, length = 10)
    private String Mest;

    @Column(name = "n_gruz", nullable = true, length = 50)
    private String n_gruz;

    @Column(name = "ptd", nullable = true, precision = 1, scale = 0)
    private java.math.BigDecimal Ptd;

    @Column(name = "is_postavka", nullable = true, precision = 1, scale = 0)
    private int Is_postavka;

    @OneToMany(mappedBy = "order", targetEntity = com.sevtrans.monitor.model.OrderEvent.class)
    @org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})
    @org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)
    private java.util.Set orderEvent = new java.util.HashSet();

    public void setId(String value) {
        this.Id = value;
    }

    public String getId() {
        return Id;
    }

    public String getORMID() {
        return getId();
    }

    public void setN_gruz(String value) {
        this.n_gruz = value;
    }

    public String getN_gruz() {
        return n_gruz;
    }

    public void setDt_zakaz(java.sql.Timestamp value) {
        this.dt_zakaz = value;
    }

    public java.sql.Timestamp getDt_zakaz() {
        return dt_zakaz;
    }

    public void setIs_postavka(int value) {
        this.Is_postavka = value;
    }

    public int getIs_postavka() {
        return Is_postavka;
    }

    public void setFk_id(String value) {
        this.Fk_id = value;
    }

    public String getFk_id() {
        return Fk_id;
    }

    public void setN_zakaza(String value) {
        this.N_zakaza = value;
    }

    public String getN_zakaza() {
        return N_zakaza;
    }

    public void setId_dpok(String value) {
        this.Id_dpok = value;
    }

    public String getId_dpok() {
        return Id_dpok;
    }

    public void setFio_knt(String value) {
        this.Fio_knt = value;
    }

    public String getFio_knt() {
        return Fio_knt;
    }

    public void setUsl(String value) {
        this.Usl = value;
    }

    public String getUsl() {
        return Usl;
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

    public void setNpost(String value) {
        this.Npost = value;
    }

    public String getNpost() {
        return Npost;
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

    public void setKpost(java.math.BigDecimal value) {
        this.Kpost = value;
    }

    public java.math.BigDecimal getKpost() {
        return Kpost;
    }

    public void setId_spros(String value) {
        this.Id_spros = value;
    }

    public String getId_spros() {
        return Id_spros;
    }

    public void setKr(String value) {
        this.Kr = value;
    }

    public String getKr() {
        return Kr;
    }

    public void setN_tir(String value) {
        this.N_tir = value;
    }

    public String getN_tir() {
        return N_tir;
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

    public void setPtd(java.math.BigDecimal value) {
        this.Ptd = value;
    }

    public java.math.BigDecimal getPtd() {
        return Ptd;
    }

    public void setCustomer(Customer value) {
        this.customer = value;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setContractor(Customer value) {
        this.contractor = value;
    }

    public Customer getContractor() {
        return contractor;
    }

    public void setGoodsCategory(Shvoc value) {
        this.goodsCategory = value;
    }

    public Shvoc getGoodsCategory() {
        return goodsCategory;
    }

    public void setVehicle(Vehicle value) {
        this.vehicle = value;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setOrderEvent(java.util.Set value) {
        this.orderEvent = value;
    }

    public java.util.Set getOrderEvent() {
        return orderEvent;
    }


    public String toString() {
        return String.valueOf(getId());
    }

}

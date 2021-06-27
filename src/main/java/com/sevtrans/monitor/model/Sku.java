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

import java.io.Serializable;
import javax.persistence.*;

@Entity
@org.hibernate.annotations.Proxy(lazy = false)
@Table(name = "sku", schema = "public")
@SuppressWarnings({"all", "unchecked"})
public class Sku implements Serializable {
    public Sku() {
    }

    @Column(name = "id", nullable = false)
    @Id
    @GeneratedValue(generator = "COM_SEVTRANS_MONITOR_MODEL_SKU_ID_GENERATOR")
    @org.hibernate.annotations.GenericGenerator(name = "COM_SEVTRANS_MONITOR_MODEL_SKU_ID_GENERATOR", strategy = "sequence", parameters = {@org.hibernate.annotations.Parameter(name = "sequence", value = "sku_seq")})
    private int Id;

    @Column(name = "revision", nullable = true)
    private Integer Revision = new Integer(0);

    @Column(name = "sku_id", nullable = true, length = 255)
    private String Sku_id;

    @Column(name = "name", nullable = false, length = 200)
    private String Name;

    @Column(name = "alt_name", nullable = true, length = 200)
    private String Alt_name;

    @Column(name = "upc", nullable = true, length = 32)
    private String Upc;

    @Column(name = "rcv_grp", nullable = true)
    private Integer Rcv_grp;

    @Column(name = "test_in_grp", nullable = true)
    private Integer Test_in_grp;

    @Column(name = "qc_type", nullable = true, length = 1)
    private Character Qc_type;

    @Column(name = "qc_destroy", nullable = false, length = 1)
    private char Qc_destroy;

    @Column(name = "test_out_grp", nullable = true)
    private Integer Test_out_grp;

    @Column(name = "pkg_grp", nullable = true)
    private Integer Pkg_grp = new Integer(0);

    @Column(name = "min_units", nullable = true)
    private Integer Min_units;

    @Column(name = "max_units", nullable = true)
    private Integer Max_units;

    @Column(name = "descr_short", nullable = true, length = 16)
    private String Descr_short;

    @Column(name = "description", nullable = true, length = 200)
    private String Description;

    @Column(name = "alt_description", nullable = true, length = 200)
    private String Alt_description;

    @Column(name = "measure", nullable = true)
    private Integer Measure = new Integer(0);

    @Column(name = "uom_changeable", nullable = false, length = 1)
    private char Uom_changeable;

    @Column(name = "shelf_life", nullable = true)
    private Integer Shelf_life;

    @Column(name = "warning_time", nullable = true)
    private Integer Warning_time;

    @Column(name = "control_date", nullable = true, length = 1)
    private Character Control_date;

    @Column(name = "weight_control", nullable = false, length = 1)
    private char Weight_control;

    @Column(name = "purchasing_price", nullable = true)
    private Double Purchasing_price;

    @Column(name = "internal_price", nullable = true)
    private Double Internal_price;

    @Column(name = "storage_price", nullable = true)
    private Double Storage_price;

    @Column(name = "release_price", nullable = true)
    private Double Release_price;

    @Column(name = "manager_made", nullable = false, length = 1)
    private char Manager_made;

    @Column(name = "sdid", nullable = true, length = 255)
    private String Sdid;

    @Column(name = "sizeless", nullable = false, length = 1)
    private char Sizeless;

    @Column(name = "pos", nullable = false)
    private int Pos = 0;

    @Column(name = "summary_units", nullable = true)
    private Integer Summary_units = new Integer(0);

    @Column(name = "reserved", nullable = true)
    private Integer Reserved = new Integer(0);

    @Column(name = "pallet_stack_size", nullable = true)
    private Integer Pallet_stack_size = new Integer(1);

    @Column(name = "max_load_height", nullable = true)
    private Integer Max_load_height;

    @Column(name = "abc_class", nullable = false, length = 1)
    private char Abc_class;

    @Column(name = "abc_class_operator", nullable = true, length = 32)
    private String Abc_class_operator;

    @Column(name = "abc_class_date", nullable = true)
    private java.sql.Timestamp Abc_class_date;

    @Column(name = "calc_abc_class", nullable = false, length = 1)
    private char Calc_abc_class;

    @Column(name = "calc_abc_class_operator", nullable = true, length = 32)
    private String Calc_abc_class_operator;

    @Column(name = "calc_abc_class_date", nullable = true)
    private java.sql.Timestamp Calc_abc_class_date;

    @Column(name = "is_new", nullable = false, length = 1)
    private char Is_new;

    @Column(name = "is_kit", nullable = false, length = 1)
    private char Is_kit;

    @Column(name = "is_tara", nullable = false, length = 1)
    private char Is_tara;

    @Column(name = "producer", nullable = true, length = 200)
    private String Producer;

    @Column(name = "vendor", nullable = true, length = 200)
    private String Vendor;

    @Column(name = "holder_id", nullable = true)
    private Integer Holder_id = new Integer(0);

    @Column(name = "coo", nullable = true, length = 50)
    private String Coo;

    @Column(name = "lot_capture_req", nullable = false, length = 1)
    private char Lot_capture_req;

    @Column(name = "hazardous", nullable = true, length = 1)
    private Character Hazardous;

    @Column(name = "labels_req", nullable = false, length = 1)
    private char Labels_req;

    @Column(name = "velocity", nullable = false)
    private int Velocity = 0;

    @Column(name = "cached", nullable = false, length = 1)
    private char Cached;

    @Column(name = "qc_percent", nullable = false)
    private int Qc_percent = 0;

    @Column(name = "neg_pick_prc", nullable = false)
    private int Neg_pick_prc = 100;

    @Column(name = "shl_prc", nullable = false)
    private int Shl_prc = 0;

    @Column(name = "can_crossdock", nullable = false, length = 1)
    private char Can_crossdock;

    @Column(name = "vendor_sku", nullable = true, length = 255)
    private String Vendor_sku = "''::character varying";

    @Column(name = "sertificat", nullable = true, length = 32)
    private String Sertificat;

    @Column(name = "label", nullable = true, length = 500)
    private String Label;

    @Column(name = "sort_key1", nullable = false)
    private int Sort_key1 = 0;

    @Column(name = "sort_key2", nullable = false)
    private int Sort_key2 = 0;

    @Column(name = "sort_key3", nullable = false)
    private int Sort_key3 = 0;

    @Column(name = "product_life", nullable = false)
    private int Product_life = 0;

    @Column(name = "hold_days", nullable = true)
    private Integer Hold_days = new Integer(0);

    @Column(name = "dday_interval", nullable = false)
    private int Dday_interval = 0;

    @Column(name = "time_fence", nullable = true)
    private Integer Time_fence = new Integer(0);

    @Column(name = "billing_class", nullable = true)
    private Integer Billing_class = new Integer(0);

    @Column(name = "auto_fp_flag", nullable = false, length = 1)
    private char Auto_fp_flag;

    @Column(name = "usage_state", nullable = false, length = 1)
    private char Usage_state;

    @Column(name = "serial_num_track", nullable = true)
    private Integer Serial_num_track = new Integer(0);

    @Column(name = "serial_num_rule", nullable = false, length = 255)
    private String Serial_num_rule = "'*'::character varying";

    @Column(name = "article", nullable = true, length = 255)
    private String Article;

    @Column(name = "host_transform_factor", nullable = false)
    private double Host_transform_factor;

    @Column(name = "created", nullable = false)
    private java.sql.Timestamp Created;

    @Column(name = "created_by", nullable = false, length = 32)
    private String Created_by = "'SYSTEM'::character varying";

    @Column(name = "modified", nullable = false)
    private java.sql.Timestamp Modified;

    @Column(name = "modified_by", nullable = false, length = 32)
    private String Modified_by = "'SYSTEM'::character varying";

    @Column(name = "bulk_qty", nullable = false, precision = 131089, scale = 0)
    private int Bulk_qty = 0;

    @Column(name = "sscc_control", nullable = true, length = 1)
    private Character Sscc_control;

    @Column(name = "product_life_measure", nullable = false, length = 1)
    private char Product_life_measure;

    @Column(name = "shelf_life_measure", nullable = false, length = 1)
    private char Shelf_life_measure;

    @Column(name = "sample_units", nullable = true, precision = 131089, scale = 0)
    private Integer Sample_units = new Integer(0);

    @Column(name = "rec_usage_state", nullable = false, length = 1)
    private char Rec_usage_state;

    @Column(name = "sku_spec_id", nullable = false, precision = 131089, scale = 0)
    private int Sku_spec_id = 0;

    @Column(name = "storage_cond_id", nullable = false, precision = 131089, scale = 0)
    private int Storage_cond_id = 0;

    @Column(name = "season_id", nullable = true, precision = 131089, scale = 0)
    private Integer Season_id = new Integer(0);

    @Column(name = "mu_units", nullable = true, precision = 131089, scale = 0)
    private Integer Mu_units;

    @Column(name = "mu_barcode", nullable = true, length = 13)
    private String Mu_barcode;

    @Column(name = "article_n", nullable = true, length = 255)
    private String Article_n;

    public void setId(int value) {
        this.Id = value;
    }

    public int getId() {
        return Id;
    }

    public int getORMID() {
        return getId();
    }

    public void setRevision(int value) {
        setRevision(new Integer(value));
    }

    public void setRevision(Integer value) {
        this.Revision = value;
    }

    public Integer getRevision() {
        return Revision;
    }

    /**
     * код СД
     */
    public void setSku_id(String value) {
        this.Sku_id = value;
    }

    /**
     * код СД
     */
    public String getSku_id() {
        return Sku_id;
    }

    /**
     * внутреннее имя
     */
    public void setName(String value) {
        this.Name = value;
    }

    /**
     * внутреннее имя
     */
    public String getName() {
        return Name;
    }

    /**
     * alternative name of sku
     */
    public void setAlt_name(String value) {
        this.Alt_name = value;
    }

    /**
     * alternative name of sku
     */
    public String getAlt_name() {
        return Alt_name;
    }

    public void setUpc(String value) {
        this.Upc = value;
    }

    public String getUpc() {
        return Upc;
    }

    /**
     * принимать в группе
     */
    public void setRcv_grp(int value) {
        setRcv_grp(new Integer(value));
    }

    /**
     * принимать в группе
     */
    public void setRcv_grp(Integer value) {
        this.Rcv_grp = value;
    }

    /**
     * принимать в группе
     */
    public Integer getRcv_grp() {
        return Rcv_grp;
    }

    /**
     * контроль качества в группе
     */
    public void setTest_in_grp(int value) {
        setTest_in_grp(new Integer(value));
    }

    /**
     * контроль качества в группе
     */
    public void setTest_in_grp(Integer value) {
        this.Test_in_grp = value;
    }

    /**
     * контроль качества в группе
     */
    public Integer getTest_in_grp() {
        return Test_in_grp;
    }

    /**
     * Тип контроля качества
     */
    public void setQc_type(char value) {
        setQc_type(new Character(value));
    }

    /**
     * Тип контроля качества
     */
    public void setQc_type(Character value) {
        this.Qc_type = value;
    }

    /**
     * Тип контроля качества
     */
    public Character getQc_type() {
        return Qc_type;
    }

    /**
     * QC разрушающий/неразрушающий
     */
    public void setQc_destroy(char value) {
        this.Qc_destroy = value;
    }

    /**
     * QC разрушающий/неразрушающий
     */
    public char getQc_destroy() {
        return Qc_destroy;
    }

    public void setTest_out_grp(int value) {
        setTest_out_grp(new Integer(value));
    }

    public void setTest_out_grp(Integer value) {
        this.Test_out_grp = value;
    }

    public Integer getTest_out_grp() {
        return Test_out_grp;
    }

    /**
     * упаковывать в группе
     */
    public void setPkg_grp(int value) {
        setPkg_grp(new Integer(value));
    }

    /**
     * упаковывать в группе
     */
    public void setPkg_grp(Integer value) {
        this.Pkg_grp = value;
    }

    /**
     * упаковывать в группе
     */
    public Integer getPkg_grp() {
        return Pkg_grp;
    }

    /**
     * При понижении запасов ниже - сообщение в host
     */
    public void setMin_units(int value) {
        setMin_units(new Integer(value));
    }

    /**
     * При понижении запасов ниже - сообщение в host
     */
    public void setMin_units(Integer value) {
        this.Min_units = value;
    }

    /**
     * При понижении запасов ниже - сообщение в host
     */
    public Integer getMin_units() {
        return Min_units;
    }

    /**
     * При повышении запасов выше - сообщение в host
     */
    public void setMax_units(int value) {
        setMax_units(new Integer(value));
    }

    /**
     * При повышении запасов выше - сообщение в host
     */
    public void setMax_units(Integer value) {
        this.Max_units = value;
    }

    /**
     * При повышении запасов выше - сообщение в host
     */
    public Integer getMax_units() {
        return Max_units;
    }

    /**
     * краткое описание
     */
    public void setDescr_short(String value) {
        this.Descr_short = value;
    }

    /**
     * краткое описание
     */
    public String getDescr_short() {
        return Descr_short;
    }

    /**
     * описание
     */
    public void setDescription(String value) {
        this.Description = value;
    }

    /**
     * описание
     */
    public String getDescription() {
        return Description;
    }

    /**
     * alternative description
     */
    public void setAlt_description(String value) {
        this.Alt_description = value;
    }

    /**
     * alternative description
     */
    public String getAlt_description() {
        return Alt_description;
    }

    /**
     * единицы измерения, использовать только если uom_changeable=f
     */
    public void setMeasure(int value) {
        setMeasure(new Integer(value));
    }

    /**
     * единицы измерения, использовать только если uom_changeable=f
     */
    public void setMeasure(Integer value) {
        this.Measure = value;
    }

    /**
     * единицы измерения, использовать только если uom_changeable=f
     */
    public Integer getMeasure() {
        return Measure;
    }

    /**
     * Флаг разрешения изменения UOM( units of measure - Единиц измерения) для SKU, то есть можно ли заводить другие UOM
     */
    public void setUom_changeable(char value) {
        this.Uom_changeable = value;
    }

    /**
     * Флаг разрешения изменения UOM( units of measure - Единиц измерения) для SKU, то есть можно ли заводить другие UOM
     */
    public char getUom_changeable() {
        return Uom_changeable;
    }

    /**
     * время хранения товара
     */
    public void setShelf_life(int value) {
        setShelf_life(new Integer(value));
    }

    /**
     * время хранения товара
     */
    public void setShelf_life(Integer value) {
        this.Shelf_life = value;
    }

    /**
     * время хранения товара
     */
    public Integer getShelf_life() {
        return Shelf_life;
    }

    /**
     * время предупреждение
     */
    public void setWarning_time(int value) {
        setWarning_time(new Integer(value));
    }

    /**
     * время предупреждение
     */
    public void setWarning_time(Integer value) {
        this.Warning_time = value;
    }

    /**
     * время предупреждение
     */
    public Integer getWarning_time() {
        return Warning_time;
    }

    /**
     * Флаг учета даты
     */
    public void setControl_date(char value) {
        setControl_date(new Character(value));
    }

    /**
     * Флаг учета даты
     */
    public void setControl_date(Character value) {
        this.Control_date = value;
    }

    /**
     * Флаг учета даты
     */
    public Character getControl_date() {
        return Control_date;
    }

    /**
     * Учет веса: A - по умолчанию расчитывается автоматически, но можно менять; M - обязательно задавать вручную
     */
    public void setWeight_control(char value) {
        this.Weight_control = value;
    }

    /**
     * Учет веса: A - по умолчанию расчитывается автоматически, но можно менять; M - обязательно задавать вручную
     */
    public char getWeight_control() {
        return Weight_control;
    }

    public void setPurchasing_price(double value) {
        setPurchasing_price(new Double(value));
    }

    public void setPurchasing_price(Double value) {
        this.Purchasing_price = value;
    }

    public Double getPurchasing_price() {
        return Purchasing_price;
    }

    public void setInternal_price(double value) {
        setInternal_price(new Double(value));
    }

    public void setInternal_price(Double value) {
        this.Internal_price = value;
    }

    public Double getInternal_price() {
        return Internal_price;
    }

    public void setStorage_price(double value) {
        setStorage_price(new Double(value));
    }

    public void setStorage_price(Double value) {
        this.Storage_price = value;
    }

    public Double getStorage_price() {
        return Storage_price;
    }

    public void setRelease_price(double value) {
        setRelease_price(new Double(value));
    }

    public void setRelease_price(Double value) {
        this.Release_price = value;
    }

    public Double getRelease_price() {
        return Release_price;
    }

    /**
     * Указывает, что товар заведен менеджером на складе
     */
    public void setManager_made(char value) {
        this.Manager_made = value;
    }

    /**
     * Указывает, что товар заведен менеджером на складе
     */
    public char getManager_made() {
        return Manager_made;
    }

    /**
     * код системы документооборота
     */
    public void setSdid(String value) {
        this.Sdid = value;
    }

    /**
     * код системы документооборота
     */
    public String getSdid() {
        return Sdid;
    }

    /**
     * Признак негабаритного товара
     */
    public void setSizeless(char value) {
        this.Sizeless = value;
    }

    /**
     * Признак негабаритного товара
     */
    public char getSizeless() {
        return Sizeless;
    }

    /**
     * Режим хранения
     */
    public void setPos(int value) {
        this.Pos = value;
    }

    /**
     * Режим хранения
     */
    public int getPos() {
        return Pos;
    }

    /**
     * Единиц товара доступных для планирования
     */
    public void setSummary_units(int value) {
        setSummary_units(new Integer(value));
    }

    /**
     * Единиц товара доступных для планирования
     */
    public void setSummary_units(Integer value) {
        this.Summary_units = value;
    }

    /**
     * Единиц товара доступных для планирования
     */
    public Integer getSummary_units() {
        return Summary_units;
    }

    /**
     * Зарезервированное количество под заказы
     */
    public void setReserved(int value) {
        setReserved(new Integer(value));
    }

    /**
     * Зарезервированное количество под заказы
     */
    public void setReserved(Integer value) {
        this.Reserved = value;
    }

    /**
     * Зарезервированное количество под заказы
     */
    public Integer getReserved() {
        return Reserved;
    }

    /**
     * Количество паллетных ярусов
     */
    public void setPallet_stack_size(int value) {
        setPallet_stack_size(new Integer(value));
    }

    /**
     * Количество паллетных ярусов
     */
    public void setPallet_stack_size(Integer value) {
        this.Pallet_stack_size = value;
    }

    /**
     * Количество паллетных ярусов
     */
    public Integer getPallet_stack_size() {
        return Pallet_stack_size;
    }

    /**
     * Максимальная высота грузов в ячейке, -1 - неограниченч
     */
    public void setMax_load_height(int value) {
        setMax_load_height(new Integer(value));
    }

    /**
     * Максимальная высота грузов в ячейке, -1 - неограниченч
     */
    public void setMax_load_height(Integer value) {
        this.Max_load_height = value;
    }

    /**
     * Максимальная высота грузов в ячейке, -1 - неограниченч
     */
    public Integer getMax_load_height() {
        return Max_load_height;
    }

    /**
     * ABC class of SKU (A,B,C,D)
     */
    public void setAbc_class(char value) {
        this.Abc_class = value;
    }

    /**
     * ABC class of SKU (A,B,C,D)
     */
    public char getAbc_class() {
        return Abc_class;
    }

    /**
     * Оператор, производивший применение расчетного значение
     */
    public void setAbc_class_operator(String value) {
        this.Abc_class_operator = value;
    }

    /**
     * Оператор, производивший применение расчетного значение
     */
    public String getAbc_class_operator() {
        return Abc_class_operator;
    }

    /**
     * Время применения расчетного значения
     */
    public void setAbc_class_date(java.sql.Timestamp value) {
        this.Abc_class_date = value;
    }

    /**
     * Время применения расчетного значения
     */
    public java.sql.Timestamp getAbc_class_date() {
        return Abc_class_date;
    }

    /**
     * ABC class of SKU (A,B,C,D)
     */
    public void setCalc_abc_class(char value) {
        this.Calc_abc_class = value;
    }

    /**
     * ABC class of SKU (A,B,C,D)
     */
    public char getCalc_abc_class() {
        return Calc_abc_class;
    }

    /**
     * Оператор, производивший расчет
     */
    public void setCalc_abc_class_operator(String value) {
        this.Calc_abc_class_operator = value;
    }

    /**
     * Оператор, производивший расчет
     */
    public String getCalc_abc_class_operator() {
        return Calc_abc_class_operator;
    }

    /**
     * Время пересчета
     */
    public void setCalc_abc_class_date(java.sql.Timestamp value) {
        this.Calc_abc_class_date = value;
    }

    /**
     * Время пересчета
     */
    public java.sql.Timestamp getCalc_abc_class_date() {
        return Calc_abc_class_date;
    }

    /**
     * Флаг нового товара
     */
    public void setIs_new(char value) {
        this.Is_new = value;
    }

    /**
     * Флаг нового товара
     */
    public char getIs_new() {
        return Is_new;
    }

    /**
     * is it kitting object
     */
    public void setIs_kit(char value) {
        this.Is_kit = value;
    }

    /**
     * is it kitting object
     */
    public char getIs_kit() {
        return Is_kit;
    }

    /**
     * Тара/не тара
     */
    public void setIs_tara(char value) {
        this.Is_tara = value;
    }

    /**
     * Тара/не тара
     */
    public char getIs_tara() {
        return Is_tara;
    }

    /**
     * Производитель
     */
    public void setProducer(String value) {
        this.Producer = value;
    }

    /**
     * Производитель
     */
    public String getProducer() {
        return Producer;
    }

    /**
     * Поставщик
     */
    public void setVendor(String value) {
        this.Vendor = value;
    }

    /**
     * Поставщик
     */
    public String getVendor() {
        return Vendor;
    }

    /**
     * Владелец
     */
    public void setHolder_id(int value) {
        setHolder_id(new Integer(value));
    }

    /**
     * Владелец
     */
    public void setHolder_id(Integer value) {
        this.Holder_id = value;
    }

    /**
     * Владелец
     */
    public Integer getHolder_id() {
        return Holder_id;
    }

    /**
     * Страна происхождения (Country Of Origin)
     */
    public void setCoo(String value) {
        this.Coo = value;
    }

    /**
     * Страна происхождения (Country Of Origin)
     */
    public String getCoo() {
        return Coo;
    }

    /**
     * Флаг требования ввода товарной партии для груза при приеме/создании
     */
    public void setLot_capture_req(char value) {
        this.Lot_capture_req = value;
    }

    /**
     * Флаг требования ввода товарной партии для груза при приеме/создании
     */
    public char getLot_capture_req() {
        return Lot_capture_req;
    }

    /**
     * Класс опасности
     */
    public void setHazardous(char value) {
        setHazardous(new Character(value));
    }

    /**
     * Класс опасности
     */
    public void setHazardous(Character value) {
        this.Hazardous = value;
    }

    /**
     * Класс опасности
     */
    public Character getHazardous() {
        return Hazardous;
    }

    /**
     * Флаг необходимости печати товарных этикеток при приеме
     */
    public void setLabels_req(char value) {
        this.Labels_req = value;
    }

    /**
     * Флаг необходимости печати товарных этикеток при приеме
     */
    public char getLabels_req() {
        return Labels_req;
    }

    /**
     * Уходимость товара
     */
    public void setVelocity(int value) {
        this.Velocity = value;
    }

    /**
     * Уходимость товара
     */
    public int getVelocity() {
        return Velocity;
    }

    /**
     * Кешируемость
     */
    public void setCached(char value) {
        this.Cached = value;
    }

    /**
     * Кешируемость
     */
    public char getCached() {
        return Cached;
    }

    public void setQc_percent(int value) {
        this.Qc_percent = value;
    }

    public int getQc_percent() {
        return Qc_percent;
    }

    public void setNeg_pick_prc(int value) {
        this.Neg_pick_prc = value;
    }

    public int getNeg_pick_prc() {
        return Neg_pick_prc;
    }

    /**
     * Минимальный процентный остаточный срок годности (ОСГ%) для приёмки
     */
    public void setShl_prc(int value) {
        this.Shl_prc = value;
    }

    /**
     * Минимальный процентный остаточный срок годности (ОСГ%) для приёмки
     */
    public int getShl_prc() {
        return Shl_prc;
    }

    /**
     * Флаг разрешения проверки перекрестной погрузки
     */
    public void setCan_crossdock(char value) {
        this.Can_crossdock = value;
    }

    /**
     * Флаг разрешения проверки перекрестной погрузки
     */
    public char getCan_crossdock() {
        return Can_crossdock;
    }

    /**
     * код товара поставщика
     */
    public void setVendor_sku(String value) {
        this.Vendor_sku = value;
    }

    /**
     * код товара поставщика
     */
    public String getVendor_sku() {
        return Vendor_sku;
    }

    public void setSertificat(String value) {
        this.Sertificat = value;
    }

    public String getSertificat() {
        return Sertificat;
    }

    public void setLabel(String value) {
        this.Label = value;
    }

    public String getLabel() {
        return Label;
    }

    public void setSort_key1(int value) {
        this.Sort_key1 = value;
    }

    public int getSort_key1() {
        return Sort_key1;
    }

    public void setSort_key2(int value) {
        this.Sort_key2 = value;
    }

    public int getSort_key2() {
        return Sort_key2;
    }

    public void setSort_key3(int value) {
        this.Sort_key3 = value;
    }

    public int getSort_key3() {
        return Sort_key3;
    }

    public void setProduct_life(int value) {
        this.Product_life = value;
    }

    public int getProduct_life() {
        return Product_life;
    }

    public void setHold_days(int value) {
        setHold_days(new Integer(value));
    }

    public void setHold_days(Integer value) {
        this.Hold_days = value;
    }

    public Integer getHold_days() {
        return Hold_days;
    }

    /**
     * FEFO интервал - используется при планировании заказов
     */
    public void setDday_interval(int value) {
        this.Dday_interval = value;
    }

    /**
     * FEFO интервал - используется при планировании заказов
     */
    public int getDday_interval() {
        return Dday_interval;
    }

    /**
     * Экономичный FIFO интервал - используется при планировании заказов
     */
    public void setTime_fence(int value) {
        setTime_fence(new Integer(value));
    }

    /**
     * Экономичный FIFO интервал - используется при планировании заказов
     */
    public void setTime_fence(Integer value) {
        this.Time_fence = value;
    }

    /**
     * Экономичный FIFO интервал - используется при планировании заказов
     */
    public Integer getTime_fence() {
        return Time_fence;
    }

    /**
     * Класс товара для учета по биллингу
     */
    public void setBilling_class(int value) {
        setBilling_class(new Integer(value));
    }

    /**
     * Класс товара для учета по биллингу
     */
    public void setBilling_class(Integer value) {
        this.Billing_class = value;
    }

    /**
     * Класс товара для учета по биллингу
     */
    public Integer getBilling_class() {
        return Billing_class;
    }

    /**
     * Разрешение работы с товаром в динамическом режиме
     */
    public void setAuto_fp_flag(char value) {
        this.Auto_fp_flag = value;
    }

    /**
     * Разрешение работы с товаром в динамическом режиме
     */
    public char getAuto_fp_flag() {
        return Auto_fp_flag;
    }

    /**
     * состояние
     */
    public void setUsage_state(char value) {
        this.Usage_state = value;
    }

    /**
     * состояние
     */
    public char getUsage_state() {
        return Usage_state;
    }

    /**
     * Необходимость регистрации серийных номеров при приемке и упаковке
     */
    public void setSerial_num_track(int value) {
        setSerial_num_track(new Integer(value));
    }

    /**
     * Необходимость регистрации серийных номеров при приемке и упаковке
     */
    public void setSerial_num_track(Integer value) {
        this.Serial_num_track = value;
    }

    /**
     * Необходимость регистрации серийных номеров при приемке и упаковке
     */
    public Integer getSerial_num_track() {
        return Serial_num_track;
    }

    /**
     * Маркер для правил разбора штрихкодов серийных номеров
     */
    public void setSerial_num_rule(String value) {
        this.Serial_num_rule = value;
    }

    /**
     * Маркер для правил разбора штрихкодов серийных номеров
     */
    public String getSerial_num_rule() {
        return Serial_num_rule;
    }

    /**
     * Код товара производителя
     */
    public void setArticle(String value) {
        this.Article = value;
    }

    /**
     * Код товара производителя
     */
    public String getArticle() {
        return Article;
    }

    /**
     * Коэффициент трансформации количества при уведомлении хост-системы
     */
    public void setHost_transform_factor(double value) {
        this.Host_transform_factor = value;
    }

    /**
     * Коэффициент трансформации количества при уведомлении хост-системы
     */
    public double getHost_transform_factor() {
        return Host_transform_factor;
    }

    /**
     * Record modification TIMESTAMP(0)
     */
    public void setCreated(java.sql.Timestamp value) {
        this.Created = value;
    }

    /**
     * Record modification TIMESTAMP(0)
     */
    public java.sql.Timestamp getCreated() {
        return Created;
    }

    /**
     * System user name
     */
    public void setCreated_by(String value) {
        this.Created_by = value;
    }

    /**
     * System user name
     */
    public String getCreated_by() {
        return Created_by;
    }

    /**
     * Дата последнего изменения
     */
    public void setModified(java.sql.Timestamp value) {
        this.Modified = value;
    }

    /**
     * Дата последнего изменения
     */
    public java.sql.Timestamp getModified() {
        return Modified;
    }

    /**
     * Пользователь изменивший запись
     */
    public void setModified_by(String value) {
        this.Modified_by = value;
    }

    /**
     * Пользователь изменивший запись
     */
    public String getModified_by() {
        return Modified_by;
    }

    public void setBulk_qty(int value) {
        this.Bulk_qty = value;
    }

    public int getBulk_qty() {
        return Bulk_qty;
    }

    /**
     * Учёт SSCC
     */
    public void setSscc_control(char value) {
        setSscc_control(new Character(value));
    }

    /**
     * Учёт SSCC
     */
    public void setSscc_control(Character value) {
        this.Sscc_control = value;
    }

    /**
     * Учёт SSCC
     */
    public Character getSscc_control() {
        return Sscc_control;
    }

    /**
     * Единица измерения срока жизни товара: Day, Hour, Month
     */
    public void setProduct_life_measure(char value) {
        this.Product_life_measure = value;
    }

    /**
     * Единица измерения срока жизни товара: Day, Hour, Month
     */
    public char getProduct_life_measure() {
        return Product_life_measure;
    }

    /**
     * Единица измерения времени хранения товара: Day, Hour, Month
     */
    public void setShelf_life_measure(char value) {
        this.Shelf_life_measure = value;
    }

    /**
     * Единица измерения времени хранения товара: Day, Hour, Month
     */
    public char getShelf_life_measure() {
        return Shelf_life_measure;
    }

    /**
     * Количество штук для отбора проб при приемке
     */
    public void setSample_units(int value) {
        setSample_units(new Integer(value));
    }

    /**
     * Количество штук для отбора проб при приемке
     */
    public void setSample_units(Integer value) {
        this.Sample_units = value;
    }

    /**
     * Количество штук для отбора проб при приемке
     */
    public Integer getSample_units() {
        return Sample_units;
    }

    /**
     * Record usage state: A - active, I - inactive, D - deleted
     */
    public void setRec_usage_state(char value) {
        this.Rec_usage_state = value;
    }

    /**
     * Record usage state: A - active, I - inactive, D - deleted
     */
    public char getRec_usage_state() {
        return Rec_usage_state;
    }

    /**
     * Product specification
     */
    public void setSku_spec_id(int value) {
        this.Sku_spec_id = value;
    }

    /**
     * Product specification
     */
    public int getSku_spec_id() {
        return Sku_spec_id;
    }

    /**
     * Product storage conditions
     */
    public void setStorage_cond_id(int value) {
        this.Storage_cond_id = value;
    }

    /**
     * Product storage conditions
     */
    public int getStorage_cond_id() {
        return Storage_cond_id;
    }

    /**
     * Сезон
     */
    public void setSeason_id(int value) {
        setSeason_id(new Integer(value));
    }

    /**
     * Сезон
     */
    public void setSeason_id(Integer value) {
        this.Season_id = value;
    }

    /**
     * Сезон
     */
    public Integer getSeason_id() {
        return Season_id;
    }

    /**
     * Количество единиц в МЮ
     */
    public void setMu_units(int value) {
        setMu_units(new Integer(value));
    }

    /**
     * Количество единиц в МЮ
     */
    public void setMu_units(Integer value) {
        this.Mu_units = value;
    }

    /**
     * Количество единиц в МЮ
     */
    public Integer getMu_units() {
        return Mu_units;
    }

    /**
     * Штрихкод метроюнита
     */
    public void setMu_barcode(String value) {
        this.Mu_barcode = value;
    }

    /**
     * Штрихкод метроюнита
     */
    public String getMu_barcode() {
        return Mu_barcode;
    }

    /**
     * декодированный код артикула
     */
    public void setArticle_n(String value) {
        this.Article_n = value;
    }

    /**
     * декодированный код артикула
     */
    public String getArticle_n() {
        return Article_n;
    }

    public String toString() {
        return String.valueOf(getId());
    }

}

Insert into sv_hvoc (VAL_ID, HVOC_VAL_ID, VOC_ID, VAL_FULL, VAL_SHORT, VAL_STATE, VAL_CHANGES, TOOLS, DATA_BEGIN,
                     DATA_END, MASTER_VAL_ID, POLICE_CODE)
values ('KB_TZK24514', 'KB_TZK24513', 'KB_TZK', 'ЗАКАЗЧИК', 'ЗАК', 'Active', 'Allowed', null,
        to_date('09.04.02', 'DD.MM.RR'), null, null, '037700');

-- 'KB_PER24667', -- Междугородняя. виды перевозок transportationType
-- 'KB_TRN24662', -- АвтоМобильный,  transportType
Insert into sv_hvoc (VAL_ID,HVOC_VAL_ID,VOC_ID,VAL_FULL,VAL_SHORT,VAL_STATE,VAL_CHANGES,TOOLS,DATA_BEGIN,DATA_END,MASTER_VAL_ID,POLICE_CODE)
values ('KB_PER24667','KB_PER24665','KB_PER','Междугородняя','МГ','Active','Allowed',null,to_date('11.04.02','DD.MM.RR'),null,null,'037700');
values ('KB_TRN24662','KB_TRN24661','KB_TRN','АвтоМобильный','А/М','Active','Allowed',null,to_date('10.04.02','DD.MM.RR'),null,null,'037700');

Insert into kb_zak (ID, FK_ID, ID_TIP_ZAK, ID_TIP_ZAK2, INN_ZAK, ID_KLIENT, ID_KOPF, N_ZAK, NAIMEN, ID_STRANA, P_IND,
                    UR_ADR, FIO, TLF, FAX, EMAIL, WEB, FIO_KNT, RS, BRS, KS, BKS, BIK, OKPO, OKONX, ID_OKONX, ACCOUNT,
                    BACCOUNT, SWIFT, LICEN, DT_LICEN, PRIM, ID_VED, ORA_USER_EDIT_ROW_NAME, ORA_USER_EDIT_ROW_DATE,
                    ORA_USER_EDIT_ROW_LOCK, DT_REG, FIO_REC, ID_IST, ID_FL, DT_END, KPP_ZAK, ROW_CREATOR,
                    ROW_CREATION_TIME, N_ENG, ADR_ENG, C_ACCOUNT, BACC_INT, SWIFT_INT, FIO_ROD, ID_USR, TLF_SMST,
                    RUS_SMS, TIR_VOD, DT_LICEN_END, INS_MAIL, KOD_NO, IS_CAR, IS_SUP, IS_HOLDER, IS_CUST, ID_WMS,
                    ID_INFO, PRF_WMS, DN_DOST, ID_NO_ACCEPT, P_IN, P_OUT, P_KOL, LIST_REG, AM_ORD, DOV_INF, ID_SVH)
values ('0102304213', null, 'KB_TZK24514', null, '0', '300185', null, 'TEST 0406187', 'TEST 04067', 'CONTRY44131', null,
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, 'YES_NO5417', 'SKP', to_date('23.03.21', 'DD.MM.RR'), '0', to_date('04.06.18', 'DD.MM.RR'),
        null, null, 'YES_NO5417', null, null, 'SPRUT4', to_date('04.06.18', 'DD.MM.RR'), null, null, null, null, null,
        null, 'KB_USR99992', null, null, '0', null, null, null, '1', '1', '1', '1', '10315', null, 'TSM', null,
        'YES_NO5417', null, null, null, '1', null, null, null);



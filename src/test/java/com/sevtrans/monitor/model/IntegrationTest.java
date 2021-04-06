package com.sevtrans.monitor.model;

import com.sevtrans.monitor.repository.CustomerDao;
import com.sevtrans.monitor.repository.ShvocDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Sql({"/components-data.sql"})
@DataJpaTest
public class IntegrationTest {

//    @Autowired
//    ShvocDao shvocDao;
    @Autowired
    CustomerDao customerDao;

    @Test
    void first() {
        Customer customer = customerDao.findByClientID(300185);
        System.out.println(customer);
        System.out.println("WTF!");
//        Shvoc shvoc = new Shvoc();
//        shvoc.setHvoc_val_id("01");
//        Shvoc t=shvocDao.save(shvoc);
//        System.out.println(t.getVal_id());
//        Shvoc shvoc1=new Shvoc();
//         t=shvocDao.save(shvoc1);
//        System.out.println(t.getVal_id());
    }
}

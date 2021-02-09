package com.sevtrans.monitor.model;

import com.sevtrans.monitor.repository.ShvocDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class IntegrationTest {

    @Autowired
    ShvocDao shvocDao;

    @Test
    void first() {
        Shvoc shvoc = new Shvoc();
        shvoc.setHvoc_val_id("01");
        Shvoc t=shvocDao.save(shvoc);
        System.out.println(t.getVal_id());
        Shvoc shvoc1=new Shvoc();
         t=shvocDao.save(shvoc1);
        System.out.println(t.getVal_id());

    }
}

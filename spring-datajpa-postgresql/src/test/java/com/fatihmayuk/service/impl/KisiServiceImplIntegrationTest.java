package com.fatihmayuk.service.impl;

import com.fatihmayuk.dto.KisiDto;
import com.fatihmayuk.entity.Adres;
import com.fatihmayuk.entity.Kisi;
import com.fatihmayuk.repository.AdresRepository;
import com.fatihmayuk.service.KisiService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class KisiServiceImplIntegrationTest {

    @Autowired
    private KisiService kisiService;

    @Autowired
    private AdresRepository adresRepository;

    @Test
    void testSave() {
        KisiDto kisiDto = new KisiDto();
        kisiDto.setAdi("Test-Name");
        kisiDto.setSoyadi("Test-Lastname");
        kisiDto.setAdresler(Arrays.asList("Test-Adres-1"));

        KisiDto result = kisiService.save(kisiDto);

        List<Adres> list = adresRepository.findAll();

        assertTrue(result.getId() > 0L);
        assertEquals(list.size(),1);

    }
}

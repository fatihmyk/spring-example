package com.fatihmayuk.service.impl;

import com.fatihmayuk.dto.KisiDto;
import com.fatihmayuk.entity.Adres;
import com.fatihmayuk.entity.Kisi;
import com.fatihmayuk.repository.AdresRepository;
import com.fatihmayuk.repository.KisiRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class KisiServiceImplTest {

    @InjectMocks
    private KisiServiceImpl kisiService;

    @Mock
    private KisiRepository kisiRepository;

    @Mock
    private AdresRepository adresRepository;

    @Test
    public void testSave() {
        KisiDto kisiDto = new KisiDto();
        kisiDto.setAdi("Test-Name");
        kisiDto.setSoyadi("Test-Lastname");
        kisiDto.setAdresler(Arrays.asList("Test-Adres-1"));
        Kisi kisiMock = mock(Kisi.class);

        when(kisiMock.getId()).thenReturn(1L);
        when(kisiRepository.save(any(Kisi.class))).thenReturn(kisiMock);
        KisiDto result = kisiService.save(kisiDto);

       assertEquals(result.getAdi(), kisiDto.getAdi());
       assertEquals(result.getId(), 1L);
    }

    @Test
    void testSaveException() {
        KisiDto kisiDto = new KisiDto();
        kisiDto.setSoyadi("Test-Lastname");
        kisiDto.setAdresler(Arrays.asList("Test-Adres-1"));

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            kisiService.save(kisiDto);
        } );
    }

    @Test
    void testGetAll() {
        Kisi kisi = new Kisi();
        kisi.setId(1L);
        kisi.setAdi("Test-name");
        kisi.setSoyadi("Test-lastname");

        when(kisiRepository.findAll()).thenReturn(Collections.singletonList(kisi));
        List<KisiDto> kisiDtos = kisiService.getAll();

        assertEquals(kisiDtos.size(),1);
        assertEquals(kisiDtos.get(0), KisiDto.builder().id(1L).build());
    }

    @Test
    void testGetAllWithAdress() {
        Kisi kisi = new Kisi();
        kisi.setId(1L);
        kisi.setAdi("Test-name");
        kisi.setSoyadi("Test-lastname");

        Adres adres = new Adres();
        adres.setAdresTipi(Adres.AdresTipi.DIGER);
        adres.setAdres("Test-Adres");
        kisi.setAdresleri(Collections.singletonList(adres));

        when(kisiRepository.findAll()).thenReturn(Collections.singletonList(kisi));
        List<KisiDto> kisiDtos = kisiService.getAll();

        //assertEquals(kisiDtos.size(),1);
        //assertEquals(kisiDtos.get(0), KisiDto.builder().id(1L).build());
        assertEquals(kisiDtos.get(0).getAdresler().size(), 1);

    }

    @Test
    void delete() {
    }

    @Test
    void getAll() {
    }


}
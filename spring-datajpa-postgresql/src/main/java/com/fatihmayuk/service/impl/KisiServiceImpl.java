package com.fatihmayuk.service.impl;

import com.fatihmayuk.dto.KisiDto;
import com.fatihmayuk.entity.Adres;
import com.fatihmayuk.entity.Kisi;
import com.fatihmayuk.repository.AdresRepository;
import com.fatihmayuk.repository.KisiRepository;
import com.fatihmayuk.service.KisiService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class KisiServiceImpl implements KisiService {

    private final KisiRepository kisiRepository;
    private final AdresRepository adresRepository;

    @Override
    @Transactional
    public KisiDto save(KisiDto kisiDto) {
        Assert.notNull(kisiDto.getAdi(), "Adi Alani Zorunludur Bos Gecilemez !");

        Kisi kisi = new Kisi();
        kisi.setAdi(kisiDto.getAdi());
        kisi.setSoyadi(kisiDto.getSoyadi());
        final  Kisi kisiDb = kisiRepository.save(kisi);

        List<Adres> liste = new ArrayList<>();
        kisiDto.getAdresler().forEach(item ->{
            Adres adres = new Adres();
            adres.setAdres(item);
            adres.setAdresTipi(Adres.AdresTipi.DIGER);
            adres.setAktif(true);
            adres.setKisi(kisiDb); //sonradan
            liste.add(adres);
        } );
          adresRepository.saveAll(liste);
          //kisi.setAdresleri(liste);
          kisiDto.setId(kisiDb.getId());
          return kisiDto;

    }

    @Override
    public void delete(Long id) {
    }

    @Override
    public List<KisiDto> getAll() {
       List<Kisi> kisiler = kisiRepository.findAll();
       List<KisiDto> kisiDtos = new ArrayList<>();

       kisiler.forEach(item -> {
           KisiDto kisiDto = new KisiDto();
           kisiDto.setId(item.getId());
           kisiDto.setAdi(item.getAdi());
           kisiDto.setSoyadi(item.getSoyadi());
           kisiDto.setAdresler(item.getAdresleri() != null ?
                   item.getAdresleri().stream().map(Adres::getAdres).collect(Collectors.toList())
                   : null);
           kisiDtos.add(kisiDto);
       });
        return kisiDtos;
    }

    @Override
    public Page<Kisi> getAll(Pageable pageable) {
        return null;
    }
}

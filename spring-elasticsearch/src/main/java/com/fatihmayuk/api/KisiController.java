package com.fatihmayuk.api;

import com.fatihmayuk.entity.Kisi;
import com.fatihmayuk.repository.KisiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/kisi")
public class KisiController {

    private final KisiRepository kisiRepository;

    @PostConstruct
    public void init(){
        Kisi kisi = new Kisi();
        kisi.setAd("Fatih");
        kisi.setSoyad("Mayuk");
        kisi.setAdres("Kale");
        kisi.setDogumTarihi(Calendar.getInstance().getTime());
        kisi.setId("K0001");
        kisiRepository.save(kisi);
    }

    @GetMapping("/{search}")
    public ResponseEntity<List<Kisi>> getKisi(@PathVariable String search) {

       // List<Kisi> kisiler = kisiRepository.getByCustomQuery(search);
        List<Kisi> kisiler = kisiRepository.getByAdLikeOrSoyadLike(search,search);
        return ResponseEntity.ok(kisiler);

    }
}

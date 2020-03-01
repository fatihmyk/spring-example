package com.fatihmayuk;

import com.fatihmayuk.dto.KisiDto;
import com.fatihmayuk.service.impl.KisiServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kisi")
@RequiredArgsConstructor
public class KisiKontroller {

    private final KisiServiceImpl kisiServiceImpl;


    @PostMapping
    public ResponseEntity<KisiDto> ekle(@RequestBody KisiDto kisiDto) {

        return ResponseEntity.ok(kisiServiceImpl.save(kisiDto));

    }

    @GetMapping
    public ResponseEntity<List<KisiDto>> tumunuListele() {
        return ResponseEntity.ok(kisiServiceImpl.getAll());
    }



}

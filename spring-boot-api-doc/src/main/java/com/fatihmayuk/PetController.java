package com.fatihmayuk;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/pet")
@Api(value = "Pet API Dokumantasyonum")
public class PetController {

    private List<PetDto> petList = new ArrayList<>();

    @PostConstruct
    public void init(){

        petList.add(new PetDto(1,"Test Pet", new Date()));

    }

    @PostMapping
    @ApiOperation(value = "Yeni pet ekleme metodu", notes = "Bu metodu dikkatli kullan")
    public ResponseEntity<PetDto> ekle(@RequestBody @ApiParam(value = "hayvan nesnesi")PetDto petDto) {
        petList.add(petDto);
        return ResponseEntity.ok(petDto);
    }

    @GetMapping
    @ApiOperation(value = "Petleri listeleme metodu", notes = "Bu metod petlerin tumunu getirir.")
    public ResponseEntity<List<PetDto>> tumunuListele() {
        return ResponseEntity.ok(petList);
    }
}

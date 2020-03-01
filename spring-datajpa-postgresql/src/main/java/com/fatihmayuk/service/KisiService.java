package com.fatihmayuk.service;

import com.fatihmayuk.dto.KisiDto;
import com.fatihmayuk.entity.Kisi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface KisiService {

     KisiDto save(KisiDto kisiDto);

     void delete(Long id);

     List<KisiDto> getAll();

     Page<Kisi> getAll(Pageable pageable);
}

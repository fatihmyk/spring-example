package com.fatihmayuk.repository;

import com.fatihmayuk.entity.Kullanici;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface KullaniciRepository extends MongoRepository<Kullanici,String> {


}

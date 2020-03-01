package com.fatihmayuk.repository;

import com.fatihmayuk.entity.Kisi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KisiRepository  extends JpaRepository<Kisi,Long> {
}

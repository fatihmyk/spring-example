package com.fatihmayuk.aop.service;

import org.springframework.stereotype.Service;

@Service
public class IkinciMesajService {

    public void mesaj(String message){
        System.out.println(message);
    }
}

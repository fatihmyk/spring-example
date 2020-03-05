package com.fatihmayuk.pagination.api;

import com.fatihmayuk.pagination.model.Book;
import com.fatihmayuk.pagination.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookApi {

    private final BookRepository bookRepository;

    @GetMapping
    public Page<Book> pagination(@RequestParam Integer pageSize, @RequestParam Integer page){

        Pageable pageable = PageRequest.of(page,pageSize);
        return bookRepository.findAll(pageable);
    }

    @GetMapping("/p")
    public Page<Book> pagination(Pageable pageable){
        //totalElements count query maaliyetlidir. Bir nevi full scan eder.
        return bookRepository.findAll(pageable);
    }

    @GetMapping("/s")
    public Slice<Book> slice(Pageable pageable){
        // Kac kayit var ilgilenmiyor. Sadece pagination devami var mi ona bakiyor. Mesela 3 sayfa istediysek 4 sorgu atiyor.
        return bookRepository.findAll(pageable);
    }
}

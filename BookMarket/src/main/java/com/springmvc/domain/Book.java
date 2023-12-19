package com.springmvc.domain;

import lombok.*;

@Getter
@Setter
//@AllArgsConstructor // 파라미터가 들어가는 생성자
@NoArgsConstructor  // 일반 생성자

public class Book {
    private String bookId;            // 도서Id
    private String name;              // 도서명
    private int unitPrice;         // 도서 가격
    private String author;            // 저자
    private String description;       // 설명
    private String publisher;         // 출판사
    private String category;          //분류
    private long unitsInStock;           // 재고
    private String releaseDate;       // 출판일(월/년)
    private String condition;         // 신규 도서 또는 중고 도서 또는 전자책


    public Book(String bookId, String name, int unitPrice) {
        this.bookId = bookId;
        this.name = name;
        this.unitPrice = unitPrice;
    }
}

package com.sparta.week04.repository;

import lombok.Getter;

@Getter
//상품 생성
public class ProductRequestDto {
    // title, link, image, lprice
    private String title;
    private String link;
    private String image;
    private int lprice;

}

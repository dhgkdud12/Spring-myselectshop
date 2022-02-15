package com.sparta.week04.utils;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class NaverShopSearch {
    public String search() {
        RestTemplate rest = new RestTemplate(); //rest Template
        HttpHeaders headers = new HttpHeaders(); //헤더 생성
        headers.add("X-Naver-Client-Id", "sm6a0kT4QF91wheMCrpP");
        headers.add("X-Naver-Client-Secret", "pPNTnZEwDC");
        String body = "";

        HttpEntity<String> requestEntity = new HttpEntity<String>(body, headers);
        ResponseEntity<String> responseEntity = rest.exchange("https://openapi.naver.com/v1/search/shop.json?query=아디다스", HttpMethod.GET, requestEntity, String.class);
        HttpStatus httpStatus = responseEntity.getStatusCode();
        int status = httpStatus.value(); //200 - 잘 받아옴을 의미
        String response = responseEntity.getBody(); // 문자열
        System.out.println("Response status: " + status);
        System.out.println(response);

        return response;
    }

    public static void main(String[] args) {
        NaverShopSearch naverShopSearch = new NaverShopSearch();
        naverShopSearch.search();
    }
}

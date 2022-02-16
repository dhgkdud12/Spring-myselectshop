package com.sparta.week04.utils;

import com.sparta.week04.repository.ItemDto;
import org.graalvm.compiler.lir.CompositeValue;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component //컴포넌트 등록
public class NaverShopSearch {
    public String search(String query) {
        RestTemplate rest = new RestTemplate(); //rest Template
        HttpHeaders headers = new HttpHeaders(); //헤더 생성
        headers.add("X-Naver-Client-Id", "sm6a0kT4QF91wheMCrpP");
        headers.add("X-Naver-Client-Secret", "pPNTnZEwDC");
        String body = "";

        HttpEntity<String> requestEntity = new HttpEntity<String>(body, headers);
        ResponseEntity<String> responseEntity = rest.exchange("https://openapi.naver.com/v1/search/shop.json?query="+query, HttpMethod.GET, requestEntity, String.class);
        HttpStatus httpStatus = responseEntity.getStatusCode();
        int status = httpStatus.value(); //200 - 잘 받아옴을 의미
        String response = responseEntity.getBody(); // 문자열
        System.out.println("Response status: " + status);
//        System.out.println("response: "+ response);

        return response;
    }

    public List<ItemDto> fromJSONtoItems(String result) {
        JSONObject rjson = new JSONObject(result);
        JSONArray items  = rjson.getJSONArray("items");

        List<ItemDto> ret = new ArrayList<>();
        for (int i=0; i<items.length(); i++) {
            JSONObject itemJson = items.getJSONObject(i);
            System.out.println("itemJson: " + itemJson);
            ItemDto itemDto = new ItemDto(itemJson);
            ret.add(itemDto);
            System.out.println("ret: "+ret);
        }
        return ret; //타이틀, 링크, 이미지, 가격 담은 리스트 반환 
    }

    public static void main(String[] args) {
        NaverShopSearch naverShopSearch = new NaverShopSearch();
        String result = naverShopSearch.search("puma");
        System.out.println(naverShopSearch.fromJSONtoItems(result));;
    }
}

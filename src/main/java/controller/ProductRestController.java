package controller;

import com.sparta.week04.repository.Product;
import com.sparta.week04.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor// final로 선언된 멤버 변수를 자동으로 생성
@RestController // JSON
public class ProductRestController {

    private final ProductRepository productRepository;

    // 등록된 전체 상품 목록 조회
    @GetMapping("/api/products")
    public List<Product> getProducts () {
        return productRepository.findAll();
    }
}

package service;

import com.sparta.week04.repository.Product;
import com.sparta.week04.repository.ProductMypriceRequestDto;
import com.sparta.week04.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class ProductService {

    public final ProductRepository productRepository;

    @Transactional
    public Long update(Long id, ProductMypriceRequestDto requestDto){
        Product product = productRepository.findById(id).orElseThrow(
                ()->new NullPointerException("아이디가 존재하지 않습니다.")
        );
        product.update(requestDto);
        return id;
    }
}

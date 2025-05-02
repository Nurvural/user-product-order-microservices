package product.product_service.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import product.product_service.dto.ProductRequest;
import product.product_service.entity.Product;
import product.product_service.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product save(ProductRequest request) {
        Product product = Product.builder()
                .name(request.getName())
                .price(request.getPrice())
                .build();
        return productRepository.save(product);
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }
    public boolean productExists(Long id) {
        return productRepository.existsById(id);
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

}
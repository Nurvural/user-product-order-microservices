package product.product_service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import product.product_service.dto.ProductRequest;
import product.product_service.entity.Product;
import product.product_service.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody ProductRequest request) {
        return ResponseEntity.ok(productService.save(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return productService.getProductById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/exists/{id}")
    public ResponseEntity<Boolean> productExists(@PathVariable Long id) {
        boolean exists = productService.productExists(id);
        return ResponseEntity.ok(exists);
    }
    @GetMapping
    public ResponseEntity<List<Product>> list() {
        return ResponseEntity.ok(productService.getAll());
    }
}

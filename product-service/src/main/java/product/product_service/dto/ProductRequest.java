package product.product_service.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequest {

    @NotBlank(message = "Ürün adı boş olamaz")
    private String name;

    @Min(value = 0, message = "Fiyat negatif olamaz")
    private Double price;
}
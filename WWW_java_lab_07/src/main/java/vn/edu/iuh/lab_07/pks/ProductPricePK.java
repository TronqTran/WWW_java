package vn.edu.iuh.lab_07.pks;

import lombok.Getter;
import lombok.Setter;
import vn.edu.iuh.lab_07.models.Product;

import java.io.Serializable;
import java.time.LocalDateTime;

@Setter @Getter
public class ProductPricePK implements Serializable {
    private Product product;
    private LocalDateTime price_date_time;
}

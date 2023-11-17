package vn.edu.iuh.lab_07.pks;

import lombok.Getter;
import lombok.Setter;
import vn.edu.iuh.lab_07.models.Order;
import vn.edu.iuh.lab_07.models.Product;


import java.io.Serializable;

@Setter @Getter
public class OrderDetailPK implements Serializable {
    private Order order;
    private Product product;
}
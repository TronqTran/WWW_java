package vn.edu.iuh.lab_02.services;

import vn.edu.iuh.lab_02.models.Product;
import vn.edu.iuh.lab_02.models.ProductPrice;
import vn.edu.iuh.lab_02.repositories.ProductPriceRepository;
import vn.edu.iuh.lab_02.repositories.ProductRepository;

import java.util.Optional;

public class ProductPriceService {
    private ProductPriceRepository productPriceRepository;
    private ProductRepository productRepository;

    public ProductPriceService() {
        this.productPriceRepository = new ProductPriceRepository();
        this.productRepository = new ProductRepository();
    }

    public boolean addProductPrice(long pId, ProductPrice productPrice){
        Optional<Product> rs = productRepository.findById(pId);
        if(rs.isEmpty()){
            return false;
        }
        productPrice.setProduct(rs.get());
        System.out.println(productPrice.getPriceDateTime().toDate());
        productPriceRepository.addProductPrice(productPrice);

        return true;
    }
}

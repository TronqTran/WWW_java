package vn.edu.iuh.lab_02.services;

import vn.edu.iuh.lab_02.models.Product;
import vn.edu.iuh.lab_02.models.ProductImage;
import vn.edu.iuh.lab_02.repositories.ProductImageRepository;

public class ProductImageService {
    private ProductImageRepository productImageRepository;

    public ProductImageService() {
        this.productImageRepository = new ProductImageRepository();
    }

    public void addProductImage(ProductImage productImage, long productId){
        Product product = new Product();
        product.setProductId(productId);
        productImage.setProduct(product);
        productImageRepository.addProductImage(productImage);
    }

    public void deleteProductImage(long id, long productId){
        productImageRepository.deleteProductImage(id, productId);
    }
}
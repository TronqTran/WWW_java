package vn.edu.iuh.lab_02.services;

import vn.edu.iuh.lab_02.enums.ProductStatus;
import vn.edu.iuh.lab_02.models.Product;
import vn.edu.iuh.lab_02.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

public class ProductService {
    private ProductRepository productRepository;

    public ProductService() {
        this.productRepository = new ProductRepository();
    }

    public void addProduct(Product product){
        product.setStatus(ProductStatus.ACTIVE);
        productRepository.addProduct(product);
    }

    public List<Product> getAll(){
        return productRepository.getAll();
    }

    public Optional<Product> findById(long id){
        return productRepository.findById(id);
    }

    public boolean updateProduct(long id, Product product){
        Optional<Product> rs = productRepository.findById(id);
        if(rs.isEmpty()){
            return false;
        }
        Product existingProduct = rs.get();
        existingProduct.setProductId(id);
        if(product.getDescription() != null){
            existingProduct.setDescription(product.getDescription());
        }
        if(product.getName() != null){
            existingProduct.setName(product.getName());
        }
        if(product.getUnit() != null){
            existingProduct.setUnit(product.getUnit());
        }
        if(product.getManufacturerName() != null){
            existingProduct.setManufacturerName(product.getManufacturerName());
        }
        if(product.getStatus() != null){
            existingProduct.setStatus(product.getStatus());
        }
        productRepository.updateProduct(existingProduct);
        return true;
    }

    public boolean deleteProduct(long id){
        Optional<Product> product = productRepository.findById(id);
        if(product.isEmpty()){
            return false;
        }
        productRepository.deleteProduct(id);
        return true;
    }
}
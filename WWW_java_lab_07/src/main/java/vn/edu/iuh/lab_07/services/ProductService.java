package vn.edu.iuh.lab_07.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vn.edu.iuh.lab_07.enums.ProductStatus;
import vn.edu.iuh.lab_07.models.Product;
import vn.edu.iuh.lab_07.repositories.ProductRepository;

import java.util.Optional;


@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Page<Product> findAll(int page, int limit){
        return productRepository.findAll(PageRequest.of(page - 1, limit).withSort(Sort.by("name").ascending()));
    }

    public Page<Product> findPublishedProduct(int page, int limit){
        return productRepository.findProductByStatusEquals(ProductStatus.ACTIVE, PageRequest.of(page - 1, limit).withSort(Sort.by("name").ascending()));
    }
    public Optional<Product> findById(long id){
        return productRepository.findById(id);
    }

    public void save(Product product){
        productRepository.save(product);
    }

    public void remove(long id){
        productRepository.deleteById(id);
    }
}

package vn.edu.iuh.lab_07.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.lab_07.enums.ProductStatus;
import vn.edu.iuh.lab_07.helpers.ProductHelper;
import vn.edu.iuh.lab_07.models.Product;
import vn.edu.iuh.lab_07.services.ProductService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("")
    public String getProducts(
            Model model,
            @Param("page") Optional<Integer> page,
            @Param("limit")Optional<Integer> limit){

        int currentPage = page.orElse(1);
        int size = limit.orElse(10);
        Page<Product> result = productService.findAll(currentPage, size);
        List<Product> products = result.getContent();
        String[] totalPages = new String[result.getTotalPages()];
        Arrays.fill(totalPages, "");

        model.addAttribute("products", products);
        model.addAttribute("totalPages", totalPages);
        return "admin/product/list";
    }

    @GetMapping("/{id}")
    public String getDetailProduct(@PathVariable("id") long id, Model model){
        Optional<Product> result = productService.findById(id);
        if(result.isEmpty()){
            return "redirect:/admin/products";
        }

        model.addAttribute("product", result.get());
        return "admin/product/detail";
    }

    @GetMapping("/new")
    public String showAddProductForm(Model model){
        Product product = new Product();
        ProductStatus[] productStatuses = ProductStatus.values();

        model.addAttribute("product", product);
        model.addAttribute("productStatuses", productStatuses);
        return "admin/product/from";
    }

    @PostMapping("/save")
    public String addProduct(@ModelAttribute("product")Product product,
                             @RequestParam(value = "price_date_time")String[] priceDateTimes,
                             @RequestParam(value = "price") String[] prices
    ){
        ProductHelper.addProductPrice(priceDateTimes, prices, product);
        productService.save(product);
        return "redirect:/admin/products";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id")long id){
        productService.remove(id);

        return "redirect:/admin/products";
    }

    @GetMapping("/update/{id}")
    public String updateProduct(@PathVariable("id") long id, Model model){
        Optional<Product> result = productService.findById(id);
        if(result.isEmpty()){
            return "redirect:/admin/products";
        }
        ProductStatus[] productStatuses = ProductStatus.values();

        model.addAttribute("product", result.get());
        model.addAttribute("productStatuses", productStatuses);

        return "admin/product/from";
    }
}

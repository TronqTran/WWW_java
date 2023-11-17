package vn.edu.iuh.lab_07.helpers;

import vn.edu.iuh.lab_07.models.Product;
import vn.edu.iuh.lab_07.models.ProductPrice;

import java.time.LocalDateTime;

public class ProductHelper {
    public static void addProductPrice(String[] priceDateTimes, String[] prices, Product product){
        for(int i = 0; i <priceDateTimes.length; i++){
            ProductPrice productPrice = new ProductPrice(product, LocalDateTime.parse(priceDateTimes[i]), Double.parseDouble(prices[i]), "");
            product.addProductPrice(productPrice);
        }
    }
}
package com.example.projectscandiweb.controllers;

import com.example.projectscandiweb.entity.ProductParameters;
import com.example.projectscandiweb.entity.ProductType;
import com.example.projectscandiweb.entity.Scu;
import com.example.projectscandiweb.model.Product;
import com.example.projectscandiweb.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @GetMapping("/")
    public String product(Model model) {
        List<Product> products = (List<Product>) productRepository.findAll();
        model.addAttribute("products", products);
        return "productList";
    }

    @GetMapping("/page2")
    public String productAddPage(Model model) {
        List<Product> products = (List<Product>) productRepository.findAll();
        model.addAttribute("scu", Scu.values());
        model.addAttribute("productType", ProductType.values());
        model.addAttribute("productParameters", ProductParameters.values());
        model.addAttribute("products", products);
        return "productAdd";
    }

    @PostMapping("/page2")
    public String productAdd(
            @RequestParam String scu,
            @RequestParam String productName,
            @RequestParam Integer price,
            @RequestParam String productType,
            @RequestParam String productParameters,
            @RequestParam Integer parameterValue, Model model) {
        Product product = new Product(scu, productName, price, productType, productParameters, parameterValue);
        product.setScu(Scu.valueOf(scu));
        product.setProductName(productName);
        product.setPrice(price);
        product.setProductType(ProductType.valueOf(productType));
        product.setProductParameters(ProductParameters.valueOf(productParameters));
        product.setParameterValue(parameterValue);
        productRepository.save(product);
        return "redirect:/";
    }

    @PostMapping("/page2/{id}/remove")
    public String productDelete(@PathVariable("id") Long id, Model model) {
        Product product = productRepository.findById(id).orElseThrow();
        productRepository.delete(product);
        return "redirect:/";
    }
}

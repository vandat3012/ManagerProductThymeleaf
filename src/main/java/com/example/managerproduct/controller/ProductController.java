package com.example.managerproduct.controller;

import com.example.managerproduct.model.Product;
import com.example.managerproduct.model.service.IProductService;
import com.example.managerproduct.model.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private IProductService iProductService = new ProductService();
    @GetMapping("")
    public String list (Model model) {
        List<Product> products = iProductService.findAll();
        model.addAttribute("products",products);
        return "/list";
    }
    @GetMapping("/create")
    public String create (Model model){
        model.addAttribute("products",new Product());
        return "/create";
    }
    @PostMapping("/save")
    public String save (Product product) {
        product.setId((int) (Math.random() *10000));
        iProductService.save(product);
        return "redirect:/products";
    }
    @GetMapping("/{id}/update")
    public String update (@PathVariable int id,Model model) {
        model.addAttribute("products", iProductService.findById(id));
        return "/update";
    }
    @PostMapping("/update")
    public String update (Product product) {
        iProductService.update(product,product.getId());
        return "redirect:/products";
    }
    @GetMapping("/{id}/delete")
    public String delete (@PathVariable int id,Model model) {
        model.addAttribute("products",iProductService.findById(id));
        return "/delete";
    }
    @PostMapping("/delete")
    public String remove (Product product, RedirectAttributes redirectAttributes){
        iProductService.remove(product.getId());
        redirectAttributes.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/products";
    }
    @GetMapping("/{id}/view")
    public String view (@PathVariable int id,Model model) {
        model.addAttribute("products",iProductService.findById(id));
        return "/view";
    }

    @GetMapping ("/find")
    public String find (@RequestParam String name, Model model){
        List<Product> products = iProductService.findByName(name);
        model.addAttribute("products",products);
        return "/list";
    }
}

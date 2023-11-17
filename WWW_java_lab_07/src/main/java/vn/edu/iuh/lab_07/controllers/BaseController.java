package vn.edu.iuh.lab_07.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaseController {

    @GetMapping("/admin")
    public String getAdminPage(){
        return "admin/index";
    }
}
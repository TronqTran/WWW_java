package vn.edu.iuh.lab_05.controllers;

import com.neovisionaries.i18n.CountryCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import vn.edu.iuh.lab_05.dtos.CompanyDto;
import vn.edu.iuh.lab_05.models.Company;
import vn.edu.iuh.lab_05.services.CompanyService;

import java.util.List;
import java.util.Optional;

@Controller
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @GetMapping("/companies/new")
    public String showAddCompanyForm(Model model){
        CountryCode[] countryCode = CountryCode.values();
        CompanyDto companyDto = new CompanyDto();
        model.addAttribute("type", "ADD");
        model.addAttribute("company", companyDto);
        model.addAttribute("countryCode", countryCode);
        return "create_company";
    }

    @PostMapping("/companies")
    public String saveCompany(@ModelAttribute("company")CompanyDto company){
        companyService.createCompany(company);

        return "redirect:/companies";
    }

    @GetMapping("/companies")
    public String getCompanies(Model model){
        List<Company> companies = companyService.findAll();
        model.addAttribute("companies", companies);
        return "company";
    }

    @GetMapping("/companies/{id}")
    public String getDetailCompany(@PathVariable("id")long id, Model model){
        Optional<Company> company = companyService.findById(id);
        if(company.isEmpty()){
            return "redirect:/companies";
        }
        model.addAttribute("type", "UPDATE");
        model.addAttribute("company", company.get());
        return "company_detail";
    }
}
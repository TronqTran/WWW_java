package vn.edu.iuh.lab_05.services;

import com.neovisionaries.i18n.CountryCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.lab_05.dtos.CompanyDto;
import vn.edu.iuh.lab_05.models.Address;
import vn.edu.iuh.lab_05.models.Company;
import vn.edu.iuh.lab_05.repositories.AddressRepository;
import vn.edu.iuh.lab_05.repositories.CompanyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private AddressRepository addressRepository;

    public Company createCompany(CompanyDto companyDto){
        Address address = new Address(companyDto.getCompanyZipcode(), companyDto.getCompanyStreet(), companyDto.getCompanyAddressNumber(), companyDto.getCompanyCity(), CountryCode.getByCode(companyDto.getCompanyCountry()));
        addressRepository.save(address);
        Company company = new Company(companyDto.getCompanyName(), companyDto.getCompanyAbout(), address, companyDto.getCompanyPhone(), companyDto.getCompanyWebUrl(), companyDto.getCompanyEmail());
        return companyRepository.save(company);
    }

    public List<Company>findAll(){
        return companyRepository.findAll();
    }

    public Optional<Company> findById(long id){
        return companyRepository.findById(id);
    }

    public Company updateCompany(Company company){
        return companyRepository.save(company);
    }
}
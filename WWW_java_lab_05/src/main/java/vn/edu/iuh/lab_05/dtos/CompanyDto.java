package vn.edu.iuh.lab_05.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDto {
    private String companyName;
    private String companyEmail;
    private String companyPhone;
    private String companyWebUrl;
    private String companyAbout;
    private String companyCity;
    private String companyZipcode;
    private String companyStreet;
    private String companyAddressNumber;
    private String companyCountry;

    @Override
    public String toString() {
        return "CompanyDto{" +
                "companyName='" + companyName + '\'' +
                ", companyEmail='" + companyEmail + '\'' +
                ", companyPhone='" + companyPhone + '\'' +
                ", companyWebUrl='" + companyWebUrl + '\'' +
                ", companyAbout='" + companyAbout + '\'' +
                ", companyCity='" + companyCity + '\'' +
                ", companyZipcode='" + companyZipcode + '\'' +
                ", companyStreet='" + companyStreet + '\'' +
                ", companyAddressNumber='" + companyAddressNumber + '\'' +
                ", companyCountry='" + companyCountry + '\'' +
                '}';
    }
}
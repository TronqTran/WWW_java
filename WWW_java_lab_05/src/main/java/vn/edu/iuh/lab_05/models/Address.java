package vn.edu.iuh.lab_05.models;

import com.neovisionaries.i18n.CountryCode;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "add_id")
    private long id;
    private String zipcode;
    private String street;
    private String number;
    private String city;
    private CountryCode country;

    public Address(String zipcode, String street, String number, String city, CountryCode country) {
        this.zipcode = zipcode;
        this.street = street;
        this.number = number;
        this.city = city;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", zipcode='" + zipcode + '\'' +
                ", street='" + street + '\'' +
                ", number='" + number + '\'' +
                ", city='" + city + '\'' +
                ", country=" + country +
                '}';
    }
}

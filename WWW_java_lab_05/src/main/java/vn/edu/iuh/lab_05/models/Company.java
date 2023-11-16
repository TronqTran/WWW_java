package vn.edu.iuh.lab_05.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "company")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "com_id")
    private long id;
    @Column(name = "comp_name")
    private String name;
    @Column(name = "about", nullable = false, columnDefinition = "NVARCHAR(2000)")
    private String about;

    @OneToOne
    @JoinColumn(name = "address", nullable = false)
    private Address address;

    @Column(nullable = false)
    private String phone;
    @Column(name = "web_url",nullable = false)
    private String webURL;
    @Column(nullable = false)
    private String email;

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Job>jobs;

    public Company(long id) {
        this.id = id;
    }

    public Company(String name, String about, Address address, String phone, String webURL, String email) {
        this.name = name;
        this.about = about;
        this.address = address;
        this.phone = phone;
        this.webURL = webURL;
        this.email = email;
    }

}

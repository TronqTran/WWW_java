package vn.edu.iuh.lab_07.models;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;
import vn.edu.iuh.lab_07.enums.EmployeeStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Getter
@Entity
@Table(name = "employee")
@NamedQueries(
        @NamedQuery(name = "Employee.findAll", query = "select e from Employee e where e.status= ?1")
//        ,@NamedQuery(name = "Employee.findXXXXXXX", query = "select e from Employee e where????")
        //,...
)
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private long id;
    @Column(name = "full_name", length = 150, nullable = false)
    private String fullname;
    @Column(name = "dob", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "mm-DD-yyyy")
    @JsonSerialize(using = LocalDateSerializer.class)
    @DateTimeFormat (pattern="yyyy-MM-dd")
    private LocalDate dob;
    @Column(name = "email", unique = true, length = 150)
    private String email;
    @Column(name = "phone", length = 15, nullable = false)
    private String phone;
    @Column(name = "address", length = 250, nullable = false)
    private String address;
    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private EmployeeStatus status;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
//    @JoinColumn
    private List<Order> lstOrder;

    public Employee() {
    }

    public Employee(String fullname, LocalDate dob, String email, String phone, String address, EmployeeStatus status) {
        this.fullname = fullname;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.status = status;
    }

    public Employee(long id) {
        this.id = id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setStatus(EmployeeStatus status) {
        this.status = status;
    }

    public void setLstOrder(List<Order> lstOrder) {
        this.lstOrder = lstOrder;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", fullname='" + fullname + '\'' +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return getId() == employee.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
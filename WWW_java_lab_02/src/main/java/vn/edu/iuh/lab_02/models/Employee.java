package vn.edu.iuh.lab_02.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.joda.deser.DateTimeDeserializer;
import jakarta.persistence.*;
import org.joda.time.DateTime;
import vn.edu.iuh.lab_02.converters.EmployeeStatusConverter;
import vn.edu.iuh.lab_02.enums.EmployeeStatus;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "employee")
@NamedQueries({
        @NamedQuery(name = "Employee.FIND_ALL", query = "SELECT e from Employee e where e.status = 1"),
        @NamedQuery(name = "Employee.FIND_BY_ID", query = "SELECT e from Employee e where e.status = 1 AND e.empId = :empId"),
        @NamedQuery(name = "Employee.DELETE", query = "UPDATE Employee e SET e.status = -1 WHERE e.empId = :empId")
})
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private long empId;
    @Column(name = "full_name", nullable = false)
    private String fullName;
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    private DateTime dob;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    @Convert(converter = EmployeeStatusConverter.class)
    @JsonIgnore
    private EmployeeStatus status;
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    private List<Order> orders;

    public Employee() {
    }

    public Employee(String fullName, DateTime dob, String email, String phone, String address, EmployeeStatus status) {
        this.fullName = fullName;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.status = status;
    }

    public long getEmpId() {
        return empId;
    }

    public void setEmpId(long empId) {
        this.empId = empId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public DateTime getDob() {
        return dob;
    }

    public void setDob(DateTime dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public EmployeeStatus getStatus() {
        return status;
    }

    public void setStatus(EmployeeStatus status) {
        this.status = status;
    }

//    public List<Order> getOrders() {
//        return orders;
//    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", fullName='" + fullName + '\'' +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", status=" + status +
                '}';
    }
}
package vn.edu.iuh.lab_06.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.Set;

@Entity
@Table(name = "users")
@NamedQueries({
        @NamedQuery(name = "USER.FIND_BY_EMAIL", query = "SELECT u FROM User u WHERE email = :email")
})
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "middle_name", nullable = false)
    private String middleName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String mobile;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(name = "registered_at")
    private Instant registeredAt;
    @Column(name = "last_login")
    private Instant lastLogin;
    @Column(nullable = false)
    private String intro;
    @Column(nullable = false)
    private String profile;
    @OneToMany(mappedBy = "user")
    private Set<PostComment>comments;
    public User() {
    }

    public User(String firstName, String middleName, String lastName, String mobile, String email, String password, Instant registeredAt, Instant lastLogin, String intro, String profile) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.mobile = mobile;
        this.email = email;
        setPassword(password);
        this.registeredAt = registeredAt;
        this.lastLogin = lastLogin;
        this.intro = intro;
        this.profile = profile;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", registeredAt=" + registeredAt +
                ", lastLogin=" + lastLogin +
                ", intro='" + intro + '\'' +
                ", profile='" + profile + '\'' +
                '}';
    }
}
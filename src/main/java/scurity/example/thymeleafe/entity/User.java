package scurity.example.thymeleafe.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private String id;
    private String name;
    private String lastName;
    private String password;
    private String userName;
    private String email;

    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    private Set<Roles> roles;
}

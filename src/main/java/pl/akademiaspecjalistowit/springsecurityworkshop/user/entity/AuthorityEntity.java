package pl.akademiaspecjalistowit.springsecurityworkshop.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.security.core.GrantedAuthority;

@Entity
public class AuthorityEntity implements GrantedAuthority {

    public AuthorityEntity(String authority) {
        this.authority = authority;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public String authority;

    @Override
    public String getAuthority() {
        return authority;
    }
}
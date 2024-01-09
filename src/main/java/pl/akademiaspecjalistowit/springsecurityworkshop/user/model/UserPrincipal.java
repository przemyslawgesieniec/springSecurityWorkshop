package pl.akademiaspecjalistowit.springsecurityworkshop.user.model;

import java.util.Collection;
import java.util.Map;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

@AllArgsConstructor
public class UserPrincipal implements OAuth2User {

    private String email;
    private Map<String, Object> attributes;
    private Collection<? extends GrantedAuthority> grantedAuthoritySet;

    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthoritySet;
    }

    @Override
    public String getName() {
        return email;
    }
}

package edu.suse.bookstore.domain;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public class SystemUser implements UserDetails {
    private User user;

    public SystemUser() {
    }

    public SystemUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(user.getRoles())){
            for (Role role : user.getRoles()) {
                authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRole()));
                if (CollectionUtils.isNotEmpty(role.getPermissions())){
                    for (Permission permission : role.getPermissions()) {
                        authorities.add(new SimpleGrantedAuthority(permission.getPermission()));
                    }
                }
            }
        }
        /*if (StringUtils.equals(user.getUsername(), "admin")) {
            return Arrays.asList(new GrantedAuthority[]{new SimpleGrantedAuthority("ROLE_ADMIN")});
        } else if (StringUtils.equals(user.getUsername(), "contact")) {
            return Arrays.asList(new GrantedAuthority[]{new SimpleGrantedAuthority("ROLE_CONTACT")});
        } else if (StringUtils.equals(user.getUsername(), "secretary")) {
            return Arrays.asList(new GrantedAuthority[]{new SimpleGrantedAuthority("ROLE_SECRETARY")});
        }*/
        return authorities;

    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return user.getStatus() == null ? true : user.getStatus() == 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SystemUser that = (SystemUser) o;
        return Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user);
    }
}

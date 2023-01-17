package com.giveandtake.userService.security.services;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.giveandtake.userService.entities.Gender;
import com.giveandtake.userService.entities.Role;
import com.giveandtake.userService.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Data
@AllArgsConstructor
public class UserDetailsImpl implements UserDetails {
    private String id;

    private String userName;

    private String email;

    @JsonIgnore
    private String password;

    private Gender gender;

    private String phone;

    private String address;

    private Role role;


    public static UserDetailsImpl build(User user) {
        return new UserDetailsImpl(
                user.getId(),
                user.getUserName(),
                user.getEmail(),
                user.getPassword(),
                user.getGender(),
                user.getPhone(),
                user.getAddress(),
                user.getRole()
        );
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities
                = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role.toString()));
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
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
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserDetailsImpl user = (UserDetailsImpl) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

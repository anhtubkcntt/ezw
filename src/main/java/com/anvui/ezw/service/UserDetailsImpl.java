package com.anvui.ezw.service;

import com.anvui.ezw.model.entity.StaffEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Objects;

public class UserDetailsImpl implements UserDetails {

    private static final long serialVersionUID = 1L;

    private String staffId;

    private String userName;

    @JsonIgnore
    private String password;


    public UserDetailsImpl(String staffId, String userName, String password) {
        this.staffId = staffId;
        this.userName = userName;
        this.password = password;
    }

    public static UserDetailsImpl build(StaffEntity staffEntity) {
        return new UserDetailsImpl(staffEntity.getStaffId(), staffEntity.getUserName(), staffEntity.getPassword());
    }

    public String getStaffId() {
        return staffId;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
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
        return Objects.equals(staffId, user.staffId);
    }
}

package org.student.testapp.models;


import java.util.Collection;
import java.util.HashSet;
import javax.persistence.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
@Entity
@Table(name = "accounts")
public class User implements UserDetails {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "pass")
    private String password;

    @Column(name = "roles")
    private String roles;

    @Transient
    private Collection<GrantedAuthority> authorities;

    //Rewrite authorities from string to hashSet
    public void setRoles(String roles) {
        this.roles=roles;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        this.authorities = new HashSet<GrantedAuthority>();
        for (final String role : roles.split(",")) {
            if (role != null && !"".equals(role.trim())) {
                GrantedAuthority grandAuthority = new GrantedAuthority() {
                    public String getAuthority() {
                        return role.trim();
                    }
                };
                this.authorities.add(grandAuthority);
            }
        }
        return this.authorities;
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return true;
    }

    public void setAuthorities(Collection<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

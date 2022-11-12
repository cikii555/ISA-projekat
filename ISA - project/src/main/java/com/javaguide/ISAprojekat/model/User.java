package com.javaguide.ISAprojekat.model;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name="users")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User implements UserDetails {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
@Id
@SequenceGenerator(name = "my_seq_gen_user", sequenceName = "my_seq_gen_user", initialValue = 1, allocationSize = 1)
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_seq_gen_user")
    private Integer id;

    @Column
    private String password;
    @Column
    private String email;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String phoneNumber;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
    @Column
    private String jmbg;
    @Column
    private String gender;

    @Column
    private boolean isActive;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false)
    private Role role;


    public User() {
    }

    public User(String password, String email, String firstName, String lastName, String phoneNumber, Address address, String jmbg, String gender, Role role) {
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.jmbg = jmbg;
        this.gender = gender;
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Role r = this.role;
        return new ArrayList<Role>() {
            {add(r);}
        };
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public void setActive(boolean active) {
        isActive = active;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public String getJmbg() {
        return jmbg;
    }

    public String getGender() {
        return gender;
    }


    public boolean isActive() {
        return isActive;
    }

    public Role getRole() {
        return role;
    }

}

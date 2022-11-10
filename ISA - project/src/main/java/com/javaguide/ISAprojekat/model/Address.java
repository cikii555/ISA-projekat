package com.javaguide.ISAprojekat.model;


import javax.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   @Column(name="country", nullable = false)
    private String country;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "street", nullable = false)
    private String street;
    @Column(name = "streetNumber", nullable = false)
    private String streetNumber;

    @Column(name = "lon")
    private String lon;

    @Column(name = "lat")
    private String lat;
    @OneToOne(mappedBy = "address")
    private BloodTransfusionCenter bloodTransfusionCenter;
    public Address() {
    }

    public Address(String country, String city, String street, String streetNumber) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.streetNumber = streetNumber;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}

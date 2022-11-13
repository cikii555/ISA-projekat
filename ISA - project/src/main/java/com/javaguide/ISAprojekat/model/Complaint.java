package com.javaguide.ISAprojekat.model;

import javax.persistence.*;

@Entity
@Table(name="complaints")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Complaint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String type; //centar ili osoblje
    @Column
    private int idRecipient; // da izvuce centar ili osoblje , id centra ili osoblja
    private Client client;
    @Column
    private String message;
    @Column
    private String response;

    @Column
    private boolean reviewed;
    @Column
    private SystemAdministrator systemAdministrator; //koji admin reviewed

    public Complaint() {}

    public Complaint(Long id, String type, int idRecipient, Client client, String message, String response, boolean reviewed, SystemAdministrator systemAdministrator) {
        this.id = id;
        this.type = type;
        this.idRecipient = idRecipient;
        this.client = client;
        this.message = message;
        this.response = response;
        this.reviewed = reviewed;
        this.systemAdministrator = systemAdministrator;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getIdRecipient() {
        return idRecipient;
    }

    public void setIdRecipient(int idRecipient) {
        this.idRecipient = idRecipient;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public boolean isReviewed() {
        return reviewed;
    }

    public void setReviewed(boolean reviewed) {
        this.reviewed = reviewed;
    }

    public SystemAdministrator getSystemAdministrator() {
        return systemAdministrator;
    }

    public void setSystemAdministrator(SystemAdministrator systemAdministrator) {
        this.systemAdministrator = systemAdministrator;
    }
}

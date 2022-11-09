package com.javaguide.ISAprojekat.model;

public class Complaint {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type; //centar ili osoblje
    private int idRecipient; // da izvuce centar ili osoblje , id centra ili osoblja
    private Client client;
    private String message;
    private String response;
    private boolean reviewed;
    private SystemAdministrator systemAdministrator; //koji admin reviewed

}

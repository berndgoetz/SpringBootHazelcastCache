package com.infotech.book.ticket.app.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "ticket")
@Data
public class Ticket implements Serializable {

    private static final long serialVersionUID = -4235680428469660467L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private Integer ticketId;

    @Column(name = "passenger_name", nullable = false)
    private String passengerName;

    @Column(name = "booking_date", nullable = false)
    private Date bookingDate;

    @Column(name = "source_station", nullable = false)
    private String sourceStation;

    @Column(name = "dest_station", nullable = false)
    private String destStation;

    @Column(name = "email")
    private String email;

}

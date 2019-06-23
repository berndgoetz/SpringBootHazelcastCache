package com.infotech.book.ticket.app.controller;

import com.infotech.book.ticket.app.entities.Ticket;
import com.infotech.book.ticket.app.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping(value = "/{ticketId}")
    public Optional<Ticket> getTicketById(@PathVariable("ticketId") Integer ticketId) {
        return ticketService.getTicketById(ticketId);
    }

    @GetMapping()
    public Iterable<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @DeleteMapping(value = "/{ticketId}")
    public void deleteTicket(@PathVariable("ticketId") Integer ticketId) {
        ticketService.deleteTicket(ticketId);
    }

    @PutMapping(value = "/{ticketId}/{newEmail:.+}")
    public Optional<Ticket> updateTicket(
            @PathVariable("ticketId") Integer ticketId,
            @PathVariable("newEmail") String newEmail) {
        return ticketService.updateTicket(ticketId, newEmail);
    }

}

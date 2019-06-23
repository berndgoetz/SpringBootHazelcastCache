package com.infotech.book.ticket.app.service;

import com.infotech.book.ticket.app.dao.TicketRepository;
import com.infotech.book.ticket.app.entities.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Cacheable(value = "ticketsCache", unless="#result==null")
    public Optional<Ticket> getTicketById(Integer ticketId) {
        return ticketRepository.findById(ticketId);
    }

    public Iterable<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    @CacheEvict("ticketsCache")
    public void deleteTicket(Integer ticketId) {
        ticketRepository.deleteById(ticketId);
    }

    @CachePut("ticketsCache")
    public Optional<Ticket> updateTicket(Integer ticketId, String newEmail) {
        Ticket upadedTicket = null;
        Optional<Ticket> ticketFromDb = ticketRepository.findById(ticketId);
        ticketFromDb.ifPresent(ticket -> {
            ticket.setEmail(newEmail);
            ticketRepository.save(ticket);
        });
        return getTicketById(ticketId);
    }

}

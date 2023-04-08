package contagiouscode.mirsengar.cinematicketbookingbackend.Repositories;

import contagiouscode.mirsengar.cinematicketbookingbackend.Models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository < Ticket, Integer > {
          public Ticket findByTicketId ( String ticketId );
}
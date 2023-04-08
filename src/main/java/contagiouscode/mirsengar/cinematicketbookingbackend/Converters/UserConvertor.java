package contagiouscode.mirsengar.cinematicketbookingbackend.Converters;
import contagiouscode.mirsengar.cinematicketbookingbackend.DTOs.EntryDTOs.TicketEntryDTO;
import contagiouscode.mirsengar.cinematicketbookingbackend.DTOs.ResponseDTOs.TicketResponseDTO;
import contagiouscode.mirsengar.cinematicketbookingbackend.Models.ShowSeat;
import contagiouscode.mirsengar.cinematicketbookingbackend.Models.Ticket;
import java.util.ArrayList;
import java.util.List;
public class UserConvertor {
          public static Ticket convertDtoToTicketEntity ( TicketEntryDTO ticketEntryDTO ){
                    Ticket ticket=new Ticket();
                    
                    return ticket;
          }
          
          public static TicketResponseDTO convertEntityToResponseDTO ( Ticket ticket ) {
                    TicketResponseDTO ticketResponseDTO=TicketResponseDTO.builder()
                                                                         .id(ticket.getId())
                                                                         .movieName(ticket.getMovieName())
                                                                         .theaterName(ticket.getTheaterName())
                                                                         .showDate(ticket.getShowDate())
                                                                         .showTime(ticket.getShowTime())
                                                                         .totalAmount(ticket.getTotalAmount())
                                                                         .cancelled(ticket.isCancelled())
                                                                         .ticketId(ticket.getTicketId())
                                                                         .build();
                    List <String> bookedSeats =new ArrayList <> ();
                    for( ShowSeat showSeat:ticket.getBookedSeatList ( )){
                              bookedSeats.add(showSeat.getSeatNo());
                    }
                    ticketResponseDTO.setBookedSeats(bookedSeats);
                    return ticketResponseDTO;
          }
}

package contagiouscode.mirsengar.cinematicketbookingbackend.Converters;

import contagiouscode.mirsengar.cinematicketbookingbackend.DTOs.ResponseDTOs.ShowSeatResponseDTO;
import contagiouscode.mirsengar.cinematicketbookingbackend.Models.ShowSeat;

public class ShowSeatConvertor {
          public static ShowSeatResponseDTO convertEntityToResponseDTO ( ShowSeat showSeat ) {
                    ShowSeatResponseDTO showSeatResponseDTO = ShowSeatResponseDTO.builder ( )
                                                                                 .id ( showSeat.getId ( ) )
                                                                                 .booked ( showSeat.isBooked ( ) )
                                                                                 .price ( showSeat.getPrice ( ) )
                                                                                 .seatType ( showSeat.getSeatType ( ).toString ( ) )
                                                                                 .bookedOn ( showSeat.getBookedOn ( ) )
                                                                                 .build ( );
                    
                    return showSeatResponseDTO;
          }
}

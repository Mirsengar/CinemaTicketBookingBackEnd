package contagiouscode.mirsengar.cinematicketbookingbackend.Converters;

import contagiouscode.mirsengar.cinematicketbookingbackend.DTOs.ResponseDTOs.TheaterSeatDTO;
import contagiouscode.mirsengar.cinematicketbookingbackend.Models.TheaterSeat;

public class TheaterSeatConvertor {
          public static TheaterSeatDTO convertEntityToResponseDTO ( TheaterSeat theaterSeat ) {
                    TheaterSeatDTO theaterSeatDTO=TheaterSeatDTO.builder()
                                                                .id(theaterSeat.getId())
                                                                .seatType(theaterSeat.getSeatType().toString())
                                                                .SeatNo(theaterSeat.getSeatNo())
                                                                .build();
                    
                    return theaterSeatDTO;
          }
}

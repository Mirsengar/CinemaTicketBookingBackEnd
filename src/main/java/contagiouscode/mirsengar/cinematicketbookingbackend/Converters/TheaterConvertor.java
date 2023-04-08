package contagiouscode.mirsengar.cinematicketbookingbackend.Converters;

import contagiouscode.mirsengar.cinematicketbookingbackend.DTOs.EntryDTOs.TheaterEntryDTO;
import contagiouscode.mirsengar.cinematicketbookingbackend.DTOs.ResponseDTOs.TheaterResponseDTO;
import contagiouscode.mirsengar.cinematicketbookingbackend.Models.Theater;
import contagiouscode.mirsengar.cinematicketbookingbackend.Models.TheaterSeat;

import java.util.ArrayList;

public class TheaterConvertor {
          public static Theater ConvertDtoToEntity ( TheaterEntryDTO theaterEntryDTO ){
                    Theater theater=Theater.builder()
                                           .name(theaterEntryDTO.getName())
                                           .location(theaterEntryDTO.getLocation())
                                           .build();
                    
                    return theater;
          }
          
          public static TheaterResponseDTO convertEntityToResponseDTO ( Theater theater ) {
                    TheaterResponseDTO theaterResponseDTO=TheaterResponseDTO.builder()
                                                                            .id(theater.getId())
                                                                            .name(theater.getName())
                                                                            .location(theater.getLocation())
                                                                            .theaterSeats (new ArrayList <> () )
                                                                            .build();
                    
                    for( TheaterSeat theaterSeat:theater.getTheaterSeatList ( )){
                              theaterResponseDTO.getTheaterSeats().add(TheaterSeatConvertor.convertEntityToResponseDTO(theaterSeat));
                    }
                    
                    return theaterResponseDTO;
          }
}

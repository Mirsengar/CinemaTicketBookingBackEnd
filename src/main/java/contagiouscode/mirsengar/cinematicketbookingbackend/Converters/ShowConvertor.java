package contagiouscode.mirsengar.cinematicketbookingbackend.Converters;

import contagiouscode.mirsengar.cinematicketbookingbackend.DTOs.EntryDTOs.ShowEntryDTO;
import contagiouscode.mirsengar.cinematicketbookingbackend.DTOs.ResponseDTOs.ShowResponseDTO;
import contagiouscode.mirsengar.cinematicketbookingbackend.Models.Show;
import contagiouscode.mirsengar.cinematicketbookingbackend.Models.ShowSeat;

import java.util.ArrayList;

public class ShowConvertor {
          public static Show convertDtotoShow ( ShowEntryDTO showEntryDTO ) {
                    Show show = Show.builder ( )
                                    .showDate ( showEntryDTO.getShowDate ( ) )
                                    .showTime ( showEntryDTO.getShowTime ( ) )
                                    .showType ( showEntryDTO.getShowType ( ) )
                                    .build ( );
                    
                    return show;
          }
          
          public static ShowResponseDTO convertEntityToResponseDTO ( Show show ) {
                    ShowResponseDTO showResponseDTO = ShowResponseDTO.builder ( )
                                                                     .id ( show.getId ( ) )
                                                                     .showDate ( show.getShowDate ( ) )
                                                                     .showTime ( show.getShowTime ( ) )
                                                                     .showType ( show.getShowType ( ).toString ( ) )
                                                                     .createdOn ( show.getCreatedOn ( ) )
                                                                     .movie ( MovieConvertor.convertEntityToResponseDTO ( show.getMovie ( ) ) )
                                                                     .showSeats ( new ArrayList <> ( ) )
                                                                     .theaterName ( show.getTheater ( ).getName ( ) )
                                                                     .build ( );
                    
                    for ( ShowSeat showSeat : show.getListOfShowSeats ( ) ) {
                              showResponseDTO.getShowSeats ( ).add ( ShowSeatConvertor.convertEntityToResponseDTO ( showSeat ) );
                    }
                    return showResponseDTO;
          }
}

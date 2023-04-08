package contagiouscode.mirsengar.cinematicketbookingbackend.Converters;
import contagiouscode.mirsengar.cinematicketbookingbackend.DTOs.EntryDTOs.MovieEntryDTO;
import contagiouscode.mirsengar.cinematicketbookingbackend.DTOs.ResponseDTOs.MovieResponseDTO;
import contagiouscode.mirsengar.cinematicketbookingbackend.Models.Movie;

public class MovieConvertor {
          public static Movie ConvertDtoToMovieEntity ( MovieEntryDTO movieEntryDTO ) {
                    Movie movie = Movie.builder ( )
                                       .name ( movieEntryDTO.getName ( ) )
                                       .genre ( movieEntryDTO.getGenre ( ) )
                                       .rating ( movieEntryDTO.getRating ( ) )
                                       .duration ( movieEntryDTO.getDuration ( ) )
                                       .language ( movieEntryDTO.getLanguage ( ) )
                                       .build ( );
                    return movie;
          }
          
          public static MovieResponseDTO convertEntityToResponseDTO ( Movie movie ) {
                    MovieResponseDTO movieResponseDTO = MovieResponseDTO.builder ( )
                                                                        .id ( movie.getId ( ) )
                                                                        .name ( movie.getName ( ) )
                                                                        .genre ( movie.getName ( ) )
                                                                        .rating ( movie.getRating ( ) )
                                                                        .duration ( movie.getDuration ( ) )
                                                                        .language ( movie.getLanguage ( ).toString ( ) )
                                                                        .build ( );
                    return movieResponseDTO;
                    
          }
}

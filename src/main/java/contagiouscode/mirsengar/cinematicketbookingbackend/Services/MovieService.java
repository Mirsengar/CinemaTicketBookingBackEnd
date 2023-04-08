package contagiouscode.mirsengar.cinematicketbookingbackend.Services;

import contagiouscode.mirsengar.cinematicketbookingbackend.Converters.MovieConvertor;
import contagiouscode.mirsengar.cinematicketbookingbackend.DTOs.EntryDTOs.MovieEntryDTO;
import contagiouscode.mirsengar.cinematicketbookingbackend.DTOs.ResponseDTOs.MovieResponseDTO;
import contagiouscode.mirsengar.cinematicketbookingbackend.Models.Movie;
import contagiouscode.mirsengar.cinematicketbookingbackend.Models.Show;
import contagiouscode.mirsengar.cinematicketbookingbackend.Models.Ticket;
import contagiouscode.mirsengar.cinematicketbookingbackend.Repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
          @Autowired
          MovieRepository movieRepository;
          
          public String addMovie ( MovieEntryDTO movieEntryDTO ) {
                    Movie movie = MovieConvertor.ConvertDtoToMovieEntity ( movieEntryDTO );
                    movieRepository.save ( movie );
                    return "Movie added";
          }
          
          public String findMovieWithMaxShows ( ) {
                    List < Movie > movieList        = movieRepository.findAll ( );
                    Movie          movieWithMAxShow = null;
                    int            maxShows         = 0;
                    for ( Movie movie : movieList ) {
                              if ( movie.getListOfShows ( ).size ( ) > maxShows ) {
                                        movieWithMAxShow = movie;
                                        maxShows         = movie.getListOfShows ( ).size ( );
                              }
                    }
                    if ( movieWithMAxShow == null ) return "no movie shows found";
                    return movieWithMAxShow.getName ( );
          }
          
          public List < String > findTheatersForMovie ( int moveId ) {
                    Movie           movie    = movieRepository.findById ( moveId ).get ( );
                    List < String > response = new ArrayList <> ( );
                    for ( Show show : movie.getListOfShows ( ) ) {
                              response.add ( show.getTheater ( ).getName ( ) );
                    }
                    return response;
          }
          
          public MovieResponseDTO getById ( int id ) {
                    Movie            movie            = movieRepository.findById ( id ).get ( );
                    MovieResponseDTO movieResponseDTO = MovieConvertor.convertEntityToResponseDTO ( movie );
                    return movieResponseDTO;
          }
          
          public List < MovieResponseDTO > getAll ( ) {
                    List < MovieResponseDTO > response = new ArrayList <> ( );
                    for ( Movie movie : movieRepository.findAll ( ) ) {
                              MovieResponseDTO movieResponseDTO = MovieConvertor.convertEntityToResponseDTO ( movie );
                              response.add ( movieResponseDTO );
                    }
                    return response;
          }
          
          public Long salesForMovieById ( int id ) {
                    Long  sales = 0L;
                    Movie movie = movieRepository.findById ( id ).get ( );
                    for ( Show show : movie.getListOfShows ( ) ) {
                              for ( Ticket ticket : show.getListOfTickets ( ) ) {
                                        if ( ! ticket.isCancelled ( ) ) {
                                                  sales += ticket.getTotalAmount ( );
                                        }
                              }
                    }
                    return sales;
          }
}

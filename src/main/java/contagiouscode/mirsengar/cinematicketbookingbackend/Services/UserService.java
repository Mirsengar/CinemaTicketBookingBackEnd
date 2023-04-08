package contagiouscode.mirsengar.cinematicketbookingbackend.Services;
import contagiouscode.mirsengar.cinematicketbookingbackend.Converters.TicketConvertor;
import contagiouscode.mirsengar.cinematicketbookingbackend.Converters.UserConvertor;
import contagiouscode.mirsengar.cinematicketbookingbackend.DTOs.EntryDTOs.UserEntryDTO;
import contagiouscode.mirsengar.cinematicketbookingbackend.DTOs.ResponseDTOs.TicketResponseDTO;
import contagiouscode.mirsengar.cinematicketbookingbackend.DTOs.ResponseDTOs.UserResponseDTO;
import contagiouscode.mirsengar.cinematicketbookingbackend.Models.Ticket;
import contagiouscode.mirsengar.cinematicketbookingbackend.Models.User;
import contagiouscode.mirsengar.cinematicketbookingbackend.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
public class UserService {
          @Autowired
          UserRepository userRepository;
          @Autowired
          TicketService  ticketService;
          public String addUser ( UserEntryDTO userEntryDTO ) {
                    User user = UserConvertor.ConvertDtoToUserEntity ( userEntryDTO );
                    userRepository.save ( user );
                    return "user entry Created userId is :" + user.getId ( );
          }
          
          public UserResponseDTO getById ( int id ) {
                    User user = userRepository.findById ( id ).get ( );
                    return UserConvertor.convertToUserResponseDTO ( user );
          }
          public List < UserResponseDTO > getAll ( ) {
                    List < User > userList = userRepository.findAll ( );
                    List < UserResponseDTO > responseDTOList = new ArrayList <> ( );
                    for ( User user : userList ) {
                              UserResponseDTO userResponseDTO = UserConvertor.convertToUserResponseDTO ( user );
                              responseDTOList.add ( userResponseDTO );
                    }
                    return responseDTOList;
          }
          public String updateUser ( UserEntryDTO userEntryDTO , int id ) {
                    User user = userRepository.findById ( id ).get ( );
                    user.setAge ( userEntryDTO.getAge ( ) );
                    user.setName ( userEntryDTO.getName ( ) );
                    user.setEmail ( userEntryDTO.getEmail ( ) );
                    user.setMobile ( userEntryDTO.getMobile ( ) );
                    userRepository.save ( user );
                    return "Details of user with id " + id + " is Updated";
          }
          public void deleteById ( int id ) {
                    User user = userRepository.findById ( id ).get ( );
                    for ( Ticket ticket : user.getListOfTickets ( ) ) {
                              ticketService.cancelTicket ( ticket.getId ( ) );
                    }
                    userRepository.delete ( user );
          }
          
          public List < TicketResponseDTO > getTicketsById ( int id ) {
                    User            user       = userRepository.findById ( id ).get ( );
                    List < Ticket > ticketList = user.getListOfTickets ( );
                    List < TicketResponseDTO > responseDTOS = new ArrayList <> ( );
                    for ( Ticket ticket : ticketList ) {
                              TicketResponseDTO ticketResponseDTO =
                                             TicketConvertor.convertEntityToResponseDTO ( ticket );
                              responseDTOS.add ( ticketResponseDTO );
                    }
                    return responseDTOS;
          }
}
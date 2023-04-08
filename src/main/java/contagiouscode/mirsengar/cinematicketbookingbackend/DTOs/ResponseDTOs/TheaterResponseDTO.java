package contagiouscode.mirsengar.cinematicketbookingbackend.DTOs.ResponseDTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TheaterResponseDTO {
          private int                     id;
          private String                  name;
          private String                  location;
          private List < TheaterSeatDTO > theaterSeats = new ArrayList <> ( );
}
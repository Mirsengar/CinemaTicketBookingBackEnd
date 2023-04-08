package contagiouscode.mirsengar.cinematicketbookingbackend.DTOs.EntryDTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TheaterEntryDTO {
          private String name;
          private String location;
          private int    normalSeatCount;
          private int    premiumSeatCount;
          
}

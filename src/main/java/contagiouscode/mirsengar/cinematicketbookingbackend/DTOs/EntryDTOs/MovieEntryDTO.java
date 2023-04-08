package contagiouscode.mirsengar.cinematicketbookingbackend.DTOs.EntryDTOs;

import contagiouscode.mirsengar.cinematicketbookingbackend.Enums.Genre;
import contagiouscode.mirsengar.cinematicketbookingbackend.Enums.Language;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieEntryDTO {
          private String   name;
          private Genre    genre;
          private double   rating;
          private int      duration;
          private Language language;
          
}

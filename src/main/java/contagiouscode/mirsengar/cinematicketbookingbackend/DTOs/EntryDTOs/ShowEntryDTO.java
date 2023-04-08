package contagiouscode.mirsengar.cinematicketbookingbackend.DTOs.EntryDTOs;

import contagiouscode.mirsengar.cinematicketbookingbackend.Enums.ShowType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShowEntryDTO {
          private LocalDate showDate;
          private LocalTime showTime;
          private ShowType  showType;
          private int       movieId;
          private int       theaterId;
          private int       premiumSeatPrice;
          private int       normalSeatPrice;
          
}

package contagiouscode.mirsengar.cinematicketbookingbackend.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table ( schema = "theaters")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Theater {
          @Id
          @GeneratedValue ( strategy = GenerationType.IDENTITY)
          private int                  id;
          private String               name;
          private String               location;
          @OneToMany ( mappedBy = "theater", cascade = CascadeType.ALL)
          private List < TheaterSeat > theaterSeatList = new ArrayList <> ( );
          @OneToMany ( mappedBy = "theater", cascade = CascadeType.ALL)
          private List < Show >        listOfShows     = new ArrayList <> ( );
          
}

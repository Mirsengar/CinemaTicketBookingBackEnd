package contagiouscode.mirsengar.cinematicketbookingbackend.Models;


import contagiouscode.mirsengar.cinematicketbookingbackend.Enums.Genre;
import contagiouscode.mirsengar.cinematicketbookingbackend.Enums.Language;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Movie {
          @Id
          @GeneratedValue ( strategy = GenerationType.IDENTITY)
          private int id;
          @Column ( unique = true, nullable = false)
          private String name;
          @Enumerated ( value = EnumType.STRING)
          private Genre genre;
          private double rating;
          private int duration;
          @Enumerated ( value = EnumType.STRING)
          private Language language;
          @OneToMany ( mappedBy = "movie", cascade = CascadeType.ALL)
          private List < Show > listOfShows = new ArrayList <> ( );
}

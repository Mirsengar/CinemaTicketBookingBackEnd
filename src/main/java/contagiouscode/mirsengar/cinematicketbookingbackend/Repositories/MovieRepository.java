package contagiouscode.mirsengar.cinematicketbookingbackend.Repositories;

import contagiouscode.mirsengar.cinematicketbookingbackend.Models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository < Movie, Integer > {
}

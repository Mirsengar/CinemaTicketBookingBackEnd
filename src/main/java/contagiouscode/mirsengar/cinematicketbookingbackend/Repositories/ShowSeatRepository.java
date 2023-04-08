package contagiouscode.mirsengar.cinematicketbookingbackend.Repositories;

import contagiouscode.mirsengar.cinematicketbookingbackend.Models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowSeatRepository extends JpaRepository < ShowSeat, Integer > {
}

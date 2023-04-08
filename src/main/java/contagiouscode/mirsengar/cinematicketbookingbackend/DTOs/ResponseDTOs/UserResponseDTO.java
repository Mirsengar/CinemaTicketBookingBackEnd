package contagiouscode.mirsengar.cinematicketbookingbackend.DTOs.ResponseDTOs;

import jakarta.persistence.GeneratedValue;
import lombok.*;
import org.springframework.stereotype.Service;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponseDTO {
          private int    id;
          private String name;
          private String email;
          private String mobile;
          private int    age;
}

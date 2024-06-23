package cm.jonabacho.annulationservice.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Voyage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String destination;

    private String dateVoyage;

    private boolean annule;
}
package edu.project.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Table(name = "Matches")
@NoArgsConstructor
@Getter
@Setter
public class Match {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch=LAZY, optional = false)
    @JoinColumn(name = "Player1", referencedColumnName = "Id", nullable = false)
    private Player player1;

    @ManyToOne(fetch=LAZY, optional = false)
    @JoinColumn(name = "Player2", referencedColumnName = "Id", nullable = false)
    private Player player2;

    @ManyToOne(fetch=LAZY, optional = false)
    @JoinColumn(name = "Winner", referencedColumnName = "Id", nullable = false)
    private Player winner;

}

package edu.project.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;


@Entity
@Table(name = "Players")
@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class Player {

    @Id
    @GeneratedValue
    @Column(name = "Id")
    private Long id;

    @Column(name = "Name", nullable = false, unique = true)
    private String name;

}

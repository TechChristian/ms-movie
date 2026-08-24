package com.api.techchristian.ms.database.model;

import com.api.techchristian.ms.database.enums.GenreEnum;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "DB_MOVIES")
public class MovieEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID movieId;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    private GenreEnum genre;

    @Column(nullable = false)
    private int releaseYear;

    @Column(nullable = false)
    private LocalDateTime sessionTime;

    private LocalDate createdAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDate.now();
    }

}

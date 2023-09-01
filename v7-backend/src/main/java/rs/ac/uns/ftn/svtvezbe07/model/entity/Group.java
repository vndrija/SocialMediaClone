package rs.ac.uns.ftn.svtvezbe07.model.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Getter
@Setter
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String descripiton;

    @Column(nullable = false)
    private LocalDate creationDate;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Post> posts;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @Column(nullable = false)
    private boolean isSuspended;


    public Group() {
        this.creationDate = LocalDate.now();
        this.isSuspended = false;
    }
}


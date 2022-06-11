package ru.ketbiev.hov.infrastructure.repository.postgres.dto;

import ru.ketbiev.hov.core.model.Account;
import ru.ketbiev.hov.core.model.Note;
import ru.ketbiev.hov.core.model.Task;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "spaces")
public class SpaceDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "create_space")
    private OffsetDateTime createTime;

    @Column(name = "last_update")
    private OffsetDateTime lastUpdate;

    @ManyToOne(cascade = {CascadeType.PERSIST,
            CascadeType.DETACH,
            CascadeType.REFRESH,
            CascadeType.MERGE})
    @JoinColumn(name = "host_id")
    private UserDto user;

    @OneToMany(cascade = CascadeType.ALL
            //, mappedBy = "book"
            , fetch = FetchType.EAGER)
    @JoinColumn(name = "space_id")
    private List<Note> notes = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL
            //, mappedBy = "book"
            , fetch = FetchType.EAGER)
    @JoinColumn(name = "space_id")
    private List<Task> tasks = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL
            //, mappedBy = "book"
            , fetch = FetchType.EAGER)
    @JoinColumn(name = "space_id")
    private List<Account> accounts = new ArrayList<>();

}

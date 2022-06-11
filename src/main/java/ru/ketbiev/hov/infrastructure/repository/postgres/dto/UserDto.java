package ru.ketbiev.hov.infrastructure.repository.postgres.dto;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
public class UserDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "create_date")
    private OffsetDateTime createDate;

    @Column(name = "last_login")
    private OffsetDateTime lastLoginDate;

    @OneToMany(cascade = CascadeType.ALL
            //, mappedBy = "book"
            , fetch = FetchType.EAGER)
    @JoinColumn(name = "host_id")
    private List<SpaceDto> spaces = new ArrayList<>();

    public UserDto() {
    }

    public UserDto(long id, String login, String password,
                   OffsetDateTime createDate, OffsetDateTime lastLoginDate, List<SpaceDto> spaces) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.createDate = createDate;
        this.lastLoginDate = lastLoginDate;
        this.spaces = spaces;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public OffsetDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(OffsetDateTime createDate) {
        this.createDate = createDate;
    }

    public OffsetDateTime getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(OffsetDateTime lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public List<SpaceDto> getSpaces() {
        return spaces;
    }

    public void setSpaces(List<SpaceDto> spaces) {
        this.spaces = spaces;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return id == userDto.id
                && Objects.equals(login, userDto.login)
                && Objects.equals(password, userDto.password)
                && Objects.equals(createDate, userDto.createDate)
                && Objects.equals(lastLoginDate, userDto.lastLoginDate)
                && Objects.equals(spaces, userDto.spaces);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, createDate, lastLoginDate, spaces);
    }
}

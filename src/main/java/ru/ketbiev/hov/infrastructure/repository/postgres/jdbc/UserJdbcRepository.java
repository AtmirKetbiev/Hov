package ru.ketbiev.hov.infrastructure.repository.postgres.jdbc;

import ru.ketbiev.hov.core.model.*;
import ru.ketbiev.hov.core.port.repository.UserRepository;
import ru.ketbiev.hov.infrastructure.repository.postgres.jdbc.dto.UserDTO;

import java.sql.*;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserJdbcRepository implements UserRepository {

    private final String urlDB;
    private final String userDB;
    private final String passwordDB;

    public UserJdbcRepository(String urlDB, String userDB, String passwordDB) {
        this.urlDB = urlDB;
        this.userDB = userDB;
        this.passwordDB = passwordDB;
    }

    @Override
    public User add(User user) {
        try {
            Connection con = DriverManager.getConnection(urlDB, userDB, passwordDB);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(
                    String.format("with idUser as (" +
                                    "INSERT INTO users " +
                                    "(login, password, create_account, last_login) " +
                                    "VALUES ('%s' ,'%s' ,'%s' ,'%s') " +
                                    "RETURNING id" +
                                    ") " +
                                    "SELECT * FROM idUser",
                            user.getLogin(),
                            user.getPassword(),
                            user.getCreateDate(),
                            user.getLastLoginDate()));
            con.close();
            rs.next();
            user.setId(rs.getInt("id"));
            return user;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public User get(long id) {
        try {
            Connection con = DriverManager.getConnection(urlDB, userDB, passwordDB);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(
                    String.format("SELECT  " +
                            "users.id as user_id,  " +
                            "users.login as user_login, " +
                            "users.password as user_password, " +
                            "users.create_account as user_create_account, " +
                            "users.last_login as user_last_login, " +
                            "spaces.id as spaces_id, " +
                            "spaces.title as spaces_title, " +
                            "spaces.create_space as spaces_create_space, " +
                            "spaces.last_login as spaces_last_login, " +
                            "spaces.host_id as spaces_host_id, " +
                            "accounts.id as accounts_id, " +
                            "accounts.title as accounts_title, " +
                            "accounts.password as accounts_password, " +
                            "accounts.url as accounts_url, " +
                            "accounts.text as accounts_text, " +
                            "accounts.space_id as accounts_space_id, " +
                            "notes.id as notes_id, " +
                            "notes.title as notes_title, " +
                            "notes.text as notes_text, " +
                            "notes.space_id as notes_space_id, " +
                            "tasks.id as tasks_id, " +
                            "tasks.title as tasks_title, " +
                            "tasks.space_id as tasks_space_id, " +
                            "task_points.id as task_points_id, " +
                            "task_points.title as task_points_title, " +
                            "task_points.done as task_points_done, " +
                            "task_points.task_id as task_points_task_id " +
                            "FROM users LEFT JOIN spaces ON users.id = spaces.host_id " +
                            "LEFT join accounts on spaces.id = accounts.space_id " +
                            "LEFT join notes on spaces.id = notes.space_id " +
                            "LEFT join tasks on spaces.id = tasks.space_id " +
                            "LEFT join task_points on tasks.id = task_points.task_id " +
                            "WHERE users.id = %s", id));
            con.close();
            rs.next();

            User user = new User();
            Space space = new Space();
            Set<Space> spaces = new HashSet<>();
            while (rs.next()) {
                user.setId(rs.getLong("user_id"));
                user.setLogin(rs.getString("user_login"));
                user.setPassword(rs.getString("user_password"));
                user.setCreateDate(OffsetDateTime.parse(rs.getString("user_create_account")));
                user.setLastLoginDate(OffsetDateTime.parse(rs.getString("user_last_login")));

                space.setId(rs.getLong("spaces_id"));
                space.setTitle(rs.getString("spaces_title"));
                space.setCreateTime(OffsetDateTime.parse(rs.getString("spaces_create_space")));
                space.setLastUpdate(OffsetDateTime.parse(rs.getString("spaces_last_login")));
                space.setHostId(rs.getLong("spaces_host_id"));

                spaces.add(space);
            }
            return null;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }
}

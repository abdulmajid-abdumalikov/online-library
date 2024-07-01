package com.malikov.onlinelibrary.model;

import com.malikov.onlinelibrary.enums.Role;
import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User extends BaseModel {
    private String name;
    private String username;
    private String password;
    private Role role;
    private String phone;
    private String email;
    private String bio;
    private String profile;
    private LocalDateTime updatedAt;

    public static User map(ResultSet resultSet) throws SQLException {
        User user = User.builder()
                .name(resultSet.getString("name"))
                .username(resultSet.getString("username"))
                .password(resultSet.getString("password"))
                .role(Role.valueOf(resultSet.getString("role")))
                .phone(resultSet.getString("phone"))
                .email(resultSet.getString("email"))
                .bio(resultSet.getString("bio"))
                .profile(resultSet.getString("profile"))
                .updatedAt(LocalDateTime.parse(resultSet.getString("updated_at")))
                .build();
        user.setID(resultSet.getObject("id", UUID.class));
        user.setCreatedAt(resultSet.getTimestamp("created_at").toLocalDateTime());
        return user;
    }
}

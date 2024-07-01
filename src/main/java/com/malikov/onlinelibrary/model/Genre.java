package com.malikov.onlinelibrary.model;

import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Genre extends BaseModel{
    private String name;
    private String description;

    public static Genre map(ResultSet resultSet) throws SQLException {
        Genre genre = Genre.builder()
               .name(resultSet.getString("name"))
               .description(resultSet.getString("description"))
               .build();
        genre.setID(resultSet.getObject("id", UUID.class));
        genre.setCreatedAt(resultSet.getTimestamp("created_at").toLocalDateTime());
        return genre;
    }
}

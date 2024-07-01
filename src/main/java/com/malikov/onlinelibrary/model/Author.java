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
public class Author extends BaseModel{
    private String name;
    private String bio;

    public static Author map(ResultSet resultSet) throws SQLException {
        Author genre = Author.builder()
               .name(resultSet.getString("name"))
               .bio(resultSet.getString("bio"))
               .build();
        genre.setID(resultSet.getObject("id", UUID.class));
        genre.setCreatedAt(resultSet.getTimestamp("created_at").toLocalDateTime());
        return genre;
    }
}

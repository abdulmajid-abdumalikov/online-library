package com.malikov.onlinelibrary.model;

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
public class Book extends BaseModel{
    private String title;
    private UUID genreID;
    private UUID authorID;
    private LocalDateTime publisherDate;
    private String description;
    private String image;
    private UUID uploadedBy;
    private Double price;

    public static Book map(ResultSet resultSet) throws SQLException {
        Book book = Book.builder()
                .title(resultSet.getString("title"))
                .genreID(UUID.fromString(resultSet.getString("genre_id")))
                .authorID(UUID.fromString(resultSet.getString("author_id")))
                .publisherDate(resultSet.getTimestamp("publisher_date").toLocalDateTime())
                .description(resultSet.getString("description"))
                .image(resultSet.getString("image"))
                .uploadedBy(UUID.fromString(resultSet.getString("uploaded_by")))
                .price(resultSet.getDouble("price"))
                .build();
        book.setID(UUID.fromString(resultSet.getString("id")));
        book.setCreatedAt(resultSet.getTimestamp("created_at").toLocalDateTime());
        return book;
    }
}

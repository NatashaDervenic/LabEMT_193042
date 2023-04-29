package mk.ukim.finki.emt.lab.lab.model.dto;

import lombok.Data;
import mk.ukim.finki.emt.lab.lab.model.Author;
import mk.ukim.finki.emt.lab.lab.model.enumerations.Category;

@Data
public class BookDto {

    private String name;

    private Category category;
    private Author author;

    private Integer availableCopies;

    public BookDto() {

    }

    public BookDto(String name, Category category, Author author, int copies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = copies;
    }
}
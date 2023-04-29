package mk.ukim.finki.emt.lab.lab.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import mk.ukim.finki.emt.lab.lab.model.enumerations.Category;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Category category;


    @ManyToOne
    private Author author;

    private Integer availableCopies;


    public Book(String name, Category category, Author author, int copies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = copies;
    }

}
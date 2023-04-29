package mk.ukim.finki.emt.lab.lab.config;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.emt.lab.lab.model.Author;
import mk.ukim.finki.emt.lab.lab.model.Book;
import mk.ukim.finki.emt.lab.lab.model.Country;
import mk.ukim.finki.emt.lab.lab.model.enumerations.Category;
import mk.ukim.finki.emt.lab.lab.model.enumerations.Role;
import mk.ukim.finki.emt.lab.lab.repository.AuthorRepository;
import mk.ukim.finki.emt.lab.lab.repository.BookRepository;
import mk.ukim.finki.emt.lab.lab.repository.CountryRepository;
import mk.ukim.finki.emt.lab.lab.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private final CountryRepository countryRepository;
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final UserService userService;


    public DataInitializer(CountryRepository countryRepository, AuthorRepository authorRepository, BookRepository bookRepository, UserService userService) {
        this.countryRepository = countryRepository;
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;

        this.userService = userService;
    }

    @PostConstruct
    public void init() {
        userService.register("admin", "pass", "pass", Role.ROLE_LIBRARIAN);
        userService.register("user", "pass", "pass", Role.ROLE_USER);
        if (countryRepository.count() != 0 || authorRepository.count() != 0 || bookRepository.count() != 0) {
            return;
        }

        for (int i = 1; i < 31; i++) {
            create(i);
        }
    }

    private void create(int i) {
        Country c = new Country();
        c.setName(String.format("Country %d", i));
        c.setContinent(String.format("Continent %d", i));
        countryRepository.save(c);

        Author a = new Author();
        a.setName(String.format("Author %d", i));
        a.setSurname(String.format("AuthorSurname %d", i));
        a.setCountry(c);
        authorRepository.save(a);

        Book b = new Book();
        b.setName(String.format("BookName %d", i));
        b.setCategory(Category.values()[i % Category.values().length]);
        b.setAuthor(a);
        b.setAvailableCopies(i);
        bookRepository.save(b);
    }
}
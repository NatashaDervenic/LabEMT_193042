package mk.ukim.finki.emt.lab.lab.service.impl;

import mk.ukim.finki.emt.lab.lab.model.Author;
import mk.ukim.finki.emt.lab.lab.model.Country;
import mk.ukim.finki.emt.lab.lab.repository.AuthorRepository;
import mk.ukim.finki.emt.lab.lab.repository.CountryRepository;
import mk.ukim.finki.emt.lab.lab.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public Optional<Author> findById(Long id) {
        return this.authorRepository.findById(id);

    }

    @Override
    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }

    @Override
    public Optional<Author> save(String name, String surname, Country country) {
        return Optional.of(this.authorRepository.save(new Author(name, surname, country)));
    }

    @Override
    public void deleteById(Long id) {
        this.authorRepository.deleteById(id);

    }
}

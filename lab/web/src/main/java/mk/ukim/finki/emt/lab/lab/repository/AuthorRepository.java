package mk.ukim.finki.emt.lab.lab.repository;

import mk.ukim.finki.emt.lab.lab.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
//@EnableJpaRepositories("mk.ukim.finki.emt.bookshop.repository")
public interface AuthorRepository extends JpaRepository<Author, Long> {
}


package co.simplon.davelooper.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.davelooper.entities.Language;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {

    boolean existsByCode(String code);
}

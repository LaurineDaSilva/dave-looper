package co.simplon.davelooper.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.davelooper.entities.Developer;

@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Long> {

    Developer findByRegistrationNumber(String number);
}

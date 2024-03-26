package co.simplon.davelooper.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.simplon.davelooper.entities.Developer;
import co.simplon.davelooper.repositories.DeveloperRepository;

@Service
@Transactional(readOnly = true)
public class DeveloperService {

    private final DeveloperRepository developers;

    public DeveloperService(DeveloperRepository developers) {
	this.developers = developers;
    }

    public Developer oneByRegistrationNumber(String number) {
	return developers.findByRegistrationNumber(number);
    }
}

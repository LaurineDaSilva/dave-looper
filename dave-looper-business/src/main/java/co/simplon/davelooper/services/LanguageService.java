package co.simplon.davelooper.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.simplon.davelooper.dtos.LanguageCreate;
import co.simplon.davelooper.entities.Language;
import co.simplon.davelooper.repositories.LanguageRepository;
import jakarta.validation.Valid;

@Service
@Transactional(readOnly = true)
public class LanguageService {

    private final LanguageRepository languages;

    public LanguageService(LanguageRepository languages) {
	this.languages = languages;
    }

    @Transactional
    public void create(@Valid LanguageCreate inputs) {
	Language entity = new Language();
	entity.setCode(inputs.code());
	entity.setName(inputs.name());
	languages.save(entity);
    }

    public boolean existsByCode(String code) {
	return languages.existsByCode(code);
    }
}

package co.simplon.davelooper.dtos.validation;

import co.simplon.davelooper.services.LanguageService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueLanguageCodeValidator
	implements ConstraintValidator<UniqueLanguageCode, String> {

    private final LanguageService service;

    public UniqueLanguageCodeValidator(LanguageService service) {
	this.service = service;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
	if (value == null) {
	    return true;
	}
	return !service.existsByCode(value);
    }
}

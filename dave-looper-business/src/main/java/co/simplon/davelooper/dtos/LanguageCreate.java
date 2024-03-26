package co.simplon.davelooper.dtos;

import co.simplon.davelooper.dtos.validation.UniqueLanguageCode;
import jakarta.validation.constraints.NotEmpty;

public record LanguageCreate(@NotEmpty @UniqueLanguageCode String code,
	@NotEmpty String name) {
    //
}

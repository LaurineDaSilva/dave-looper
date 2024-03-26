package co.simplon.davelooper.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.davelooper.dtos.LanguageCreate;
import co.simplon.davelooper.services.LanguageService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/languages")
class LanguageController {

    private final LanguageService service;

    public LanguageController(LanguageService service) {
	this.service = service;
    }

    @PostMapping
    void create(@RequestBody @Valid LanguageCreate inputs) {
	service.create(inputs);
    }
}

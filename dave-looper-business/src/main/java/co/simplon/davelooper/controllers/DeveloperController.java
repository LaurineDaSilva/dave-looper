package co.simplon.davelooper.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.davelooper.entities.Developer;
import co.simplon.davelooper.services.DeveloperService;

@RestController
@RequestMapping("/developers")
class DeveloperController {

    private final DeveloperService service;

    public DeveloperController(DeveloperService service) {
	this.service = service;
    }

    @GetMapping("/{number}")
    Developer oneByRegistrationNumber(@PathVariable("number") String number) {
	return service.oneByRegistrationNumber(number);
    }
}

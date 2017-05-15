package net.crespo.api.controller;

import java.util.List;

import net.crespo.model.Sith;
import net.crespo.service.SithService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = SithController.JEDI_BASE_URL_MAPPING)
class SithController {

    static final String JEDI_BASE_URL_MAPPING = "/api/sith";
    static final String JEDI_MAPPING = "/{sithId}";

    private final SithService service;

    @Autowired
    public SithController(SithService service) {
        this.service = service;
    }

    @GetMapping
    public List<Sith> findAll() {
        return service.findAll();
    }

    @GetMapping(value = JEDI_MAPPING)
    public Sith getById(@PathVariable Integer sithId) {
        return service.findOne(sithId);
    }

    @PostMapping
    public Sith add(@RequestBody Sith sith) {
        return service.save(sith);
    }

    @PutMapping
    public Sith update(@RequestBody Sith sith) {
        return service.save(sith);
    }

    @DeleteMapping(value = JEDI_MAPPING)
    public void delete(@PathVariable Integer sithId) {
        service.delete(sithId);
    }

}

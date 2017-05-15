package net.crespo.api.controller;

import java.util.List;

import net.crespo.model.Jedi;
import net.crespo.service.JediService;

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
@RequestMapping(value = JediController.JEDI_BASE_URL_MAPPING)
class JediController {

    static final String JEDI_BASE_URL_MAPPING = "/api/jedi";
    static final String JEDI_MAPPING = "/{jediId}";

    private final JediService service;

    @Autowired
    public JediController(JediService service) {
        this.service = service;
    }

    @GetMapping
    public List<Jedi> findAll() {
        return service.findAll();
    }

    @GetMapping(value = JEDI_MAPPING)
    public Jedi getById(@PathVariable Integer jediId) {
        return service.findOne(jediId);
    }

    @PostMapping
    public Jedi add(@RequestBody Jedi jedi) {
        return service.save(jedi);
    }

    @PutMapping
    public Jedi update(@RequestBody Jedi jedi) {
        return service.save(jedi);
    }

    @DeleteMapping(value = JEDI_MAPPING)
    public void delete(@PathVariable Integer jediId) {
        service.delete(jediId);
    }

}

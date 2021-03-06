package net.crespo.service;

import net.crespo.model.Jedi;

import java.util.List;

public interface JediService {

    List<Jedi> findAll();

    Jedi findOne(Integer id);

    Jedi save(Jedi jedi);

    void delete(Jedi Jedi);

    void delete(Integer id);

}

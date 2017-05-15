package net.crespo.service;

import net.crespo.model.Sith;

import java.util.List;

public interface SithService {

    List<Sith> findAll();

    Sith findOne(Integer id);

    Sith save(Sith sith);

    void delete(Sith sith);

    void delete(Integer id);

}

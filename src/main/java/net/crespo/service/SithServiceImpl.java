package net.crespo.service;

import net.crespo.model.Sith;
import net.crespo.repository.SithRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SithServiceImpl implements SithService {

    private final SithRepository repository;

    @Autowired
    public SithServiceImpl(SithRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Sith> findAll() {
        return repository.findAll();
    }

    @Override
    public Sith findOne(Integer id) {
        return repository.findOne(id);
    }

    @Override
    public Sith save(Sith sith) {
        return repository.save(sith);
    }

    @Override
    public void delete(Sith sith) {
        repository.delete(sith);
    }

    @Override
    public void delete(Integer id) {
        repository.delete(id);
    }


}

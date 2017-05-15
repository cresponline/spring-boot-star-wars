package net.crespo.service;

import net.crespo.model.Jedi;
import net.crespo.repository.JediRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JediServiceImpl implements JediService {

    private final JediRepository repository;

    @Autowired
    public JediServiceImpl(JediRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Jedi> findAll() {
        return repository.findAll();
    }

    @Override
    public Jedi findOne(Integer id) {
        return repository.findOne(id);
    }

    @Override
    public Jedi save(Jedi jedi) {
        return repository.save(jedi);
    }

    @Override
    public void delete(Jedi jedi) {
        repository.delete(jedi);
    }

    @Override
    public void delete(Integer id) {
        repository.delete(id);
    }


}

package net.crespo.repository;

import net.crespo.model.Sith;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SithRepository extends JpaRepository<Sith, Integer> {
}
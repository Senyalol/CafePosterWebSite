package com.Poster.Cafe.Repository;

import com.Poster.Cafe.Entity.Cafe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CafeRepository extends JpaRepository<Cafe, Integer> {

    Cafe findById(int id);
    Cafe findByName(String name);

}

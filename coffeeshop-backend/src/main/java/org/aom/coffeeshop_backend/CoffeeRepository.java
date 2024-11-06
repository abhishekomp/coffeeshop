package org.aom.coffeeshop_backend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CoffeeRepository extends JpaRepository<CoffeeEntity, Integer> {
}

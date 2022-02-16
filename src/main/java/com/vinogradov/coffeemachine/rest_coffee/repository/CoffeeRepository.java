package com.vinogradov.coffeemachine.rest_coffee.repository;

import com.vinogradov.coffeemachine.rest_coffee.model.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeRepository extends JpaRepository<Coffee, Integer> {
}

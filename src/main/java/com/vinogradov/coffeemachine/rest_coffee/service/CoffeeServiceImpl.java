package com.vinogradov.coffeemachine.rest_coffee.service;

import com.vinogradov.coffeemachine.rest_coffee.model.Coffee;
import com.vinogradov.coffeemachine.rest_coffee.repository.CoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoffeeServiceImpl implements CoffeeService {

    @Autowired
    private CoffeeRepository coffeeRepository;

    @Override
    public void create(Coffee coffee) {
        coffeeRepository.save(coffee);
    }

    @Override
    public List<Coffee> readAll() {
        return coffeeRepository.findAll();
    }

    @Override
    public Coffee read(int id) {
        return coffeeRepository.getById(id);
    }

    @Override
    public boolean delete(int id) {
        if (coffeeRepository.existsById(id)) {
            coffeeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

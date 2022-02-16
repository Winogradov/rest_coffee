package com.vinogradov.coffeemachine.rest_coffee.controller;

import com.vinogradov.coffeemachine.rest_coffee.model.Coffee;
import com.vinogradov.coffeemachine.rest_coffee.service.CoffeeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CoffeeController {

    private final CoffeeService coffeeService;

    @Autowired
    public CoffeeController(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }

    @Tag(name = "Выбор кофе", description = "выбор кофе")
    @PostMapping(value = "/coffee")
    public ResponseEntity<?> create(@RequestBody Coffee coffee) {
        coffeeService.create(coffee);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Tag(name = "Все заказанные кофе", description = "История использование")
    @GetMapping(value = "/coffee")
    public ResponseEntity<List<Coffee>> read() {
        final List<Coffee> coffee = coffeeService.readAll();

        return coffee != null && !coffee.isEmpty()
                ? new ResponseEntity<>(coffee, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Tag(name = "История использования", description = "Поиск по индексу")
    @GetMapping(value = "/coffee/{id}")
    public ResponseEntity<Coffee> read(@PathVariable(name = "id") int id) {
        final Coffee coffee = coffeeService.read(id);

        return coffee != null
                ? new ResponseEntity<>(coffee, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Tag(name = "Очистка истории использования", description = "Удаление по индексу")
    @DeleteMapping(value = "/coffee/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = coffeeService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}

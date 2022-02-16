package com.vinogradov.coffeemachine.rest_coffee.service;

import com.vinogradov.coffeemachine.rest_coffee.model.Coffee;

import java.util.List;

public interface CoffeeService {

    /*
    Создание новой порции кофе
     */
    void create(Coffee coffee);

    /*
    Возвращает список всех порций
     */
    List<Coffee> readAll();

    /*
    Возвращает порцию по ID
     */
    Coffee read(int id);

    /*
    Удаление порции из истории по ID
     */
    boolean delete(int id);


}

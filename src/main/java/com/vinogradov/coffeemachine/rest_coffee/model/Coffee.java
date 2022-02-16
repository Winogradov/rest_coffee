package com.vinogradov.coffeemachine.rest_coffee.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.persistence.*;

@Entity
@Table(name = "coffee")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Schema(description = "Варианты кофе")
public class Coffee {

    @Id
    @Column(name = "id")
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Schema(description = "Тип кофе" , example = "Капучино, Латте или Стандарт")
    @Column(name = "typeofcoffee")
    private String typeOfCoffee;

    @Schema(description = "Количество воды: 150 или 240 мл на выбор")
    @Column(name = "waterquantity")
    private Integer waterQuantity;

    @Schema(description = "Количество кофе: 5, 7 или 10 мг на выбор")
    @Column(name = "coffeequantity")
    private Integer coffeeQuantity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeOfCoffee() {
        return typeOfCoffee;
    }

    public void setTypeOfCoffee(String typeOfCoffee) {
        if (typeOfCoffee.equals("Капучино") | typeOfCoffee.equals("Латте") | typeOfCoffee.equals("Стандарт")) {
            this.typeOfCoffee = typeOfCoffee;
        }
    }

    public Integer getWaterQuantity() {
        return waterQuantity;
    }

    public void setWaterQuantity(Integer waterQuantity) {
        if (waterQuantity.equals(150) | waterQuantity.equals(240)) {
            this.waterQuantity = waterQuantity;
        }
    }

    public Integer getCoffeeQuantity() {
        return coffeeQuantity;
    }

    public void setCoffeeQuantity(Integer coffeeQuantity) {
        if (coffeeQuantity.equals(5) | coffeeQuantity.equals(7) | coffeeQuantity.equals(10)) {
            this.coffeeQuantity = coffeeQuantity;
        }
    }
}

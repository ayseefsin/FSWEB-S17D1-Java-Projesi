package com.aysin.sp17d1.controller;


import com.aysin.sp17d1.entity.Animal;
import com.aysin.sp17d1.utils.ValidationUtils;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/aysin/animal")
public class AnimalController {
    Map<Integer, Animal> animals;


    @PostConstruct
    public void initial(){
        animals=new HashMap<>();
        animals.put(1,new Animal(1,"cat"));
    }
    @GetMapping
    public List<Animal> getAnimals(){
        return new ArrayList<>(this.animals.values());
    }

    @GetMapping(path = "/{id}")
    public Animal getAnimal( @PathVariable("id") Integer id){
        ValidationUtils.checkID(id);
        return animals.get(id);
    }

    @PostMapping
    public void setAnimal(@RequestBody Animal animal){
        ValidationUtils.checkAnimal(animal);
        this.animals.put(animal.getId(), animal);
    }

    @PutMapping("/{id}")
    public Animal putAnimal( @PathVariable("id") Integer id, @RequestBody Animal newAnimal){
        ValidationUtils.checkID(id);
        ValidationUtils.checkAnimal(newAnimal);
        animals.put(id,newAnimal);
        return newAnimal;
    }

    @DeleteMapping("/{id}")
    public void deleteAnimal(@PathVariable("id") Integer id ){
        animals.remove(id);

    }

}

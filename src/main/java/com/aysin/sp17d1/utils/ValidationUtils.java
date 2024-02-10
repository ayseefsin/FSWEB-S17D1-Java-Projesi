package com.aysin.sp17d1.utils;

import com.aysin.sp17d1.entity.Animal;

public class ValidationUtils {

    public static void checkID(Integer id){
        if(id==null || id<0){
            System.out.println("Id cannot be null or cannot be smaller than zero");
        }
    }
    public static void checkAnimal(Animal animal){
        if(animal.getName()==null || animal.getName().isEmpty()){
            System.out.println("Animal name cannot be null or empty");
        }
    }


}

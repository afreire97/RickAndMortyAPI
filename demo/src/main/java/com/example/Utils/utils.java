package com.example.Utils;

import java.util.Random;


public class utils {
    

public static String getRandomNumberWithURL(){



    Random random = new Random();
    int id = random.nextInt(825) + 1; // Hay 671 personajes en la API de Rick and Morty
   return "https://rickandmortyapi.com/api/character/" + id;


}
public static int getRandom(int max){
    Random r = new Random();
    return  r.nextInt(max);
}
public static String getPage(String url){

    String [] trozos = url.split("=");


return trozos[trozos.length-1];

}
}

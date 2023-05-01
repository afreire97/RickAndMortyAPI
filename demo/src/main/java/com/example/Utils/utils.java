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
    int number = r.nextInt(max);
    return number;
}
public static String getPage(String url){

char page = url.charAt(url.length()-1);
String num = String.valueOf(page);
return num;

}
}

package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.example.Utils.utils;
import com.example.demo.models.CharacterInfo;
import com.example.demo.models.CharacterModel;
import com.example.demo.service.RickAndMortyService;



@RestController
@CrossOrigin(origins = "*")
public class RickAndMortyController {
    
    @Autowired
    RickAndMortyService rickAndMortyService;
  
   
    
    @GetMapping("/randomCharacter")
    public RedirectView getRandomCharacter() {
        String url = utils.getRandomNumberWithURL();
        return new RedirectView(url);
    }
   
    @GetMapping("/rickandmorty/random")
    public  String randomCharacter() {
        CharacterModel chm = rickAndMortyService.getCharacterRandom();
        return chm.name+ "<br/>" + chm.status + "<br/>" + chm.species + "<br/>" +  "<img width='200' src='"+chm.image+"'/>" ;
    }
    @GetMapping("/rickandmorty/next")
    public  String nextCharacter() {
        CharacterInfo info = rickAndMortyService.getInfo("1");
        return info.next;
    }
    @GetMapping("/try")
    public  String next() {
        CharacterInfo info = rickAndMortyService.getInfo("1");
        String number = info.next;
        number = utils.getPage(number);
        return number;
    }
    // @GetMapping("/rickandmorty/all")
    // public String allCharacters() {
    //     CharactersModel chm = rickAndMortyService.getAllCharacters();
    //     String enseñar = "";
    //     for (int i = 1; i < chm.results.size(); i++) {
    //         enseñar += chm.results.get(i).name + "<br/>" + "<img width='200' src='" + chm.results.get(i).image + "'/>" + "<br/>";
    //     }
    //     return enseñar;
    // }
   
}

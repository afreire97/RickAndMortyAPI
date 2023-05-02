package com.example.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.Utils.utils;
import com.example.demo.models.CharacterInfo;
import com.example.demo.models.CharacterModel;
import com.example.demo.models.CharactersModel;

@Service

public class RickAndMortyService {

    @Autowired
    private RestTemplate restTemplate;
    final String URL = "https://rickandmortyapi.com/api";
    public final String PAGE_ONE = "https://rickandmortyapi.com/api/character/?page=1";
    public CharacterModel getCharacterRandom() {
        final int TOTAL_CHARACTERS = 826;
        int random = utils.getRandom(TOTAL_CHARACTERS);
        String url = URL + "/character/" + random;
        CharacterModel datos = restTemplate.getForObject(url, CharacterModel.class);
        return datos;
    }
    public CharactersModel getAllCharacters(String page) {
        String url = "https://rickandmortyapi.com/api/character/?page=" + page;
        CharactersModel chsm = restTemplate.getForObject(url, CharactersModel.class);
        if (chsm.info.prev == null) {
            chsm.info.prev = PAGE_ONE;
        }
        return chsm;
    }
    public CharactersModel searchByName(String name) {
        String url = "https://rickandmortyapi.com/api/character/?name=" + name;
        CharactersModel chsm = restTemplate.getForObject(url, CharactersModel.class);
        return chsm;
    }
    
    public CharacterInfo getNextPage(String page) {
        String url = "https://rickandmortyapi.com/api/character/?page="+ page;
        CharactersModel chsm = restTemplate.getForObject(url, CharactersModel.class);
       
        return chsm.info;
    }
   

}


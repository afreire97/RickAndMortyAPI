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
        // chsm =restTemplate.getForObject(chsm.info.next, CharactersModel.class);
        
        return chsm;
    }
    public CharacterInfo getInfo(String page) {
        String url = "https://rickandmortyapi.com/api/character/?page="+ page;
        CharactersModel chsm = restTemplate.getForObject(url, CharactersModel.class);
        // chsm =restTemplate.getForObject(chsm.info.next, CharactersModel.class);
        
        return chsm.info;
    }
}


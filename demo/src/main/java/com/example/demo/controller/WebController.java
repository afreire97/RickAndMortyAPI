package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Utils.utils;
import com.example.demo.models.CharacterInfo;
import com.example.demo.models.CharactersModel;
import com.example.demo.service.RickAndMortyService;

@Controller
public class WebController {

    @Autowired
    RickAndMortyService rMortyService;

    @RequestMapping("/rickandmorty/alltemplate/{url}")
    public String charactersTemplate(Model model, @PathVariable String url) {
        CharactersModel chsm = rMortyService.getAllCharacters(url);
        model.addAttribute("characters", chsm.results);
        CharacterInfo chinfo = rMortyService.getNextPage(url);
        String next = chinfo.next;
        next = utils.getPage(next);
        String prev = chinfo.prev;
        prev = utils.getPage(prev);
        
        if (chinfo == null || chinfo.next == null) {
            next = "1";
        }
        model.addAttribute("prev", "/rickandmorty/alltemplate/" + prev);
        model.addAttribute("next", "/rickandmorty/alltemplate/" + next);

        return "rickandmortycharacters";

    }

}

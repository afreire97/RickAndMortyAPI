package com.example.demo.controller;

import java.util.ArrayList;

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
        if (chsm == null) {
            model.addAttribute("characters", new ArrayList<Character>());
            model.addAttribute("prev", "/rickandmorty/alltemplate/1");
            model.addAttribute("next", "/rickandmorty/alltemplate/1");
        } else {
            model.addAttribute("characters", chsm.results);
            String next = chsm.info.next;
            next = utils.getPage(next);

            String prev = chsm.info.prev;
            prev = utils.getPage(prev);

            if (next == null) {
                next = "1";
            }

            if (prev == null) {
                prev = "1";
            }

            model.addAttribute("prev", "/rickandmorty/alltemplate/" + prev);
            model.addAttribute("next", "/rickandmorty/alltemplate/" + next);
        }

        return "rickandmortycharacters";

    }

}

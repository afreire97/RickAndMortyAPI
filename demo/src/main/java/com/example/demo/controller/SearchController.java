package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.CharactersModel;
import com.example.demo.service.RickAndMortyService;


@Controller
public class SearchController {

    @Autowired
    RickAndMortyService rMortyService;
    @GetMapping("/buscar")
    public String buscar(@RequestParam("nombre") String nombre, Model model) {
        CharactersModel chsm = rMortyService.searchByName(nombre);
        model.addAttribute("busqueda", chsm.results);
        return "resultadobusqueda"; 
    }


}

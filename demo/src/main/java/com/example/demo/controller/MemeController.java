package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.MemeModel;
import com.example.demo.service.MemeService;



@Controller
public class MemeController {
    @Autowired
    MemeService memeService;

    @RequestMapping("/memes")
    public String memes(Model model){
        ArrayList<MemeModel> memes = memeService.getAllMemes();
        model.addAttribute("misMemes", memes);
        return "memeList";
    } 

    @PostMapping("/memes")
    public String memesAdd(@RequestParam Map<String, String> body){
        String description = body.get("description");
        String urlImage = body.get("urlImage");
        String category = body.get("category");
        String author = body.get("author");

        MemeModel nuevoMeme = new MemeModel();
        nuevoMeme.setDescription(description);
        nuevoMeme.setUrlImage(urlImage);
        nuevoMeme.setCategory(category);
        nuevoMeme.setAuthor(author);

        memeService.createMeme(nuevoMeme);
        return "memeOK";
    }

    @RequestMapping("/memes/addForm")
    public String memeAddForm(){
        return "memeAddForm";
    }  

}
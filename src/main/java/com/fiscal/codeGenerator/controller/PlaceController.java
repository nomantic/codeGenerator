package com.fiscal.codeGenerator.controller;

import com.fiscal.codeGenerator.entity.*;
import com.fiscal.codeGenerator.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlaceController {

    private PlaceService placeService;
    @Autowired
    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @GetMapping(path = "/allPlaces")
    public List<PlaceEntity> getPlaceList(){
        return placeService.getPlaceList();
    }
//this endpoint finds a list of all the nations
    @GetMapping(path = "/nations")
    public List<Nation> getNations() {
        return placeService.getNationList();
    }

    @GetMapping(path = "/province")
    public List<Province> getProvinceList() {
        return placeService.getProvinceList();
    }

    @GetMapping(path = "/comuni")
    public List<Comune> getComuneList() {
        return placeService.getComuneList();
    }
    @GetMapping(path = "/validComuni")
    public List<ValidComune> getValidComuneList() {
        return placeService.getValidComuneList();
    }

    @PostMapping("/submitUser")
    public List<PlaceEntity> addPlace(@RequestBody User user) {
        return placeService.getControlledPlaceList(user);
    }

    @PostMapping("/nameAbbreviate")
    public String nameAbbreviation(@RequestBody User user) {
        return placeService.nameSimplifier(user);
    }


}

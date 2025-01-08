package com.fiscal.codeGenerator.controller;

import com.fiscal.codeGenerator.entity.PlaceEntity;
import com.fiscal.codeGenerator.entity.User;
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

    @PostMapping("/submitUser")
    public List<PlaceEntity> addPlace(@RequestBody User user) {
        return placeService.getControlledPlaceList(user);
    }


}

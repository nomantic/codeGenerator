package com.fiscal.codeGenerator.service;

import com.fiscal.codeGenerator.entity.PlaceEntity;
import com.fiscal.codeGenerator.entity.User;
import com.fiscal.codeGenerator.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PlaceService {
    private PlaceRepository repository;
    @Autowired
    public PlaceService(PlaceRepository repository) {
        this.repository = repository;
    }

    public List<PlaceEntity> getPlaceList() {
        return repository.findAll();
    }

    //takes a user input from the controller and sorts out the places depending on the dob of the user
    public List<PlaceEntity> getControlledPlaceList(User user) {
        List<PlaceEntity> controlledPlaceList = new ArrayList<>();
        List<PlaceEntity> allPlaces = repository.findAll();
        LocalDate input = user.getUserDob();
        for (PlaceEntity place : allPlaces) {
            if(place.getData_Inizio_Validita().isBefore(input)){
                controlledPlaceList.add(place);
            }
        }
        return controlledPlaceList;
    }

    //name simplifier makes abbreviation  of a given name
    public String nameSimplifier(User user) {
        String simplifiedName = "";
        double d = Math.ceil(user.getUserName().length() / 2.0);
        Double[] index ={0.0, d - 1.0, user.getUserName().length() - 1.0};
            for ( double j : index) {
                simplifiedName += user.getUserName().charAt((int)j);
            }
        return simplifiedName;
    }
}

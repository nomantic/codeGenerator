package com.fiscal.codeGenerator.service;

import com.fiscal.codeGenerator.entity.*;
import com.fiscal.codeGenerator.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PlaceService implements CodeService {
    private PlaceRepository repository;
    private NationRepository nationRepository;
    private ProvinceRepository provinceRepository;
    private ComuneRepository comuneRepository;
    private ValidComuneRepository validComuneRepository;
    @Autowired
    public PlaceService(PlaceRepository repository, NationRepository nationRepository, ProvinceRepository provinceRepository, ComuneRepository comuneRepository, ValidComuneRepository validComuneRepository) {
        this.nationRepository = nationRepository;
        this.repository = repository;
        this.provinceRepository = provinceRepository;
        this.comuneRepository = comuneRepository;
        this.validComuneRepository = validComuneRepository;
    }
//for demo database
    public List<PlaceEntity> getPlaceList() {
        return repository.findAll();
    }

    public List<Nation> getNationList() {return nationRepository.findAll(); }

    public List<Province> getProvinceList() {return provinceRepository.findAll(); }

    public List<Comune> getComuneList() {return comuneRepository.findAll(); }

    public List<ValidComune> getValidComuneList() {return validComuneRepository.findAll(); }



    //takes a user input from the controller and sorts out the places depending on the dob of the user \\ for demo database
    @Override
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

    //name simplifier makes abbreviation  of a given name \\ for demo database
    @Override
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
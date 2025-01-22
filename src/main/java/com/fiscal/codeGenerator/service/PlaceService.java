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

    //gets comune if they exsisted depending on user birthdate
    public List<ValidComune> getControlledComuneList(User user) {
        List<ValidComune> controlledComuneList = new ArrayList<>();
        List<ValidComune> allComune = validComuneRepository.findAll();
        LocalDate input = user.getUserDob();
        for (ValidComune comune : allComune) {
            if(comune.getStartDate().isBefore(input)) {
                if (comune.getEndDate() == null || comune.getEndDate().isAfter(input)) {
                    controlledComuneList.add(comune);
                }
            }
        }
        return controlledComuneList;
    }

    //searches comune by string and returns a province
    public Province getProvinceByComune(String comuneName) {
        List<Comune> c = getComuneList();
        Province province = null;
        for (Comune comune : c) {
            if(comune.getPlaceName().toLowerCase().equals(comuneName.toLowerCase())) {
                province = getProvince(comune);
            }
        }
        return province;
    }
    //takes a comune as argument and returns a province
    public Province getProvince(Comune comune) {
        List<Province> Provinces = getProvinceList();
        Province p = null;
        for (Province province : Provinces) {
            if(comune.getProvinceCode().equals(province.getProvinceCode())) {
                p = province;
                break;
            }
        }
        return p;
    }

    //gets province depending on which comune it's part of
    public Province getProvinceByValidComune(ValidComune validComune) {
        List<Province> provinces = getProvinceList();
        Province p = null;
        for (Province province : provinces) {
            validComune.getProvinceInitials().equals(province.getProvinceAbbriviation());
            p = province;
            break;
        }
        return p;
    }

    //searches valid comune by name
    public List<ValidComune> getValidComuneByName(String name) {
        List<ValidComune> validComuneList = getValidComuneList();
        List<ValidComune> newValidComune = new ArrayList<>();
        for (ValidComune validComune : validComuneList) {
            if(validComune.getPlaceName().equals(name.toUpperCase())) {
                newValidComune.add(validComune);
                System.out.println(validComune.getPlaceName());
            }

        }
        return newValidComune;
    }



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
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
    private NationRepository nationRepository;
    private ProvinceRepository provinceRepository;
    private ComuneRepository comuneRepository;
    private ValidComuneRepository validComuneRepository;
    @Autowired
    public PlaceService(NationRepository nationRepository, ProvinceRepository provinceRepository, ComuneRepository comuneRepository, ValidComuneRepository validComuneRepository) {
        this.nationRepository = nationRepository;
        this.provinceRepository = provinceRepository;
        this.comuneRepository = comuneRepository;
        this.validComuneRepository = validComuneRepository;
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
        Province p = provinceRepository.findByProvinceAbbriviation(validComune.getProvinceInitials());
        return p;
//        List<Province> provinces = getProvinceList();
//        Province p = null;
//        for (Province province : provinces) {
//            if(province.getProvinceAbbriviation().equals(validComune.getProvinceInitials())) {
//                p = province;
//                break;
//            }
//        }
//        return p;
    }

    //searches valid comune by name
    public List<ValidComune> getValidComuneByName(String name) {
        List<ValidComune> validComune = validComuneRepository.getValidComuneByPlaceName(name);
        return validComune;
//        List<ValidComune> validComuneList = getValidComuneList();
//        List<ValidComune> newValidComune = new ArrayList<>();
//        for (ValidComune validComune : validComuneList) {
//            if(validComune.getPlaceName().equals(name.toUpperCase())) {
//                newValidComune.add(validComune);
//                System.out.println(validComune.getPlaceName());
//            }
//
//        }
//        return newValidComune;
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
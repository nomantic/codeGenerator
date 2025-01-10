package com.fiscal.codeGenerator.service;

import com.fiscal.codeGenerator.entity.PlaceEntity;
import com.fiscal.codeGenerator.entity.User;

import java.util.List;

public interface CodeService {

    public List<PlaceEntity> getControlledPlaceList(User user);

    public String nameSimplifier(User user);
}

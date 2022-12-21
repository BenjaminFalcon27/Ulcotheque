package com.univlittoral.projetback.mapper;

import java.util.ArrayList;
import java.util.List;

import com.univlittoral.projetback.dto.AuteurDTO;
import com.univlittoral.projetback.dto.HomeDTO;
import com.univlittoral.projetback.entity.AuteurEntity;

public class AuteurMapper {
  public static AuteurDTO dtoToEntity(AuteurEntity auteurEntity) {
    AuteurDTO result = new AuteurDTO();
    result.setId(auteurEntity.getId());
    result.setNom(auteurEntity.getNom());
    result.setPrenom(auteurEntity.getPrenom());
    result.setDate(auteurEntity.getDate());
    return result;
  }

  public static List<AuteurDTO> dtoToEntity(List<AuteurEntity> auteurEntity) {
    List<AuteurDTO> result = new ArrayList<AuteurDTO>();

    for (final AuteurEntity entity : auteurEntity) {
      result.add(AuteurMapper.dtoToEntity(entity));
    }
    return result;
  }
}

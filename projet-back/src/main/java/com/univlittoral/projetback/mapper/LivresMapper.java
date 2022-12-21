package com.univlittoral.projetback.mapper;

import java.util.ArrayList;
import java.util.List;

import com.univlittoral.projetback.dto.AuteurDTO;
import com.univlittoral.projetback.dto.HomeDTO;
import com.univlittoral.projetback.dto.LivresDTO;
import com.univlittoral.projetback.entity.AuteurEntity;
import com.univlittoral.projetback.entity.LivresEntity;

public class LivresMapper {

    public static LivresDTO dtoToEntity(LivresEntity livreEntity) {
        LivresDTO result = new LivresDTO();
        result.setId(livreEntity.getId());
        result.setNom(livreEntity.getNom());
        result.setEditeur(livreEntity.getEditeur());
        result.setNbPages(livreEntity.getNbPages());
        result.setLieuParution(livreEntity.getLieuParution());
        result.setDateParution(livreEntity.getDateParution());
        result.setGenre(livreEntity.getGenre());
        return result;
    }

    public static List<LivresDTO> dtoToEntity(List<LivresEntity> bookEntity) {
        List<LivresDTO> result = new ArrayList<LivresDTO>();

        for (final LivresEntity entity : bookEntity) {
            result.add(LivresMapper.dtoToEntity(entity));
        }
        return result;
    }

    public static LivresEntity entityToDTO(LivresDTO livreDTO) {
        LivresEntity result = new LivresEntity();
        result.setId(livreDTO.getId());
        result.setNom(livreDTO.getNom());
        result.setEditeur(livreDTO.getEditeur());
        result.setNbPages(livreDTO.getNbPages());
        result.setLieuParution(livreDTO.getLieuParution());
        result.setDateParution(livreDTO.getDateParution());
        result.setGenre(livreDTO.getGenre());
        return result;
    }

    public static List<LivresEntity> entityToDTO(List<LivresDTO> livreDTO) {
        List<LivresEntity> result = new ArrayList<LivresEntity>();

        for (final LivresDTO dto : livreDTO) {
            result.add(LivresMapper.entityToDTO(dto));
        }
        return result;
    }

    // public static AuteurDTO map(AuteurEntity auteurEntity) {
    // AuteurDTO result = new AuteurDTO();
    // result.setId(auteurEntity.getId());
    // result.setNom(auteurEntity.getNom());
    // result.setPrenom(auteurEntity.getPrenom());
    // result.setDate(auteurEntity.getDate());
    // return result;
    // }
}

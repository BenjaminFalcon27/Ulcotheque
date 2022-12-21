package com.univlittoral.projetback.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.univlittoral.projetback.dto.AuteurDTO;
import com.univlittoral.projetback.dto.HomeDTO;
import com.univlittoral.projetback.dto.IndicateurDTO;
import com.univlittoral.projetback.dto.LivresDTO;
import com.univlittoral.projetback.mapper.AuteurMapper;
import com.univlittoral.projetback.mapper.LivresMapper;
import com.univlittoral.projetback.service.AuteurService;
import com.univlittoral.projetback.service.LivresService;

@RestController
@RequestMapping(value = "rest/bd/home")
public class HomeController {

	@Autowired
	private LivresService service;
	// private AuteurService serviceAuteur;

	@GetMapping
	public HomeDTO findAllLivres() {
		// list qui contient tout les books
		List<LivresDTO> livredto = LivresMapper.dtoToEntity(service.findAll());
		// List<AuteurDTO> auteurdto =
		// AuteurMapper.dtoToEntity(serviceAuteur.findAll());
		// remplissage des indicateurs à partir de la taille de la liste
		IndicateurDTO indicateurs = new IndicateurDTO();
		indicateurs.setNbLivres(livredto.size());
		// indicateurs.setNbAuteurs(auteurdto.size());
		HomeDTO homedto = new HomeDTO();
		homedto.setLivres(LivresMapper.dtoToEntity(service.findAll()));
		homedto.setIndicateurs(indicateurs);
		return homedto;
	}
}

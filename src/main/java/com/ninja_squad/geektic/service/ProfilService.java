package com.ninja_squad.geektic.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ninja_squad.geektic.metier.GeekDao;

@RestController
@Transactional
@RequestMapping("/api/profil")
public class ProfilService {
	
    @Autowired
    private GeekDao dao;
}

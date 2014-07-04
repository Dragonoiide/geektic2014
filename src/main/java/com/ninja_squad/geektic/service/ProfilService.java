package com.ninja_squad.geektic.service;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ninja_squad.geektic.metier.Geek;
import com.ninja_squad.geektic.metier.GeekDao;

@RestController
@Transactional
@RequestMapping("/api/profil")
public class ProfilService {
	
    @Autowired
    private GeekDao dao;
    
    @RequestMapping(method = GET)
    public Geek rechercheProfil(@RequestParam long id){
            Geek g = dao.findById(id);
            return g;
    }
}

package com.ninja_squad.geektic.service;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ninja_squad.geektic.metier.GeekDao;
import com.ninja_squad.geektic.metier.Interet;
import com.ninja_squad.geektic.metier.InteretDao;

@RestController
@Transactional
@RequestMapping("/api/recherche")
public class RechercheService {
	
    @Autowired
    private GeekDao geekDao;
    @Autowired
    private InteretDao interetDao;
    
    @RequestMapping(method = GET)
    public List<Interet> getInteret(){
            List<Interet> interet = interetDao.findAll();
            return interet;
    }
}

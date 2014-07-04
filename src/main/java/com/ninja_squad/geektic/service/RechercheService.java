package com.ninja_squad.geektic.service;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ninja_squad.geektic.metier.Geek;
import com.ninja_squad.geektic.metier.GeekDao;
import com.ninja_squad.geektic.metier.Interet;
import com.ninja_squad.geektic.metier.InteretDao;

@RestController
@Transactional
@RequestMapping("/api")
public class RechercheService {
	
    @Autowired
    private GeekDao geekDao;
    @Autowired
    private InteretDao interetDao;
    
    @RequestMapping(value="/interet", method = GET)
    public List<Interet> getInteret(){
            List<Interet> interet = interetDao.findAll();
            return interet;
    }
    
    @RequestMapping(value="/recherche", method = GET)
    public List<Geek> rechercheGeek(@RequestParam String sexe,@RequestParam String interet)
    {
    	List<Geek> listGeek = geekDao.research(sexe, interet);
    	return listGeek;
    }
}

package com.ninja_squad.geektic.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.*;
import org.springframework.web.bind.annotation.RestController;

import com.ninja_squad.geektic.metier.Geek;
import com.ninja_squad.geektic.metier.GeekDao;

@RestController
@Transactional
@RequestMapping("/api/utilisateurs")
public class UtilisateursService {
        @Autowired
        private GeekDao dao;
        
        @RequestMapping(method = GET)
        public List<Geek> afficheGeeks(){
                List<Geek> listeGeeks = dao.findAll();
                return listeGeeks;
        }
}

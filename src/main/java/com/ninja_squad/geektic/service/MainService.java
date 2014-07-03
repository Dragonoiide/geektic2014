package com.ninja_squad.geektic.service;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ninja_squad.geektic.metier.Geek;
import com.ninja_squad.geektic.metier.GeekDao;

@RestController
@Transactional
@RequestMapping("/api/main")
public class MainService {
	@Autowired
    private GeekDao dao;
    
    @RequestMapping(method = GET)
    public int compteGeeks(){
            int nombre = dao.countGeek();
            return nombre;
    }
}

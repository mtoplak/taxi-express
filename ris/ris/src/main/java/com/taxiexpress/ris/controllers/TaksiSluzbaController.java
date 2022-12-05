package com.taxiexpress.ris.controllers;

//import com.taxiexpress.ris.dao.TaksiSluzbaRepository;
import com.taxiexpress.ris.models.TaksiSluzba;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sluzbe")
public class TaksiSluzbaController {
/*
    @Autowired
    private TaksiSluzbaRepository sluzbaDao;


    @GetMapping("")
    public Iterable<TaksiSluzba> vrniSluzbe(){
        return sluzbaDao.findAll();
    }*/
}

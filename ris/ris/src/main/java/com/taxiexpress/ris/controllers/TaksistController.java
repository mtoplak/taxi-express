package com.taxiexpress.ris.controllers;

import com.taxiexpress.ris.dao.TaksistRepository;
import com.taxiexpress.ris.models.Taksist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/taksist")
public class TaksistController {

    @Autowired
    private TaksistRepository taksistDao;

    // poizvedba z 2 modeloma
    // izpis taksistov taksi službe z nazivom x
    @GetMapping("/taksisti/{naziv}")
    public Iterable<Taksist> vrniTaksisteOdSluzbe(@PathVariable(name = "naziv") String naziv){
        return taksistDao.vrniTaksisteOdSluzbe(naziv);
    }
}

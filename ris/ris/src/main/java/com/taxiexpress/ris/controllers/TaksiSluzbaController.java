package com.taxiexpress.ris.controllers;

import com.taxiexpress.ris.dao.TaksiSluzbaRepository;
import com.taxiexpress.ris.models.Placilo;
import com.taxiexpress.ris.models.TaksiSluzba;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sluzbe")
public class TaksiSluzbaController {

    @Autowired
    private TaksiSluzbaRepository sluzbaDao;

    @GetMapping("")
    public Iterable<TaksiSluzba> vrniVseSluzbe() {
        return sluzbaDao.findAll();
    }

    @PostMapping(value = "/dodaj", consumes = MediaType.APPLICATION_JSON_VALUE)
    public TaksiSluzba dodajTaxiSluzbo(@RequestBody TaksiSluzba sluzba){
        return sluzbaDao.save(sluzba);
    }

    @PutMapping("/spremeni/{id}")
    public TaksiSluzba spremeniSluzbo(@PathVariable(name="id") Long id, @RequestBody TaksiSluzba sluzba) {
        if(!sluzbaDao.existsById(id))
            return null;

        sluzba.setId(id);
        return sluzbaDao.save(sluzba);
    }

    @DeleteMapping("/zbrisi/{id}")
    public Boolean izbrisiSluzbo(@PathVariable(name="id") Long id) {
        if(!sluzbaDao.existsById(id)){
            return false;
        }
        sluzbaDao.deleteById(id);
        return true;
    }



}

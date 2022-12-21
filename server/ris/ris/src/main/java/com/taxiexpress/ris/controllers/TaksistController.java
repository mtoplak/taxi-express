package com.taxiexpress.ris.controllers;

import com.taxiexpress.ris.dao.TaksistRepository;
import com.taxiexpress.ris.models.Taksist;
import com.taxiexpress.ris.models.Uporabnik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/taksist")
public class TaksistController {

    @Autowired
    private TaksistRepository taksistDao;

    @GetMapping("")
    public Iterable<Taksist> vrniVseUporabnike() {
        return taksistDao.findAll();
    }

    @PostMapping("/dodaj")
    public Taksist dodajTaksista(@RequestBody Taksist taksist) {
        return taksistDao.save(taksist);
    }

    @PutMapping("/spremeni/{id}")
    public Taksist spremeniTaksista(@PathVariable(name="id") Long id, @RequestBody Taksist taksist) {

        if (!taksistDao.existsById(id)){
            return null;
        }
        taksist.setId(id);
        return taksistDao.save(taksist);
    }

    @DeleteMapping("/zbrisi/{id}")
    public Boolean izbrisiTaksista(@PathVariable(name="id") Long id) {

        if(!taksistDao.existsById(id)){
            return false;
        }
        taksistDao.deleteById(id);
        return true;
    }

    // poizvedba z 2 modeloma
    // izpis taksistov taksi službe z nazivom x
    @GetMapping("/taksisti/{naziv}")
    public Iterable<Taksist> vrniTaksisteOdSluzbe(@PathVariable(name = "naziv") String naziv){
        return taksistDao.vrniTaksisteOdSluzbe(naziv);
    }

    // poizvedba z 3 modeli
    // izpis taksista, kateri taksi vozi, in pri kateri taksi službi
    @GetMapping("/ime/{ime}")
    public List vrniTaksiste(@PathVariable(name = "ime") String ime){
        return taksistDao.vrniTaksisteOdSluzbe(ime);
    }
}

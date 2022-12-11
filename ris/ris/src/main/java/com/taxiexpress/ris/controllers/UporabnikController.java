package com.taxiexpress.ris.controllers;

import com.taxiexpress.ris.dao.*;
import com.taxiexpress.ris.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/uporabnik")
public class UporabnikController {
    @Autowired
    private UporabnikRepository uporabnikDao;

    @GetMapping("")
    public Iterable<Uporabnik> vrniVseUporabnike() {
        return uporabnikDao.findAll();
    }
    @GetMapping("{id}")
    public Optional<Uporabnik> vrniUporabnika(@PathVariable(name="id") Long id) {
        return uporabnikDao.findById(id);
    }
    @PostMapping("/dodajUporabnika")
    public Uporabnik dodajUporabnika(@RequestBody Uporabnik uporabnik)
    {return uporabnikDao.save(uporabnik);}

    @PutMapping("/spremeni/{id}")
    public Uporabnik spremeniUporabnika(@PathVariable(name="id") Long id, @RequestBody Uporabnik uporabnik) {

        if (!uporabnikDao.existsById(id))
            return null;

        uporabnik.setId(id);
        return uporabnikDao.save(uporabnik);
    }
    @DeleteMapping("/zbrisi/{id}")
    public Boolean izbrisiUporabnika(@PathVariable(name="id") Long id) {

        if(!uporabnikDao.existsById(id))
            return false;
        uporabnikDao.deleteById(id);
        return true;
    }

    // kompleksna poizvedba (osnovni del)
    // vrne uporabnika z dolločenih imenom in priimkom
    @GetMapping("/ime/{ime}/priimek/{priimek}")
    public Iterable<Uporabnik> vrniDolocenegaUporabnika(@PathVariable(name = "ime") String ime, @PathVariable(name = "priimek") String priimek) {
        return uporabnikDao.vrniDolocenegaUporabnika(ime, priimek);
    }
    /*
    // 1. kompleksnejša poizvedba z 3 parametri
    // vrni uporabniski niz (ime, email, priimek)
    @GetMapping("/ime/{ime}/email/{email}/priimek/{priimek}")
    public Iterable<Uporabnik> vrniUporabniskiNiz(@PathVariable(name = "ime") String ime, @PathVariable(name = "email") String email, @PathVariable(name = "priimek") String priimek) {
        return uporabnikDao.vrniUporabniskiNiz(ime, email, priimek);
    }

    //2. kompleksnejša poizvedba z 3 parametri
    // vrne uporabnike, ki niso admini in je njihovo ime ali priimek 'adam'
    @GetMapping("/jeAdmin/{jeAdmin}/ime/{ime}/priimek/{priimek}")
    public Iterable<Uporabnik> vrniUporabnikeBrezAdminov(@PathVariable(name="jeAdmin") boolean jeAdmin, @PathVariable(name="ime") String ime, @PathVariable(name = "priimek") String priimek) {
        return uporabnikDao.vrniUporabnikeBrezAdminov(jeAdmin, ime, priimek);
    }

     */



}

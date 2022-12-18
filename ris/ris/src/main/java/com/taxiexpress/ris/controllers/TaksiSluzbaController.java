package com.taxiexpress.ris.controllers;

import com.taxiexpress.ris.dao.TaksiSluzbaRepository;
import com.taxiexpress.ris.models.Placilo;
import com.taxiexpress.ris.models.Taksi;
import com.taxiexpress.ris.models.TaksiSluzba;
import com.taxiexpress.ris.models.Taksist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    // poizvedba z 2 modeloma
    // izpis vseh taksijev taksi službe z nazivom x
    // to mislim, da ni v pravem filu
    @GetMapping("/taksiji/{naziv}")
    public Iterable<Taksi> vrniTaksijeOdSluzbe(@PathVariable(name = "naziv") String naziv){
        return sluzbaDao.vrniTaksijeOdSluzbe(naziv);
    }


    // poizvedba z 2 modeloma
    // izpis taksistov taksi službe z nazivom x
    // to mislim, da ni v pravem filu
    @GetMapping("/taksisti/{naziv}")
    public Iterable<Taksist> vrniTaksisteOdSluzbe(@PathVariable(name = "naziv") String naziv){
        return sluzbaDao.vrniTaksisteOdSluzbe(naziv);
    }

    // poizvedba z 2 modeloma
    // izpis taksi služb, ki imajo več kot x taksijev
    @GetMapping("/taksisti2/{stevilo}")
    public ArrayList<TaksiSluzba> vrniTaksijeOdSluzbe2(@PathVariable(name = "stevilo") int stevilo){
        return sluzbaDao.vrniTaksijeOdSluzbe2(stevilo);
    }

    // poizvedba z 2 modeloma
    // izpis taksi služb, ki imajo več kot x taksistov
    @GetMapping("/taksisti3/{stevilo}")
    public ArrayList<TaksiSluzba> vrniTaksijeOdSluzbe3(@PathVariable(name = "stevilo") int stevilo){
        return sluzbaDao.vrniTaksijeOdSluzbe3(stevilo);
    }

    // poizvedba s 3 modeli
    // vrne taksije in taksiste od taksi službe z id-jem x
    @GetMapping("/taksijiInTaksisti/{id}")
    public List vrniTaksijeInTaksiste(@PathVariable(name = "id") int id){
        System.out.println(id);
        return sluzbaDao.vrniTaksijeInTaksiste(id);
    }

    // poizvedba s 3 modeli
    // vrne taksi službe in taksije, ki imajo taksista z imenom x
    @GetMapping("taksijiInTaksiSluzbe/{ime}")
    public List vrniTaksijeInSluzbe(@PathVariable(name = "ime") String ime){
        System.out.println(ime);
        return sluzbaDao.vrniTaksijeInSluzbe(ime);
    }

    // poizvedba s 3 modeli
    // vrne taksiste in taksi službe od službe, ki imajo taksi z določeno registrsko številko x
    @GetMapping("taksistiInTaksiSluzbe/{reg}")
    public List vrniTaksisteInSluzbe(@PathVariable(name = "reg") String reg){
        return sluzbaDao.vrniTaksisteInSluzbe(reg);
    }
}

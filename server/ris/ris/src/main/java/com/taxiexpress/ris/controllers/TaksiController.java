package com.taxiexpress.ris.controllers;

import com.taxiexpress.ris.dao.TaksiRepository;
import com.taxiexpress.ris.models.Placilo;
import com.taxiexpress.ris.models.Taksi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/taksiji")
public class TaksiController {

    @Autowired
    private TaksiRepository taksiDao;

    @GetMapping("")
    public Iterable<Taksi> vrniVseTaksije() {
        return taksiDao.findAll();
    }

    @PostMapping("/dodaj")
    public Taksi dodajTaksi(@RequestBody Taksi taksi){
        return taksiDao.save(taksi);
    }

    @PutMapping("/spremeni/{id}")
    public Taksi spremeniPlacilo(@PathVariable(name="id") Long id, @RequestBody Taksi taksi) {
        if(!taksiDao.existsById(id))
            return null;

        taksi.setId(id);
        return taksiDao.save(taksi);
    }

    @DeleteMapping("/zbrisi/{id}")
    public Boolean izbrisiTaksi(@PathVariable(name="id") Long id) {
        if(!taksiDao.existsById(id))
            return false;
        taksiDao.deleteById(id);
        return true;
    }

    // poizvedba z 2 modeloma
    // izpis vseh taksijev taksi službe z nazivom x
    @GetMapping("/taksiji/{naziv}")
    public Iterable<Taksi> vrniTaksijeOdSluzbe(@PathVariable(name = "naziv") String naziv){
        return taksiDao.vrniTaksijeOdSluzbe(naziv);
    }

    // poskusna
    @GetMapping("/taksiji2/{naziv}")
    public ArrayList<Taksi> vrniTaksijeOdSluzbe2(@PathVariable(name = "naziv") String naziv){
        return taksiDao.vrniTaksijeOdSluzbe2(naziv);
    }

}

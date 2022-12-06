package com.taxiexpress.ris.controllers;

import com.taxiexpress.ris.dao.PlaciloRepository;
import com.taxiexpress.ris.models.Placilo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/placilo")
public class PlaciloController {

    @Autowired
    private PlaciloRepository placiloDao;

    @GetMapping("")
    public Iterable<Placilo> vrniVsaPlacila() {
        return placiloDao.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Placilo> vrniPlacilo(@PathVariable(name="id") Long id) {
        return placiloDao.findById(id);
    }

    @PostMapping("/dodaj")
    public Placilo dodajPlacilo(@RequestBody Placilo placilo){
            return placiloDao.save(placilo);
    }

    @PutMapping("/spremeni/{id}")
    public Placilo spremeniPlacilo(@PathVariable(name="id") Long id, @RequestBody Placilo placilo) {
        if(!placiloDao.existsById(id))
            return null;

        placilo.setId(id);
        return placiloDao.save(placilo);
    }

    @DeleteMapping("/zbrisi/{id}")
    public Boolean izbrisiPlacilo(@PathVariable(name="id") Long id) {
        if(!placiloDao.existsById(id))
            return false;
        placiloDao.deleteById(id);
        return true;
    }

    // kompleksna poizvedba (osnovni del)
    // vrne true, če je točno določeno plačilo večje kot podan znesek oz. false, če ni večje kot podan znesek
    @GetMapping("/znesek/{znesek}/id/{id}")
    public boolean vrnoDolocenoPlaciloCeJeVecje(@PathVariable(name = "znesek") float znesek, @PathVariable(name = "id") long id) {
        return (placiloDao.vrnoDolocenoPlaciloCeJeVecje(znesek, id).size() == 1);
    }

    // 1. kompleksnejša poizvedba z 3 parametri
    // vrni plačila, ki nimajo določenega časa plačila, niso plačana ali pa imajo opombo
    @GetMapping("/zNapako")
    public Iterable<Placilo> vrniPlacilaZNapako() {
        return (placiloDao.vrniPlacilaZNapako());
    }

    //2. kompleksnejša poizvedba z 3 parametri
    // vrne plačila, ki so neplačana (status false), med določenima datumoma in so večja od 20€
    @GetMapping("/neplacana")
    public Iterable<Placilo> vrniNeplacana(){
        return (placiloDao.vrniNeplacana());
    }

}

package com.taxiexpress.ris.controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.taxiexpress.ris.dao.*;
import com.taxiexpress.ris.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
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
    public Uporabnik dodajUporabnika(@RequestBody Uporabnik uporabnik) {
        return uporabnikDao.save(uporabnik);
    }

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

    // registracija
    @PostMapping("/registracija")
    public boolean registracijaUporabnika(@RequestBody Uporabnik uporabnik) throws NoSuchAlgorithmException {
        List<Uporabnik> tempUporabnik = uporabnikDao.preveriCeEmailObstaja(uporabnik.getEmail());
        if(tempUporabnik.size() > 0){
            // uporabnik že obstaja
            return false;
        }
        String geslo = uporabnik.getGeslo();
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(geslo.getBytes(StandardCharsets.UTF_8));
        byte[] digest = md.digest();

        String hex = String.format("%064x", new BigInteger(1, digest));
        uporabnik.setGeslo(hex);
        System.out.println(uporabnik.getGeslo());
        /*
        MessageDigest digest1 = MessageDigest.getInstance("SHA-256");
        byte[] encodedhash = digest1.digest(
                geslo.getBytes(StandardCharsets.UTF_8));
        System.out.println("Drugi način: "+encodedhash);*/
        uporabnikDao.save(uporabnik);
        System.out.println("Registracija uspešna");
        return true;
    }

    // prijava
    @PostMapping("/prijava")
    public boolean vrniLogin(@RequestBody ObjectNode objectNode) throws NoSuchAlgorithmException {
        System.out.println(objectNode);

        String geslo = objectNode.get("geslo").asText();
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(geslo.getBytes(StandardCharsets.UTF_8));
        byte[] digest = md.digest();
        String hex = String.format("%064x", new BigInteger(1, digest));

        List<Uporabnik> tempUporabnik = uporabnikDao.vrniLogin(hex, objectNode.get("email").asText());
        System.out.println(tempUporabnik);
        if(tempUporabnik.size() > 0){
            System.out.println("Prijava uspešna");
            return true;
        }
        return false;
    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

}

package com.taxiexpress.ris.dao;

import com.taxiexpress.ris.models.Taksi;
import com.taxiexpress.ris.models.TaksiSluzba;
import com.taxiexpress.ris.models.Taksist;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface TaksiSluzbaRepository extends CrudRepository<TaksiSluzba, Long> {

    @Query(value = "SELECT * FROM taksi t INNER JOIN taksi_sluzba ts ON t.sluzba_id=ts.id HAVING naziv=:naziv", nativeQuery = true)
    List<Taksi> vrniTaksijeOdSluzbe(String naziv);
// SELECT * FROM ris_vaje1.taksi t INNER JOIN ris_vaje1.taksi_sluzba ts ON t.sluzba_id=ts.id HAVING naziv="uber";

    @Query(value = "SELECT * FROM taksist t INNER JOIN taksi_sluzba ts ON t.sluzba_id=ts.id HAVING naziv=:naziv", nativeQuery = true)
    List<Taksist> vrniTaksisteOdSluzbe(String naziv);


    // 2. sprint - kompleksna poizvedba 1
    @Query("SELECT ts FROM TaksiSluzba ts WHERE SIZE(ts.taksi)>:stevilo")
    ArrayList<TaksiSluzba> vrniTaksijeOdSluzbe2(int stevilo);

    // 2. sprint - kompleksna poizvedba 2
    @Query("SELECT ts FROM TaksiSluzba ts WHERE SIZE(ts.taksist)>:stevilo")
    ArrayList<TaksiSluzba> vrniTaksijeOdSluzbe3(int stevilo);

    // 3. sprint
    @Query(value = "SELECT t.id, t.registrska_stevilka, t.znamka, tak.id, tak.prevozi_skupaj, tak.email FROM taksi t INNER JOIN taksi_sluzba ts ON t.sluzba_id=ts.id INNER JOIN taksist tak ON tak.sluzba_id=ts.id WHERE ts.id=:id", nativeQuery = true)
    //     @Query(value = "SELECT ts.naziv, t.id FROM taksi_sluzba ts INNER JOIN taksi t ON t.sluzba_id=ts.id", nativeQuery = true)
    //     @Query(value = "SELECT * FROM taksi t INNER JOIN taksi_sluzba ts ON t.sluzba_id=ts.id INNER JOIN taksist tak ON tak.sluzba_id=ts.id ", nativeQuery = true)
    List vrniTaksijeInTaksiste(int id);


    // 3. sprint
    @Query(value = "SELECT ts.id, ts.naziv, t.id, t.registrska_stevilka FROM taksi t INNER JOIN taksi_sluzba ts ON t.sluzba_id=ts.id INNER JOIN taksist tak ON tak.sluzba_id=ts.id WHERE tak.ime=:ime", nativeQuery = true)
    List vrniTaksijeInSluzbe(String ime);

    // 3. sprint
    @Query(value = "SELECT tak.id, tak.email, tak.ime, tak.priimek, ts.id, ts.naziv FROM taksi t INNER JOIN taksi_sluzba ts ON t.sluzba_id=ts.id INNER JOIN taksist tak ON tak.sluzba_id=ts.id WHERE t.registrska_stevilka=:reg", nativeQuery = true)
    List vrniTaksisteInSluzbe(String reg);

}

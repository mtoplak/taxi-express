package com.taxiexpress.ris.dao;

import com.taxiexpress.ris.models.Taksist;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TaksistRepository extends CrudRepository<Taksist, Long> {

    // poizvedba z 2 modeloma
    // izpis taksistov taksi službe z nazivom x
    @Query(value = "SELECT * FROM taksist t INNER JOIN taksi_sluzba ts ON t.sluzba_id=ts.id HAVING naziv=:naziv", nativeQuery = true)
    List<Taksist> vrniTaksisteOdSluzbe(String naziv);

    // poizvedba z 3 modeli
    // izpis taksista, kateri taksi vozi, in pri kateri taksi službi
    @Query(value = "t.id as taksistov_id, t.ime, t.priimek, ts.naziv, tak.registrska_stevilka FROM taksist t LEFT JOIN taksi_sluzba ts ON t.sluzba_id=ts.id LEFT JOIN taksi tak ON tak.sluzba_id=ts.id", nativeQuery = true)
    List vrniTaksiste(String ime);


    // filtriranje
    @Query(value = "SELECT * FROM taksist WHERE zasluzek>:zasluzek AND prevozi_skupaj>:prevozi AND ime LIKE %:ime%", nativeQuery = true)
    List<Taksist> filtriraj(double zasluzek, int prevozi, String ime);

}

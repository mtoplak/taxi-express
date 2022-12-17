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


}

package com.taxiexpress.ris.dao;

import com.taxiexpress.ris.models.Taksi;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface TaksiRepository extends CrudRepository<Taksi, Long> {

    // poizvedba z 2 modeloma
    // izpis vseh taksijev taksi službe z nazivom x
    @Query(value = "SELECT * FROM ris_vaje1.taksi t INNER JOIN ris_vaje1.taksi_sluzba ts ON t.sluzba_id=ts.id HAVING naziv='uber'", nativeQuery = true)
    //SELECT t.id as taksi, t.max_stevilo_potnikov, t.model, t.registrska_stevilka, t.znamka, t.sluzba_id, t.taksist_id, ts.id as sluzba, ts.naziv FROM taksi t INNER JOIN taksi_sluzba ts ON t.sluzba_id=ts.id HAVING ts.naziv=:naziv
    List<Taksi> vrniTaksijeOdSluzbe(String naziv);

    @Query("SELECT t FROM Taksi t")
    // WHERE size(n.koncert) >=:stevilo
    ArrayList<Taksi> vrniTaksijeOdSluzbe2(String naziv);

}

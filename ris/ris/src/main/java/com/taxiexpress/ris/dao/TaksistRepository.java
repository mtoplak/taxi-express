package com.taxiexpress.ris.dao;

import com.taxiexpress.ris.models.Taksist;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaksistRepository extends CrudRepository<Taksist, Long> {

    // poizvedba z 2 modeloma
    // izpis taksistov taksi službe z nazivom x
    @Query(value = "SELECT * FROM taksist t INNER JOIN taksi_sluzba ts ON t.sluzba_id=ts.id HAVING naziv=:naziv", nativeQuery = true)
    List<Taksist> vrniTaksisteOdSluzbe(String naziv);

}

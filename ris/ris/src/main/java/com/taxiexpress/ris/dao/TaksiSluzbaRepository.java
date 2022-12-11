package com.taxiexpress.ris.dao;

import com.taxiexpress.ris.models.TaksiSluzba;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaksiSluzbaRepository extends CrudRepository<TaksiSluzba, Long> {

    @Query(value = "SELECT * FROM taksi ;", nativeQuery = true)
    List<TaksiSluzba> vrniSluzbeZVsajTaksiji(int max_stevilo_potnikov);
        /*
// HAVING COUNT(taksi.id)>=:max_stevilo_potnikov
// SELECT taksi_sluzba.naziv FROM taksi_sluzba INNER JOIN taksi ON taksi_sluzba.id = taksi.sluzba_id GROUP BY taksi_sluzba.id;
*/

    @Query(value = "SELECT ts.id FROM taksi_sluzba ts INNER JOIN taksi t ON ts.id = t.sluzba_id GROUP BY ts.id HAVING t.max_stevilo_potnikov >= :stevilo_potnikov ;", nativeQuery = true)
    List<TaksiSluzba> vrniSluzbeStLjudi(int stevilo_potnikov);


}

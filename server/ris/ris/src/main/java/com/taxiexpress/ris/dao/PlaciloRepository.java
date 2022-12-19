package com.taxiexpress.ris.dao;

import com.taxiexpress.ris.models.Placilo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlaciloRepository extends CrudRepository<Placilo, Long> {

    @Query(value="SELECT * FROM placilo p WHERE p.id=:id AND p.znesek>=:znesek", nativeQuery=true)
    List<Placilo> vrnoDolocenoPlaciloCeJeVecje(float znesek, long id);

    @Query(value = "SELECT * FROM placilo WHERE status = 0 OR cas IS NULL OR opomba IS NOT NULL", nativeQuery = true)
    List<Placilo> vrniPlacilaZNapako();

    @Query(value = "SELECT * FROM placilo WHERE znesek >= 20 AND status = 0 AND opomba IS NOT NULL", nativeQuery = true)
    List<Placilo> vrniNeplacana(); //(p.cas BETWEEN '2022-12-20 00:00:00' AND '2022-12-30 23:59:59')
}

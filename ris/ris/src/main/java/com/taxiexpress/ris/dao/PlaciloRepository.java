package com.taxiexpress.ris.dao;

import com.taxiexpress.ris.models.Placilo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlaciloRepository extends CrudRepository<Placilo, Long> {

    @Query(value="SELECT * FROM placilo p WHERE p.id=:id AND p.znesek>:znesek", nativeQuery=true)
    List<Placilo> vrnoDolocenoPlaciloCeJeVecje(float znesek, long id);

}

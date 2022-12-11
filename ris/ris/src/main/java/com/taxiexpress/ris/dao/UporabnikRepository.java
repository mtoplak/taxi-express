package com.taxiexpress.ris.dao;

import com.taxiexpress.ris.models.Placilo;
import com.taxiexpress.ris.models.Uporabnik;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UporabnikRepository extends CrudRepository<Uporabnik, Long> {

    @Query(value="SELECT * FROM uporabnik u WHERE u.ime=:ime AND u.priimek=:priimek ", nativeQuery=true)
    List<Uporabnik> vrniDolocenegaUporabnika(String ime, String priimek);

    /*@Query(value="SELECT * FROM uporabnik u WHERE u.ime='miha' AND u.email= '%miha.lorber%' AND u.priimek='lorber' ", nativeQuery=true)
    List<Uporabnik> vrniUporabniskiNiz(String ime, String email, String priimek);

    @Query(value="SELECT * FROM uporabnik u WHERE u.jeAdmin = 0 AND u.ime LIKE %adam% OR u.priimek LIKE %adam%", nativeQuery=true)
    List<Uporabnik> vrniUporabnikeBrezAdminov(boolean jeAdmin, String ime, String priimek);
    */
}

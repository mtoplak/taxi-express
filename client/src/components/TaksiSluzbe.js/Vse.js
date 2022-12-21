import React, { useEffect, useState } from "react";
import api from "../../services/api";

function Vse() {
  const [sluzbe, setSluzbe] = useState([]);

  useEffect(() => {
    api.get("/sluzbe").then((response) => {
      console.log(response.data);
      setSluzbe(response.data);
    });
  }, []);

  return (
    <div>
      <h3>Vse taksi službe</h3>
      {sluzbe.map((sluzba) => {
        return (
          <span key={sluzba.id}>
            <h4>{sluzba.naziv}</h4>
            <li>Začetek izvajanja: {sluzba.zacetekIzvajanja}</li>
            <li>
              Taksisti:
              <ol>
                {sluzba.taksist.map((taksist, index) => {
                  return <li key={index}>{taksist.email}</li>;
                })}
              </ol>
            </li>
            <li>
              Taksiji:
              <ol>
                {sluzba.taksi.map((taksi, index) => {
                  return (
                    <li key={index}>
                      {taksi.registrskaStevilka +
                        ", " +
                        taksi.znamka +
                        ", " +
                        taksi.model}
                    </li>
                  );
                })}
              </ol>
            </li>
          </span>
        );
      })}
    </div>
  );
}

export default Vse;

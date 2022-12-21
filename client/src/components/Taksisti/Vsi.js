import React, { useEffect, useState } from "react";
import api from "../../services/api";

function Vsi() {
  const [taksiji, setTaksiji] = useState([]);

  useEffect(() => {
    api.get("/taksist").then((response) => {
      console.log(response.data);
      setTaksiji(response.data);
    });
  }, []);

  return (
    <>
      <h3>Vsi taksisti</h3>
      {taksiji.map((taksist) => {
        return (
          <span key={taksist.id}>
            <h4>
              {taksist.ime} {taksist.priimek}
            </h4>
            <li>Email: {taksist.email}</li>
            <li>Zaslužek: {taksist.zasluzek}</li>
            <li>Prevozi skupaj: {taksist.prevoziSkupaj}</li>
            <li>
              Taksiji:
              <ol>
                {taksist.taksi.map((taksi, index) => {
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
    </>
  );
}

export default Vsi;

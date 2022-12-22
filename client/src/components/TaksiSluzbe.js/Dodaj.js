import { Button, TextField } from "@mui/material";
import { Box } from "@mui/system";
import React, { useState } from "react";
import api from "../../services/api";

function Dodaj() {
  const [naziv, setNaziv] = useState("");
  const [datum, setDatum] = useState("");

  const dodajTS = () => {
    console.log(naziv, datum);
    api
      .post("/sluzbe/dodaj", {
        naziv: naziv,
        zacetekIzvajanja: datum,
      })
      .then((result) => console.log(result.data));
  };

  return (
    <>
      <h3>Dodaj taksi službo</h3>
      <Box
        component="form"
        sx={{
          "& .MuiTextField-root": { m: 1, width: "25ch" },
        }}
        noValidate
        autoComplete="off"
      >
        <div>
          <TextField
            className="outlined-basic"
            label="Naziv"
            variant="outlined"
            value={naziv}
            onChange={(e) => setNaziv(e.target.value)}
          />
          <TextField
            className="outlined-basic"
            label="Začetek izvajanja (npr. 2022-01-01)"
            variant="outlined"
            value={datum}
            onChange={(e) => setDatum(e.target.value)}
          />
        </div>
        <Button variant="contained" onClick={() => dodajTS()}>
          Dodaj
        </Button>
      </Box>
    </>
  );
}

export default Dodaj;

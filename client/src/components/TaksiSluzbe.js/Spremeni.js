import { Box, Button, TextField } from "@mui/material";
import React, { useState } from "react";
import api from "../../services/api";

function Spremeni() {
  const [id, setId] = useState(0);
  const [naziv, setNaziv] = useState("");
  const [datum, setDatum] = useState("");

  const spremeniTS = () => {
    api.put(`/sluzbe/spremeni/${id}`, {
      naziv: naziv,
      zacetekIzvajanja: datum,
    });
  };

  return (
    <>
      <h3>Spremeni taksi službo</h3>
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
            label="Id"
            variant="outlined"
            value={id}
            type="number"
            onChange={(e) => setId(e.target.value)}
          />
          <TextField
            className="outlined-basic"
            label="Naziv"
            variant="outlined"
            value={naziv}
            type="text"
            onChange={(e) => setNaziv(e.target.value)}
          />
          <TextField
            className="outlined-basic"
            label="Začetek izvajanja"
            variant="outlined"
            value={datum}
            type="text"
            onChange={(e) => setDatum(e.target.value)}
          />
        </div>
        <Button variant="contained" onClick={() => spremeniTS()}>
          Spremeni
        </Button>
      </Box>
    </>
  );
}

export default Spremeni;

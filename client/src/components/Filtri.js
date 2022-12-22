import { Box, Button, TextField } from "@mui/material";
import React, { useState } from "react";
import api from "../services/api";

function Filtri() {
  const [ime, setIme] = useState("");
  const [zasluzek, setZasluzek] = useState(0);
  const [prevozi, setPrevozi] = useState(0);
  const [taksisti, setTaksisti] = useState();

  const filtriraj = () => {
    api
      .get(`/taksist/filter/ime=${ime}&zasluzek=${zasluzek}&prevozi=${prevozi}`)
      .then((result) => {
        console.log(result.data);
        setTaksisti(result.data);
      });
  };

  return (
    <>
      <h3>Filtriranje taksistov</h3>
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
            label="Ime"
            variant="outlined"
            value={ime}
            onChange={(e) => setIme(e.target.value)}
          />
          <TextField
            className="outlined-basic"
            label="Zaslužek"
            variant="outlined"
            value={zasluzek}
            type="number"
            onChange={(e) => setZasluzek(e.target.value)}
          />
          <TextField
            className="outlined-basic"
            label="Prevozi"
            variant="outlined"
            value={prevozi}
            type="number"
            onChange={(e) => setPrevozi(e.target.value)}
          />
        </div>
        <Button variant="contained" onClick={() => filtriraj()}>
          Išči
        </Button>
      </Box>
      <div>
        <br />
        {taksisti && <h2>Taksisti: </h2>}
        {taksisti &&
          taksisti.map((taksist) => (
            <div key={taksist.id}>
              <li>{taksist.ime}</li>
              <li>{taksist.priimek}</li>
              <li>{taksist.email}</li>
              <li>{taksist.zasluzek}</li>
              <li>{taksist.prevoziSkupaj}</li>
              <br />
            </div>
          ))}
      </div>
    </>
  );
}

export default Filtri;

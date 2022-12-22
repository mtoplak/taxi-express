import { Box, Button, TextField } from "@mui/material";
import React, { useState } from "react";
import api from "../../services/api";

function Dodaj() {
  const [ime, setIme] = useState("");
  const [priimek, setPriimek] = useState("");
  const [email, setEmail] = useState("");

  const dodajTaksista = () => {
    console.log(ime, priimek, email);
    api
      .post("/taksist/dodaj", {
        ime: ime,
        priimek: priimek,
        email: email,
        prevoziSkupaj: 0,
        zasluzek: 0,
      })
      .then((result) => console.log(result.data));
  };

  return (
    <>
      <h3>Dodaj taksista</h3>
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
            label="Priimek"
            variant="outlined"
            value={priimek}
            onChange={(e) => setPriimek(e.target.value)}
          />
          <TextField
            className="outlined-basic"
            label="Email"
            variant="outlined"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
          />
        </div>
        <Button variant="contained" onClick={() => dodajTaksista()}>
          Dodaj
        </Button>
      </Box>
    </>
  );
}

export default Dodaj;

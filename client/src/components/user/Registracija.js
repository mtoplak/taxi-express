import { Box, Button, TextField } from "@mui/material";
import React, { useState } from "react";
import api from "../../services/api";
import { useNavigate } from "react-router-dom";

function Registracija() {
  const [ime, setIme] = useState("");
  const [priimek, setPriimek] = useState("");
  const [email, setEmail] = useState("");
  const [geslo, setGeslo] = useState("");
  const [warning, setWarning] = useState("");
  const navigate = useNavigate();

  const registracija = () => {
    api
      .post("/uporabnik/registracija", {
        ime: ime,
        priimek: priimek,
        email: email,
        geslo: geslo,
      })
      .then((result) => {
        console.log(result.data);
        if (result.data === true) {
          navigate("/prijava");
        } else {
          setWarning("Email že obstaja");
        }
      });
  };

  return (
    <>
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
          <TextField
            className="outlined-basic"
            label="Geslo"
            variant="outlined"
            value={geslo}
            onChange={(e) => setGeslo(e.target.value)}
          />
        </div>
        <div style={{ color: "red", marginBottom: "10px" }}>{warning}</div>
        <Button variant="contained" onClick={() => registracija()}>
          Registracija
        </Button>
      </Box>
    </>
  );
}

export default Registracija;

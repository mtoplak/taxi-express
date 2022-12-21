import { Box, Button, TextField } from "@mui/material";
import React, { useState } from "react";
import api from "../../services/api";

function Prijava() {
  const [email, setEmail] = useState("");
  const [geslo, setGeslo] = useState("");
  const [warning, setWarning] = useState("");

  const prijava = () => {
    api
      .post("/uporabnik/prijava", {
        email: email,
        geslo: geslo,
      })
      .then((result) => {
        console.log(result.data);
        if (result.data === true) {
          localStorage.setItem("prijavljen", true);
        } else {
          setWarning("Napačno geslo ali email");
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
        <Button variant="contained" onClick={() => prijava()}>
          Prijava
        </Button>
      </Box>
    </>
  );
}

export default Prijava;

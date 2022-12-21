import { Button, TextField } from "@mui/material";
import { Box } from "@mui/system";
import React, { useState } from "react";
import api from "../../services/api";

function Spremeni() {
  const [id, setId] = useState(0);
  const [ime, setIme] = useState("");
  const [priimek, setPriimek] = useState("");
  const [zasluzek, setZasluzek] = useState(0);
  const [prevozi, setPrevozi] = useState(0);

  const spremeniTaksista = () => {
    api.put(`/taksist/spremeni/${id}`, {
      ime: ime,
      priimek: priimek,
      zasluzek: zasluzek,
      prevoziSkupaj: prevozi,
    });
  };

  return (
    <>
      <h3>Spremeni taksista</h3>
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
            label="Ime"
            variant="outlined"
            value={ime}
            type="text"
            onChange={(e) => setIme(e.target.value)}
          />
          <TextField
            className="outlined-basic"
            label="Priimek"
            variant="outlined"
            value={priimek}
            type="text"
            onChange={(e) => setPriimek(e.target.value)}
          />
          <TextField
            className="outlined-basic"
            label="Zaslužek"
            variant="outlined"
            value={zasluzek}
            type="number"
            onChange={(e) => setZasluzek(e.target.value)}
          />{" "}
          <TextField
            className="outlined-basic"
            label="Št. prevozov"
            variant="outlined"
            value={prevozi}
            type="number"
            onChange={(e) => setPrevozi(e.target.value)}
          />
        </div>
        <Button variant="contained" onClick={() => spremeniTaksista()}>
          Spremeni
        </Button>
      </Box>
    </>
  );
}

export default Spremeni;

import React, { useState } from "react";
import { Button, TextField } from "@mui/material";
import { Box } from "@mui/system";
import api from "../../services/api";

function Izbrisi() {
  const [id, setId] = useState(0);

  const izbrisiTS = () => {
    api.delete(`/taksist/zbrisi/${id}`).then((result) => console.log(result.data));;
  };

  return (
    <>
      <h3>Izbriši taksista</h3>
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
        </div>
        <Button variant="contained" onClick={() => izbrisiTS()}>
          Izbriši
        </Button>
      </Box>
    </>
  );
}

export default Izbrisi;

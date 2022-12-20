import React from "react";
import { Route } from "react-router";
import { Routes } from "react-router-dom";
import Home from "../Home";
import Dodaj from "../Taksisti/Dodaj";


function Routing() {
  return (
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="/Dodaj taksista" element={<Dodaj />} />
    </Routes>
  );
}

export default Routing;

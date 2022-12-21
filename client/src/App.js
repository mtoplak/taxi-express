import "./App.css";
import { BrowserRouter } from "react-router-dom";
import Routing from "./components/routing/Routing";
import NavBar from "./components/navbars/NavBar";
import NavBar2 from "./components/navbars/NavBar2";

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <NavBar />
        <NavBar2 />
        <Routing />
      </BrowserRouter>
    </div>
  );
}

export default App;

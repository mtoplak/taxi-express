import * as React from "react";
import AppBar from "@mui/material/AppBar";
import Box from "@mui/material/Box";
import Toolbar from "@mui/material/Toolbar";
import Typography from "@mui/material/Typography";
import Button from "@mui/material/Button";
import IconButton from "@mui/material/IconButton";
import MenuIcon from "@mui/icons-material/Menu";
import { useNavigate } from "react-router-dom";
import { Avatar, Menu, MenuItem, Tooltip } from "@mui/material";
import LocalTaxiIcon from "@mui/icons-material/LocalTaxi";

export default function Navbar() {
  const navigate = useNavigate();

  const [anchorElUser, setAnchorElUser] = React.useState(null);

  const settings = ["Profile", "Account", "Dashboard", "Logout"];

  const navigatePrijava = () => {
    navigate("/prijava");
  };

  const navigateReg = () => {
    navigate("/registracija");
  };

  const handleOpenUserMenu = (event) => {
    setAnchorElUser(event.currentTarget);
  };

  const handleCloseUserMenu = () => {
    setAnchorElUser(null);
  };

  return (
    <Box sx={{ flexGrow: 1 }}>
      <AppBar position="static">
        <Toolbar>
          <IconButton
            size="large"
            edge="start"
            color="inherit"
            aria-label="menu"
            sx={{ mr: 2 }}
          >
            <MenuIcon />
          </IconButton>
          <Typography variant="h6" component="div" sx={{ flexGrow: 1 }}>
            <LocalTaxiIcon />
            TaxiExpress
          </Typography>
          <Button onClick={() => navigatePrijava()} color="inherit">
            Prijava
          </Button>
          <Button onClick={() => navigateReg()} color="inherit">
            Registracija
          </Button>
          <Tooltip title="Open settings">
            <IconButton onClick={handleOpenUserMenu} sx={{ p: 0 }}>
              <Avatar alt="R" src="/static/images/avatar/2.jpg">
                MT
              </Avatar>
            </IconButton>
          </Tooltip>
          <Menu
            sx={{ mt: "45px" }}
            id="menu-appbar"
            anchorEl={anchorElUser}
            anchorOrigin={{
              vertical: "top",
              horizontal: "right",
            }}
            keepMounted
            transformOrigin={{
              vertical: "top",
              horizontal: "right",
            }}
            open={Boolean(anchorElUser)}
            onClose={handleCloseUserMenu}
          >
            {settings.map((setting) => (
              <MenuItem key={setting} onClick={handleCloseUserMenu}>
                <Typography textAlign="center">{setting}</Typography>
              </MenuItem>
            ))}
          </Menu>
        </Toolbar>
      </AppBar>
    </Box>
  );
}

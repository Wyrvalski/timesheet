/* eslint-disable react/forbid-prop-types */
/* eslint-disable no-shadow */
import React, { useState } from 'react';
import { Nav, MenuOpen, MenuClose, Ul, NavBar, H1 } from './style';
import { Link } from 'react-router-dom';
import { connect, useDispatch } from 'react-redux';
import { logout } from '../../../actions/auth';

const Navbar = ({ auth: { isAuthenticated, email } }) => {
  const dispatch = useDispatch();
  const [formState, setState] = useState({
    menuAtivo: false,
  });

  const { menuAtivo } = formState;

  const ativarMenu = () => {
    setState({ menuAtivo: !menuAtivo });
  };

  const onClickLogout = () => {
    dispatch(logout());
  };
  const authLinks = (
    <Ul>
      <li>
        {email === 'admin@admin.com' ? (
          <Link to="/total">Total de horas apontadas</Link>
        ) : (
          <Link to="/profile">Minhas Horas</Link>
        )}
      </li>
      <li>
        <Link to="/login">Apontar Horas</Link>
      </li>
      <li>
        <Link to="/login">
          <span onClick={() => onClickLogout()}>Logout</span>
        </Link>
      </li>
    </Ul>
  );
  const guestLinks = (
    <Ul>
      <li>
        <Link to="/login">Login</Link>
      </li>
    </Ul>
  );
  return (
    <Nav>
      <MenuOpen onClick={ativarMenu}>
        <span></span>
        <span></span>
        <span></span>
      </MenuOpen>
      <H1>
        <Link to="/">Timesheet</Link>
      </H1>
      <div className={menuAtivo ? 'menu-ativo' : ''}>
        <NavBar>
          <MenuClose onClick={ativarMenu}>
            <span></span>
            <span></span>
            <span></span>
          </MenuClose>
          {<>{isAuthenticated ? authLinks : guestLinks}</>}
        </NavBar>
      </div>
    </Nav>
  );
};

const mapStateToProps = (state) => ({
  auth: state.auth,
});

export default connect(mapStateToProps)(Navbar);

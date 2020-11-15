import React, { useState } from 'react';
import { login } from '../../actions/auth';
import { connect, useDispatch } from 'react-redux';
import ContainerLoginCadastro from '../layout/container_login';
import PropTypes from 'prop-types';
import { Redirect } from 'react-router-dom';
import Input from '../layout/input';
import Button from '../layout/input_button';

const Login = ({ isAuthenticated }) => {
  const dispatch = useDispatch();
  const [formData, setFormData] = useState({
    email: '',
    password: '',
  });
  const { email, password } = formData;

  const onChange = (event) =>
    setFormData({ ...formData, [event.target.name]: event.target.value });

  const onSubmit = (event) => {
    event.preventDefault();
    const data = {
      email,
      password,
    };
    dispatch(login(data));
  };

  if (isAuthenticated) {
    return <Redirect to="/dashboard"></Redirect>;
  }
  return (
    <ContainerLoginCadastro>
      <h1>Login</h1>
      <p>
        <i /> Entrar na conta
      </p>
      <form action="/dashboard" onSubmit={(event) => onSubmit(event)}>
        <div>
          <Input
            type="email"
            name="email"
            onChangeInput={(event) => onChange(event)}
            valueInput={email}
            placeholder="Email"
          />
        </div>
        <div>
          <Input
            onChangeInput={(event) => onChange(event)}
            name="password"
            value={password}
            type="password"
            placeholder="Senha"
            minLength="4"
          />
        </div>
        <Button value="Login" />
      </form>
    </ContainerLoginCadastro>
  );
};

Login.propTypes = {
  isAuthenticated: PropTypes.bool.isRequired,
};

const mapStateToProps = (state) => ({
  isAuthenticated: state.auth.isAuthenticated,
});

export default connect(mapStateToProps)(Login);

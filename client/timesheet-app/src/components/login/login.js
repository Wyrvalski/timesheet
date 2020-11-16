import React, { useState } from 'react';
import { login } from '../../actions/auth';
import { connect, useDispatch } from 'react-redux';
import ContainerLoginCadastro from '../layout/container_login';
import PropTypes from 'prop-types';
import { Redirect } from 'react-router-dom';
import Input from '../layout/input';
import Button from '../layout/input_button';
import Alert from '@material-ui/lab/Alert';
import Fade from '@material-ui/core/Fade';
import AlertTitle from '@material-ui/lab/AlertTitle';

const Login = ({ auth: { isAuthenticated, emailSend } }) => {
  const dispatch = useDispatch();
  const [formData, setFormData] = useState({
    email: '',
    password: '',
    errorEmail: true,
  });
  const { email, password, errorEmail } = formData;

  const onChange = (event) =>
    setFormData({ ...formData, [event.target.name]: event.target.value });

  const onSubmit = (event) => {
    event.preventDefault();
    if (email === '' || password === '') {
      setFormData({ ...formData, errorEmail: false });
    } else {
      event.preventDefault();
      const data = {
        email,
        password,
      };
      dispatch(login(data));
      setTimeout(() => {
        setFormData({ ...formData, errorEmail: emailSend });
      }, 1000);
    }
  };

  if (isAuthenticated) {
    return <Redirect to="/dashboard"></Redirect>;
  }

  if (!errorEmail) {
    setTimeout(() => {
      setFormData({ ...formData, errorEmail: true });
    }, [3000]);
  }

  return (
    <>
      {errorEmail === false ? (
        <Fade in={!errorEmail} timeout={1500}>
          <Alert severity="error">
            <AlertTitle>Erro ao realizar o login</AlertTitle>
            Verificar se o email e a senha estão corretos
          </Alert>
        </Fade>
      ) : (
        ''
      )}
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
    </>
  );
};

Login.propTypes = {
  auth: PropTypes.object.isRequired,
};

const mapStateToProps = (state) => ({
  auth: state.auth,
});

export default connect(mapStateToProps)(Login);

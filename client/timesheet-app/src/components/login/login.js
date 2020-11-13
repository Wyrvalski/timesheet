import React, { useState } from 'react';
import { login } from '../../actions/auth';
import { connect, useDispatch } from 'react-redux';
import { Redirect } from 'react-router-dom';
import Input from '../helpers/Input';

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
    <div>
      <form className="form" onSubmit={(event) => onSubmit(event)}>
        <h1 className="welcome-title">TimeSheet</h1>
        <Input
          typeInput="email"
          labelInput="Email"
          nameInput="email"
          valueInput={email}
          onChangeInput={(event) => onChange(event)}
        />
        <Input
          typeInput="password"
          labelInput="Senha"
          nameInput="password"
          valueInput={password}
          onChangeInput={(event) => onChange(event)}
        />
        <div className="submit-form">
          <button type="submit" className="button-submit">
            Entrar
          </button>
        </div>
      </form>
    </div>
  );
};

const mapStateToProps = (state) => ({
  state,
  isAuthenticated: state.auth.isAuthenticated,
});

export default connect(mapStateToProps, { login })(Login);

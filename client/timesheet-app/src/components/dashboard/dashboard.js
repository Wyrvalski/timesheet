import React, { useState, useEffect } from 'react';
import Input from '../../components/layout/input';
import ContainerLoginCadastro from '../layout/container_login';
import { useDispatch, connect } from 'react-redux';
import { getUserInfo, saveHour } from '../../actions/user';
import PropTypes from 'prop-types';
import Select from '../layout/select';
import Button from '../layout/input_button';
import Alert from '@material-ui/lab/Alert';
import Fade from '@material-ui/core/Fade';
import AlertTitle from '@material-ui/lab/AlertTitle';

const Dashboard = ({ auth: { email }, user: { name, projects } }) => {
  const dispatch = useDispatch();
  const [formData, setFormData] = useState({
    hour: '',
    project: '',
    alert: false,
    success: false,
    loading: false,
  });

  const [mountAlert, setTmountAlert] = useState(false);
  const [selectedProject, setSelectedProject] = useState(null);

  const { hour, alert, success, loading } = formData;

  useEffect(() => {
    dispatch(getUserInfo(email));
  }, []);
  const onSubmit = (event) => {
    event.preventDefault();
    console.log(selectedProject);
    if (hour !== '' && selectedProject !== null) {
      setFormData({ ...formData, alert: !alert, success: true, loading: true });
      const data = {
        hour,
        selectedProject,
      };
      console.log(data);
      dispatch(saveHour(data));
    } else {
      setFormData({
        ...formData,
        alert: !alert,
        success: false,
        loading: true,
      });
    }
    setTmountAlert({ mountAlert: !mountAlert });
  };

  useEffect(() => {
    if (mountAlert !== false) {
      setTimeout(() => {
        setFormData({ ...formData, alert: !alert, loading: false });
        dispatch(getUserInfo(email));
      }, 3000);
    }
  }, [mountAlert]);

  const onChange = (event) => {
    setFormData({ ...formData, [event.target.name]: event.target.value });
    setSelectedProject({
      ...selectedProject,
      [event.target.name]: event.target.value,
    });
  };
  return (
    <>
      {alert !== false ? (
        success !== false ? (
          <Fade in={alert} timeout={1500}>
            <Alert severity="success">
              <AlertTitle>Horas cadatradas!</AlertTitle>
              Foram cadastradas {hour} para o projeto !
            </Alert>
          </Fade>
        ) : (
          <Fade in={alert} timeout={1500}>
            <Alert severity="error">
              <AlertTitle>Houve um erro no cadastro das horas</AlertTitle>
              Favor verificar se o campo hora foi preenchido corretamente
            </Alert>
          </Fade>
        )
      ) : (
        ''
      )}
      <ContainerLoginCadastro>
        <div>
          <h1>Olá {name}</h1>
        </div>
        <form action="/dashboard" onSubmit={(event) => onSubmit(event)}>
          <div>
            <Input
              type="time"
              name="hour"
              onChangeInput={(event) => onChange(event)}
              valueInput={hour}
              placeholder="Horas Trabalhas no projeto"
              loading={loading}
            />
          </div>
          {projects.length > 0 ? (
            <Select
              name="selectedProject"
              projects={projects}
              onChangeInput={(event) => onChange(event)}
              loading={loading}
            />
          ) : (
            <h2>Você ainda não está em nenhum projeto :(</h2>
          )}
          <Button value="Cadastrar Horas" loading={loading} />
        </form>
      </ContainerLoginCadastro>
    </>
  );
};

Dashboard.propTypes = {
  user: { name: PropTypes.object.isRequired },
  auth: { email: PropTypes.object.isRequired },
};

const mapStateToProps = (state) => ({
  auth: state.auth,
  user: state.user,
});

export default connect(mapStateToProps)(Dashboard);

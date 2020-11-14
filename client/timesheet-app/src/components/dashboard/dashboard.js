import React, { useState, useEffect } from 'react';
import Input from '../../components/layout/input';
import ContainerLoginCadastro from '../layout/container_login';
import { useDispatch } from 'react-redux';
import { getUserInfo } from '../../actions/user';

export const Dashboard = () => {
  const dispatch = useDispatch();
  const [formData, setFormData] = useState({
    hour: '',
    project: '',
  });

  useEffect(() => dispatch(getUserInfo('dev1@dev1.com')), []);

  const { hour, project } = formData;
  const onChange = (event) =>
    setFormData({ ...formData, [event.target.name]: event.target.value });

  return (
    <ContainerLoginCadastro>
      <div>
        <Input
          type="text"
          name="hour"
          onChangeInput={(event) => onChange(event)}
          valueInput={hour}
          placeholder="Horas Trabalhas no projeto"
        />
      </div>
      <div>
        <select>
          <option value="projetoa">{project}</option>
          <option value="projetob">Projeto B</option>
        </select>
      </div>
    </ContainerLoginCadastro>
  );
};

import React from 'react';
import { Select } from './style';

const InputSelect = ({ projects, name, onChangeInput, loading }) => {
  const onChange = (event) => {
    onChangeInput(event);
  };

  return (
    <Select
      disabled={loading}
      name={name}
      onChange={(event) => onChange(event)}
    >
      <option name="aqui" value="aqui">
        Escolha o projeto
      </option>
      {projects.map((item, index) => {
        return (
          <option name={name} key={index} value={item.id}>
            {item.project.name}
          </option>
        );
      })}
    </Select>
  );
};

export default InputSelect;

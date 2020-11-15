import React from 'react';
import { Select } from './style';

const InputSelect = ({ team, name, onChangeInput, loading }) => {
  if (team === undefined) {
    return <div> </div>;
  }

  const onChange = (event) => {
    onChangeInput(event);
  };

  team = team.split(';');
  return (
    <Select
      disabled={loading}
      name={name}
      onChange={(event) => onChange(event)}
    >
      <option>Escolha o projeto</option>
      {team.map((item, index) => {
        return (
          <option name={name} key={index} value={item}>
            {item}
          </option>
        );
      })}
    </Select>
  );
};

export default InputSelect;

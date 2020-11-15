import React from 'react';
import PropTypes from 'prop-types';
import { InputStyle } from './style';

const Input = (props) => {
  const onChange = (event) => {
    props.onChangeInput(event);
  };

  return (
    <div>
      <InputStyle
        onChange={(event) => onChange(event)}
        name={props.name}
        value={props.valueInput}
        type={props.type}
        placeholder={props.placeholder}
        minLength={props.minLength ? props.minLength : 'unset'}
        disabled={props.loading}
      ></InputStyle>
    </div>
  );
};

Input.propTypes = {
  onChangeInput: PropTypes.func.isRequired,
};

export default Input;

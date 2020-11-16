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
  name: PropTypes.string.isRequired,
  valueInput: PropTypes.string,
  type: PropTypes.string.isRequired,
  placeholder: PropTypes.string.isRequired,
  minLength: PropTypes.string,
  loading: PropTypes.bool,
};

export default Input;

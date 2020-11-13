import React from 'react';

const Input = ({
  typeInput,
  labelInput,
  nameInput,
  onChangeInput,
  valueInput,
}) => {
  return (
    <div className="form-group">
      <label>{labelInput}</label>
      <input
        type={typeInput}
        name={nameInput || ''}
        className="form-control"
        id={nameInput || ''}
        onChange={onChangeInput}
        value={valueInput}
      />
    </div>
  );
};

export default Input;

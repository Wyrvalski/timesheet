import React, { Fragment } from 'react';
import { Button } from './style';

const InputButton = (props) => {
  return (
    <Fragment>
      <Button
        disabled={props.loading}
        type="submit"
        value={props.value}
      ></Button>
    </Fragment>
  );
};

export default InputButton;

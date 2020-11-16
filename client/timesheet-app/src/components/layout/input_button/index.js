import React, { Fragment } from 'react';
import { Button } from './style';
import PropTypes from 'prop-types';

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

InputButton.propTypes = {
  loading: PropTypes.bool,
  value: PropTypes.string.isRequired,
};

export default InputButton;

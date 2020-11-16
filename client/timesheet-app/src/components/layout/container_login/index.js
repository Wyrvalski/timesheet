import React, { Fragment } from 'react';
import { Container } from './style';
import PropTypes from 'prop-types';

const ContainerLoginCadastro = (props) => {
  return (
    <Container>
      <Fragment>{props.children}</Fragment>
    </Container>
  );
};

ContainerLoginCadastro.propTypes = {
  children: PropTypes.object.isRequired,
};

ContainerLoginCadastro.propTypes = {};

export default ContainerLoginCadastro;

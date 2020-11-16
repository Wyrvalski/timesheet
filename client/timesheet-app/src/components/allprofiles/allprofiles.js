import React, { useEffect } from 'react';
import { withStyles, makeStyles } from '@material-ui/core/styles';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableContainer from '@material-ui/core/TableContainer';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Paper from '@material-ui/core/Paper';
import ContainerLoginCadastro from '../layout/container_login';
import { connect, useDispatch } from 'react-redux';
import { getAll } from '../../actions/user';
import PropTypes from 'prop-types';

const StyledTableCell = withStyles((theme) => ({
  head: {
    backgroundColor: theme.palette.common.black,
    color: theme.palette.common.white,
  },
  body: {
    fontSize: 14,
  },
}))(TableCell);

const StyledTableRow = withStyles((theme) => ({
  root: {
    '&:nth-of-type(odd)': {
      backgroundColor: theme.palette.action.hover,
    },
  },
}))(TableRow);

const useStyles = makeStyles({
  table: {
    minWidth: 700,
    maxWidth: 1200,
  },
});
const AllProfiles = ({ user: { allUsers } }) => {
  const dispatch = useDispatch();
  useEffect(() => {
    dispatch(getAll());
  }, []);
  const classes = useStyles();
  return (
    <ContainerLoginCadastro>
      <TableContainer className={classes.table} component={Paper}>
        <Table aria-label="customized table">
          <TableHead>
            <TableRow>
              <StyledTableCell align="center">
                Nome do Desenvolvedor
              </StyledTableCell>
              <StyledTableCell align="center"> Projeto </StyledTableCell>
              <StyledTableCell align="center">Total</StyledTableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {allUsers.map((item, index) =>
              item.projects.map((otherItem, otherindex) => (
                <StyledTableRow key={otherindex}>
                  <StyledTableCell align="center">{item.name}</StyledTableCell>
                  <StyledTableCell align="center">
                    {otherItem.project.name}
                  </StyledTableCell>
                  <StyledTableCell align="center">
                    {otherItem.hour}
                  </StyledTableCell>
                </StyledTableRow>
              ))
            )}
          </TableBody>
        </Table>
      </TableContainer>
    </ContainerLoginCadastro>
  );
};

AllProfiles.propTypes = {
  user: { allUsers: PropTypes.object.isRequired },
};

const mapStateToProps = (state) => ({
  user: state.user,
});

export default connect(mapStateToProps)(AllProfiles);

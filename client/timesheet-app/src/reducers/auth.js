import * as types from '../actions/types';

const initialState = {
  token: localStorage.getItem('token'),
  isAuthenticated: false,
  loading: true,
  user: null,
};

const login = (state = initialState, { type, payload } = {}) => {
  const response = payload;
  console.log(type);
  switch (type) {
    case types.LOGGED_SUCCESS:
      return { isAuthenticated: true, response };
    case types.LOGGED_FAIL:
      console.log(type);
      console.log('oi');
      return { isAuthenticated: false, response };
    default:
      return state;
  }
};

export default login;

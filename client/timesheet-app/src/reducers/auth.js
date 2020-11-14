import * as types from '../actions/types';

const initialState = {
  token: localStorage.getItem('token'),
  isAuthenticated: false,
  loading: true,
  user: null,
};

const login = (state = initialState, action = null) => {
  const response = action;
  switch (action.type) {
    case types.LOGGED_SUCCESS:
      localStorage.setItem('token', response.response.data.access_token);
      return { ...state, isAuthenticated: true, response };
    case types.LOGGED_FAIL:
      return { ...state, isAuthenticated: false, response };
    case types.LOGOUT:
      localStorage.removeItem('token');
      return { ...state, token: null, isAuthenticated: false };
    default:
      return state;
  }
};

export default login;

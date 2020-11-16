import * as types from '../actions/types';

const initialState = {
  token: localStorage.getItem('token'),
  isAuthenticated: false,
  loading: true,
  email: null,
  emailSend: true,
};

const login = (state = initialState, action = null) => {
  const response = action.response;
  switch (action.type) {
    case types.LOGGED_SUCCESS:
      localStorage.setItem('token', response.data.access_token);
      return {
        ...state,
        isAuthenticated: true,
        email: response.data.name,
        emaiSend: true,
        response,
      };
    case types.LOGGED_FAIL:
      return { ...state, isAuthenticated: false, emailSend: false, response };
    case types.LOGOUT:
      localStorage.removeItem('token');
      return { ...state, token: null, isAuthenticated: false };
    default:
      return state;
  }
};

export default login;

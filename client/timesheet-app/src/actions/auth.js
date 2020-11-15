import * as types from './types';

export const login = (user) => {
  return {
    type: types.LOGIN_REQUEST,
    user,
  };
};

export const logout = () => {
  return {
    type: types.LOGOUT_REQUEST,
  };
};

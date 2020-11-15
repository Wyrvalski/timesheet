import * as types from './types';

export const getUserInfo = (email) => {
  return {
    type: types.USER_INFO_REQUEST,
    email,
  };
};

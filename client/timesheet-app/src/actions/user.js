import * as types from './types';

export const getUserInfo = (email) => {
  return {
    type: types.USER_INFO_REQUEST,
    email,
  };
};

export const getAll = () => {
  return {
    type: types.ALL_USERS_REQUEST
  }
}

export const saveHour = (data) => {
  return {
    type: types.SAVE_HOUR_REQUEST,
    data,
  };
};

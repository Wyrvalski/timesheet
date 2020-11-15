import * as types from '../actions/types';

const initialState = {
  email: null,
  name: null,
  team: null,
  loading: true,
};

const getUserInfo = (state = initialState, action = null) => {
  const response = action.response;
  switch (action.type) {
    case types.USER_INFO_SUCCESS:
      return {
        ...state,
        loading: true,
        email: response.data.email,
        name: response.data.name,
        team: response.data.team,
      };
    default:
      return state;
  }
};

export default getUserInfo;

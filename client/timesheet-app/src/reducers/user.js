import * as types from '../actions/types';

const initialState = {
  email: null,
  name: null,
  projects: [],
  loading: true,
  allUsers: null,
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
        projects: response.data.projects,
      };
    case types.All_USERS_SUCCESS:
      console.log(response.data[2]);
      return {
        ...state,
        allUsers: response.data,
      };
    default:
      return state;
  }
};

export default getUserInfo;

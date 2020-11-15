import * as types from '../actions/types';

const initialState = {
  email: null,
  name: null,
  projects: [],
  loading: true,
};

const getUserInfo = (state = initialState, action = null) => {
  const response = action.response;
  switch (action.type) {
    case types.USER_INFO_SUCCESS:
      console.log(response.data.projects);
      return {
        ...state,
        loading: true,
        email: response.data.email,
        name: response.data.name,
        projects: response.data.projects,
      };
    default:
      return state;
  }
};

export default getUserInfo;

import qs from 'qs';
import axios from 'axios';

export const loginUserService = (request) => {
  const LOGIN_API_ENDPOINT = 'http://localhost:9094/auth/oauth/token';
  const client = axios.create({
    headers: {
      'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8',
      Authorization: 'Basic dGltZXNoZWV0OjEyMzQ=',
    },
    withCredentials: true,
  });
  const body = qs.stringify({
    username: request.user.email,
    password: request.user.password,
    grant_type: 'password',
  });
  return client
    .post(LOGIN_API_ENDPOINT, body)
    .then((response) => {
      localStorage.setItem('token', response.data.access_token);
      return response;
    })
    .catch((event) => console.log(event));
};

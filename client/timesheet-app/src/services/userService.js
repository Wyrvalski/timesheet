import axios from 'axios';
import storage from 'redux-persist/lib/storage';

export function getUserInfo(request) {
  const LOGIN_API_ENDPOINT = `http://localhost:9094/auth/user/${request.email}`;
  console.log(storage.getItem('root').then((even) => console.log(even)));
  const client = axios.create({
    headers: {
      'Content-Type': 'application/json',
      Authorization: `Bearer ${localStorage.getItem('token')} `,
    },
    withCredentials: true,
  });
  return new Promise((resolve, reject) => {
    try {
      const result = client.get(LOGIN_API_ENDPOINT);
      resolve(result);
    } catch (error) {
      reject(error);
    }
  });
}

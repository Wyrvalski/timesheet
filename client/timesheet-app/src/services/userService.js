import axios from 'axios';

export function getUserInfo(request) {
  const LOGIN_API_ENDPOINT = `http://localhost:9094/projects/user/${request.email}`;
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

export function saveHour(request) {
  const LOGIN_API_ENDPOINT = `http://localhost:9094/projects/userproject/${request.data.selectedProject.selectedProject}?hour=${request.data.hour}`;
  const client = axios.create({
    headers: {
      'Content-Type': 'application/json',
      Authorization: `Bearer ${localStorage.getItem('token')} `,
    },
    withCredentials: true,
  });
  return new Promise((resolve, reject) => {
    try {
      const result = client.put(LOGIN_API_ENDPOINT);
      resolve(result);
    } catch (error) {
      reject(error);
    }
  });
}

export function getAll() {
  const LOGIN_API_ENDPOINT = `http://localhost:9094/projects/user/all`;
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

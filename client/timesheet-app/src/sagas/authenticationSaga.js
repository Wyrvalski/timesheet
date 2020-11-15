import { put, call } from 'redux-saga/effects';
import { loginUserService } from '../services/authenticationService';

import * as types from '../actions/types';

export function* loginSaga(payload) {
  try {
    const response = yield call(loginUserService, payload);
    yield put({ type: types.LOGGED_SUCCESS, response });
  } catch (error) {
    yield put({ type: types.LOGGED_FAIL, error });
  }
}

export function* logoutSaga() {
  yield localStorage.removeItem('token');
  yield put({ type: types.LOGOUT });
}

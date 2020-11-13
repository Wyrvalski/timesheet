import { put, call } from 'redux-saga/effects';
import { loginUserService } from '../services/authenticationService';

import * as types from '../actions/types';

export function* loginSaga(payload) {
  try {
    const response = yield call(loginUserService, payload);
    yield put({ type: types.LOGGED_SUCCESS, response });
    console.log(response);
  } catch (error) {
    console.log('ué');
    yield put({ type: types.LOGGED_FAIL, error });
  }
}

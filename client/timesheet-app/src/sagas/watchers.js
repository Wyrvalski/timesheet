import { takeLatest } from 'redux-saga/effects';
import { loginSaga } from './authenticationSaga';

import * as types from '../actions/types';

export default function* watchUserAuthentication() {
  yield takeLatest(types.LOGIN_REQUEST, loginSaga);
}

import { takeLatest } from 'redux-saga/effects';
import { loginSaga, logoutSaga } from './authenticationSaga';

import * as types from '../actions/types';
import { getUserInfoSaga, saveHourSaga, getAllSaga } from './userSaga';

export default function* watchUserAuthentication() {
  yield takeLatest(types.LOGIN_REQUEST, loginSaga);
  yield takeLatest(types.LOGOUT_REQUEST, logoutSaga);
  yield takeLatest(types.USER_INFO_REQUEST, getUserInfoSaga);
  yield takeLatest(types.SAVE_HOUR_REQUEST, saveHourSaga);
  yield takeLatest(types.ALL_USERS_REQUEST, getAllSaga);
}

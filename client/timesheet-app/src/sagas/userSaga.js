import { put, call } from 'redux-saga/effects';
import * as types from '../actions/types';
import { getUserInfo } from '../services/userService';

export function* getUserInfoSaga(payload) {
  try {
    const response = yield call(getUserInfo, payload);
    console.log(response);
    yield put({ type: types.USER_INFO_SUCCESS, response });
  } catch (error) {
    yield put({ type: types.USER_INFO_FAIL });
  }
}

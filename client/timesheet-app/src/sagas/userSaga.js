import { put, call } from 'redux-saga/effects';
import * as types from '../actions/types';
import { getUserInfo, saveHour, getAll } from '../services/userService';

export function* getUserInfoSaga(payload) {
  try {
    const response = yield call(getUserInfo, payload);
    yield put({ type: types.USER_INFO_SUCCESS, response });
  } catch (error) {
    yield put({ type: types.USER_INFO_FAIL });
  }
}

export function* saveHourSaga(payload) {
  try {
    yield call(saveHour, payload);
    yield put({ type: types.SAVE_HOUR_SUCCESS });
  } catch (error) {
    yield put({ type: types.SAVE_HOUR_FAIL });
  }
}

export function* getAllSaga(payload) {
  try {
    const response = yield call(getAll, payload);
    yield put({ type: types.All_USERS_SUCCESS, response });
  } catch (error) {
    yield put({ type: types.All_USERS_FAIL });
  }
}

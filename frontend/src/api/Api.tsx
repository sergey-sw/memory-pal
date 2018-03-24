import { dispatch } from '../dispatch/AppDispatcher';
import constants from '../const/ActionTypes';

export function saveNote(payload) {
  dispatch({
    type: constants.NOTE_ADD,
    payload
  });
}

export default Api;
import BaseStore from './BaseStore';
import constants from 'const/ActionTypes';

class NoteStore extends BaseStore {

  constructor() {
    super();
    this.subscribe(() => this._registerToAction);
  }

  _registerToAction = ({ type, payload, error }) => {
      switch (type) {
        case constants.NOTE_ADD:

        this.emitChange();
        break;

        default:
        break;
      }
  }
}

export default new NoteStore();
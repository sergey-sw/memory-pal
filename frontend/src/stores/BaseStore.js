import { EventEmitter } from 'events';
import AppDispather from '../dispatch/AppDispatcher.js';

export default class BaseStore extends EventEmitter {
  get dispatchToken() {
    return this._dispatchToken;
  }

  subscribe(actionSubscribe) {
    this._dispatchToken = AppDispatcher.register(actionSubscribe());
  }

  emitChange() {
    this.emit('CHANGE');
  }

  addChangeListener(cb) {
    this.on('CHANGE', cb);
  }

  removeChangeListener(cb) {
    this.removeListener('CHANGE', cb);
  }
}

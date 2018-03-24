import { Dispatcher } from 'flux';

const AppDispatcher = new Dispatcher();

export const dispatch = AppDispatcher.dispatch.bind(AppDispatcher);
export const isDispatching = AppDispatcher.isDispatching.bind(AppDispatcher);
export default AppDispatcher;
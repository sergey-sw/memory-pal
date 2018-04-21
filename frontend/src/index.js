import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import "react-mde/lib/styles/css/react-mde-all.css";

import App from './App';
import registerServiceWorker from './registerServiceWorker';

ReactDOM.render(<App />, document.getElementById('root'));
registerServiceWorker();

import * as React from 'react';
import './App.css';
import Menu from './components/menu/Menu';

class App extends React.Component {

  render() {

    return (
      <div className="App">
        <Menu />
      </div>
    );
  }
}

export default App;
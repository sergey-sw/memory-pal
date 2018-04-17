import * as React from 'react';
import './App.css';
import Notes from './components/note/Notes';

class App extends React.Component {

  render() {

    return (
      <div className="App">
        <Notes />
      </div>
    );
  }
}

export default App;
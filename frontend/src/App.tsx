import * as React from 'react';
import './App.css';
import NodeList from './note/NoteList';

class App extends React.Component {

  render() {

    return (
      <div className="App">
        <NodeList />
      </div>
    );
  }
}

export default App;

import * as React from 'react';
import './App.css';
import NodeList from './components/note/NoteList';
import NodeAdd from './components/note/NoteAdd';

class App extends React.Component {

  render() {

    return (
      <div className="App">
        <NodeList />
        <NodeAdd />
      </div>
    );
  }
}

export default App;
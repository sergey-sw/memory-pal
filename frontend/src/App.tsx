import * as React from 'react';
import './App.css';

const logo = require('./logo.svg');

class App extends React.Component {

  state = {
     notes: [],
     isLoading: false
  };

  componentDidMount() {
      this.setState({notes: [], isLoading: true});

      fetch('http://localhost:8080/api/notes')
        .then(response => response.json())
        .then(data => this.setState({notes: data, isLoading: false}));
  }

  render() {
    const {notes, isLoading} = this.state;

    if (isLoading) {
      return <p>Loading...</p>;
    }

    return (
      <div className="App">
        <div className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <h2>Welcome to React</h2>
        </div>
        <div>
          <h2>Note list</h2>
          {notes.map((note: any) =>
            <div key={note.id}>
              {note.text}
            </div>
          )}
        </div>
      </div>
    );
  }
}

export default App;

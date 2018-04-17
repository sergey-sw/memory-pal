import * as React from 'react';
import Note from './Note';

export default class NoteList extends React.Component {

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
          <div>
            <h2>Note list</h2>
            {notes.map(note =>
              <Note key={note.id} text={note.text} />
            )}
          </div>
      );
    }
}
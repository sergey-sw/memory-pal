import * as React from 'react';
import Note from './Note';
import './notes.css';

import api from '../api'

export default class Notes extends React.Component {

  state = {
     notes: [],
     isLoading: false
  };

  componentDidMount() {
     this.setState({notes: [], isLoading: true});
     this.updateNotes();
  }

  updateNotes = () => {
       fetch(api.endpoint + '/notes')
              .then(response => response.json())
              .then(data => this.setState({notes: data, isLoading: false}));
  }

  render() {
      const {notes, isLoading} = this.state;

      if (isLoading) {
        return <p>Loading...</p>;
      }

      return (
          <div className="Notes">
            <h2>My notes</h2>
            {notes.map(note =>
              <Note key={note.id}
                    text={note.text}
                    title={note.title}
                    tags={note.tags}
                    category={note.category}
              />
            )}
          </div>
      );
    }
}
import * as React from 'react';
import axios from 'axios';

export default class NoteAdd extends React.Component {

    constructor(props) {
        super(props);
        this.updateInputValue = this.updateInputValue.bind(this);
    }

    state = {
        text : 'Enter new note...'
    }

    onNoteAdd = () => {
        axios.post('http://localhost:8080/api/notes/create', { "text" : this.state.text } )
              .then(res => {
                this.setState({
                    text : 'Enter new note...'
                });
                this.props.onAfterSubmit();
              })
    }

    updateInputValue = (evt) => {
        this.setState({
          text: evt.target.value
        });
    }

    render() {
        return (
          <div id="note-add">
              <input
                    id="note-add-input"
                    type="text"
                    value={this.state.text}
                    onChange={evt => this.updateInputValue(evt)}
              />
              <button onClick={this.onNoteAdd}>Add</button>
          </div>
        );
    }
}
import * as React from 'react';
import axios from 'axios';

const DEFAULT_TEXT = 'Enter new note...';

export default class NoteAdd extends React.Component {

    constructor(props) {
        super(props);
        this.updateInputValue = this.updateInputValue.bind(this);
        this.onInputFocus = this.onInputFocus.bind(this);
        this.onInputBlur = this.onInputBlur.bind(this);
    }

    state = {
        text : DEFAULT_TEXT
    }

    onNoteAdd = () => {
        axios.post('http://localhost:8080/api/notes/create', { "text" : this.state.text } )
              .then(res => {
                this.setState({
                    text : DEFAULT_TEXT
                });
                this.props.onAfterSubmit();
              })
    }

    updateInputValue = (evt) => {
        this.setState({
          text: evt.target.value
        });
    }

    onInputFocus = (evt) => {
        const input = this.state.text;
        if (input === DEFAULT_TEXT) {
           this.setState({
               text: ''
           });
        }
    }

    onInputBlur = (evt) => {
        const input = this.state.text;
        if (input.length === 0) {
           setTimeout(() => {
               this.setState({
                   text: DEFAULT_TEXT
               });
           }, 300);
        }
    }

    render() {
        return (
          <div id="note-add">
              <input
                    id="note-add-input"
                    type="text"
                    value={this.state.text}
                    onChange={evt => this.updateInputValue(evt)}
                    onFocus={evt => this.onInputFocus(evt)}
                    onBlur={evt => this.onInputBlur(evt)}
              />
              <button onClick={this.onNoteAdd}>Add</button>
          </div>
        );
    }
}
import * as React from 'react';

export default class NoteAdd extends React.Component {

    state = {
        text : 'Enter new note...'
    }

    onNoteAdd = () => {
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
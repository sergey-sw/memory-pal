import * as React from 'react';

import { saveNote } from '../../api/Api';

export default class NoteAdd extends React.Component {

    state = {
        text : 'Enter new note...'
    }

    onNoteAdd = () => {
        saveNote(this.state);
    }

    updateInputValue: function(evt) {
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
              <button onClick={this.onNoteAdd} caption="Add">
          <div>
        );
    }
}
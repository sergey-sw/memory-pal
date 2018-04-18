import * as React from 'react';
import axios from 'axios';
import {MegadraftEditor, editorStateFromRaw} from "megadraft";


const DEFAULT_TEXT = 'Enter new note...';

export default class NoteAdd extends React.Component {

    constructor(props) {
        super(props);
        this.state = {editorState: editorStateFromRaw(null)};
    }

    onChange = (editorState) => {
        this.setState({editorState});
    }

    render() {
        return (
            <div className="NoteAdd">
                <MegadraftEditor
                        editorState={this.state.editorState}
                        onChange={this.onChange}/>

                <button onClick={this.onNoteAdd} className="NoteAddButton">Add</button>
            </div>
        );
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
}
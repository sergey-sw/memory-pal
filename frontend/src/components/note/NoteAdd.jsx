import * as React from 'react';
import axios from 'axios';
import ReactMde from "react-mde";
import * as Showdown from "showdown";
import './notes.css';

const DEFAULT_TEXT = 'Enter new note...';

export default class NoteAdd extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
          mdeState: null
        };

        this.converter = new Showdown.Converter({
          tables: true,
          simplifiedAutoLink: true
        });
    }

    handleValueChange = (mdeState) => {
        this.setState({ mdeState });
    };

    render() {
        return (
            <div className="NoteAdd">
                <h3>Create new note</h3>

                <ReactMde
                    onChange={this.handleValueChange}
                    editorState={this.state.mdeState}
                    generateMarkdownPreview={(markdown) => Promise.resolve(this.converter.makeHtml(markdown))}
                />

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
import * as React from 'react';
import axios from 'axios';
import ReactMde from "react-mde";
import * as Showdown from "showdown";
import './notes.css';

const DEFAULT_TITLE = 'My new note';

export default class NoteAdd extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
          mdeState: null,
          title : DEFAULT_TITLE
        };

        this.converter = new Showdown.Converter({
          tables: true,
          simplifiedAutoLink: true
        });
    }

    handleValueChange = (mdeState) => {
        this.setState({ mdeState });
    };

    updateTitleValue = (evt) => {
        this.setState({title: evt.target.value});
    };

    render() {
        return (
            <div className="NoteAdd">

                <input className="NoteAddTitle"
                     id="note-add-input"
                     type="text"
                     value={this.state.title}
                     onChange={evt => this.updateTitleValue(evt)}
                />

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
        const md = this.state.mdeState.markdown;
        const title = this.state.title;

        axios.post('http://localhost:8080/api/notes/create', { text : md, title : title } )
              .then(res => {
                this.props.onAfterSubmit();
              })
    }
}
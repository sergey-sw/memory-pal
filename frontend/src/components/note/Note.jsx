import * as React from 'react';
import './notes.css';

export default class Note extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            text : props.text,
            title : props.title
        }
    }

    render() {
        return (
            <div className="Note">
                <div className="NoteTitle">{this.state.title}</div>
                <div className="NoteText">{this.state.text}</div>
            </div>
        );
    }
}
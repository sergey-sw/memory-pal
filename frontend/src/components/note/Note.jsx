import * as React from 'react';
import './notes.css';
import * as Showdown from "showdown";

export default class Note extends React.Component {

    converter = new Showdown.Converter();

    constructor(props) {
        super(props);
        this.state = {
            text : props.text,
            title : props.title
        }
    }

    render() {
        const md = this.state.text;
        const html = this.converter.makeHtml(md);

        return (
            <div className="Note">
                <div className="NoteTitle">{this.state.title}</div>
                <span dangerouslySetInnerHTML={{__html: html}} />
            </div>
        );
    }
}
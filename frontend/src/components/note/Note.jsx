import * as React from 'react';
import './notes.css';
import * as Showdown from "showdown";
import Tags from '../tag/Tags';

export default class Note extends React.Component {

    converter = new Showdown.Converter();

    constructor(props) {
        super(props);
        this.state = {
            text : props.text,
            title : props.title,
            tags: props.tags,
            category: props.category
        }
    }

    render() {
        const md = this.state.text;
        const html = this.converter.makeHtml(md);

        return (
            <div className="Note">
                <div className="NoteTitle">{this.state.title}</div>
                <Tags tags={this.state.tags} />
                <div> Category: {this.state.category}</div>
                <span dangerouslySetInnerHTML={{__html: html}} />
            </div>
        );
    }
}
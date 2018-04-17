import * as React from 'react';

export default class Note extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            text : props.text
        }
    }

    render() {
        return <div>{this.state.text}</div>
    }
}
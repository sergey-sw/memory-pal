import * as React from 'react';
import './tags.css';

export default class Tags extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            tags: props.tags
        }
    }

    render() {
        return (
            <div className="Tags">
                {this.state.tags.map(tag =>
                    <button className="Tag">{tag}</button>
                 )}
            </div>
        );
    }
}
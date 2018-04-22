import * as React from 'react';
import './tags.css';

export default class Tags extends React.Component {

    render() {
        return (
            <div className="Tags">
                {this.props.tags.map(tag =>
                    <button className="Tag" key={tag}>{tag}</button>
                 )}
            </div>
        );
    }
}
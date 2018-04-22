import * as React from 'react';
import './tags.css';
import Tags from './Tags';
import TagAdd from './TagAdd';

export default class TagEditor extends React.Component {

    render() {
        return (
            <div className="TagEditor">
                <Tags tags={this.props.tags}/>
                <TagAdd onTagAdd={this.props.onTagAdd} />
            </div>
        );
    }
}
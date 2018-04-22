import * as React from 'react';
import './tags.css';

export default class TagAdd extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            name : null
        }
    }

    updateTagValue = (evt) => {
        this.setState({name: evt.target.value});
    };

    isBlank = (str) => {
        return (!str || /^\s*$/.test(str));
    }

    onBtnClick = () => {
        this.props.onTagAdd(this.state.name);
        this.setState({
            name : ''
        });
    }

    render() {
        return (
            <div className="TagAdd">

                <input id="tag-add-input"
                     type="text"
                     value={this.state.name}
                     onChange={evt => this.updateTagValue(evt)}
                />

                <button className="TagAddButton"
                        disabled={this.isBlank(this.state.name)}
                        onClick={this.onBtnClick}>
                    Add tag
                </button>
            </div>
        );
    }
}
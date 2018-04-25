import * as React from 'react';
import './tags.css';
import Tags from './Tags';

export default class MyTags extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
           tags: []
        };
    }

    componentDidMount() {
       this.loadTags();
    }

    loadTags = () => {
         fetch('http://localhost:8080/api/tags')
                .then(response => response.json())
                .then(data => this.setState({tags: data}));
    }

    render() {
        return (
            <Tags tags={this.state.tags.map(t => t.name)} />
        );
    }
}
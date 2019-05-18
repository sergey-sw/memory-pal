import * as React from 'react';

import api from '../api'

export default class MyCategories extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
           categories: []
        };
    }

    componentDidMount() {
       this.loadCategories();
    }

    loadCategories = () => {
         fetch(api.endpoint + '/categories')
                .then(response => response.json())
                .then(data => this.setState({categories: data}));
    }

    render() {
        return (
            <div className="Categories">
                <ul>
                {this.state.categories.map(category =>
                    <li className="Category" key={category.id}>{category.name}</li>
                )}
                </ul>
            </div>
        );
    }
}
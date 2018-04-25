import * as React from 'react';
import { BrowserRouter as Router, Route, Link } from "react-router-dom";
import Notes from './../note/Notes';
import NoteAdd from './../note/NoteAdd';
import MyTags from './../tag/MyTags';


export default class Menu extends React.Component {

    render() {
        return (
            <Router>
                <div className="Menu">
                  <ul>
                    <li>
                      <Link to="/">My notes</Link>
                    </li>
                    <li>
                      <Link to="/my-tags">My tags</Link>
                    </li>
                    <li>
                      <Link to="/new-note">New note</Link>
                    </li>
                  </ul>

                  <hr />

                  <Route exact path="/" component={Notes} />

                  <Route exact path="/my-tags" component={MyTags} />

                  <Route path="/new-note" render={ ({history}) => (
                    <NoteAdd
                         onAfterSubmit={() => { history.push('/') }}
                         />
                  )} />

                </div>
            </Router>
        );
    }
}
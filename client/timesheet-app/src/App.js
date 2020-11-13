import React from 'react';
import { Provider } from 'react-redux';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import Login from './components/login/login';
import store from './store';

const configStore = store();

function App() {
  return (
    <Provider store={configStore}>
      <Router>
        <Switch>
          <>
            <Route path="/login" component={Login}></Route>
          </>
        </Switch>
      </Router>
    </Provider>
  );
}

export default App;

import React from 'react';
import { Provider } from 'react-redux';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import NavBar from './components/layout/navbar';
import Login from './components/login/login';
import { stores, persistor } from './store';
import { PersistGate } from 'redux-persist/integration/react';
import { Dashboard } from './components/dashboard/dashboard';

const store = stores;

function App() {
  return (
    <Provider store={store}>
      <PersistGate loading={null} persistor={persistor}>
        <Router>
          <NavBar />
          <Switch>
            <>
              <Route path="/login" component={Login}></Route>
              <Route path="/dashboard" component={Dashboard}></Route>
            </>
          </Switch>
        </Router>
      </PersistGate>
    </Provider>
  );
}

export default App;

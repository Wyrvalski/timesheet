import React from 'react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import NavBar from './components/layout/navbar';
import Login from './components/login/login';
import Dashboard from './components/dashboard/dashboard';
import Profile from './components/profile/profile';
import AllProfiles from './components/allprofiles/allprofiles';

function App() {
  return (
    <Router>
      <NavBar />
      <Switch>
        <>
          <Route path="/total" component={AllProfiles}></Route>
          <Route path="/profile" component={Profile}></Route>
          <Route path="/login" component={Login}></Route>
          <Route path="/dashboard" component={Dashboard}></Route>
        </>
      </Switch>
    </Router>
  );
}

export default App;

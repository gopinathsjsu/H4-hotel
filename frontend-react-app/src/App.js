import logo from './logo.svg';
import './App.css';
import Appbar from './components/Appbar';
import React, { Component }  from 'react';
import FormPropsTextFields from './components/login';

function App() {
  return (
      <div className='App'>
        <Appbar/>
        <FormPropsTextFields/>
      </div>
  );
}

export default App;

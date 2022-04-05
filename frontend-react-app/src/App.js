import logo from './logo.svg';
import './App.css';
import Appbar from './components/Appbar';
import React, { Component }  from 'react';
import FormPropsTextFields from './components/login';
import Navbar from './components/Navbar';

function App() {
  return (
      <div className='App'>
        <h1>F4 Hotels</h1>
        {/* <Appbar/>
        <FormPropsTextFields/>
        <button className='btn btn-primary'>button</button> */}

        <Navbar/>
      </div>
  );
}

export default App;

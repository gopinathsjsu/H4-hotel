import React from "react";
import {useEffect,useState} from 'react';
import axios from 'axios';
function Navbar() {

  function logout() {
    localStorage.removeItem('currentUser')
    window.location.href='/login'
  }

  const [rewards, setRewards] = useState([]);
    
    useEffect(() => {
      async function fetchData() {
        var retrievedData = JSON.parse(localStorage.getItem('currentUser'));
        console.log(retrievedData.email)
        const req = await axios.post('/api/users/rewards',{email:retrievedData.email});
        var reqdata = req.data;
        console.log(reqdata[0].rewards);
        setRewards(reqdata[0].rewards);
       
      }

      fetchData();
    }, [])

  return (
    <div>
      <nav className="navbar navbar-expand-lg">
        <a className="navbar-brand" href="/">
          F4Hotels
        </a>
      
        <a className="navbar-brand" href="../HelpScreen">
          About
        </a>
        
        <button
          className="navbar-toggler"
          type="button"
          data-toggle="collapse"
          data-target="#navbarNav"
          aria-controls="navbarNav"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span className="navbar-toggler-icon"><i className='fa fa-bars' style={{color: 'white'}}></i></span>
        </button>
        <div className="collapse navbar-collapse " id="navbarNav">

         


          <ul className="navbar-nav ml-auto">

          {localStorage.getItem('currentUser') ? (
            <div className="dropdown mr-5">
            <button className="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i className="fa fa-user" aria-hidden="true"></i>  {JSON.parse(localStorage.getItem('currentUser')).name} 
            </button>
            <div className="dropdown-menu" aria-labelledby="dropdownMenuButton">
              <a className="dropdown-item" href="/profile">Profile</a>
              <a className="dropdown-item" href="/profile">Rewards: &nbsp; {rewards}</a>
              <a className="dropdown-item" href="#" onClick={logout}>Logout</a>
            </div>
          </div>

          ) : (
            <>
            <li className="nav-item active">
              <a className="nav-link" href="/register">
                Register
              </a>
            </li>
            <li className="nav-item">
              <a className="nav-link" href="/login">
                Login
              </a>
            </li>
            </>
            )}
           
          </ul>
        </div>
      </nav>
    </div>
  );
}

export default Navbar;

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
      <nav class="navbar navbar-expand-lg">
        <a class="navbar-brand" href="/">
          F4Hotels
        </a>
        <a className="navbar-brand" href="/">
          Destinations
        </a>
        <a className="navbar-brand" href="/">
          Help
        </a>
        <a className="navbar-brand" href="/">
          Services
        </a>
        <button
          class="navbar-toggler"
          type="button"
          data-toggle="collapse"
          data-target="#navbarNav"
          aria-controls="navbarNav"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"><i className='fa fa-bars' style={{color: 'white'}}></i></span>
        </button>
        <div class="collapse navbar-collapse " id="navbarNav">

         


          <ul class="navbar-nav ml-auto">

          {localStorage.getItem('currentUser') ? (
            <div class="dropdown mr-5">
            <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fa fa-user" aria-hidden="true"></i>  {JSON.parse(localStorage.getItem('currentUser')).name} 
            </button>
            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
              <a class="dropdown-item" href="/profile">Profile</a>
              <a class="dropdown-item" href="/profile">Rewards: &nbsp; {rewards}</a>
              <a class="dropdown-item" href="#" onClick={logout}>Logout</a>
            </div>
          </div>

          ) : (
            <>
            <li class="nav-item active">
              <a class="nav-link" href="/register">
                Register
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="/login">
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
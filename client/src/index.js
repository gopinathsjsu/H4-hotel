import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import 'bootstrap';
import 'bootstrap/dist/css/bootstrap.css';


import App from './App';
import reportWebVitals from './reportWebVitals';

ReactDOM.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>,
  document.getElementById('root')
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();

function bg() {

  var imgCount = 3;
  var dir = 'https://elasticbeanstalk-us-east-1-286814152293.s3.amazonaws.com/hotel-images/hotelimage.jpg';
  // I changed your random generator
   //floor: helps getting a random integer
  var randomCount = (Math.floor(Math.random() * imgCount));
  // I changed your array to the literal notation. The literal notation is preferred.
  var images = ['001.png', '002.png', '003.png'];
  // I changed this section to just define the style attribute the best way I know how.
  document.getElementById('banner').setAttribute("style", "background-image: url(" + dir + images[randomCount] + ");background-repeat: no-repeat;background-size: 388px 388px");
}
// Don't forget to run the function instead of just defining it.
bg();


import logo from "./logo.svg";
import "./App.css";
import {BrowserRouter, Route , path} from 'react-router-dom'
import Homescreen from "./screens/Homescreen";
import Navbar from "./components/Navbar";
import Loginscreen from "./screens/Loginscreen";
import Registerscreen from "./screens/Registerscreen";
import 'antd/dist/antd.css';
import Bookingscreen from "./screens/Bookingscreen";
import Profilescreen from "./screens/Profilescreen";
import Helpscreen from "./screens/Helpscreen";
import Landingscreen from "./screens/Landingscreen";
import Adminscreen from "./screens/Adminscreen";
import './App.css'
// import hotelimage from "./images/back.png";
    
function App() {


  return (

  //   <div
  //   class="bg_image"
  //   style={{
  //     backgroundImage: 'url('+hotelimage+')',
  //     backgroundSize: "cover",
  //     height: "280vh",
  //     color: "#f5f5f5",
      
  //     backgroundRepeat: 'no-repeat'
  //   }}
  // >

    
    <div className="App">
      <Navbar />
      <BrowserRouter>
      
         <Route path="/" exact component={Landingscreen}/>
         <Route path="/home" exact component={Homescreen}/>
         <Route path="/login" component={Loginscreen}/>
         <Route path="/register" component={Registerscreen}/>
         <Route path="/book/:roomid/:fromdate/:todate" component={Bookingscreen}/>
         <Route path="/profile" component={Profilescreen}/>
         <Route path="/HelpScreen" component={Helpscreen}/>
         <Route path="/admin" component={Adminscreen}/>
      </BrowserRouter>
    </div>
    // </div>
  );
}

export default App;
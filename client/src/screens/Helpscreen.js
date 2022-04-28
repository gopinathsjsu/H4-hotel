import React from "react";
import Swal from "sweetalert2";
import Error from "../components/Error";
import Loader from "../components/Loader";
import Success from "../components/Success";
import { Tag, Divider } from 'antd';
import { Grid } from "antd";
import { Typography } from "antd";
import { Tabs } from "antd";
const { TabPane } = Tabs;



const user = JSON.parse(localStorage.getItem('currentUser'))
function Helpscreen() {
  return (
    <div className="mt-5 ml-3">
      <div className="text-center">
        <div className="col-md-9 " style={{ marginLeft: "150px" }}>
          <h3> WHO WE ARE </h3>
          <h1>F4 was born in 2007 when two Hosts welcomed three guests to their San Francisco home, 
            and has since grown to 4 million Hosts who have welcomed more than 1 billion guest arrivals 
            in almost every country across the globe. Every day, Hosts offer unique stays and one-of-a-kind 
            activities that make it possible for guests to experience the world in a more authentic, connected way.

          </h1>
          <h1>
            REACH US AT
          </h1>
          <h1>Email us on : f4@gmail.com</h1>
          <h1>call us on  : 628-243-2420</h1>
        </div>
      </div>
    </div>
  );

}

export default Helpscreen;


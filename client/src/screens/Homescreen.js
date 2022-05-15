import React, { useState, useEffect } from "react";
import "react-date-range/dist/styles.css"; // main style file
import "react-date-range/dist/theme/default.css"; // theme css file
import { Calendar } from "react-date-range";
import { DateRangePicker } from "react-date-range";
import moment from "moment";
import Select from 'react-select';
import AsyncSelect from "react-select/async";
import axios from "axios";
import Loader from "../components/Loader";
import Room from "../components/Room";
import { DatePicker, Space } from "antd";
import AOS from 'aos';
import 'aos/dist/aos.css';
import './screen.css';
AOS.init();
const { RangePicker } = DatePicker;
var dupdate = null;
var dupdate1 = null;
var dupdate2 = null;


function Homescreen() {


  const aquaticCreatures = [
    { label: 'san jose', value: 'san jose' },
    { label: 'santa clara', value: 'santa clara' }
  ];


  const [hotels, sethotels] = useState([]);
  const [duplicatehotes, setduplicatehotes] = useState([]);
  const [fromdate, setfromdate] = useState('');
  const [todate, settodate] = useState('')
  const [loading, setloading] = useState(false);
  const [searchkey, setsearchkey] = useState('');
  const [location, setLocation] = useState('all')
  const [searchlockey, setsearchlockey] = useState('');
  const[type , settype]=useState('all')

  function disabledDate(current) {
    // Can not select days before today and today
    return current && current < moment().endOf('day');
  }

  function filterByDate(dates) {
    setfromdate(moment(dates[0]).format('MM-DD-YYYY'))
    settodate(moment(dates[1]).format('MM-DD-YYYY'))
    var temp=[]

    function confirmBooking(filtered_hotels){
      for (var room of filtered_hotels) {
        var availability = false;

        for (var booking of room.currentbookings) {

          if (room.currentbookings.length) {
            if (
                !moment(moment(dates[0]).format('MM-DD-YYYY')).isBetween(booking.fromdate, booking.todate) &&
                !moment(moment(dates[1]).format('MM-DD-YYYY')).isBetween(booking.fromdate, booking.todate)
            ) {
              if (
                  moment(dates[0]).format('MM-DD-YYYY') !== booking.fromdate &&
                  moment(dates[0]).format('MM-DD-YYYY') !== booking.todate &&
                  moment(dates[1]).format('MM-DD-YYYY') !== booking.fromdate &&
                  moment(dates[1]).format('MM-DD-YYYY') !== booking.todate
              ) {
                availability = true;
              }
            }
          }
        }
        if (availability || room.currentbookings.length === 0) {
          temp.push(room)
        }
        sethotels(temp)
      }
    }

    if(dupdate == null && dupdate1 == null && dupdate2 == null) {
      confirmBooking(duplicatehotes)
    }
    else if(dupdate1 == null && dupdate2 == null){
      confirmBooking(dupdate)
    }
    else if((dupdate == null && dupdate2 == null) || dupdate2 == null){
      confirmBooking(dupdate1)
    }
    else{
      confirmBooking(dupdate2)
    }
  }

  useEffect(async () => {
    try {
      setloading(true);
      const rooms = await (await axios.get("/api/rooms/getallrooms")).data;
      console.log(rooms);
      sethotels(rooms);
      setduplicatehotes(rooms)
      setloading(false);
    } catch (error) {
      console.log(error);
      setloading(false);
    }
  }, []);



  function filterBySearch()
  {
    dupdate1 = null;
    if(dupdate == null) {
      dupdate1 = duplicatehotes.filter(room => room.name.toLowerCase().includes(searchkey))
      sethotels(dupdate1)
    }
    else{
      dupdate1 = dupdate.filter(room => room.name.toLowerCase().includes(searchkey))
      sethotels(dupdate1)
    }
  }

  function filterByLocation(e)
  {
    dupdate = null;
    setLocation(e)
    // if(dupdate2 !== null && (dupdate1 !== null || dupdate1 == null)){
    //   if(e!=='all'){
    //     dupdate = dupdate2.filter(room=>room.location.toLowerCase().includes(e.toLowerCase()))
    //     sethotels(dupdate)
    //   }
    //   else{
    //     dupdate = dupdate2
    //     sethotels(dupdate)
    //   }
    // }
    if(dupdate2 == null && dupdate1 !== null){
      if (e !== 'all') {
        dupdate = dupdate1.filter(room => room.location.toLowerCase().includes(e.toLowerCase()))
        sethotels(dupdate)
      } else {
        dupdate = dupdate1
        sethotels(dupdate)
      }
    }
    if(dupdate1 == null && dupdate2 == null) {
      if (e !== 'all') {
        dupdate = duplicatehotes.filter(room => room.location.toLowerCase().includes(e.toLowerCase()))
        sethotels(dupdate)
      } else {
        dupdate = duplicatehotes
        sethotels(dupdate)
      }
    }
  }

  

  function filterByType(e)
  {
    dupdate2 = null;
    settype(e)
    if(dupdate == null && dupdate1 == null) {
      if (e !== 'all') {
        dupdate2 = duplicatehotes.filter(room => room.type.toLowerCase().includes(e.toLowerCase()))
        sethotels(dupdate2)
      } else {
        dupdate2 = duplicatehotes
        sethotels(dupdate2)
      }
    }
    else if(dupdate1 == null){
      if (e !== 'all'){
        dupdate2 = dupdate.filter(room => room.type.toLowerCase().includes(e.toLowerCase()))
        sethotels(dupdate2)
      } else {
      dupdate2 = dupdate
      sethotels(dupdate2)
      }
    }
    else {
      if (e !== 'all') {
        dupdate2 = dupdate1.filter(room => room.type.toLowerCase().includes(e.toLowerCase()))
        sethotels(dupdate2)
      } else {
        dupdate2 = dupdate1
        sethotels(dupdate2)
      }
    }
  }

  return (
      <body><div className="mt-5">
        <div className="container">
          <div className="row bs p-3 m-5">
            <div className="col-md-3">

              {/* <Select
  options={aquaticCreatures}

  onChange={e => {setsearchlockey(e.value)}}
/> */}
              <select className="form-control m-2" value={location} onChange={(e)=>{filterByLocation(e.target.value)}} >

                <option value="all">Select Location</option>
                <option value="Monterey">Monterey</option>
                <option value="san Jose">San Jose</option>
                <option value="san Francisco">San Francisco</option>

              </select>
            </div>

            <div className="col-md-3">
              <input
                  type="text"
                  className="form-control i2 m-2"
                  placeholder='Search Hotels'
                  value={searchkey}
                  onKeyUp={filterBySearch}
                  onChange={(e)=>{setsearchkey(e.target.value)}}
              />
            </div>

            <div className="col-md-3">
              <select className="form-control m-2" value={type} onChange={(e)=>{filterByType(e.target.value)}} >

                <option value="all">Select Room type</option>
                <option value="suite">Suite</option>
                <option value="classic">Classic</option>

              </select>
            </div>

            <div className="col-md-3">
              <RangePicker disabledDate={disabledDate} placeholder={["check-in", "check-out"]} style={{ height: "38px" }} onChange={filterByDate} format='MM-DD-YY' className='m-2'/>
            </div>

          </div>
        </div>

        <div className="row justify-content-center">
          {loading ? (
              <Loader />
          ) : (
              hotels.map((room) => {
                return (
                    <div className="col-md-8" data-aos='zoom-in'>
                      <Room room={room} fromdate={fromdate} todate={todate}/>
                    </div>
                );
              })
          )}
        </div>
      </div>
      </body>


  );
}

export default Homescreen;

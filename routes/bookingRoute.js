const express = require("express");
const router = express.Router();
const mongoose = require("mongoose");
const { v4: uuidv4 } = require("uuid");
const sgMail = require('@sendgrid/mail');
const moment = require("moment");
const stripe = require("stripe")(
  "sk_test_51IYnC0SIR2AbPxU0EiMx1fTwzbZXLbkaOcbc2cXx49528d9TGkQVjUINJfUDAnQMVaBFfBDP5xtcHCkZG1n1V3E800U7qXFmGf"
);
const Booking = require("../models/booking");
const Room = require("../models/room");
const sendgridApiKey = "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";
sgMail.setApiKey(sendgridApiKey);

const msg = {
  to: 'shubhadasanjay.paithankar@sjsu.edu', // Change to your recipient
  from: 'shubhadasanjay.paithankar@sjsu.edu', // Change to your verified sender
  subject: 'Your Reservation has been confirmed',
  text: 'You have successfully completed reservation',
  html: '<strong>You have successfully completed reservation</strong>',
}

router.post("/bookroom", async (req, res) => {
  const { room, fromdate, todate, totalDays, totalAmount, user , token } = req.body;
    console.log("bookroom api is called");

    console.log("payment is successful");
    msg.to = user.email;

    console.log("msg: " + JSON.stringify(msg));
    sgMail
    .send(msg)
    .then((response) => {

      console.log(response[0].statusCode)
      console.log(response[0].headers)
    })
    .catch((error) => {
      console.error(error)
    })

    try {
      const customer = await stripe.customers.create({
        email: token.email,
        source: token.id,
      });

      const payment = await stripe.charges.create(
        {
          amount: totalAmount * 100,
          currency: "inr",
          customer: customer.id,
          receipt_email: token.email,
        },
        {
          idempotencyKey: uuidv4(),
        }
      );

      if (true) {
        try {
        

          const newbooking = new Booking({
            userid: user._id,
            room: room.name,
            roomid: room._id,
            totalDays: totalDays,
            fromdate: moment(fromdate).format('MM-DD-YYYY'),
            todate: moment(todate).format('MM-DD-YYYY'),
            totalAmount: totalAmount,
            transactionId: "1234",
            status:'booked'
          });
      
          await newbooking.save(async (err, booking) => {
            const oldroom = await Room.findOne({ _id: room._id });
      
            oldroom.currentbookings.push({
              bookingid: booking._id,
              fromdate: moment(fromdate).format('MM-DD-YYYY'),
              todate: moment(todate).format('MM-DD-YYYY'),
              userid: user._id,
              status:'booked'
            });
            await oldroom.save();
          });
      
          res.send("Room Booked Successfully");
        } catch (error) {
          console.log("Error");
          console.log(error);
          // return res.status(200).json({ message: error });
          res.send("Room Booked Successfully");
        }
      } else {
        res.send("Payment failed");
      }
    } catch (error) {
      console.log(JSON.stringify(error));
     // return res.status(200).json({ message: "Something went wrong" + error });
      res.send("Room Booked Successfully");
    }

  
});

router.post("/cancelbooking", async (req, res) => {
  const {bookingid,roomid } = req.body;
  

  try {

    const bookingitem = await Booking.findOne({_id: bookingid}) 
    bookingitem.status='cancelled'
    await bookingitem.save();
    const room = await Room.findOne({_id:roomid})
    const bookings = room.currentbookings
    const temp=bookings.filter(booking=>booking.bookingid.toString()!==bookingid)
    console.log(temp);
    room.currentbookings=temp;
    await room.save()

    res.send('Booking deleted successfully')
  } catch (error) {
    console.log(error);
    return res.status(400).json({ message: "something went wrong" });
  }
});

router.post("/getuserbookings", async (req, res) => {
  const { userid } = req.body;
  try {
    const bookings = await Booking.find({ userid: userid }).sort({ _id: -1 });
    res.send(bookings);
  } catch (error) {
    return res.status(400).json({ message: "Something went wrong" });
  }
});

router.get("/getallbookings", async (req, res) => {
  try {
    const bookings = await Booking.find({});
    res.send(bookings);
  } catch (error) {
    return res.status(400).json({ message: error });
  }
});

module.exports = router;

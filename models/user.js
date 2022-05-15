const mongoose = require("mongoose");

const userSchema = mongoose.Schema({
    name : {type: String , require},
    email : {type: String , require},
    password : {type: String , require},
    isAdmin : {type: Boolean , require , default: false},
    opt_reward: {type: Number,required:true, default:0},
    rewards: {type: Number,required:true, default:100}
} , {
    timestamps : true
})

module.exports = mongoose.model('users' , userSchema)
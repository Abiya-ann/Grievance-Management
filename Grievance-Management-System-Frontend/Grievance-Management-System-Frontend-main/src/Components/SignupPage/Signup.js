import React, { useState } from 'react';
import './Signup.css';
import axios from 'axios';
import { base_url } from '../Config/Config';

export default function Signup() {
   const [form, setForm] = useState({ name: '', mail: '', pw: '' });
   const [errmsg, setErrmsg] = useState(null);  // Move outside of handleSubmit
   const [LogMsg, setLogMsg] = useState(null);  // Move outside of handleSubmit

   const handleChange = (e) => {
      setForm({ ...form, [e.target.name]: e.target.value });
   };

   const handleSubmit = async(e) => {
      e.preventDefault();

      try{
       const response= await axios.post(`${base_url}/user/create`,form);
       setLogMsg("Account created. Kimdly log in");
      }
      catch(error){
         setErrmsg("Failed. Try again later")
      }

      /*if (form.mail === 'Ahaan@123.com') {
         setErrmsg('Existing user. Please Log in.');
         setLogMsg(null);  // Clear success message if error occurs
      } else {
         setLogMsg('Account created. Kindly Log In');
         setErrmsg(null);  // Clear error message if success occurs
      }*/
   };

   return (
      <div className="Form">
         <h1>SIGN UP</h1>
         <div className="SignupForm">
            <form onSubmit={handleSubmit}>
               <div className="form">
                  <label>Name</label>
                  <input
                     type="text"
                     name="name"
                     value={form.name}  // Correct name is 'name', not 'username'
                     onChange={handleChange}
                     required
                  />
               </div>
               <div className="form">
                  <label>Email</label>
                  <input
                     type="email"
                     name="mail"  // Name should match the key in form state
                     value={form.mail}
                     onChange={handleChange}
                     required
                  />
               </div>
               <div className="form">
                  <label>Password</label>
                  <input
                     type="password"
                     name="pw"  // Name should match the key in form state
                     value={form.pw}
                     onChange={handleChange}
                     required
                  />
               </div>
               <div className="form">
                  <button type="submit">Submit</button>
               </div>
               {LogMsg && <div style={{ color: 'green' }}>{LogMsg}</div>}
               {errmsg && <div style={{ color: 'red' }}>{errmsg}</div>}
            </form>
         </div>
      </div>
   );
}

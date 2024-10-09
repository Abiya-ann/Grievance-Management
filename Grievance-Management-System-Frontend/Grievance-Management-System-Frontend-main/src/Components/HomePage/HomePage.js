import React from "react";
import './HomePage.css';

export default function Homepage() {
  return (
    <div className="homepage">
      <div className="main">
        <h1>Grievance Management System</h1>
        <h2 className="description">Solution to all your digital problems</h2>
        
        <div className='choice'>
          <div className='choicemid'>
            <div className='ch1'>
              <h2>Create an account</h2>
              <button className='register'><a href='/signup' >Register Now</a></button>
            </div>
            <div className='ch2'>
              <h2>Already have an account?</h2>
              <button className='register'><a href='/login'>Login</a></button>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

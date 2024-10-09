import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import './LoginPage.css';
import axios from 'axios';
import { base_url } from '../Config/Config';


export default function HomePage() {
  const [login, setLogin] = useState({ email: '', password: ''});
  const [errMsg, seterrMsg] = useState(null);
  const navigate = useNavigate();

  const handleChange = (e) => {setLogin({ ...login, [e.target.name]: e.target.value });};

  const handleLoginSubmit = async (e) => {
    e.preventDefault();

    /*try{
      const response = await axios.post(`${base_url}/user/create`,login);


    }
    catch(error){
      console.log(error);
    }*/
    if (login.email === 'user@gmail.com' && login.password === 'userpassword') {
      navigate('/GrievanceForm'); // Redirect to customer dashboard
    } else if (login.email === 'supervisor@gmail.com' && login.password === 'supervisorpassword') {
      navigate('/supervDashboard'); // Redirect to supervisor dashboard
    } else if (login.email === 'assignee@gmail.com' && login.password === 'assigneepassword') {
      navigate('/assigneeDashboard'); // Redirect to assignee dashboard
    } else {
      seterrMsg('Login failed.');
    }
  };
  
  return (
    <div className="loginPage">
      <h1>LOGIN</h1>
      <form className="loginForm" onSubmit={handleLoginSubmit}>
        <div className="formGroup">
          <label>Email</label>
          <input
            type="email"
            name="email"
            value={login.email}
            onChange={handleChange}
            required
          />
        </div>
        <div className="formGroup">
          <label>Password</label>
          <input
            type="password"
            name="password"
            value={login.password}
            onChange={handleChange}
            required
          />
        </div>
        <div className="formGroup">
          <button type="submit" className="submitButton">Login</button>
        </div>
        {errMsg && <div style={{ color: 'red' }}>{errMsg}</div>}
      </form>
    </div>
  );}
  
  
  
  
  
  /*import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import './LoginPage.css';


export default function HomePage() {
  const [loginData, setLoginData] = useState({
    email: '',
    password: ''
  });
  const [errorMessage, setErrorMessage] = useState(null);
  const navigate = useNavigate();

  const handleChange = (e) => {
    setLoginData({ ...loginData, [e.target.name]: e.target.value });
  };

  const handleLoginSubmit = async (e) => {
    e.preventDefault();
    if (loginData.email === 'user@gmail.com' && loginData.password === 'userpassword') {
      navigate('/GrievanceForm'); // Redirect to customer dashboard
    } else if (loginData.email === 'supervisor@gmail.com' && loginData.password === 'supervisorpassword') {
      navigate('/supervDashboard'); // Redirect to supervisor dashboard
    } else if (loginData.email === 'assignee@gmail.com' && loginData.password === 'assigneepassword') {
      navigate('/assigneeDashboard'); // Redirect to assignee dashboard
    } else {
      setErrorMessage('Login failed. Please check your credentials.');
    }
  };

  return (
    <div className="loginPage">
      <h1>LOGIN</h1>
      <form className="loginForm" onSubmit={handleLoginSubmit}>
        <div className="formGroup">
          <label>Email</label>
          <input
            type="email"
            name="email"
            value={loginData.email}
            onChange={handleChange}
            required
          />
        </div>
        <div className="formGroup">
          <label>Password</label>
          <input
            type="password"
            name="password"
            value={loginData.password}
            onChange={handleChange}
            required
          />
        </div>
        <div className="formGroup">
          <button type="submit" className="submitButton">Login</button>
        </div>
        {errorMessage && <div style={{ color: 'red' }}>{errorMessage}</div>}
      </form>
    </div>
  );}

  */
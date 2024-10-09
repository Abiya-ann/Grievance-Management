import './App.css';
import React, { useState } from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Signup from './Components/SignupPage/Signup';
import LoginPage from './Components/LoginPage/LoginPage';
import HomePage from './Components/HomePage/HomePage';
import AssigneeDashboard from './Components/AssigneeDashboard/AssigneeDashboard';
import SuperVDashboard from './Components/SupervisorDashboard/SuperVisorDashboard';
import GrievDetails from './Components/GrievDetails/GrievDetails';
import DetailsSuperVisor from './Components/SupervisorGDetails/DetailsSuperVisor';
import GrievanceForm from './Components/GrievanceForm/GrievanceForm';
import PreviousGrievances from './Components/PreviousGrievances/PreviousGrievances';

function App() {
  const [submittedGrievances, setSubmittedGrievances] = useState([]);

  return (
    <Router>
      <div className="App">
        <Routes>
          <Route path='/' element={<HomePage />} />
          <Route path='/login' element={<LoginPage />} />
          <Route path='/signup' element={<Signup />} />
          
                
                
            
          <Route 
            path='/GrievanceForm' 
            element={
              <GrievanceForm 
                submittedGrievances={submittedGrievances} 
                setSubmittedGrievances={setSubmittedGrievances} 
              />
            } 
          />
          <Route 
            path='/PreviousGrievances' 
            element={
              <PreviousGrievances 
                submittedGrievances={submittedGrievances} 
              />
            } 
          />
          <Route path='/assigneeDashboard' element={<AssigneeDashboard />} />
          <Route path='/supervDashboard' element={<SuperVDashboard />} />
          <Route path='/grievance-list/:id' element={<GrievDetails />} />
          <Route path='/grievances/:id' element={<DetailsSuperVisor />} />
          
        </Routes>
      </div>
    </Router>
  );
}

export default App;

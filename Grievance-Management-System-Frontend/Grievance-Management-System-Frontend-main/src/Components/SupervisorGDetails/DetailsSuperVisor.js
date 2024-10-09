import React, { useState } from 'react';
import { useLocation } from 'react-router-dom';
import './DetailsSuperVisor.css'; 

export default function GrievDetails() {
  const location = useLocation();
  const grievance = location.state.grievance;
  const [successMessage, setSuccessMessage] = useState(null);
  const [statusUpdate, setStatusUpdate] = useState(grievance.status);
  const [assignee, setAssignee] = useState(grievance.assignee || ''); // New state for assignee

  const handleSubmit = () => {
    const updatedGrievance = { ...grievance, status: statusUpdate,  assignee };

    setSuccessMessage(`${grievance.id} updated`);
   
  };

  return (
    <div className="detailsContainer">
      <h1>Grievance Details</h1>
      {successMessage ? (<p className="successMessage">{successMessage}</p>) :
        (grievance && (
          <div className="outerForm">
            <div className="lab">
            <p className='details'>User:{grievance.user.name}</p>
            <p className='details'>Email:{grievance.user.email}</p>
           <p className='details'>Complaint:{grievance.description}</p>
            <p className='details'>Current Status: {grievance.status}</p>
            </div>

            {/* Dropdown for status update */}
            <div className="updateStatus">
              <label htmlFor={`status-${grievance.id}`}>Update Status:</label>
              <select id={`status-${grievance.id}`} value={statusUpdate} onChange={(e) => setStatusUpdate(e.target.value)} className='update-select'>
                <option value="PENDING">The work is yet to start</option>
                <option value="IN_PROGRESS">We are working on it</option>
                <option value="RESOLVED">Work is done</option>
              </select>
            </div>

            {/* Dropdown for assignee selection */}
            <div className="assigneeSection">
              <label htmlFor={`assignee-${grievance.id}`}>Assign To:</label>
              <select id={`assignee-${grievance.id}`} value={assignee} onChange={(e) => setAssignee(e.target.value)} className='assignee-select'>
                <option value="">Select Assignee</option>
                <option value="Suresh">Suresh</option>
                <option value="Krishna">Krishna</option>
                <option value="Daya">Daya</option>
                <option value="Sidhique">Sidhique</option>
                <option value="Vijay">Vijay</option>
              </select>
            </div>

            

            {/* Submit button */}
            <button className="submitBtn" onClick={handleSubmit}>Submit</button>
          </div>
        ))
      }
    </div>
  );
}

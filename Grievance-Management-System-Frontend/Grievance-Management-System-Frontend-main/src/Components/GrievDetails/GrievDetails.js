import React, { useState } from 'react';
import { useLocation } from 'react-router-dom';
import './GrievDetails.css'; // Assuming you have a separate CSS file

export default function GrievanceDetails() {
  const location = useLocation();
  const grievance = location.state.grievance; // Restoring grievance variable
  const [message, setMessage] = useState(null); // For displaying success message
  const [currentStatus, setCurrentStatus] = useState(grievance.status); // Managing status updates
  const [assignedPerson, setAssignedPerson] = useState(grievance.assignee || ''); // Managing assignee

  // Handle form submission
  const onSubmit = () => {
    const updatedGrievance = {
      ...grievance,
      status: currentStatus,
      assignee: assignedPerson
    };

    // Show the success message
    setMessage(`Grievance ID ${grievance.id} has been updated`);
  };

  return (
    <div className="infoContainer">
      <h1>Grievance Information</h1>
      {message ? (
        <p className="successMessage">{message}</p>
      ) : (
        grievance && (
          <div className="formWrapper">
            <div className="grievanceDetails">
              <p className="detailItem">User: {grievance.user.name}</p>
              <p className="detailItem">Email: {grievance.user.email}</p>
              <p className="detailItem">Description: {grievance.description}</p>
              <p className="detailItem">Current Status: {grievance.status}</p>
            </div>

            {/* Dropdown to update status */}
            <div className="statusUpdate">
              <label htmlFor={`status-${grievance.id}`}>Change Status:</label>
              <select
                id={`status-${grievance.id}`}
                value={currentStatus}
                onChange={(e) => setCurrentStatus(e.target.value)}
                className="statusSelect"
              >
                <option value="PENDING">Pending</option>
                <option value="IN_PROGRESS">In Progress</option>
                <option value="RESOLVED">Resolved</option>
              </select>
            </div>

            {/* Dropdown for assignee */}
            <div className="assignSection">
              <label htmlFor={`assignee-${grievance.id}`}>Assign To:</label>
              <select
                id={`assignee-${grievance.id}`}
                value={assignedPerson}
                onChange={(e) => setAssignedPerson(e.target.value)}
                className="assigneeSelect"
              >
                <option value="">Select Assignee</option>
                <option value="Suresh">Suresh</option>
                <option value="Krishna">Krishna</option>
                <option value="Daya">Daya</option>
                <option value="Sidhique">Sidhique</option>
                <option value="Vijay">Vijay</option>
              </select>
            </div>

            {/* Submit button */}
            <button className="submitButton" onClick={onSubmit}>
              Update
            </button>
          </div>
        )
      )}
    </div>
  );
}

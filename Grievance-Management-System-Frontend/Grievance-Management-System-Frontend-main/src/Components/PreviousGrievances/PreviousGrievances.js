
import React from 'react';
import { Link } from 'react-router-dom';
import './PreviousGrievances.css';

export default function PreviousGrievances({ submittedGrievances = [] }) {
    return (
        <div className='prevGriev'>
            <h1>Previously Submitted Grievances</h1>
            
            <div className="grievance-list">
                {submittedGrievances.length > 0 ? (
                    <table>
                        <thead>
                            <tr>
                                <th>Grievance Id</th>
                                <th>Category</th>
                                <th>Description</th>
                                <th>Assignee</th>
                                <th>Submitted At</th>
                                <th>Status</th>
                            </tr>
                        </thead>
                        <tbody>
                            {submittedGrievances.map((grievance) => (
                                <tr key={grievance.id}>
                                    <td>{grievance.id}</td>
                                    <td>{grievance.category}</td>
                                    <td>{grievance.description}</td>
                                    <td>{grievance.assignee}</td> 
                                    <td>{new Date(grievance.createdAt).toLocaleString()}</td>
                                    <td>{grievance.status}</td>
                                </tr>
                            ))}
                        </tbody>
                    </table>
                ) : (
                    <p>No grievances submitted yet.</p>
                )}
            </div>
        </div>
    );
}



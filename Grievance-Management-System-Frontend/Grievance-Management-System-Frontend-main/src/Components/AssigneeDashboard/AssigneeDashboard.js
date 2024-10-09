import React, { useState, useEffect } from 'react';
import './AssigneeDashboard.css';
import { useNavigate, useLocation } from 'react-router-dom';

export default function AssigneeDashboard() {
  const [grievances, setGrievances] = useState([]);
  const navigate = useNavigate();
  const location = useLocation();

  useEffect(() => {
    const mockGrievances = [
      {
        id: 1,
        user: { name: 'John Doe', email: 'john@example.com', address: '123 Main St' },
        category: 'Damaged Products',
        status: 'PENDING',
        feedback: '',
        assignedDate: '2023-09-01',
      },
      {
        id: 2,
        user: { name: 'Jane Smith', email: 'jane@example.com', address: '456 Oak St' },
        category: 'Incorrect Products',
        status: 'IN_PROGRESS',
        feedback: '',
        assignedDate: '2023-09-02',
      },
      {
        id: 3,
        user: { name: 'Bob Johnson', email: 'bob@example.com', address: '789 Pine St' },
        category: 'App Issues',
        status: 'PENDING',
        feedback: '',
        assignedDate: '2023-09-03',
      }
    ];

    const sortedGrievances = mockGrievances.sort((a, b) => new Date(b.assignedDate) - new Date(a.assignedDate));
    setGrievances(sortedGrievances);
  }, []);

  const handleRowSelect = (grievance) => {
    navigate(`/grievance-list/${grievance.id}`, { state: { grievance } });
  };

  useEffect(() => {
    if (location.state && location.state.updatedGrievance) {
      const updatedGrievance = location.state.updatedGrievance;
      setGrievances((prevGrievances) =>
        prevGrievances.map((g) => (g.id === updatedGrievance.id ? updatedGrievance : g))
      );
    }
  }, [location.state]);

  return (
    <div className="griev">
      
     
      <h1>Issues</h1>

      <div className="table-bg">
        <div className="table-heads">
          <div>Grievance ID</div>
          <div>Name</div>
          <div>Product</div>
          <div>Assigned Date</div>
          <div>Status</div>
        </div>
      </div>

      {grievances.length === 0 ? (
        <div className="no-data">
          <p>No grievances yet.</p>
        </div>
      ) : (
        <div className="table-rows">
          {grievances.map((grievance) => (
            <div
              key={grievance.id}
              className="table-row"
              onClick={() => handleRowSelect(grievance)}
            >
              <div className="row-assignee">{grievance.id}</div>
              <div className="row-assignee">{grievance.user.name}</div>
              <div className="row-assignee">{grievance.category}</div>
              <div className="row-assignee">
                {new Date(grievance.assignedDate).toLocaleDateString()}
              </div>
              <div className="row-assignee">{grievance.status}</div>
            </div>
          ))}
        </div>
      )}
    </div>
  );
}



/*import React, { useState, useEffect } from 'react';
import './AssigneeDashboard.css';
import { useNavigate,useLocation } from 'react-router-dom';

export default function AssigneeDashboard() {
  const [grievances, setGrievances] = useState([]);
  const navigate = useNavigate();
   const location=useLocation();

  useEffect(() => {
    const mockGrievances = [
      {
        id: 1,
        user: { name: 'John Doe', email: 'john@example.com', address: '123 Main St' },
        category: 'Damaged Products',
        status: 'PENDING',
        feedback: '',
        assignedDate: '2023-09-01',
      },
      {
        id: 2,
        user: { name: 'Jane Smith', email: 'jane@example.com', address: '456 Oak St' },
        category: 'Incorrect Products',
        status: 'IN_PROGRESS',
        feedback: '',
        assignedDate: '2023-09-02',
      },
      {
        id: 3,
        user: { name: 'Bob Johnson', email: 'bob@example.com', address: '789 Pine St' },
        category: 'App Issues',
        status: 'PENDING',
        feedback: '',
        assignedDate: '2023-09-03',
      }
    ];

    const sortedGrievances = mockGrievances.sort((a, b) => new Date(b.assignedDate) - new Date(a.assignedDate));
    setGrievances(sortedGrievances);
  }, []);

  
  const handleRowSelect = (grievance) => {
    navigate(`/grievance-list/${grievance.id}`, { state: { grievance } });
  };
  useEffect(() => {
    if (location.state && location.state.updatedGrievance) {
        const updatedGrievance = location.state.updatedGrievance;
        setGrievances((prevGrievances) =>
            prevGrievances.map((g) => (g.id === updatedGrievance.id ? updatedGrievance : g))
        );
    }
}, [location.state]);

  return (
    <div className="griev">
      <h1>Grievance Management Website</h1>
      <h2>Assignee Dashboard</h2>
      <h2>Assignments</h2>
      
    
      <div className="table-bg">
            <div className="table-heads">
                <div>Grievance id</div>
                <div>Name</div>
                <div>Category</div>
                <div>Assigned Date</div>               
                <div>Status</div>
                
            </div>
      </div>

      {grievances.length === 0 ? (
            <tr>
              <td colSpan="6">No grievances yet.</td>
            </tr>
          ) : ( grievances.map((grievance) => (

                    <div className='rows' onClick={() => handleRowSelect(grievance)}>
                        <div className="table-row">
                            <div className="row-assignee">{grievance.id}</div>
                            <div className="row-assignee">{grievance.user.name}</div>
                            <div className="row-assignee">{grievance.category}</div>
                            <div className='row-assignee'>{new Date(grievance.assignedDate).toLocaleDateString()}</div>
                            <div className='row-assignee'>{grievance.status}</div>
                            <div className='row-feedback'>{grievance.feedback || 'No Feedback'}</div>
                        </div>

                    </div>)
                )
              )
        }

      
    </div>
  );
}
  */
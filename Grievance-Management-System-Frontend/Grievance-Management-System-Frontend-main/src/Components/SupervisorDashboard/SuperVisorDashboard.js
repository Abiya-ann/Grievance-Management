import './SuperVisorDashboard.css';
import { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';

function SuperVDashboard() {
  const navigate = useNavigate();
  
  // Dummy grievances data
  const dummyGrievances = [
    {
      id: 1,
      user: { name: 'John Doe' },
      category: 'Software',
      assignee: 'Engineer A',
      status: 'Pending',
    },
    {
      id: 2,
      user: { name: 'Jane Smith' },
      category: 'Hardware',
      assignee: 'Engineer B',
      status: 'In Progress',
    },
    {
      id: 3,
      user: { name: 'Mike Johnson' },
      category: 'Networking',
      assignee: 'Engineer C',
      status: 'Resolved',
    },
  ];

  const [grievances, setGrievances] = useState([]);

  useEffect(() => {
    // Instead of fetching, we set dummy data directly
    const fetchGrievances = () => {
      setGrievances(dummyGrievances);
    };
    
    fetchGrievances();
  }, []);

  const handleRowSelect = (grievance) => {
    navigate(`/grievances/${grievance.id}`, { state: { grievance } });
  };

  return (
    <div className='griev'>
      <h2>Pending Grievances</h2>
      <table className="grievance-table">
        <thead>
          <tr>
            <th>Grievance id</th>
            <th>Name</th>
            <th>Product</th>
            <th>Engineer</th>
            <th>Status</th>
          </tr>
        </thead>
        <tbody>
          {grievances.length === 0 ? (
            <tr>
              <td colSpan="5">No grievances yet.</td>
            </tr>
          ) : (
            grievances.map((grievance) => (
              <tr key={grievance.id} onClick={() => handleRowSelect(grievance)}>
                <td>{grievance.id}</td>
                <td>{grievance.user.name}</td>
                <td>{grievance.category}</td>
                <td>{grievance.assignee}</td>
                <td>{grievance.status}</td>
              </tr>
            ))
          )}
        </tbody>
      </table>
    </div>
  );
}

export default SuperVDashboard;
/*import './SuperVisorDashboard.css';
import { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import { base_url } from '../Config/Config';

function SuperVDashboard() {

  const navigate = useNavigate();
  const [grievances, setGrievances] = useState([]);

  useEffect(() => {
   const fetchGrievances= async () =>{
      try{
       const response = await axios.get(`${base_url}/grievances/all`,{withCredentials:true})
       console.log(response.data);
       setGrievances(grievances);
     }
      
      catch(error){
        console.log(error)
      }

   }
   fetchGrievances();


  }, []);

  const handleRowSelect = (grievance) => {
    navigate(`/grievances/${grievance.id}`, { state: { grievance } });
  };

  return (
    <div className='griev'>
      <h2>Pending Grievances</h2>
      <table className="grievance-table">
        <thead>
          <tr>
            <th>Grievance id</th>
            <th>Name</th>
            <th>Product</th>
            <th>Engineer</th>
            <th>Status</th>
          </tr>
        </thead>
        <tbody>
          {grievances.length === 0 ? (
            <tr>
              <td colSpan="5">No grievances yet.</td>
            </tr>
          ) : (
            grievances.map((grievance) => (
              <tr key={grievance.id} onClick={() => handleRowSelect(grievance)}>
                <td>{grievance.id}</td>
                <td>{grievance.user.name}</td>
                <td>{grievance.category}</td>
                <td>{grievance.assignee}</td>
                <td>{grievance.status}</td>
              </tr>
            ))
          )}
        </tbody>
      </table>
    </div>
  );
}

export default SuperVDashboard;

*/

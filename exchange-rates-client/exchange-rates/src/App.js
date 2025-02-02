import 'bootstrap/dist/css/bootstrap.css';
import './App.css';
import Rates from './Components/Rates';
import RateDetail from './Components/RateDetail';
import {
  BrowserRouter as Router,
  Link,
  Route,
  Routes,
  Navigate,
} from "react-router-dom";

function App() {
  return (
    <>
      <div>
        <Router>
          <Routes>
            <Route index element={<Navigate to="/rates" />} />
            <Route path="/rates">
              <Route index element={<Rates />} />
              <Route path="show/:country" element={<RateDetail />} />
            </Route>
          </Routes>
        </Router>
      </div >
    </>
  );
}

export default App;

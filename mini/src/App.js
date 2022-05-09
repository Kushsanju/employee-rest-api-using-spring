
import './App.css';
import ListEmployeeComponent from "./Components/ListEmployeeComponent";
import FooterComponent from "./Components/FooterComponent";
import HeaderComponent from "./Components/HeaderComponent";
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom'
import CreateEmployeeComponent from './Components/CreateEmployeeComponent';
import UpdateEmployeeComponent from './Components/UpdateEmployeeComponent';
import ViewEmployeeComponent from './Components/ViewEmployeeComponent';
function App() {
  return (
    <div>
      <Router>

        <HeaderComponent />
        <div className="container">
          <Switch>
            <Route path="/" exact component={ListEmployeeComponent}></Route>
            <Route path="/employees" component={ListEmployeeComponent}></Route>
            //step 1
            <Route path="/add-employee/:id" component={CreateEmployeeComponent}></Route>
            <Route path="/view-employee/:id" component={ViewEmployeeComponent}></Route>

            {/* <Route path="/update-employee/:id" component={UpdateEmployeeComponent}></Route> */}

          </Switch>
        </div>
        <FooterComponent />

      </Router>
    </div>
  );
}

export default App;

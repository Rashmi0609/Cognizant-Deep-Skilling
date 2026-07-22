import React, { Component } from "react";
import GuestPage from "./Components/GuestPage";
import UserPage from "./Components/UserPage";


class App extends Component {

  constructor(props) {
    super(props);

    this.state = {
      isLoggedIn: false
    };
  }


  login = () => {
    this.setState({
      isLoggedIn: true
    });
  };


  logout = () => {
    this.setState({
      isLoggedIn: false
    });
  };


  render() {

    let page;

    if(this.state.isLoggedIn) {
      page = <UserPage />;
    }
    else {
      page = <GuestPage />;
    }


    return (

      <div style={{textAlign:"center", margin:"30px"}}>

        <h1>Ticket Booking App</h1>


        {
          this.state.isLoggedIn ?

          <button onClick={this.logout}>
            Logout
          </button>

          :

          <button onClick={this.login}>
            Login
          </button>
        }


        {page}


      </div>

    );
  }

}


export default App; 
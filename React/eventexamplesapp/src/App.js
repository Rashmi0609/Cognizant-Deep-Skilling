import React, { Component } from "react";
import CurrencyConvertor from "./Components/CurrencyConvertor";


class App extends Component {

  constructor(props) {
    super(props);

    this.state = {
      count: 0
    };
  }


  increment = () => {
    this.setState({
      count: this.state.count + 1
    });

    this.sayHello();
  };


  decrement = () => {
    this.setState({
      count: this.state.count - 1
    });
  };


  sayHello = () => {
    alert("Hello! Welcome to React Events");
  };


  sayWelcome = (message) => {
    alert(message);
  };


  handleClick = () => {
    alert("I was clicked");
  };


  render() {
  return (
    <div style={{ textAlign: "center", margin: "30px" }}>

      <h1>React Event Examples</h1>

      <h2>Counter: {this.state.count}</h2>

      <button onClick={this.increment}>
        Increase
      </button>

      <button onClick={this.decrement}>
        Decrease
      </button>

      <br/><br/>

      <button onClick={() => this.sayWelcome("Welcome")}>
        Say Welcome
      </button>

      <br/><br/>

      <button onClick={this.handleClick}>
        OnPress
      </button>

      <hr/>

      <CurrencyConvertor />

    </div>
  );
} 
}


export default App; 
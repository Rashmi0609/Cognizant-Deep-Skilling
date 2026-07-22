import React, { Component } from "react";


class CurrencyConvertor extends Component {


  constructor(props){
    super(props);

    this.state = {
      rupees: "",
      euro: 0
    };
  }


  handleSubmit = () => {

    let result = this.state.rupees / 90;

    this.setState({
      euro: result
    });

  };


  render(){

    return(
      <div>

        <h2 style={{ color: "green" }}>
  Currency Convertor
</h2>


        <input
          type="number"
          placeholder="Enter Rupees"
          onChange={(e)=>
            this.setState({
              rupees:e.target.value
            })
          }
        />


        <button onClick={this.handleSubmit}>
          Convert
        </button>


        <h3>
          Euro: {this.state.euro}
        </h3>


      </div>
    );
  }

}


export default CurrencyConvertor; 
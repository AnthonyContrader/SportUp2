import React, { Component } from "react";
import Header from "./Header";
import Menu from "./Menu";
import Footer from "./Footer";
import Prova from "./Prova";





export default class app extends Component {

    render() {
        return (
            <div>
                <Header/>
                <Menu/>
                <Prova/>
                <Footer/> 
            </div>
        )

    }
}


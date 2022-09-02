
	import React, { Component } from 'react';

	import { Link } from 'react-router-dom';


	export class Header extends Component {

		render(){

			return(

				<>

					<nav 

						className="navbar fixed-top p-3 navbar-light shadow-sm" 

						style={{ 

							'backgroundColor' : 'rgb(255, 255, 255, .7)',

							'backdropFilter' : 'saturate(180%) blur(20px)' 

						}}

					>

						<div className="container">

							<Link to="/" className="navbar-brand text-primary">Zénith Assurances</Link>

							<Link to="/Form/Create" className="px-4 btn btn-success">Nouvelle Fiche</Link>

						</div>

					</nav>

				</>

			)

		}

	}

	export default Header;
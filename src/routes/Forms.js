
	import React, { Component } from 'react';

	import axios from 'axios';

/**
	*
	* Components
	* 
*/
	import Form from '../components/layouts/Form';


	export class FormPage extends Component {

		state = {

			forms : []

		}

		getForms = () => {

			axios.get( 'http://192.168.3.15:8080/api/fiche' ).then( response => {

				this.setState({ forms : response.data });
				
			});

		}

		componentDidMount(){

			this.getForms();

		}

		render(){

			let forms = this.state.forms;

			return(

				<>

					<div className="row mt-4">

						{ 

							forms.map( data => (

								<Form 

									key  = { data.ficheId }

									data = { data }

								/>

							))

						}

					</div>

				</>

			)

		}

	}

	export default FormPage;

	import React, { Component } from 'react';

	import axios from 'axios';

/**
	*
	* Components
	* 
*/
	import Form   from '../components/layouts/Form';


	export class FormProfilePage extends Component {

		state = {

			form: { idFiche : '', ficheId : '', datecreationFiche : '', libelleFiche : '' }

		}

		getForm = () => {

			axios.get( 'http://192.168.3.15:8080/api/fiche/' + this.props.match.params.id ).then( response => {

				this.setState({ form : response.data });
				
			});

		}

		componentDidMount(){

			this.getForm();

		}

		render(){

			let form = this.state.form;

			return(

				<>

					<div className="row mt-4">

						<div className="col-md-4"></div>

						<Form data = { form } />

						<div className="col-md-4"></div>

					</div>

				</>

			)

		}

	}

	export default FormProfilePage;
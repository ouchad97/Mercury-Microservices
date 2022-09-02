
	import React, { Component } from 'react';

	import axios from 'axios';


	export class FormCreatePage extends Component {

		state = { id : '', date : '', libelle : '' }


		dateChange    = (e) => { this.setState({ date : e.target.value }); }

		idChange      = (e) => { this.setState({ id : e.target.value }); }

		libelleChange = (e) => { this.setState({ libelle : e.target.value }); }


		submit = (e) => {

			e.preventDefault();
			
			axios.post( 'http://192.168.3.15:8080/api/fiche', {

				ficheId           : this.state.id,

				datecreationFiche : this.state.date,

				libelleFiche      : this.state.libelle

			}).then( function( response ){

				console.log( response );
				
			}).catch( function( error ){

				console.log( error );
				
			});

		}

		render(){

			return(

				<>

				<div className="d-flex justify-content-center">

					<form onSubmit={ this.submit } style={{ width : '300px' }}>

						<div className="form-group">

							<label className="p-2" htmlFor="date">Date</label>
							
							<input onChange={ this.dateChange } value={ this.state.date } type="date" className="form-control" id="date" />

						</div>

						<div className="form-group">

							<label className="p-2" htmlFor="id">FicheId</label>
							
							<input onChange={ this.idChange } value={ this.state.id } type="text" className="form-control" id="id" />

						</div>
						
						<div className="form-group">

							<label className="p-2" htmlFor="libelle">libelle</label>
							
							<input onChange={ this.libelleChange } value={ this.state.libelle } type="text" className="form-control" id="libelle" />

						</div>

						<button type="submit" className="mt-3 btn btn-primary">Submit</button>

					</form>

				</div>

				</>

			)

		}

	}

	export default FormCreatePage;
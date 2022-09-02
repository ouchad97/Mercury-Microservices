
	import React, { Component } from 'react';

	import { Link } from 'react-router-dom';


	export class Form extends Component {

		render(){

			const { idFiche, ficheId, datecreationFiche, libelleFiche } = this.props.data;

			return(

				<>

					<div className="col-md-4">

						<Link to={ '/Form/' + ficheId } className="card p-4 mb-4 text-dark" style={{ textDecoration : 'none' }}>

							<div className="card-top text-muted h6">{ ficheId }</div>
						
							<div className="card-title text-success">{ datecreationFiche }</div>

							<div className="card-text mt-2">{ libelleFiche }</div>
					
						</Link>

					</div>

				</>

			)

		}

	}

	export default Form;
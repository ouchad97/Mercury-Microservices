
	import React from 'react';

	import { BrowserRouter, Switch, Route } from 'react-router-dom';

/**
	*
	* Components
	*
*/
	import Header from './components/layouts/Header';

/**
	*
	* Routes
	*
*/
	import FormsPage       from './routes/Forms';
	import FormProfilePage from './routes/FormProfile';
	import FormCreatePage  from './routes/FormCreate';


	function App(){

		return(

			<BrowserRouter>

				<Header />

				<div className="container py-2">

					<Switch>

						<Route exact path="/" children={ <FormsPage /> } />

						<Route exact path="/Form/Create" children={ <FormCreatePage /> } />

						<Route exact path="/Form/:id" render={ (props) => <FormProfilePage { ...props } /> } />

					</Switch>

				</div>

			</BrowserRouter>

		);
	
	}

	export default App;
<%@page import="model.CreditModel"%>
<%
 CreditModel model = (CreditModel)request.getAttribute("creditModel");
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Credit bancaire</title>
		<link rel="stylesheet" type="text/css"  href="css/style.css" />
		<link rel="stylesheet" type="text/css"  href="css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css"  href="css/bootstrap.css" />
	</head>
	<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarColor01">
      <ul class="navbar-nav me-auto">
        <li class="nav-item">
          <a class="nav-link active" href="#">Home
            <span class="visually-hidden">(current)</span>
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Features</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Pricing</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">About</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Dropdown</a>
          <div class="dropdown-menu">
            <a class="dropdown-item" href="#">Action</a>
            <a class="dropdown-item" href="#">Another action</a>
            <a class="dropdown-item" href="#">Something else here</a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#">Separated link</a>
          </div>
        </li>
      </ul>
      <form class="d-flex">
        <input class="form-control me-sm-2" type="text" placeholder="Search">
        <button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
      </form>
    </div>
  </div>
</nav>
	
				   <p>Test</p>
	      <p>link : http://localhost:8080/Banque/VueCredit.jsp</p>
	<div class="container">
		<div class="panel panel-primary">
			<div class="panel-header">
			   Simulation de crédit				
			</div>
			<div class="panel-body">

	      <div>
	      	<form action="calculerMensualite.do" method="post">
	      		<table class="table">
	      			<tr>
	      				<td>Montant : </td>
	      				<td><input class="form-control-plaintext" type="text" name="montant" value="<%= model.getMontant() %>"/></td>
	      				<td>DHS</td>
	      			</tr>
	      			<tr>
	      				<td>Taux : </td>
	      				<td><input class="form-control-plaintext" type="text" name="taux" value="<%= model.getTaux() %>"/></td>
	      				<td>%</td>
	      			</tr>
	      			<tr>
	      				<td>Duree : </td>
	      				<td><input class="form-control-plaintext" type="text" name="duree" value="<%= model.getDuree() %>"/></td>
	      				<td>Mois</td>
	      			</tr>
	      		</table>
	      		<button type="submit">Calculer</button>
	      	</form>
	      </div>
	      <div>
	          Mensualite = <% out.println(model.getMensualite()); %>
	          Mensualite = <%= model.getMensualite()%>
	      </div>			
			</div>
		</div>
	</div>
	
	      
	</body>
</html>
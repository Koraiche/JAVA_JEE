<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<link rel="stylesheet" type="text/css"  href="css/style.css" />
		<link rel="stylesheet" type="text/css"  href="css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css"  href="css/bootstrap.css" />
		<title>Insert title here</title>
	</head>
	<body>
	     <%@include file="header.jsp" %>
		
         <div class="row">
             <div class="">
             		<div class="card border-primary my-4 offset-2 col-md-8" >
						  <div class="card-header">Seek Products</div>
						  <div class="card-body">
						    <h4 class="card-title">Give us a hint :) </h4>
						    <form action="search.do" method="get">
						    	<label class="card-text">Key word :</label>
						    	<input type="text" name="motCle" value="${model.motCle}" />
						    	<button type="submit" class="btn btn-primary">Search</button>
						    </form>
						    <table class="table table-striped">
						    	<tr>
						    	   <th>ID</th><th>Désignation</th><th>Prix</th><th>Quantite</th><th>Actions</th>
						    	</tr>
						    	<c:forEach items="${model.produits}" var="p">
						    	   <tr>
						    	      <td>${p.id}</td>
						    	      <td>${p.designation}</td>
						    	      <td>${p.prix}</td>
						    	      <td>${p.quantite}</td>
						    	      <td>
						    	      		<button class="btn btn-primary"><a style="text-decoration: none;color:white;" href="view.do?id=${p.id}">View</a></button>
						    	      		<button class="btn btn-warning"><a style="text-decoration: none;color:white;" href="edit.do?id=${p.id}" >Update</a></button>
						    	      		<button class="btn btn-danger" ><a onclick="return confirm('Are you sure you want to delete this element?');" style="text-decoration: none;color:white;" href="delete.do?id=${p.id}" >Delete</a></button>
						    	      </td>
						    	   </tr>
						    	</c:forEach>
						    </table>
						  </div>
					</div>						                   
             </div>
         </div>
	</body>
</html>
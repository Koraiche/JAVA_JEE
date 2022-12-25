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
						  <div class="card-header">Product</div>
						  <div class="card-body">
						  		<form action="updateProduct.do" method="post">
						  
							  		<div class="form-group">
							      		<label class="form-label">ID :</label>
							      		<input class="form-control" type="text" name="id" value="${produit.id }" readonly />
							      	</div>
							      	<div class="form-group">
							      		<label class="form-label">Designation :</label>
							      		<input class="form-control" type="text" name="designation" value="${produit.designation }" />
							      	</div>
							      	<div class="form-group">
							      		<label class="form-label">Price :</label>
							      		<input class="form-control" type="text" name="prix" value="${produit.prix }" />
							      	</div>
							      	<div class="form-group">
							      		<label class="form-label">Quantity :</label>
							      		<input class="form-control" type="text" name="quantite" value="${produit.quantite }" />
							      	</div>
							      	<button class="btn btn-primary"><a style="text-decoration: none;color:white;" href="index.do">Back</a></button>
							  		<button class="btn btn-success" type="submit"><a style="text-decoration: none;color:white;" >Confirm</a></button>
							  </form>
						  </div>
					</div>						                   
             </div>
         </div>
	</body>
</html>
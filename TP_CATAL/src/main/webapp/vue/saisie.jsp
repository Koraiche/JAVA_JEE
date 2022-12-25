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
						  <div class="card-header">Add Products</div>
						  <div class="card-body">
						      <form action="addProduct.do" method="post">
						      	<div class="form-group">
						      		<label class="form-label">Designation :</label>
						      		<input class="form-control" type="text" name="designation" />
						      	</div>
						      	<div class="form-group">
						      		<label class="form-label">Price :</label>
						      		<input class="form-control" type="text" name="prix" />
						      	</div>
						      	<div class="form-group">
						      		<label class="form-label">Quantity :</label>
						      		<input class="form-control" type="text" name="quantite" />
						      	</div>
						      	<button class="btn btn-primary m-3" type="submit">Add</button>
						      </form>
						  </div>
					</div>						                   
             </div>
         </div>
	</body>
</html>
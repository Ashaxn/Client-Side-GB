<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!Doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0"
	crossorigin="anonymous">
<link rel="stylesheet" href="Views/bootstrap.min.css">
<title>Payment Management</title>
<style>
.show {
	display: "block";
}

.hide {
	display: "none";
}
</style>
</head>
<body>
	<header>
		<nav
			class="navbar navbar-expand-lg navbar-dark bg-dark shadow fixed-top">
			<div class="container">
				<a class="navbar-brand" href="#">GadgetBadget</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarResponsive" aria-controls="navbarResponsive"
					aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarResponsive">
					<ul class="navbar-nav ml-auto">
						<li class="nav-item"><a class="nav-link" href="#">Home</a></li>
						<li class="nav-item active"><a class="nav-link" href="#">Payment
								Management <span class="sr-only">(current)</span>
						</a></li>
						<li class="nav-item"><a class="nav-link" href="#">Logout</a>
						</li>
					</ul>
				</div>
			</div>
		</nav>
	</header>
	<br>
	<br>
	<br>
	<br>

	<div class="container">
		<div class="row">
			<div class="col-6">
				<h1>Payment Management</h1>
				<br>
				<form>
					<div class="form-group">
						<label for="recipientid" class="form-label">Receipt ID:</label> <input
							class="form-control" id="recipientid"
							aria-describedby="namelHelp">
					</div>
					<div class="form-group" style="display: none">
						<label for="id" class="form-label">Receipt ID:</label> <input
							class="form-control" id="id" aria-describedby="idHelp">
					</div>
					<div class="form-group">
						<label for="totamount" class="form-label">Total Amount:</label> <input
							class="form-control" id="totamount" aria-describedby="idHelp">
					</div>
					<div class="form-group">
						<label for="paymentmethod" class="form-label">Payment
							Method:</label> <input class="form-control" id="paymentmethod"
							aria-describedby="idHelp">
					</div>
					<div class="form-group">
						<label for="researcherid" class="form-label">Researcher
							ID:</label> <input class="form-control" id="researcherid"
							aria-describedby="idHelp">
					</div>
					<div class="form-group">
						<label for="fbodyid" class="form-label">Funding Body ID:</label> <input
							class="form-control" id="fbodyid" aria-describedby="idHelp">
					</div>
					<div class="form-group">
						<label for="buyerid" class="form-label">Buyer ID:</label> <input
							class="form-control" id="buyerid" aria-describedby="emailHelp">
					</div>

					<br>
					<button class="btn btn-primary submit">Save</button>
				</form>
			</div>
			<div>
				<br /> <br />
				<div id="deleteLabel" class="alert alert-success hide" role="alert"
					style="display: none">Succesfully deleted the item.</div>
				<div id="insertLabel" class="alert alert-success hide" role="alert"
					style="display: none">Succesfully inserted the item.</div>
				<div id="deleteLabelerror" class="alert alert-danger hide"
					role="alert" style="display: none">Error while deleting the
					item.</div>
				<div id="insertLabelerror" class="alert alert-danger hide"
					role="alert" style="display: none">Error while inserting the
					item.</div>
			</div>
			<br> <br>

			<h1>All the Payment Details</h1>

			<div class="table-responsive-md">
				<br>
				<table class="table table-bordered">
					<thead class="thead-dark">
						<tr>
							<th scope="col">Id</th>
							<th scope="col">Receipt ID</th>
							<th scope="col">Total Amount</th>
							<th scope="col">Payment Method</th>
							<th scope="col">Researcher ID</th>
							<th scope="col">Funding Body ID</th>
							<th scope="col">Buyer ID</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody id="payment_table">
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<br>
	<br>
	<!--grid -->
	<!--end grid -->
	<!-- Option 1: Bootstrap Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8"
		crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.6.0.js"
		integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
		crossorigin="anonymous"></script>
	<script src="Components/payment.js"></script>
</body>

<!-- Footer -->
<footer class="bg-dark text-center text-white">
	<!-- Grid container -->
	<div class="container p-4">

		<!-- Copyright -->
		<div class="text-center p-3"
			style="background-color: rgba(0, 0, 0, 0.2);">
			© 2021 Copyright: <a class="text-white" href="http://ashano.tech/">GadgetBadget</a>
		</div>
	</div>
	<!-- Copyright -->
</footer>
</html>
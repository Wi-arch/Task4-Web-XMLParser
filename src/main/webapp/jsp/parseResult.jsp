<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Gem table</title>
<link rel="stylesheet" href="./css/all.css">
<link href="./css/bootstrap.min.css" rel="stylesheet">
<link href="./css/mdb.min.css" rel="stylesheet">
<style>
html, body, header, .view {
	height: 100%;
}

@media ( max-width : 740px) {
	html, body, header, .view {
		height: 1000px;
	}
}

@media ( min-width : 800px) and (max-width: 850px) {
	html, body, header, .view {
		height: 650px;
	}
}

.top-nav-collapse {
	background-color: #3f51b5 !important;
}

.navbar
:not
 
(
.top-nav-collapse
 
)
{
background
:
 
transparent
 
!
important
;


}
@media ( max-width : 991px) {
	.navbar
	:not
	 
	(
	.top-nav-collapse
	 
	)
	{
	background
	:
	 
	#3f51b5
	 
	!
	important
	;
	
	
}

}
.rgba-gradient {
	background: -webkit-linear-gradient(45deg, rgba(0, 0, 0, 0.7),
		rgba(72, 15, 144, 0.4) 100%);
	background: -webkit-gradient(linear, 45deg, from(rgba(0, 0, 0, 0.7),
		rgba(72, 15, 144, 0.4) 100%));
	background: linear-gradient(to 45deg, rgba(0, 0, 0, 0.7),
		rgba(72, 15, 144, 0.4) 100%);
}

.translucent {
	opacity: 0.7;
	filter: alpha(Opacity = 70);
}

.card {
	background-color: rgba(126, 123, 215, 0.2);
}

.md-form label {
	color: #ffffff;
}

h6 {
	line-height: 1.7;
}
</style>
<style type="text/css">/* Chart.js */
@
-webkit-keyframes chartjs-render-animation {
	from {opacity: 0.99
}

to {
	opacity: 1
}

}
@
keyframes chartjs-render-animation {
	from {opacity: 0.99
}

to {
	opacity: 1
}

}
.chartjs-render-monitor {
	-webkit-animation: chartjs-render-animation 0.001s;
	animation: chartjs-render-animation 0.001s;
}
</style>
</head>

<body aria-busy="true">
	<header>
		<nav
			class="navbar navbar-expand-lg navbar-dark fixed-top scrolling-navbar">
			<div class="container-fluid">
				<a class="navbar-brand" href="./"> <strong>Gem
						Store</strong>
				</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarSupportedContent-7"
					aria-controls="navbarSupportedContent-7" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent-7">
					<ul class="navbar-nav mr-auto">
						<li class="nav-item active"><a
							class="nav-link waves-effect waves-light" href="./">Home
								<span class="sr-only">(current)</span>
						</a></li>
					</ul>
				</div>
			</div>	
		</nav>
		<div class="view"
			style="background-image: url(&#39;./images/background.jpg&#39;); background-repeat: no-repeat; background-size: cover; background-position: center center;">
			<div
				class="mask rgba-gradient d-flex justify-content-center align-items-center">

				<div class="container-fluid text-center h-75 d-inline-block">
					<table class="table table-hover table-dark  translucent">
						<thead>
							<tr>
								<th scope="col">#</th>
								<th scope="col">Name</th>
								<th scope="col">Preciousness type</th>
								<th scope="col">Origin</th>
								<th scope="col">Color</th>
								<th scope="col">Transparency</th>
								<th scope="col">Facet</th>
								<th scope="col">Value</th>
								<th scope="col">Production date</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${parserResult}" var="gem" varStatus="status">
								<tr>
									<td><c:out value="${status.count}" /></td>
									<td><c:out value="${gem.name}" /></td>
									<td><c:out value="${gem.preciousnessType}" /></td>
									<td><c:out value="${gem.origin}" /></td>
									<td><c:out value="${gem.visualParameter.gemColor}" /></td>
									<td><c:out value="${gem.visualParameter.transparencyValue}" /></td>
									<td><c:out value="${gem.visualParameter.facetCount}" /></td>
									<td><c:out value="${gem.value}" /></td>
									<td><c:out value="${gem.productionDate}" /></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</header>

	<script type="text/javascript" src="./js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="./js/popper.min.js"></script>
	<script type="text/javascript" src="./js/bootstrap.min.js"></script>
	<script type="text/javascript" src="./js/mdb.min.js"></script>
	<div class="hiddendiv common"></div>
	<script>
		new WOW().init();
	</script>


</body>
</html>
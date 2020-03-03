<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Gem store</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/all.css">
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/mdb.min.css" rel="stylesheet">
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
	 ( .top-nav-collapse ) {
		background: #3f51b5 ! important;
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
				<a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp"> <strong>Gem Store</strong>
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
							class="nav-link waves-effect waves-light" href="${pageContext.request.contextPath}/index.jsp">Home <span
								class="sr-only">(current)</span>
						</a></li>
					</ul>
				</div>
			</div>
		</nav>
		<div class="view"
			style="background-image: url(&#39;${pageContext.request.contextPath}/images/background.jpg&#39;); background-repeat: no-repeat; background-size: cover; background-position: center center;">
			<div
				class="mask rgba-gradient d-flex justify-content-center align-items-center">
				<div class="container">
					<div class="row mt-5">
						<div
							class="col-md-6 mb-5 mt-md-0 mt-5 white-text text-center text-md-left">
							<h1 class="h1-responsive font-weight-bold wow fadeInLeft"
								data-wow-delay="0.3s"
								style="visibility: visible; animation-name: fadeInLeft; animation-delay: 0.3s;">Upload
								file</h1>

							<form action="controller" method="post"
								enctype="multipart/form-data">

								<div class="md-form wow fadeInLeft">
									<div class="file-field">
										<div class="btn btn-rounded purple-gradient btn-sm float-left">
											<input class="custom-file-input" id="file" type="file"
												name="file" accept=".xml"> <span>Choose file</span>
											<input type="file">
										</div>
										<div class="file-path-wrapper">
											<input class="file-path alert-heading" type="text" readonly
												placeholder="Upload your file">
										</div>
									</div>
								</div>
								<hr class="hr-light wow fadeInLeft" data-wow-delay="0.3s"
									style="visibility: visible; animation-name: fadeInLeft; animation-delay: 0.3s;">
								<div class="form-check wow fadeInLeft">
									<input class="form-check-input" type="radio" name="command"
										id="PARSE_DOM" value="PARSE_DOM" checked> <label
										class="form-check-label" for="PARSE_DOM"> DOM Parser </label>
								</div>
								<div class="form-check wow fadeInLeft">
									<input class="form-check-input" type="radio" name="command"
										id="PARSE_SAX" value="PARSE_SAX"> <label
										class="form-check-label" for="PARSE_SAX"> SAX Parser </label>
								</div>
								<div class="form-check wow fadeInLeft">
									<input class="form-check-input" type="radio" name="command"
										id="PARSE_STAX" value="PARSE_STAX"> <label
										class="form-check-label" for="PARSE_STAX"> STAX Parser
									</label>
								</div>
								<input type="submit"
									class="btn btn-outline-white wow fadeInLeft waves-effect waves-light"
									data-wow-delay="0.3s" value="Show gems"
									style="visibility: visible; animation-name: fadeInLeft; animation-delay: 0.3s;">
							</form>	
							<h1
								class="h1-responsive font-weight-bold wow fadeInLeft text-danger"
								style="visibility: visible; animation-name: fadeInLeft; animation-delay: 0.2s;">${error}
							</h1>

						</div>
					</div>
				</div>
			</div>
		</div>
	</header>

	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/popper.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/mdb.min.js"></script>
	<div class="hiddendiv common"></div>
	<script>
		new WOW().init();
	</script>


</body>
</html>
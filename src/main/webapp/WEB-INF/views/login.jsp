<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<html>
<head>
<title>Home</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" href="<c:url value="/resources/css/main.css"/>">
<link rel="shortcut icon" href="<c:url value="/resources/favicon.ico"/>">
</head>
<body>
	<div id="app">
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<a class="navbar-brand" href="/">CRUD TEST</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active"><a class="nav-link" href="/">Home
							<span class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item"><a class="nav-link" href="/board">Bulletin
							Board</a></li>
				</ul>
				<button v-if="!loginSuccess"
					class="btn btn-outline-success my-2 my-sm-0" type="button"
					v-on:click='clickLogin'>login</button>
				<button v-else class="btn btn-outline-success my-2 my-sm-0"
					type="button">logout</button>
			</div>
		</nav>
		<div class="justify-content-center container" id="fluidText">
			<div class="container-fluid alert alert-primary text-center"
				role="alert">LOGIN</div>
			<div class="jumbotron jumbotron-fluid">
				<div v-if="!userWantAccount" class="container text-center">
					<h1 class="display-4 text-center">ID
						<input v-model="userInfo.username" type="text" class="form-control" />
					</h1>
					<h1 class="display-4 text-center">PW
						<input v-model="userInfo.password" type="password" class="form-control" />
					</h1>
					<button v-on:click="checkUserInfo" class="btn btn-primary text-center">login</button>
					<button v-on:click="changeAccount();clearUserInfo();" class="btn btn-success text-center">회원가입</button>
				</div>
				<div v-else class="container text-center">
					<h1 class="btn-dark">회원가입</h1>
					<h1 class="display-4 text-center">ID
						<input v-model="userInfo.username" type="text" class="form-control" />
					</h1>
					<h1 class="display-4 text-center">PW
						<input v-model="userInfo.password" type="password" class="form-control" />
					</h1>
					<button v-on:click="addUserInfo" class="btn btn-primary text-center">가입하기</button>
					<button v-on:click="clearUserInfo();changeAccount();" class="btn btn-success text-center">뒤로가기</button>
				</div>
			</div>
		</div>
	</div>

	<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
	<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
	<script src="<c:url value="/resources/js/login.js"/>"></script>
</body>
</html>

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
				<button v-else v-on:click="logout"
					class="btn btn-outline-success my-2 my-sm-0" type="button">logout</button>
			</div>
		</nav>
		<div class="alert alert-primary text-center" role="alert">게시판</div>
		<button v-on:click='goToNew' class="btn btn-warning">글쓰기1</button>
		<table class="table text-center">
			<thead class="thead-dark">
				<tr>
					<th scope="col">No</th>
					<th scope="col">Title</th>
					<th scope="col">Writer</th>
					<th scope="col">Created</th>
				</tr>
			</thead>
			<tbody>
				<tr v-for="item in boardData"  @click="goToDetail(item.no)">
					<th scope="row">{{item.no}}</th>
					<td>{{item.title}}</td>
					<td>{{item.writer}}</td>
					<td>{{item.created}}</td>
				</tr>
			</tbody>
		</table>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
	<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
	<script src="<c:url value="/resources/js/board.js"/>"></script>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=windows-1256"
pageEncoding="windows-1256"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@include file="header.jsp" %>
<p></p>
<div class="container">
<div class="card">
<div class="card-header">
Modification des Montres
</div>
<div   class="card-body">
<form action="update.do" method="post">
<div hidden class="form-group">
<label class="control-label">ID Montre :</label>
<input type="text" name="id" class="form-control"
value="${montre.idMontre}"/>
</div>
<div class="form-group">
<label class="control-label">Nom Montre :</label>
<input type="text" name="nom" class="form-control"
value="${montre.nomMontre}"/>
</div>
<div class="form-group">
<label class="control-label">Prix :</label>
<input type="text" name="prix" class="form-control" value="${montre.prix}"/>
</div>

<div class="form-group">
<select name="genre" class="form-control">
<option value="${montre.genre.idGen}"
selected>${montre.genre.nomGen}</option>
<c:forEach items="${genModel.genres}" var="gen">
<c:if test="${gen.idGen != montre.genre.idGen}">
<option value="${gen.idGen}">${gen.nomGen}</option>
</c:if>
</c:forEach>
</select>
</div>
<div>
<button type="submit" class="btn btn-primary">Modifier</button>
</div>
</form> 
</div>
</div>
</div>
</body>
</html>

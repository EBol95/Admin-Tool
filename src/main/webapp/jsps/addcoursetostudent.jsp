<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@6.2.0/css/all.min.css">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@6.2.0/css/fontawesome.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/navmenu.css">
    <title>Students Found</title>
</head>
<body>
<nav class="navbar navbar-expand-lg bg-light">
<a class="btn btn-outline-primary btn-margin" href="${pageContext.request.contextPath}/jsps/studentsmenu.jsp"> <i class="fa-solid fa-book-open-reader"></i> Students </a>
<a class="btn btn-outline-primary btn-margin" href="${pageContext.request.contextPath}/coursesmenu"> <i class="fa-solid fa-book"></i> Courses</a>
<a class="btn btn-outline-primary btn-margin" href="${pageContext.request.contextPath}/jsps/teachersmenu.jsp"> <i class="fa-solid fa-person-chalkboard"></i> Teachers</a>
 <div class="container-fluid btn-right">
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <form class="d-flex" role="search" action="${pageContext.request.contextPath}/login" method="get">
            <button class="btn btn-outline-secondary btn-right " type="submit">Sign Out <i class="fa-solid fa-right-from-bracket"></i></button>
          </form>
        </div>
      </div>
    </nav>
    <div>
        <table>
            <thead>
                <tr>
                    <th>ID</th><th>Description</th><th>Teacher ID</th><th></th>
                </tr>
            </thead>

            <tbody>
                <c:forEach var="course" items="${courses}">
                    <tr>
                        <td>${course.id}</td>
                        <td>${course.description}</td>
                        <td>${course.teacherId}</td>
                        <td><a href="${pageContext.request.contextPath}/insert/coursetostudent?studentId=${studentId}&courseId=${course.id}">Add Course</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <div>
        <c:if test="${deleteAPIError}">
            <p>Something went wrong in delete</p>
        </c:if>
    </div>
    <div>
        <c:if test="${sqlError}">
            <p>Error in SQL</p>
        </c:if>
    </div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@6.2.0/js/fontawesome.min.js"></script>
</html>
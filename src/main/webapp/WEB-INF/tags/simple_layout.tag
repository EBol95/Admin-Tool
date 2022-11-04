<!DOCTYPE html>
<%@tag description="Simple Template" pageEncoding="UTF-8"%>
 
<%@attribute name="title" required="true"%>
<%@attribute name="head_area" fragment="true" %>
<%@attribute name="body_area" fragment="true" %>
 
<html>
 <head>
 <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@6.2.0/css/all.min.css">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@6.2.0/css/fontawesome.min.css">
	
		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/navmenu.css">
    
 <title>${title}</title>
     <jsp:invoke fragment="head_area"/>
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
     <jsp:invoke fragment="body_area"/>
 </body>
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@6.2.0/js/fontawesome.min.js"></script>
</html>

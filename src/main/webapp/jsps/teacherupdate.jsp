<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t"  tagdir="/WEB-INF/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <t:simple_layout title="Update Teacher">
 <jsp:attribute name="body_area">
 	<div>
        <form method="post" action="${pageContext.request.contextPath}/update/teacher">
            
            <input type="hidden" name="id" value="${teacher.id}"> <br>
            <input type="text" name="firstname" value="${teacher.firstname}" ><br>
            <input type="text" name="lastname" value="${teacher.lastname}"> <br><br>
            <button type="submit">Update Teacher</button>
        </form>
	 </div>  
 </jsp:attribute>
 </t:simple_layout>
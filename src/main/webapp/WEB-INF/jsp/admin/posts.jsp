<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

       
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
        <link rel="stylesheet" href="/css/style.css" type="text/css" media="screen" charset="utf-8">
   </head>
   <body>
           <div id="header">
               <span class="title"><a href="http://localhost:8081/index">Mon blog</a></span>
               <span class="title"><a href="http://localhost:8081/admin/posts">admin</a></span>
               
           </div>
           
           <div id="posts">
           <a href="/admin/post"> Nouveau </a>
              <c:forEach var="post" items="${posts}">
              	<div class="post">

 					<span class="title"> 
 					<a href="./post/${post.id}">${post.title}</a>
 					(<a href="/admin/post/${post.id}/delete">supprimer</a>)
              		</span>
              		
              	</div>
              </c:forEach>
            

           </div>
           
           <div id="right">
               <div class="tagcloud">
                   <span class="title">Les tags</span>
                   
                  <ul>
                   <c:forEach var="tag" items="${tags}">
                       <li>${tag}</li>
                   </c:forEach>
                   </ul>
                   
               </div>
               
               <div class="latest">
                   <span class="title">Les billets récents</span>
                   <ul>
                   <c:forEach var="post" items="${posts}" end="1">
                       <li><a href="./post/${post.id}">${post.title}</a></li>
                   </c:forEach>
                   </ul>
               </div>
           </div>
   </body>
</html>
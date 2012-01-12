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
 					<a href="./post/${post.id}">
 					(<a href="/admin/post/${post.id}/delete">supprimer</a>)
              		${post.title}
              		</a>
              		</span>
              		
              	</div>
              </c:forEach>
            

           </div>
           
           <div id="right">
               <div class="tagcloud">
                   <span class="title">Les tags</span>
                   <ul>
                       <li>tag 1</li>
                       <li>tag 2</li>
                   </ul>
               </div>
               
               <div class="latest">
                   <span class="title">Les billets récents</span>
                   <ul>
                       <li>Un post</li>
                       <li>Un post</li>
                   </ul>
               </div>
           </div>
   </body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: shamsudeen
  Date: 8/30/21
  Time: 1:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Featured posts-->
<div class="widget mt-n1 mb-5">
    <h3 class="widget-title pb-1">Trending posts</h3>
    <c:forEach items="${trendingPosts}" var="post" begin="0" end="5">
        <c:set var="title" value="${fn:replace(fn:toLowerCase(post.enhTitle),'?', '')}"/>
        <div class="d-flex align-items-center pb-1 mb-3">
            <a class="d-block flex-shrink-0" href="${pageContext.request.contextPath}/${fn:replace(title,' ', '-')}-${post.postId}">
                <img class="rounded" src="/img/blog/avatar/06.jpg" alt="Post" width="64">
            </a>
            <div class="ps-2 ms-1">
                <h4 class="fs-md nav-heading mb-1"><a class="fw-medium" href="${pageContext.request.contextPath}/${fn:replace(title,' ', '-')}-${post.postId}">
                        ${post.enhTitle}
                </a></h4>
                <p class="fs-xs text-muted mb-0">by smashvoid</p>
            </div>
        </div>
    </c:forEach>
</div>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
<head>

  <c:import url="/WEB-INF/views/common/head.jsp">
    <c:param name="title" value=" smashvoid" />
    <c:param name="desc" value="smashvoid technology" />
  </c:import>

  <c:import url="/WEB-INF/views/common/googlead/autoad.jsp"/>
</head>
<!-- Body-->
<body class="is-sidebar">
<main class="page-wrapper">
  <!-- Navbar (Solid background + shadow)-->
  <!-- Remove "navbar-sticky" class to make navigation bar scrollable with the page.-->
  <c:import url="../common/header-4a.jsp"/>
  <!-- Page content-->
  <div class="container py-4 mb-2 mb-sm-0 pb-sm-5">
    <nav aria-label="breadcrumb">
      <ol class="py-1 my-2 breadcrumb">
        <li class="breadcrumb-item"><a href="index.html">Home</a></li>
        <li class="breadcrumb-item"><a href="#">Blog</a>
        </li>
        <li class="breadcrumb-item active" aria-current="page">Grid no sidebar</li>
      </ol>
    </nav>
    <h1 class="mb-5">Blog</h1>
    <!-- Blog grid-->
    <div class="masonry-grid overflow-hidden" data-columns="4">
      <!-- Post-->
      <c:forEach items="${posts}" var="post">
        <div class="masonry-grid-item">
          <article class="card card-hover"><a class="card-img-top" href="blog-single-rs.html"><img src="https://www.smashplus.com/img/blog/03.jpg" alt="Post thumbnail"></a>
            <div class="card-body"><a class="meta-link fs-sm mb-2" href="/questions/${post.primaryTag}">${post.primaryTag}</a>
              <c:set var="title" value="${fn:replace(fn:toLowerCase(post.enhTitle),'?', '')}"/>
              <h2 class="h5 nav-heading mb-4"><a href="/${fn:replace(title,' ', '-')}-${post.postId}">${post.enhTitle}</a></h2>
              <a class="d-flex meta-link fs-sm align-items-center pt-3" href="#"><img class="rounded-circle" src="img/blog/avatar/07.jpg" alt="smashvoid-avtar" width="36">
                <div class="ps-2 ms-1 mt-n1">by<span class="fw-semibold ms-1">smashvoid</span></div></a>
              <div class="mt-3 text-end text-nowrap"><a class="meta-link fs-xs" href="#"><i class="ai-message-square me-1 mt-n1 align-middle"></i>&nbsp;6</a><span class="meta-divider"></span><a class="meta-link fs-xs" href="#"><i class="ai-calendar me-1 mt-n1 align-middle"></i>&nbsp;Feb 19</a></div>
            </div>
          </article>
        </div>
      </c:forEach>
      <!-- Post-->


    </div>
    <!-- Pagination-->
    <div class="d-md-flex justify-content-between align-items-center pt-3 pb-2">
      <div class="d-flex justify-content-center align-items-center mb-4">
        <label class="pe-1 me-2">Show</label>
        <select class="form-select me-2" style="width: 5rem;">
          <option value="10">10</option>
          <option value="20">20</option>
          <option value="30">30</option>
          <option value="40">40</option>
          <option value="50">50</option>
        </select>
        <div class="fs-sm text-nowrap ps-1 mb-1">posts per page</div>
      </div>
      <nav class="mb-4" aria-label="Page navigation">
        <ul class="pagination justify-content-center">
          <li class="page-item"><a class="page-link" href="#" aria-label="Previous"><i class="ai-chevron-left"></i></a></li>
          <li class="page-item d-sm-none"><span class="page-link page-link-static">2 / 10</span></li>
          <li class="page-item d-none d-sm-block"><a class="page-link" href="#">1</a></li>
          <li class="page-item active d-none d-sm-block" aria-current="page"><span class="page-link">2<span class="visually-hidden">(current)</span></span></li>
          <li class="page-item d-none d-sm-block"><a class="page-link" href="#">3</a></li>
          <li class="page-item d-none d-sm-block"><a class="page-link" href="#">4</a></li>
          <li class="page-item d-none d-sm-block">...</li>
          <li class="page-item d-none d-sm-block"><a class="page-link" href="#">10</a></li>
          <li class="page-item"><a class="page-link" href="#" aria-label="Next"><i class="ai-chevron-right"></i></a></li>
        </ul>
      </nav>
    </div>
  </div>
</main>
<c:import url="../common/footer-min.jsp">
  <c:param name="type" value="bg-dark"/>
</c:import>
<!-- Sidebar toggle button-->
<button class="btn btn-primary btn-sm sidebar-toggle" type="button" data-bs-toggle="offcanvas" data-bs-target="#blog-sidebar"><i class="ai-sidebar fs-base me-2"></i>Sidebar</button>
<!-- Back to top button--><a class="btn-scroll-top" href="#top" data-scroll data-fixed-element><span class="btn-scroll-top-tooltip text-muted fs-sm me-2">Top</span><i class="btn-scroll-top-icon ai-arrow-up">   </i></a>
<!-- Vendor scrits: js libraries and plugins-->
<script src="/js/vendor/bootstrap/bootstrap.bundle.min.js"></script>
<script src="/js/vendor/simplebar/simplebar.min.js"></script>
<script src="/js/vendor/smooth-scroll/smooth-scroll.polyfills.min.js"></script>
<script src="/js/vendor/tiny-slider/dist/min/tiny-slider.js"></script>
<script src="/js/vendor/lightgallery.js/dist/js/lightgallery.min.js"></script>
<script src="/js/vendor/lg-fullscreen.js/dist/lg-fullscreen.min.js"></script>
<script src="/js/vendor/lg-zoom.js/dist/lg-zoom.min.js"></script>
<script src="/js/vendor/lg-video.js/dist/lg-video.min.js"></script>

<!-- Main theme script-->
<script src="/js/theme.js"></script>
<script>
  $(document).ready(function(){
    let teaser =$("div.teaser").text();
    console.log(teaser);
    $("meta[name='description']").attr("content", teaser);
    $("meta[property='og\\:description']").attr("content", teaser);
  });
</script>
<script src="https://cdn.jsdelivr.net/npm/marked/marked.min.js"></script>
<script>
</script>
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: shamsudeen
  Date: 09/09/22
  Time: 8:49 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <!-- SEO Meta Tags-->
  <meta name="author" content="Smashplus">
  <!-- Viewport-->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- Favicon and Touch Icons-->
  <link rel="apple-touch-icon" sizes="180x180" href="assets/favicon/apple-touch-icon.png">
  <link rel="icon" type="image/png" sizes="32x32" href="assets/favicon/favicon-32x32.png">
  <link rel="icon" type="image/png" sizes="16x16" href="assets/favicon/favicon-16x16.png">
  <link rel="manifest" href="assets/favicon/site.webmanifest">
  <link rel="mask-icon" color="#6366f1" href="assets/favicon/safari-pinned-tab.svg">
  <meta name="msapplication-TileColor" content="#080032">
  <meta name="msapplication-config" content="assets/favicon/browserconfig.xml">
  <meta name="theme-color" content="white">
  <!-- Theme mode-->
  <script>
    let mode = window.localStorage.getItem('mode'),
            root = document.getElementsByTagName('html')[0];
    if (mode !== undefined && mode === 'dark') {
      root.classList.add('dark-mode');
    } else {
      root.classList.remove('dark-mode');
    }


  </script>
  <!-- Page loading styles-->

  <!-- Import Google Font-->
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&amp;display=swap" rel="stylesheet" id="google-font">
  <!-- Vendor styles-->
  <link rel="stylesheet" media="screen" href="/css/vendor/swiper/swiper-bundle.min.css"/>
  <!-- Main Theme Styles + Bootstrap-->
  <c:import url="/WEB-INF/views/common/head-4a.jsp">
    <c:param name="title" value="${post.title}" />
    <c:param name="desc" value="${post.title} - ${teaser}" />
  </c:import>
</head>
<!-- Body-->
<body>
<!-- Page wrapper-->
<main class="page-wrapper">
  <!-- Navbar. Remove 'fixed-top' class to make the navigation bar scrollable with the page-->
  <c:import url="../common/header-4a.jsp"/>
  <!-- Page content-->
  <!-- Container-->
  <section class="container pt-5 mt-5">
    <!-- Breadcrumb-->
    <nav aria-label="breadcrumb">
      <ol class="pt-lg-3 pb-lg-4 pb-2 breadcrumb">
        <li class="breadcrumb-item"><a href="/">Home</a></li>
        <li class="breadcrumb-item"><a href="/">Sultan Bathery</a></li>
        <li class="breadcrumb-item active" aria-current="page">${post.title}</li>
      </ol>
    </nav>
    <div class="row">
      <div class="col-lg-9 col-xl-8 pe-lg-4 pe-xl-0">
        <!-- Post title + post meta-->
        <h1 class="pb-2 pb-lg-3">${post.title}</h1>
        <div class="d-flex flex-wrap align-items-center justify-content-between border-bottom mb-4">
          <div class="d-flex align-items-center mb-4 me-4"><span class="fs-sm me-2">By:</span><a class="nav-link position-relative fw-semibold p-0" href="https://www.smashplus.com" data-scroll data-scroll-offset="80">Smashplus<span class="d-block position-absolute start-0 bottom-0 w-100" style="background-color: currentColor; height: 1px;"></span></a></div>
          <%--<div class="d-flex align-items-center mb-4"><span class="fs-sm me-2">Share post:</span>
            <div class="d-flex"><a class="nav-link p-2 me-2" href="#" data-bs-toggle="tooltip" data-bs-placement="top" title="Instagram"><i class="ai-instagram"></i></a><a class="nav-link p-2 me-2" href="#" data-bs-toggle="tooltip" data-bs-placement="top" title="Facebook"><i class="ai-facebook"></i></a><a class="nav-link p-2 me-2" href="#" data-bs-toggle="tooltip" data-bs-placement="top" title="Telegram"><i class="ai-telegram fs-sm"></i></a><a class="nav-link p-2" href="#" data-bs-toggle="tooltip" data-bs-placement="top" title="Twitter"><i class="ai-twitter"></i></a></div>
          </div>--%>
        </div>
        <!-- Post content-->

        <p class="fs-lg pt-2 pt-sm-3">${post.content}</p>

        <!-- Tags-->
        <div class="d-flex flex-wrap pb-5 pt-3 pt-md-4 pt-xl-5 mt-xl-n2">
          <h3 class="h6 py-1 mb-0 me-4">Relevant tags:</h3>
          <c:forEach items="${post.labels}" var="tag" varStatus="inx">
            <a class="nav-link fs-sm py-1 px-0 me-3" href="/${blgid}/${fn:trim(tag)}"><span class="text-primary">#</span> ${tag}</a>
          </c:forEach>
        </div>

      </div>
      <!-- Sidebar (offcanvas on sreens < 992px)-->
      <aside class="col-lg-3 offset-xl-1">
        <div class="offcanvas-lg offcanvas-end" id="sidebar">
          <div class="offcanvas-header">
            <h4 class="offcanvas-title">Sidebar</h4>
            <button class="btn-close ms-auto" type="button" data-bs-dismiss="offcanvas" data-bs-target="#sidebar"></button>
          </div>
          <div class="offcanvas-body">
            <!-- Search box-->
            <div class="position-relative mb-4 mb-lg-5"><i class="ai-search position-absolute top-50 start-0 translate-middle-y ms-3"></i>
              <input class="form-control ps-5" type="search" placeholder="Enter keyword">
            </div>

            <!-- Recent posts-->
            <%--<h4 class="pt-3 pt-lg-1 mb-4">City News:</h4>
            <ul class="list-unstyled mb-lg-5 mb-4">
              <c:forEach var="news" items="${cityNews}">
                <li class="border-bottom pb-3 mb-3">
                  <span class="h6 mb-0">
                  <a href="https://www.smashplus.com/${news.shortUrl}" target="_blank">${news.title}</a></span>
                </li>
              </c:forEach>
            </ul>--%>
            <!-- Relevant topics-->
            <h4 class="pt-3 pt-lg-1 mb-4">Relevant topics:</h4>
            <div class="d-flex flex-wrap mt-n3 ms-n3 mb-lg-5 mb-4 pb-3 pb-lg-0">
              <c:forTokens items="${entity.tags}" delims="," var="tag" varStatus="inx">
                  <a class="btn btn-outline-secondary rounded-pill mt-3 ms-3" href="/tag-${fn:trim(tag)}--sb">${tag}</a>
              </c:forTokens>
              <c:if test="${not empty entity.subCategory}">
                <a class="btn btn-outline-secondary rounded-pill mt-3 ms-3" href="/sc-${entity.subCategory}--sb">${entity.subCategory}</a>
              </c:if>
            </div>

            <!-- Banner-->
            <div class="position-relative mb-3">
              <div class="ignore-dark-mode position-absolute w-100 text-center top-0 start-50 translate-middle-x pt-4" style="max-width: 15rem;">
                <h3 class="h2 pt-3 mb-0">Advertise here!</h3>
              </div><img class="rounded-5" src="/img/blog/sidebar/banner.jpg" alt="Banner">
            </div>
          </div>
        </div>
      </aside>
    </div>
  </section>
  <!-- Sidebar toggle button-->
  <button class="d-lg-none btn btn-sm fs-sm btn-primary w-100 rounded-0 fixed-bottom" data-bs-toggle="offcanvas" data-bs-target="#sidebar"><i class="ai-layout-column me-2"></i>Sidebar</button>
</main>

<c:import url="../common/footer-4a.jsp"/>
<!-- Back to top button--><a class="btn-scroll-top" href="#top" data-scroll>
  <svg viewBox="0 0 40 40" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
    <circle cx="20" cy="20" r="19" fill="none" stroke="currentColor" stroke-width="1.5" stroke-miterlimit="10"></circle>
  </svg><i class="ai-arrow-up"></i></a>
<!-- Vendor scripts: js libraries and plugins-->
<script src="/js/4/bootstrap/bootstrap.bundle.min.js"></script>
<script src="/js/4/smooth-scroll/smooth-scroll.polyfills.min.js"></script>
<script src="/js/4/swiper/swiper-bundle.min.js"></script>
<%--
<script src="/js/4/lgallery/lightgallery.min.js"></script>
<script src="/js/4/lgallery/plugins/video/lg-video.min.js"></script>
<script src="/js/4/lgallery/plugins/fullscreen/lg-fullscreen.min.js"></script>
--%>

<!-- Main theme script-->
<script src="/js/4/theme.min.js"></script>

</body>
</html>

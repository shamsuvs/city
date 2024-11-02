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
  <meta name="keywords" content="bootstrap, business, corporate, coworking space, services, creative agency, dashboard, e-commerce, mobile app showcase, saas, multipurpose, product landing, shop, software, ui kit, web studio, landing, dark mode, html5, css3, javascript, gallery, slider, touch, creative">
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

  <!-- Import Google Font-->
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&amp;display=swap" rel="stylesheet" id="google-font">
  <!-- Vendor styles-->
  <link rel="stylesheet" media="screen" href="/css/vendor/swiper/swiper-bundle.min.css"/>
  <!-- Main Theme Styles + Bootstrap-->
  <c:import url="/WEB-INF/views/common/head-4a.jsp">
    <c:param name="title" value="${target}" />
    <c:param name="desc" value="${target} - ${teaser}" />
  </c:import>
</head>
<!-- Body-->
<body>

<!-- Page wrapper-->
<main class="page-wrapper">
  <!-- Navbar. Remove 'fixed-top' class to make the navigation bar scrollable with the page-->
  <c:import url="../common/header-4a.jsp"/>
  <!-- Page content-->
  <!-- Page content-->
  <div class="container pt-5 pb-lg-5 pb-md-4 pb-2 my-5">
    <!-- Breadcrumb-->
    <nav aria-label="breadcrumb">
      <ol class="pt-lg-3 pb-lg-4 pb-2 breadcrumb">
        <li class="breadcrumb-item"><a href="/">Home</a></li>
        <li class="breadcrumb-item active" aria-current="page">${target}</li>
      </ol>
    </nav>
    <div class="row mb-md-2 mb-xl-4">
      <!-- Blog posts-->
      <div class="col-lg-9 pe-lg-4 pe-xl-5">
        <h1 class="pb-3 pb-lg-4">${target}</h1>
        <p>${teaser}</p>
        <c:forEach items="${establishments}" var="establishment">
          <!-- Post-->
          <article class="row g-0 border-0 mb-4"><a class="col-sm-5 bg-repeat-0 bg-size-cover bg-position-center rounded-5" href="/${establishment.uniqueSEOId}--sb" style="background-image: url(${establishment.image1}); min-height: 14rem"></a>
            <div class="col-sm-7">
              <div class="pt-4 pb-sm-4 ps-sm-4 pe-lg-4">
                <h3><a href="/${establishment.uniqueSEOId}--sb">${establishment.title}</a></h3>
                <p class="d-sm-none d-md-block">${establishment.teaser}</p>
                <div class="d-flex flex-wrap align-items-center mt-n2">
                  <a class="nav-link text-muted fs-sm fw-normal p-0 mt-2 me-3" href="#">${establishment.likes}<i class="ai-like fs-lg ms-1"></i></a>
                  <span class="fs-xs opacity-20 mt-2 mx-3">|</span><span class="fs-sm text-muted mt-2">${establishment.tags}</span>
                  <span class="fs-xs opacity-20 mt-2 mx-3">|</span><a class="badge text-nav fs-xs border mt-2" href="${categoryDto.get(establishment.category).url}">${categoryDto.get(establishment.category).categoryTitle}</a></div>
              </div>
            </div>
          </article>
        </c:forEach>


      </div>
      <!-- Sidebar (offcanvas on sreens < 992px)-->
      <aside class="col-lg-3">
        <div class="offcanvas-lg offcanvas-end" id="sidebarBlog">
          <div class="offcanvas-header">
            <h4 class="offcanvas-title">Sidebar</h4>
            <button class="btn-close ms-auto" type="button" data-bs-dismiss="offcanvas" data-bs-target="#sidebarBlog"></button>
          </div>
          <div class="offcanvas-body">
            <!-- Search box-->
            <div class="position-relative mb-4 mb-lg-5"><i class="ai-search position-absolute top-50 start-0 translate-middle-y ms-3"></i>
              <input class="form-control ps-5" type="search" placeholder="Enter keyword">
            </div>
            <!-- Category links-->
            <h4 class="pt-1 pt-lg-0 mt-lg-n2">Categories:</h4>
            <ul class="nav flex-column mb-lg-5 mb-4">
              <li class="mb-2"><a class="nav-link d-flex p-0 active" href="#">All categories<span class="fs-sm text-muted ms-2">(110)</span></a></li>
              <li class="mb-2"><a class="nav-link d-flex p-0" href="${categoryDto.get('hotel').url}">Hotels<span class="fs-sm text-muted ms-2">(8)</span></a></li>
              <li class="mb-2"><a class="nav-link d-flex p-0" href="${categoryDto.get('hospital').url}">Hospitals<span class="fs-sm text-muted ms-2">(5)</span></a></li>
              <li class="mb-2"><a class="nav-link d-flex p-0" href="${categoryDto.get('textile').url}">Textiles<span class="fs-sm text-muted ms-2">(3)</span></a></li>
            </ul>
            <!-- Featured posts widget-->
            <%--<h4 class="pt-3 pt-lg-0 pb-1">Trending posts:</h4>
            <div class="mb-lg-5 mb-4">
              <c:forEach var="news" items="${cityNews}">
              <article class="position-relative d-flex align-items-center mb-4"><img class="rounded" src="${news.thumbImage}" width="92" alt="Post image">
                <div class="ps-3">
                  <h4 class="h6 mb-2"><a class="stretched-link" href="https://www.smashplus.com/${news.shortUrl}" target="_blank">${news.title}</a></h4>
                </div>
              </article>
              </c:forEach>

            </div>--%>
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
  </div>
  <!-- Sidebar toggle button-->
  <button class="d-lg-none btn btn-sm fs-sm btn-primary w-100 rounded-0 fixed-bottom" data-bs-toggle="offcanvas" data-bs-target="#sidebarBlog"><i class="ai-layout-column me-2"></i>Sidebar</button>
</main>

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
<!-- Main theme script-->
<script src="/js/4/theme.min.js"></script>
</body>
</html>

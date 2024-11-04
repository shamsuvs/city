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
    <c:param name="title" value="${entity.title}" />
    <c:param name="desc" value="${entity.title} - ${entity.teaser}" />
    <c:param name="kw" value="${entity.title}, best ${entity.category} in ${city}" />
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
        <li class="breadcrumb-item active" aria-current="page">${entity.title}</li>
      </ol>
    </nav>
    <div class="row">
      <div class="col-lg-9 col-xl-8 pe-lg-4 pe-xl-0">
        <!-- Post title + post meta-->
        <h1 class="pb-2 pb-lg-3">${entity.title}</h1>
        <div class="d-flex flex-wrap align-items-center justify-content-between border-bottom mb-4">
          <div class="d-flex align-items-center mb-4 me-4"><span class="fs-sm me-2">By:</span><a class="nav-link position-relative fw-semibold p-0" href="https://www.smashplus.com" data-scroll data-scroll-offset="80">Smashplus<span class="d-block position-absolute start-0 bottom-0 w-100" style="background-color: currentColor; height: 1px;"></span></a></div>
          <%--<div class="d-flex align-items-center mb-4"><span class="fs-sm me-2">Share post:</span>
            <div class="d-flex"><a class="nav-link p-2 me-2" href="#" data-bs-toggle="tooltip" data-bs-placement="top" title="Instagram"><i class="ai-instagram"></i></a><a class="nav-link p-2 me-2" href="#" data-bs-toggle="tooltip" data-bs-placement="top" title="Facebook"><i class="ai-facebook"></i></a><a class="nav-link p-2 me-2" href="#" data-bs-toggle="tooltip" data-bs-placement="top" title="Telegram"><i class="ai-telegram fs-sm"></i></a><a class="nav-link p-2" href="#" data-bs-toggle="tooltip" data-bs-placement="top" title="Twitter"><i class="ai-twitter"></i></a></div>
          </div>--%>
        </div>
        <!-- Post content-->
        <div class="card border-0 bg-secondary mb-3">
          <div class="card-body">
            <figure>
              <blockquote>
                <p>${entity.teaser}</p>
              </blockquote>
            </figure>
          </div>
        </div>
        <p class="text-muted mb-1"> <i class="fa fa-map-marker text-primary mr-1"></i>${entity.address}, ${entity.district},${entity.state}, ${entity.country}</p>
        <ul class="list-unstyled mb-0">
          <c:if test="${not empty entity.phone}">
            <li class="pb-1 mb-2"><span class="d-block fs-sm text-muted mb-1">Contact numbers</span><a class="nav-link fs-lg p-0" href="tel:${entity.phone}">${entity.phone}</a> <a class="nav-link fs-lg p-0" href="tel:${entity.mobile}">${entity.mobile}</a></li>
          </c:if>
          <c:if test="${not empty entity.website}">
            <li class="pb-1 mb-2"><span class="d-block fs-sm text-muted mb-1">website</span>
            <a class="nav-link fs-lg p-0" href="${entity.website}">${entity.website}</a>
          </c:if>

        </ul>

        <c:if test="${not empty entity.image1}">
          <figure class="figure"><img class="figure-img rounded-5 mb-3" src="${entity.image1}" alt="${entity.title}">
            <figcaption class="figure-caption">Image: ${entity.title}</figcaption>
          </figure>
        </c:if>
        <p class="fs-lg pt-2 pt-sm-3">${entity.about}</p>
        <h2 class="h4 mb-lg-4 pt-3 pt-md-4 pt-xl-5">Features</h2>
        <ul class="list-unstyled pb-3 mb-3 mb-lg-4">
          <c:forTokens items="${entity.features}" delims="," var="feature" varStatus="inx">
            <li class="d-flex pt-1 mt-2 mx-2 mx-md-0"><i class="ai-check-alt text-primary fs-4 mt-n1 me-2"></i>${feature}</li>
          </c:forTokens>
        </ul>
        <c:if test="${not empty entity.image2 or not empty entity.image3}">
        <section class="position-relative pt-5 mt-lg-3 mt-xl-4 mt-xxl-5">
          <div class="bg-secondary position-absolute start-0 bottom-0 w-100 d-none d-sm-block" style="height: 110px;"></div>
          <div class="bg-secondary position-absolute start-0 bottom-0 w-100 d-sm-none" style="height: 80px;"></div>
          <div class="container position-relative zindex-2 pt-2 pt-sm-4 pt-lg-5 mt-md-2 mt-lg-0">
            <h2 class="h1 text-center pb-3 mb-3 mb-lg-4">See more photos on <a href="#" class="text-primary text-decoration-none">Instagram</a></h2>
            <div class="row g-4">
              <div class="col-md-8">
                <div class="row g-3 g-sm-4">
                  <div class="col-5"><a class="d-block card-hover zoom-effect" href="#">
                    <div class="d-flex justify-content-center align-items-center position-absolute top-0 start-0 w-100 h-100 rounded-5 overflow-hidden zindex-2 opacity-0"><i class="ai-instagram lead text-white position-relative zindex-2"></i>
                      <div class="position-absolute top-0 start-0 w-100 h-100 bg-black opacity-20"></div>
                    </div>
                    <div class="zoom-effect-wrapper rounded-5"><img class="zoom-effect-img" src="${entity.image2}" alt="Instagram image"></div></a></div>
                  <div class="col-7"><a class="d-block card-hover zoom-effect" href="#">
                    <div class="d-flex justify-content-center align-items-center position-absolute top-0 start-0 w-100 h-100 rounded-5 overflow-hidden zindex-2 opacity-0"><i class="ai-instagram lead text-white position-relative zindex-2"></i>
                      <div class="position-absolute top-0 start-0 w-100 h-100 bg-black opacity-20"></div>
                    </div>
                    <div class="zoom-effect-wrapper rounded-5"><img class="zoom-effect-img" src="${entity.image3}" alt="Instagram image"></div></a></div>
                  <div class="col-7"><a class="d-block card-hover zoom-effect" href="#">
                    <div class="d-flex justify-content-center align-items-center position-absolute top-0 start-0 w-100 h-100 rounded-5 overflow-hidden zindex-2 opacity-0"><i class="ai-instagram lead text-white position-relative zindex-2"></i>
                      <div class="position-absolute top-0 start-0 w-100 h-100 bg-black opacity-20"></div>
                    </div>
                    <div class="zoom-effect-wrapper rounded-5"><img class="zoom-effect-img" src="${entity.image1}" alt="Instagram image"></div></a></div>
                  <div class="col-5"><a class="d-block card-hover zoom-effect" href="#">
                    <div class="d-flex justify-content-center align-items-center position-absolute top-0 start-0 w-100 h-100 rounded-5 overflow-hidden zindex-2 opacity-0"><i class="ai-instagram lead text-white position-relative zindex-2"></i>
                      <div class="position-absolute top-0 start-0 w-100 h-100 bg-black opacity-20"></div>
                    </div>
                    <div class="zoom-effect-wrapper rounded-5"><img class="zoom-effect-img" src="${entity.image2}" alt="Instagram image"></div></a></div>
                </div>
              </div>

            </div>
          </div>
        </section>
        </c:if>
        <h2 class="h4 mb-lg-4 pt-3 pt-md-4 pt-xl-5">Notes</h2>
        <p class="fs-lg">${entity.specialNote}</p>
        <c:if test="${not empty entity.youtubeUrl}">
        <section class="container pt-5 mt-lg-3 mt-xl-4 mt-xxl-5">
          <div class="row text-center text-md-start pb-3 pt-1 pt-sm-3 pt-md-4 pt-xl-5 mt-lg-2 mt-xl-0 mb-3 mb-lg-4">
            <div class="col-md-6">
              <h2 class="h1 mb-md-0">View in video reels</h2>
            </div>
            <div class="col-md-6 pt-2">
              <p class="mb-0">View the video created for this establishment, curated from YouTube.</p>
            </div>
          </div>
          <div class="rounded-5 overflow-hidden">
            <div class="jarallax ratio ratio-16x9 d-flex align-items-center justify-content-center" data-jarallax="" data-speed="0.6">

              <div class="w-auto position-relative p-4"><a class="btn btn-icon btn-xl btn-primary rounded-circle stretched-link" href="https://www.youtube.com/watch?v=${entity.youtubeUrl}" data-bs-toggle="video" data-lg-id="a4cd7a6d-23f6-4a66-8e64-f2561d96490f"><i class="ai-play-filled"></i></a></div>
              <div id="jarallax-container-1" style="position: absolute; top: 0px; left: 0px; width: 100%; height: 100%; overflow: hidden; z-index: -100; clip-path: polygon(0px 0px, 100% 0px, 100% 100%, 0px 100%);"><div class="jarallax-img" style="background-image: url(&quot;${entity.image1}&quot;); object-fit: cover; object-position: 50%; max-width: none; position: absolute; top: 0px; left: 0px; width: 1296px; height: 564.2px; overflow: hidden; pointer-events: none; transform-style: preserve-3d; backface-visibility: hidden; margin-top: -123.60000000000002px; transform: translate3d(0px, -178.2125px, 0px);" data-jarallax-original-styles="background-image: url(assets/img/landing/coworking-space/parallax-image.jpg);"></div></div></div>
          </div>
        </section>
        </c:if>
        <c:if test="${entity.category eq 'hospital'}">
          <h1 class="pb-3 pb-lg-4">Doctors of ${entity.title}</h1>
          <!-- Post-->
          <c:forEach var="doctor" items="${entity.doctors}">
            <!-- Horizontal card: Image on the left card border-0 bg-secondary rounded-4 position-relative mb-3-->
            <div class="card overflow-hidden border-0 bg-secondary rounded-4 position-relative mb-3">
              <div class="row g-0">
                <div class="col-sm-12">
                  <c:set var="turl" value="#" />
                  <div class="card-body">
                    <h4 class="card-title"> ${doctor.name} </h4>
                    <div class="d-flex align-items-center me-3 fs-lg text-uppercase"><i class="ai-clipboard me-1"></i>${doctor.qualification}</div>

                    <h2 class="fs-base fw-normal text-muted mb-2 mb-sm-3 text-capitalize">Speciality : <a href="/${doctor.specialityShortCode}-doctors--sultan-bathery"> ${doctor.specialityShortCode}</a></h2>

                  </div>
                </div>
              </div>
            </div>
        </c:forEach>
        </c:if>
        <!-- Tags-->
        <div class="d-flex flex-wrap pb-5 pt-3 pt-md-4 pt-xl-5 mt-xl-n2">
          <h3 class="h6 py-1 mb-0 me-4">Relevant tags:</h3>
          <c:forTokens items="${entity.tags}" delims="," var="tag" varStatus="inx">
            <a class="nav-link fs-sm py-1 px-0 me-3" href="/tag-${fn:trim(tag)}--sb"><span class="text-primary">#</span> ${tag}</a>
          </c:forTokens>
          <a class="nav-link fs-sm py-1 px-0 me-3" href="${categoryDto.get(entity.category).url}-in--sulthan-bathery">
            <span class="text-primary">#</span>${entity.category}</a>
          <c:if test="${not empty entity.subCategory}">
            <a class="nav-link fs-sm py-1 px-0 me-3" href="/sc-${entity.subCategory}--sb">
              <span class="text-primary">#</span>${entity.subCategory}</a>
          </c:if>
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
  <!-- Related articles (carousel) -->
  <section class="container py-5 mt-sm-2 my-md-4 my-xl-5">
    <div class="d-flex align-items-center pb-3 mb-3 mb-lg-4 mt-2 mt-xxl-3">
      <h2 class="h1 mb-0 me-4">Related Business Profiles</h2>
      <div class="d-flex ms-auto">
        <button class="btn btn-prev btn-icon btn-sm btn-outline-primary rounded-circle me-3" type="button" id="prev-post"><i class="ai-arrow-left"></i></button>
        <button class="btn btn-next btn-icon btn-sm btn-outline-primary rounded-circle" type="button" id="next-post"><i class="ai-arrow-right"></i></button>
      </div>
    </div>
    <div class="swiper pb-2 pb-sm-3 pb-md-4" data-swiper-options="
      {
        &quot;spaceBetween&quot;: 24,
        &quot;loop&quot;: true,
        &quot;autoHeight&quot;: true,
        &quot;navigation&quot;: {
          &quot;prevEl&quot;: &quot;#prev-post&quot;,
          &quot;nextEl&quot;: &quot;#next-post&quot;
        },
        &quot;breakpoints&quot;: {
          &quot;576&quot;: { &quot;slidesPerView&quot;: 2 },
          &quot;1000&quot;: { &quot;slidesPerView&quot;: 3 }
        }
      }
    ">
      <div class="swiper-wrapper">
        <c:forEach var="ent" items="${relEntities}">
          <!-- Post-->
          <article class="swiper-slide">
            <div class="position-relative"><img class="rounded-5" src="${ent.image1}" alt="Post image">
              <h3 class="h4 mt-4 mb-0"><a class="stretched-link" href="${ent.uniqueSEOId}--sb">${ent.title}</a></h3>
            </div>
          </article>
        </c:forEach>
      </div>
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

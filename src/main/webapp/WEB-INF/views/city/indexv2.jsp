<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="author" content="smashplus">
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
    <style>
        .page-loading {
            position: fixed;
            top: 0;
            right: 0;
            bottom: 0;
            left: 0;
            width: 100%;
            height: 100%;
            -webkit-transition: all .4s .2s ease-in-out;
            transition: all .4s .2s ease-in-out;
            background-color: #fff;
            opacity: 0;
            visibility: hidden;
            z-index: 9999;
        }
        .dark-mode .page-loading {
            background-color: #121519;
        }
        .page-loading.active {
            opacity: 1;
            visibility: visible;
        }
        .page-loading-inner {
            position: absolute;
            top: 50%;
            left: 0;
            width: 100%;
            text-align: center;
            -webkit-transform: translateY(-50%);
            transform: translateY(-50%);
            -webkit-transition: opacity .2s ease-in-out;
            transition: opacity .2s ease-in-out;
            opacity: 0;
        }
        .page-loading.active > .page-loading-inner {
            opacity: 1;
        }
        .page-loading-inner > span {
            display: block;
            font-family: 'Inter', sans-serif;
            font-size: 1rem;
            font-weight: normal;
            color: #6f788b;
        }
        .dark-mode .page-loading-inner > span {
            color: #fff;
            opacity: .6;
        }
        .page-spinner {
            display: inline-block;
            width: 2.75rem;
            height: 2.75rem;
            margin-bottom: .75rem;
            vertical-align: text-bottom;
            background-color: #d7dde2;
            border-radius: 50%;
            opacity: 0;
            -webkit-animation: spinner .75s linear infinite;
            animation: spinner .75s linear infinite;
        }
        .dark-mode .page-spinner {
            background-color: rgba(255,255,255,.25);
        }
        @-webkit-keyframes spinner {
            0% {
                -webkit-transform: scale(0);
                transform: scale(0);
            }
            50% {
                opacity: 1;
                -webkit-transform: none;
                transform: none;
            }
        }
        @keyframes spinner {
            0% {
                -webkit-transform: scale(0);
                transform: scale(0);
            }
            50% {
                opacity: 1;
                -webkit-transform: none;
                transform: none;
            }
        }

    </style>
    <!-- Page loading scripts-->
<%--    <script>
        (function () {
            window.onload = function () {
                const preloader = document.querySelector('.page-loading');
                preloader.classList.remove('active');
                setTimeout(function () {
                    preloader.remove();
                }, 1500);
            };
        })();

    </script>--%>
    <!-- Import Google Font-->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&amp;display=swap" rel="stylesheet" id="google-font">
    <!-- Vendor styles-->
    <link rel="stylesheet" media="screen" href="/css/vendor/swiper/swiper-bundle.min.css"/>
    <c:import url="/WEB-INF/views/common/head-4a.jsp">
        <c:param name="title" value="${cityObject.cityName}" />
        <c:param name="desc" value="${cityObject.cityName} - ${cityObject.teaser}" />
        <c:param name="kw" value="${cityObject.cityName} - ${cityObject.teaser}" />
    </c:import>
</head>
<!-- Body-->
<body>
<%--<!-- Page loading spinner-->
<div class="page-loading active">
    <div class="page-loading-inner">
        <div class="page-spinner"></div><span>Loading...</span>
    </div>
</div>--%>
<!-- Page wrapper-->
<main class="page-wrapper">
    <!-- Navbar. Remove 'fixed-top' class to make the navigation bar scrollable with the page-->
   <c:import url="../common/header-4a.jsp"/>
    <!-- Page content-->
    <!-- Hero slider-->
    <section class="ignore-dark-mode position-relative min-vh-100 py-5">
        <!-- Background image slider-->
        <div class="swiper swiper-scale-effect position-absolute top-0 start-0 w-100 h-100" data-swiper-options="{
      &quot;effect&quot;: &quot;fade&quot;,
      &quot;speed&quot;: 800,
      &quot;autoplay&quot;: {
        &quot;delay&quot;: 7000,
        &quot;disableOnInteraction&quot;: false
      },
      &quot;pagination&quot;: {
        &quot;el&quot;: &quot;.swiper-pagination&quot;,
        &quot;clickable&quot;: true
      }
    }">
            <div class="swiper-wrapper">
                <div class="swiper-slide">
                    <div class="swiper-slide-cover bg-position-top-center" style="background-image: url(https://res.cloudinary.com/dw8him6rb/image/upload/v1730616919/sulthan-bathery/sby-image1.jpg);"></div>
                </div>
                <div class="swiper-slide">
                    <div class="swiper-slide-cover bg-position-top-center" style="background-image: url(https://res.cloudinary.com/dw8him6rb/image/upload/v1665039140/city-explorer/textiles.jpg);"></div>
                </div>
                <div class="swiper-slide">
                    <div class="swiper-slide-cover bg-position-top-center" style="background-image: url(https://res.cloudinary.com/dw8him6rb/image/upload/v1665039690/city-explorer/hospital.jpg);"></div>
                </div>
            </div>
            <div class="swiper-pagination mb-4"></div>
        </div>
        <!-- Content-->
        <div class="container position-relative zindex-2 py-lg-3 py-xl-5 my-5">
            <div class="row pt-md-3 py-xxl-5 my-5">
                <div class="col py-5 mb-md-4 mb-lg-5">
                    <h1 class="display-2  mb-4">${cityObject.cityName}</h1>
                    <p class="d-block fs-xl pb-2 mb-4 mb-md-5" style="max-width: 500px;">${cityObject.teaser} Clean & Happiest City. Adapted at a high level to the needs of the modern pace of life.</p>
                    <div class="position-relative d-inline-flex align-items-center"><a class="btn btn-icon btn-lg btn-primary rounded-circle stretched-link" href="https://www.youtube.com/watch?v=sr6vKYAJcE4" data-bs-toggle="video"><i class="ai-play-filled"></i></a><span class="fs-lg fw-semibold ms-3">Watch Video</span></div>
                </div>
            </div>
        </div>
    </section>
    <!-- Latest News-->

    <!-- Latest posts -->
    <section class="container py-5 my-md-2 my-lg-3 my-xl-4 my-xxl-5">
        <h2 class="h1 pb-3 py-md-4">Latest posts</h2>
        <div class="row pb-md-4 pb-lg-5">

            <!-- Featured article -->
            <div class="col-lg-6 pb-2 pb-lg-0 mb-4 mb-lg-0">
                <article class="card h-100 border-0 position-relative overflow-hidden bg-size-cover bg-position-center me-lg-4" style="background-image: url(${news.get(0).image});">
                    <div class="bg-dark position-absolute top-0 start-0 w-100 h-100 opacity-60"></div>
                    <div class="card-body d-flex flex-column position-relative z-2 mt-sm-5">
                        <h3 class="pt-5 mt-4 mt-sm-5 mt-lg-auto">
                            <a class="stretched-link text-light" href="${news.get(0).customURL}">${news.get(0).title}</a>
                        </h3>
                        <p class="card-text text-light opacity-70">${news.get(0).teaser}</p>
                        <div class="d-flex align-items-center">
                            <span class="fs-sm text-light opacity-50">9 hours ago</span>
                            <span class="fs-xs text-light opacity-30 mx-3">|</span>
                            <a class="badge text-ligh fs-xs border border-light" href="#">${news.get(0).labels}</a>
                        </div>
                    </div>
                </article>
            </div>

            <!-- Other articles -->
            <div class="col-lg-6">
                <div class="row row-cols-1 row-cols-sm-2 g-4">


                    <!-- Article -->
                    <c:forEach var="news" items="${news}" begin="1" end="4">
                    <article class="col py-1 py-xl-2">
                        <div class="border-bottom pb-4 ms-xl-3">
                            <h3 class="h4">
                                <a href="blog-single-v3.html">${news.title}</a>
                            </h3>
                            <p>${news.teaser}</p>
                            <div class="d-flex align-items-center">
                                <a class="badge text-nav fs-xs border" href="#">${news.labels}</a>
                            </div>
                        </div>
                    </article>
                    </c:forEach>

                </div>
            </div>
        </div>
    </section>

    <!-- Editor's picks (Carousel on screens < 992px)-->
    <section class="container pb-1 mb-1 mb-lg-2 pt-3">
        <h2 class="h1 pb-3 pb-lg-4">Editor's Picks</h2>
        <div class="swiper" data-swiper-options="
      {
        &quot;spaceBetween&quot;: 24,
        &quot;pagination&quot;: {
          &quot;el&quot;: &quot;.swiper-pagination&quot;,
          &quot;clickable&quot;: true
        },
        &quot;breakpoints&quot;: {
          &quot;576&quot;: { &quot;slidesPerView&quot;: 2 },
          &quot;992&quot;: { &quot;slidesPerView&quot;: 3 }
        }
      }
    ">
            <div class="swiper-wrapper">
                <c:forEach items="${editorsPicks}" var="establishment">
                    <c:set value="/${establishment.uniqueSEOId}--sb" var="destUrl"/>
                    <!-- Item-->
                    <article class="swiper-slide h-auto">
                        <div class="card border-0 bg-secondary">
                            <div class="card-body pb-4">
                                <div class="d-flex align-items-center mb-4 mt-n1"><span class="fs-sm text-muted">
                                    <a class="badge text-nav fs-xs border" href="${categoryDto.get(establishment.category).url}-in--sultan-bathery">${categoryDto.get(establishment.category).categoryTitle}</a></span>
                                        <%--<span class="fs-xs opacity-20 mx-3">|</span><a class="badge text-nav fs-xs border" href="#">Fashion</a>--%>
                                </div>
                                <h3 class="h4 card-title"><a href="${destUrl}">${establishment.title}</a></h3>
                                <p class="card-text">${establishment.teaser}</p>

                                <div class="d-flex flex-wrap align-items-center pt-1 mt-n2"><a class="nav-link text-muted fs-sm fw-normal p-0 mt-2 me-3" href="#">${establishment.likes}<i class="ai-like fs-lg ms-1" href="#"></i></a>
                                    <%--<span class="fs-xs opacity-20 mt-2 mx-3">|</span><span class="fs-sm text-muted mt-2">3 days ago</span>
                                    <span class="fs-xs opacity-20 mt-2 mx-3">|</span><a class="badge bg-faded-primary text-primary fs-xs mt-2" href="#">${establishment.tags}</a>--%>
                                    <a href="${destUrl}" class="btn btn-sm btn-primary">view</a>
                                </div>
                            </div>
                        </div>
                    </article>
                </c:forEach>
            </div>
            <!-- Pagination (bullets)-->
            <div class="swiper-pagination position-relative bottom-0 mt-2 pt-4 d-lg-none"></div>
        </div>
        <!-- Read more button-->
        <div class="text-center" style="margin: 0; padding: 0;">
            <a class="btn btn-primary" href="/all-establishments--sb" style="margin-top: 5px; margin-bottom: 0; padding: 10px 20px;">View all</a>
        </div>
    </section>
    <!-- Classes (Tabs)-->
    <section class="container pt-2 mt-lg-3 mt-xl-4 mt-xxl-5">
        <h2 class="h1 text-center pt-2 pt-sm-3">At your services</h2>
        <p class="text-center pb-3 mb-3 mb-lg-4">Whether you are looking for services or products, these establishments can help you</p>
        <!-- Nav tabs-->
        <ul class="nav nav-tabs flex-nowrap overflow-auto text-nowrap w-100 mx-auto pb-3 mb-3 mb-lg-4" role="tablist" style="max-width: 892px;">
            <c:forEach items="${keys}" var="type" varStatus="ind">
                <c:set var="ty" value="other"/>
                <c:if test="${not empty type}"><c:set var="ty" value="${categoryDto.get(type).categoryTitle}"/></c:if>
                <li class="nav-item mb-0"><a class="nav-link <c:if test="${ind.count eq 1}">active</c:if> " href="#${type}" data-bs-toggle="tab" role="tab"><span class="text-uppercase">${ty}</span> </a></li>
            </c:forEach>
        </ul>
        <!-- Tab content-->
        <div class="tab-content">
            <!-- tab item-->
            <c:forEach items="${keys}" var="type" varStatus="indx">
                    <div class="tab-pane fade show <c:if test="${indx.count eq 1}">active</c:if>" id="${type}" role="tabpanel">
                        <div class="row align-items-lg-center">
                            <div class="col-md-6 pb-4 pb-md-0 mb-2 mb-md-0"><img class="rounded-5" src="${categoryDto.get(type).image}" alt="Hospitals"></div>
                            <div class="col-md-6 col-lg-5 col-xl-4 offset-lg-1">
                                <div class="ps-md-4 ps-lg-0">
                                    <h2 class="mb-xl-4 text-uppercase">${categoryDto.get(type).categoryTitle}</h2>
                                    <p class="pb-3 mb-3 mb-xl-4">${categoryDto.get(type).teaser}</p>
                                    <div class="row row-cols-2 g-4 pb-2 pb-xl-0 mb-4 mb-xl-5">
                                        <c:forEach items="${estabGroup.get(type)}" var="org" varStatus="indEnt" begin="0" end="3">
                                            <div class="col"><i class="ai-map-pin d-block h2 text-primary fw-normal pb-2 mb-1"></i>
                                                <c:set value="/${org.url}--sb" var="destUrl"/>
                                                <h3 class="h6 mb-2"><a href="${destUrl}"> ${org.estName}</a></h3>
                                                <p class="fs-sm mb-0">${org.teaser}</p>
                                            </div>
                                        </c:forEach>
                                    </div><a class="btn btn-primary w-100 w-sm-auto" href="${categoryDto.get(type).url}-in--sultan-bathery">View all</a>
                                </div>
                            </div>
                        </div>
                    </div>
            </c:forEach>
        </div>
    </section>

     <!-- Popular articles (Carousel)-->
    <section class="bg-secondary py-5">
        <div class="container d-flex align-items-center pt-lg-2 pt-xl-4 pt-xxl-5 pb-3 mt-1 mt-sm-3 mb-3 my-md-4">
            <h2 class="h1 mb-0">Most popular List</h2>
            <div class="d-flex ms-auto">
                <button class="btn btn-sm btn-icon btn-outline-primary rounded-circle ms-3" type="button" id="prev-popular"><i class="ai-arrow-left"></i></button>
                <button class="btn btn-sm btn-icon btn-outline-primary rounded-circle ms-3" type="button" id="next-popular"><i class="ai-arrow-right"></i></button>
            </div>
        </div>
        <!-- Swiper slider-->
        <div class="container-start">
            <div class="swiper" data-swiper-options="{
        &quot;slidesPerView&quot;: 1,
        &quot;spaceBetween&quot;: 24,
        &quot;loop&quot;: true,
        &quot;navigation&quot;: {
          &quot;prevEl&quot;: &quot;#prev-popular&quot;,
          &quot;nextEl&quot;: &quot;#next-popular&quot;
        },
        &quot;breakpoints&quot;: {
          &quot;576&quot;: {
            &quot;slidesPerView&quot;: &quot;auto&quot;
          }
        }
      }">
                <div class="swiper-wrapper">
                    <c:forEach items="${establishmentsAll}" var="establishment">
                        <!-- Item-->
                        <article class="swiper-slide w-sm-auto h-auto">
                            <div class="card h-100 border-0 mx-auto" style="max-width: 416px;">
                                <a href="/${establishment.uniqueSEOId}--sb">
                                    <img class="card-img-top" src="${establishment.image1}" alt="${establishment.title}">
                                </a>
                                    <div class="card-body pb-4">
                                        <div class="d-flex align-items-center mb-4 mt-n1">
                                            <c:set value="${establishment.category}" var="type"/>
                                            <%--<span class="fs-sm text-muted">${establishment.category}</span>
                                            <span class="fs-xs opacity-20 mx-3">|</span>--%>
                                            <a class="badge text-nav fs-xs border" href="${categoryDto.get(type).url}-in--sultan-bathery">${categoryDto.get(type).categoryTitle}</a></div>
                                        <h3 class="h4 card-title">
                                            <a href="/${establishment.uniqueSEOId}--sb">${establishment.title}</a>
                                        </h3>
                                        <p class="card-text">${establishment.teaser}</p>
                                    </div>

                            </div>
                        </article>
                    </c:forEach>

                </div>
            </div>
        </div>
        <!-- All articles button-->
        <div class="container text-center pt-4 pb-1 pb-sm-3 pb-md-4 py-lg-5 mb-xl-1 mb-xxl-4 mt-2 mt-lg-0"><a class="btn btn-primary mb-1" href="/all-establishments--sb">View All</a></div>
    </section>

</main>

<!-- Footer-->
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

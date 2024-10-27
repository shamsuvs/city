<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <c:set var="url" value="https://www.smashplus.com/${blgid}/post/${pid}/${ptitle}"/>
    <c:set var="description" value="${post.title} | smashplus blog post"/>

    <c:import url="/WEB-INF/views/common/head.jsp">
        <c:param name="title" value=" ${post.title}" />
        <c:param name="desc" value="${description}" />
    </c:import>

    <meta property="og:url"           content="${url}" />
    <meta property="og:type"          content="article" />
    <meta property="og:title"         content="${post.title}" />
    <meta property="og:description"   content="${post.title}" />
    <meta property="og:image"   content="${post.images[0].url}" />
    <meta property="og:image:secure_url"   content="${post.images[0].url}" />
    <meta property="og:image:width" content="450"/>
    <meta property="og:image:height" content="300"/>

    <meta name="twitter:card" content="summary"/>
    <meta name="twitter:site" content="@shamsudeen"/>
    <meta name="twitter:creator" content="@shamsudeen"/>
    <meta name="twitter:title" content="${post.title}"/>
    <meta name="twitter:description" content="${description}"/>
    <meta name="twitter:image" content="${post.images[0].url}"/>

    <c:import url="/WEB-INF/views/common/googlead/autoad.jsp"/>
</head>
<!-- Body-->
<body class="is-sidebar">
<main class="page-wrapper">
    <!-- Navbar (Solid background + shadow)-->
    <!-- Remove "navbar-sticky" class to make navigation bar scrollable with the page.-->
    <c:import url="/WEB-INF/views/common/header-4a.jsp"/>
    <!-- Page content-->
    <!-- Container-->
    <section class="container pt-5 mt-5">
        <!-- Breadcrumb-->
        <nav aria-label="breadcrumb">
            <ol class="pt-lg-3 pb-lg-4 pb-2 breadcrumb">
                <li class="breadcrumb-item"><a href="index.html">Home</a></li>
                <li class="breadcrumb-item"><a href="blog-list-sidebar.html">Blog</a></li>
                <li class="breadcrumb-item active" aria-current="page">Single post v.3</li>
            </ol>
        </nav>
        <div class="row">
            <div class="col-lg-9 col-xl-8 pe-lg-4 pe-xl-0">
                <!-- Post title + post meta-->
                <h1 class="pb-2 pb-lg-3">${story.title}</h1>
                <div class="d-flex flex-wrap align-items-center justify-content-between border-bottom mb-4">
                    <div class="d-flex align-items-center mb-4 me-4"><span class="fs-sm me-2">By:</span><a class="nav-link position-relative fw-semibold p-0" href="#author" data-scroll data-scroll-offset="80">Darlene Robertson<span class="d-block position-absolute start-0 bottom-0 w-100" style="background-color: currentColor; height: 1px;"></span></a></div>
                    <div class="d-flex align-items-center mb-4"><span class="fs-sm me-2">Share post:</span>
                        <div class="d-flex"><a class="nav-link p-2 me-2" href="#" data-bs-toggle="tooltip" data-bs-placement="top" title="Instagram"><i class="ai-instagram"></i></a><a class="nav-link p-2 me-2" href="#" data-bs-toggle="tooltip" data-bs-placement="top" title="Facebook"><i class="ai-facebook"></i></a><a class="nav-link p-2 me-2" href="#" data-bs-toggle="tooltip" data-bs-placement="top" title="Telegram"><i class="ai-telegram fs-sm"></i></a><a class="nav-link p-2" href="#" data-bs-toggle="tooltip" data-bs-placement="top" title="Twitter"><i class="ai-twitter"></i></a></div>
                    </div>
                </div>
                <!-- Post content-->
                <figure class="figure"><img class="figure-img rounded-5 mb-3" src="/img/blog/single/image.jpg" alt="Image">
                    <figcaption class="figure-caption">Image source tristique justo et pharetra</figcaption>
                </figure>
                <c:forEach items="${storyParts}" var="st" varStatus="ind">
                    <p>${st}</p>
                </c:forEach>
                <!-- Tags-->
                <div class="d-flex flex-wrap pb-5 pt-3 pt-md-4 pt-xl-5 mt-xl-n2">
                    <h3 class="h6 py-1 mb-0 me-4">Relevant tags:</h3><a class="nav-link fs-sm py-1 px-0 me-3" href="#"><span class="text-primary">#</span>Inspiration</a><a class="nav-link fs-sm py-1 px-0 me-3" href="#"><span class="text-primary">#</span>Travel</a><a class="nav-link fs-sm py-1 px-0 me-3" href="#"><span class="text-primary">#</span>Books</a>
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
                        <!-- Popular posts-->
                        <h4 class="pt-1 pt-lg-0 mt-lg-n2">Most popular:</h4>
                        <div class="mb-lg-5 mb-4">
                            <article class="position-relative pb-2 mb-3 mb-lg-4"><img class="rounded-5" src="/img/blog/list/01.jpg" alt="Post image">
                                <h5 class="h6 mt-3 mb-0"><a class="stretched-link" href="blog-single-v1.html">The fashion for eco bags with vintage prints will still be relevant for more than one year</a></h5>
                            </article>
                            <article class="position-relative"><img class="rounded-5" src="/img/blog/list/06.jpg" alt="Post image">
                                <h5 class="h6 mt-3 mb-0"><a class="stretched-link" href="blog-single-v2.html">A session with a psychologist as a personal choice or a fashion trend</a></h5>
                            </article>
                        </div>
                        <!-- Recent posts-->
                        <h4 class="pt-3 pt-lg-1 mb-4">Recent posts:</h4>
                        <ul class="list-unstyled mb-lg-5 mb-4">
                            <li class="border-bottom pb-3 mb-3"><span class="h6 mb-0"><a href="blog-single-v1.html">Instagram trends that will definitely work and bring results in the new 2022</a></span></li>
                            <li class="border-bottom pb-3 mb-3"><span class="h6 mb-0"><a href="blog-single-v2.html">A session with a psychologist as a personal choice </a></span></li>
                            <li class="border-bottom pb-3 mb-3"><span class="h6 mb-0"><a href="blog-single-v1.html">Travel destinations to inspire and restore resources</a></span></li>
                            <li class="border-bottom pb-3"><span class="h6 mb-0"><a href="blog-single-v2.html">How to look for inspiration for new goals in life?</a></span></li>
                        </ul>
                        <!-- Relevant topics-->
                        <h4 class="pt-3 pt-lg-1 mb-4">Relevant topics:</h4>
                        <div class="d-flex flex-wrap mt-n3 ms-n3 mb-lg-5 mb-4 pb-3 pb-lg-0"><a class="btn btn-outline-secondary rounded-pill mt-3 ms-3" href="#">Reading</a><a class="btn btn-outline-secondary rounded-pill mt-3 ms-3" href="#">Inspiration</a><a class="btn btn-outline-secondary rounded-pill mt-3 ms-3" href="#">Travel</a><a class="btn btn-outline-secondary rounded-pill mt-3 ms-3" href="#">Psychology</a></div>
                    </div>
                </div>
            </aside>
        </div>
    </section>
    <!-- Related articles (carousel) -->
    <section class="container py-5 mt-sm-2 my-md-4 my-xl-5">
        <div class="d-flex align-items-center pb-3 mb-3 mb-lg-4 mt-2 mt-xxl-3">
            <h2 class="h1 mb-0 me-4">Related articles</h2>
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
                <!-- Post-->
                <article class="swiper-slide">
                    <div class="position-relative"><img class="rounded-5" src="/img/blog/list/01.jpg" alt="Post image">
                        <h3 class="h4 mt-4 mb-0"><a class="stretched-link" href="blog-single-v1.html">The fashion for eco bags with vintage prints will still be relevant for more than one year</a></h3>
                    </div>
                </article>
                <!-- Post-->
                <article class="swiper-slide">
                    <div class="position-relative"><img class="rounded-5" src="/img/blog/list/04.jpg" alt="Post image">
                        <h3 class="h4 mt-4 mb-0"><a class="stretched-link" href="blog-single-v3.html">How to look for inspiration for new goals in life and remember to give yourself a break?</a></h3>
                    </div>
                </article>
                <!-- Post-->
                <article class="swiper-slide">
                    <div class="position-relative"><img class="rounded-5" src="/img/blog/list/06.jpg" alt="Post image">
                        <h3 class="h4 mt-4 mb-0"><a class="stretched-link" href="blog-single-v1.html">A session with a psychologist as a personal choice or a fashion trend in society</a></h3>
                    </div>
                </article>
                <!-- Post-->
                <article class="swiper-slide">
                    <div class="position-relative"><img class="rounded-5" src="/img/blog/list/05.jpg" alt="Post image">
                        <h3 class="h4 mt-4 mb-0"><a class="stretched-link" href="blog-single-v3.html">Top 10 best TV shows on Netflix for your next weekend</a></h3>
                    </div>
                </article>
            </div>
        </div>
    </section>
    <!-- Sidebar toggle button-->
    <button class="d-lg-none btn btn-sm fs-sm btn-primary w-100 rounded-0 fixed-bottom" data-bs-toggle="offcanvas" data-bs-target="#sidebar"><i class="ai-layout-column me-2"></i>Sidebar</button>

</main>
<!-- Footer-->
<footer class="footer pt-lg-5 pt-4 pb-5">
    <div class="container">
        <div class="row gy-md-5 gy-4 mb-md-5 mb-4 pb-lg-2">
            <div class="col-lg-3"><a class="navbar-brand d-inline-flex align-items-center mb-lg-4 mb-3" href="index.html"><span class="text-primary flex-shrink-0 me-2">
                <svg version="1.1" width="35" height="32" viewBox="0 0 36 33" xmlns="http://www.w3.org/2000/svg">
                  <path fill="currentColor" d="M35.6,29c-1.1,3.4-5.4,4.4-7.9,1.9c-2.3-2.2-6.1-3.7-9.4-3.7c-3.1,0-7.5,1.8-10,4.1c-2.2,2-5.8,1.5-7.3-1.1c-1-1.8-1.2-4.1,0-6.2l0.6-1.1l0,0c0.6-0.7,4.4-5.2,12.5-5.7c0.5,1.8,2,3.1,3.9,3.1c2.2,0,4.1-1.9,4.1-4.2s-1.8-4.2-4.1-4.2c-2,0-3.6,1.4-4,3.3H7.7c-0.8,0-1.3-0.9-0.9-1.6l5.6-9.8c2.5-4.5,8.8-4.5,11.3,0L35.1,24C36,25.7,36.1,27.5,35.6,29z"></path>
                </svg></span><span class="text-nav">Around</span></a>
                <p class="mb-4 pb-lg-3 fs-xs text-muted" style="max-width: 306px;">Morbi et massa fames ac scelerisque sit commodo dignissim faucibus vel quisque proin lectus laoreet sem adipiscing sollicitudin erat massa tellus lorem enim aenean phasellus in hendrerit</p>
                <div class="mt-n3 ms-n3"><a class="btn btn-secondary btn-icon btn-sm btn-instagram rounded-circle mt-3 ms-3" href="#"><i class="ai-instagram"></i></a><a class="btn btn-secondary btn-icon btn-sm btn-facebook rounded-circle mt-3 ms-3" href="#"><i class="ai-facebook"></i></a><a class="btn btn-secondary btn-icon btn-sm btn-linkedin rounded-circle mt-3 ms-3" href="#"><i class="ai-linkedin"></i></a></div>
            </div>
            <div class="col-xl-8 offset-xl-1 col-lg-9">
                <div class="row row-cols-sm-4 row-cols-1">
                    <div class="col">
                        <ul class="nav flex-column mb-0">
                            <li class="nav-item mb-2"><a class="nav-link p-0" href="#">Relevant Blogs</a></li>
                            <li class="nav-item mb-2"><a class="nav-link p-0" href="#">Top Author</a></li>
                            <li class="nav-item mb-2"><a class="nav-link p-0" href="#">Latest News</a></li>
                        </ul>
                    </div>
                    <div class="col">
                        <ul class="nav flex-column mb-0">
                            <li class="nav-item mb-2"><a class="nav-link p-0" href="#">Business</a></li>
                            <li class="nav-item mb-2"><a class="nav-link p-0" href="#">Marketing</a></li>
                            <li class="nav-item mb-2"><a class="nav-link p-0" href="#">Design</a></li>
                            <li class="nav-item mb-2"><a class="nav-link p-0" href="#">Psychology</a></li>
                            <li class="nav-item mb-2"><a class="nav-link p-0" href="#">Books</a></li>
                            <li class="nav-item mb-2"><a class="nav-link p-0" href="#">Inspiration</a></li>
                        </ul>
                    </div>
                    <div class="col">
                        <ul class="nav flex-column mb-0">
                            <li class="nav-item mb-2"><a class="nav-link p-0" href="#">Analytics</a></li>
                            <li class="nav-item mb-2"><a class="nav-link p-0" href="#">Ecommerce</a></li>
                            <li class="nav-item mb-2"><a class="nav-link p-0" href="#">Brand strategy</a></li>
                            <li class="nav-item mb-2"><a class="nav-link p-0" href="#">Travels</a></li>
                        </ul>
                    </div>
                    <div class="col">
                        <ul class="nav flex-column mb-0">
                            <li class="nav-item mb-2"><a class="nav-link p-0 text-primary" href="#">example@gmail.com</a></li>
                            <li class="nav-item mb-2"><a class="nav-link p-0" href="#">Privacy policy</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="fs-sm text-muted">&copy; All rights reserved. Made by <a href='https://createx.studio/' target='_blank' rel='noopener' class='text-dark text-decoration-none opacity-90'>Createx Studio</a></div>
        <div class="pt-4 pt-lg-0"></div>
    </div>
</footer>
<!-- Back to top button--><a class="btn-scroll-top" href="#top" data-scroll>
    <svg viewBox="0 0 40 40" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
        <circle cx="20" cy="20" r="19" fill="none" stroke="currentColor" stroke-width="1.5" stroke-miterlimit="10"></circle>
    </svg><i class="ai-arrow-up"></i></a>
<!-- Vendor scripts: js libraries and plugins-->
<script src="/js/vendor/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
<script src="/js/vendor/smooth-scroll/dist/smooth-scroll.polyfills.min.js"></script>
<script src="/js/vendor/swiper/swiper-bundle.min.js"></script>
<!-- Main theme script-->
<script src="/js/theme.min.js"></script>
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <c:import url="/WEB-INF/views/common/head.jsp">
        <c:param name="title" value="All traffic Signs Home Page | smashplus"></c:param>
        <c:param name="desc" value="Traffic Signs Home page for Dubai, Abu Dhabi, Qatar and Kuwait"></c:param>
    </c:import>
</head>
<body class="is-sidebar">
<main class="page-wrapper">
    <c:import url="/WEB-INF/views/common/header-4a.jsp"/>
    <!--container start-->
    <div class="sidebar-enabled sidebar-end">
        <div class="container">
            <div class="row">
                <div class="col-lg-9 content py-4 mb-2 mb-sm-0 pb-sm-5">
                    <!--banner-->
                    <div class="pb-sm-4 py-3">
                        <div id="ad-lb" class="ad-wrapper">
                            <!-- banner -->
                            <c:import url="/WEB-INF/views/common/banner2.jsp"/>
                        </div>
                    </div>
                    <nav aria-label="breadcrumb">
                        <ol class="py-1 my-2 breadcrumb">
                            <li class="breadcrumb-item"><a href="/">Home</a></li>
                            <li class="breadcrumb-item active">Slaitz Home
                            </li>
                        </ol>
                    </nav>
                    <!-- Blog grid-->
                    <div class="masonry-grid overflow-hidden" data-columns="3">
                        <!-- Post-->
                        <div class="masonry-grid-item">
                            <c:set var="snipUrl" value="/slaitz/phonics"></c:set>
                            <article class="card card-hover"><a class="card-img-top" href="${snipUrl}">
                                <img src="/img/blog/single/03.jpg" alt="Dubai Driving Theory Tests" title="Dubai Driving Theory Tests"></a>
                                <div class="card-body"><a class="meta-link fs-sm mb-2" href="${snipUrl}">Phonics</a>
                                    <h2 class="h5 nav-heading mb-4"><a href="${snipUrl}">Phonics</a></h2>
                                </div>
                            </article>
                        </div>

                        <!-- Post-->
                        <div class="masonry-grid-item">
                            <c:set var="snipUrl" value="/slaitz/sentences"></c:set>
                            <article class="card card-hover"><a class="card-img-top" href="${snipUrl}">
                                <img src="/img/blog/single/03.jpg" alt="Dubai Driving Theory Tests" title="Dubai Driving Theory Tests"></a>
                                <div class="card-body"><a class="meta-link fs-sm mb-2" href="${snipUrl}">Small Sentences</a>
                                    <h2 class="h5 nav-heading mb-4"><a href="${snipUrl}">Sentences</a></h2>
                                </div>
                            </article>
                        </div>

                        <!-- Post-->
                        <div class="masonry-grid-item">
                            <c:set var="snipUrl" value="/slaitz/cat-object"></c:set>
                            <article class="card card-hover"><a class="card-img-top" href="${snipUrl}">
                                <img src="/img/blog/single/03.jpg" alt="Dubai Driving Theory Tests" title="Dubai Driving Theory Tests"></a>
                                <div class="card-body"><a class="meta-link fs-sm mb-2" href="${snipUrl}">All Objects</a>
                                    <h2 class="h5 nav-heading mb-4"><a href="${snipUrl}">Objects</a></h2>
                                </div>
                            </article>
                        </div>
                        <!-- Post-->
                        <div class="masonry-grid-item">
                            <c:set var="snipUrl" value="/slaitz/stories"></c:set>
                            <article class="card card-hover"><a class="card-img-top" href="${snipUrl}">
                                <img src="/img/blog/single/03.jpg" alt="Dubai Driving Theory Tests" title="Dubai Driving Theory Tests"></a>
                                <div class="card-body"><a class="meta-link fs-sm mb-2" href="${snipUrl}">All Stories</a>
                                    <h2 class="h5 nav-heading mb-4"><a href="${snipUrl}">All Stories</a></h2>
                                </div>
                            </article>
                        </div><!-- Post-->
                        <div class="masonry-grid-item">
                            <c:set var="snipUrl" value="/slaitz/phonics/sight-words"></c:set>
                            <article class="card card-hover"><a class="card-img-top" href="${snipUrl}">
                                <img src="/img/blog/single/03.jpg" alt="Dubai Driving Theory Tests" title="Dubai Driving Theory Tests"></a>
                                <div class="card-body"><a class="meta-link fs-sm mb-2" href="${snipUrl}">All Sight Words</a>
                                    <h2 class="h5 nav-heading mb-4"><a href="${snipUrl}">All Sight Words</a></h2>
                                </div>
                            </article>
                        </div><!-- Post-->
                        <div class="masonry-grid-item">
                            <c:set var="snipUrl" value="/slaitz/phonics/fun-to-read"></c:set>
                            <article class="card card-hover"><a class="card-img-top" href="${snipUrl}">
                                <img src="/img/blog/single/03.jpg" alt="Dubai Driving Theory Tests" title="Dubai Driving Theory Tests"></a>
                                <div class="card-body"><a class="meta-link fs-sm mb-2" href="${snipUrl}">All Fun to Read</a>
                                    <h2 class="h5 nav-heading mb-4"><a href="${snipUrl}">All Fun to Read</a></h2>
                                </div>
                            </article>
                        </div>
                    </div>

                </div>
                <div class="sidebar col-lg-3 pt-lg-5">
                    <div class="offcanvas offcanvas-end offcanvas-collapse" id="blog-sidebar">
                        <div class="offcanvas-header navbar-shadow px-4 mb-3">
                            <h5 class="mt-1 mb-0">Sidebar</h5>
                            <button class="btn-close lead" type="button" data-bs-dismiss="offcanvas" aria-label="Close"></button>
                        </div>
                        <div class="offcanvas-body px-4 pt-3 pt-lg-0 pe-lg-0 ps-lg-2 ps-xl-4" data-simplebar>
                            <!-- Search-->
                            <div class="widget mb-5">
                                <h3 class="widget-title">Search This Site</h3>
                                <div class="search-row">
                                    <script async src="https://cse.google.com/cse.js?cx=72867606a2c10e585"></script>
                                    <div class="gcse-search"></div>

                                </div>
                                <%--<div class="input-group"><i class="ai-search position-absolute top-50 start-0 translate-middle-y ms-3"></i>
                                    <input class="form-control rounded" type="text" placeholder="Search">--%>
                            </div>
                        </div>
                        <!-- Side ad 1-->
                        <c:import url="/WEB-INF/views/common/sky1.jsp"/>


                    </div>
                </div>
            </div>
        </div>
    </div>

</main>
<!--container end-->

<!--footer start-->
<c:import url="/WEB-INF/views/common/footer-min.jsp">
    <c:param name="type" value="bg-dark"/>
</c:import>
<script src="/js/vendor/bootstrap/bootstrap.bundle.min.js">
</script>
<script src="/js/vendor/smooth-scroll/smooth-scroll.polyfills.min.js"></script>
<script src="/js/vendor/imagesloaded/imagesloaded.pkgd.min.js"></script>
<script src="/js/vendor/shufflejs/dist/shuffle.min.js"></script>
<!-- Main theme script-->
<script src="/js/theme.min.js"></script>
</body>
</html>

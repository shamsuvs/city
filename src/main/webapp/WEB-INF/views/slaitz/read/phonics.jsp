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
    <c:import url="../../common/header-4a.jsp"/>
    <!-- Page content-->
    <div class="sidebar-enabled sidebar-end">
        <div class="container">
            <div class="row">
                <!-- Content-->
                <div class="col-lg-9 content py-4 mb-2 mb-sm-0 pb-sm-5">
                    <!--banner-->
                    <div class="pb-sm-4 py-3">
                        <div id="ad-lb" class="ad-wrapper">
                            <c:import url="../../common/banner2.jsp"/>
                        </div>
                    </div>
                    <div class="pb-1" style="max-width: 38rem;">
                        <nav aria-label="breadcrumb">
                            <ol class="py-1 my-2 breadcrumb">
                                <li class="breadcrumb-item"><a href="/">Home</a></li>
                                <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/slaitz/">Slaitz</a>
                                </li>
                                <li class="breadcrumb-item active" aria-current="page">Phonics</li>
                            </ol>
                        </nav>
                        <h1>Phonics</h1>

                    </div>


                   <!-- Portfolio-->
                    <section class="overflow-hidden" id="portfolio">
                        <div class="container py-lg-7 py-md-6 py-5 my-2 my-md-0">
                            <h2 class="mb-3 text-center">List of Words</h2>
                            <p class="mb-4 pb-md-2 text-muted text-center">Most recent projects I have completed</p>
                            <div class="masonry-filterable">
                                <!-- Portfolio nav (Filters)-->
                                <nav class="pb-3 mb-4" data-simplebar data-simplebar-auto-hide="false">
                                    <ul class="masonry-filters nav nav-tabs justify-content-sm-center flex-nowrap text-nowrap mb-0">
                                        <li class="nav-item"><a class="nav-link active" href="#" data-group="all">All</a></li>
                                        <li class="nav-item"><a class="nav-link" href="#" data-group="Aa">Aa - Bb</a></li>
                                        <li class="nav-item"><a class="nav-link" href="#" data-group="Cc">Cc - Dd</a></li>
                                        <li class="nav-item"><a class="nav-link" href="#" data-group="Ee">Ee - Ii</a></li>
                                        <li class="nav-item"><a class="nav-link" href="#" data-group="branding">Jj - Mm</a></li><!--Next Page refresh-->
                                    </ul>
                                </nav>
                                <!-- Portfolio grid-->
                                <div class="masonry-grid" data-columns="3">
                                    <c:forEach items="${phonics}" var="phonicsObj">
                                        <c:set var="grp" value="Aa"></c:set>
                                    <!-- Portfolio item-->
                                        <c:if test="${phonicsObj.subCategory eq 'Aa' or phonicsObj.subCategory eq 'Bb'}">
                                            <c:set var="grp" value="Aa"></c:set>
                                        </c:if>
                                        <c:if test="${phonicsObj.subCategory eq 'Cc' or phonicsObj.subCategory eq 'Dd'}">
                                            <c:set var="grp" value="Cc"></c:set>
                                        </c:if>
                                        <c:if test="${phonicsObj.subCategory eq 'Ee' or phonicsObj.subCategory eq 'Ff'}">
                                            <c:set var="grp" value="Ee"></c:set>
                                        </c:if>
                                    <article class="masonry-grid-item" data-groups="[&quot;${grp}&quot;]"><a class="card card-hover h-100 border-0 shadow" href="/slaitz/${phonicsObj.word}-object">
                                        <span class="badge badge-floating badge-pill bg-danger">${phonicsObj.subCategory}</span>
                                        <img class="card-img-top" src="${phonicsObj.image}" alt="Article image" onerror="this.onerror=null; this.src='/img/demo/business-consulting/industries/011.jpg'">
                                        <div class="card-body text-center">
                                            <h3 class="h3 mb-1">${phonicsObj.word}</h3><span class="fs-sm text-muted">${grp}</span>
                                        </div></a></article>
                                    </c:forEach>

                                </div>
                            </div>
                            <div class="pt-3 text-center"><a class="btn btn-primary" href="#"><i class="ai-refresh-cw me-2"></i>Load more</a></div>
                        </div>
                    </section>
                </div>
                <!-- Sidebar-->
                <div class="sidebar col-lg-3 pt-lg-5">
                    <div class="offcanvas offcanvas-end offcanvas-collapse" id="blog-sidebar">
                        <div class="offcanvas-header navbar-shadow px-4 mb-3">
                            <h5 class="mt-1 mb-0">Sidebar</h5>
                            <button class="btn-close lead" type="button" data-bs-dismiss="offcanvas" aria-label="Close"></button>
                        </div>
                        <div class="offcanvas-body px-4 pt-3 pt-lg-0 pe-lg-0 ps-lg-2 ps-xl-4" data-simplebar>
                            <!-- Search-->
                            <div class="widget mb-5">
                                <h3 class="widget-title">Search</h3>
                                <c:import url="/WEB-INF/views/common/googlead/search-ad-ref.jsp"/>
                            </div>
                            <c:import url="/WEB-INF/views/common/trending.jsp"/>
                            <!-- Side ad 1-->
                            <c:import url="/WEB-INF/views/common/sky1.jsp"/>

                            <!-- Tag cloud-->
                            <div class="widget mb-5">
                                <h3 class="widget-title pb-1">Article Tags</h3>
                                <c:forEach items="${post.labels}" var="tag">
                                    <c:choose><c:when test="${tag eq 'driving' or tag eq 'driving-license' or tag eq 'uaenews' or tag eq 'innovations' }">
                                        <a href="${pageContext.request.contextPath}/${indexurl}/${tag}">
                                            <a class="btn-tag me-2 mb-2" href="${pageContext.request.contextPath}/${indexurl}/${tag}">#${tag}</a>
                                        </a>
                                    </c:when>
                                        <c:otherwise>
                                            <a href="${pageContext.request.contextPath}/${indexurl}/${tag}">
                                                <a class="btn-tag me-2 mb-2" href="${pageContext.request.contextPath}/${indexurl}/${tag}">#${tag}</a>
                                            </a>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>

                            </div>
                            <!-- Side ad 2-->
                            <c:import url="/WEB-INF/views/common/rectangle1.jsp"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>
<c:import url="../../common/footer-min.jsp">
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
<script src="/js/vendor/imagesloaded/imagesloaded.pkgd.min.js"></script>
<script src="/js/vendor/shufflejs/dist/shuffle.min.js"></script>
<script src="/js/vendor/lightgallery.js/dist/js/lightgallery.min.js"></script>
<script src="/js/vendor/lg-fullscreen.js/dist/lg-fullscreen.min.js"></script>
<script src="/js/vendor/lg-zoom.js/dist/lg-zoom.min.js"></script>
<script src="/js/vendor/lg-video.js/dist/lg-video.min.js"></script>

<!-- Main theme script-->
<script src="/js/theme.js"></script>

<script src="https://cdn.jsdelivr.net/npm/marked/marked.min.js"></script>
<script>
</script>
</body>
</html>

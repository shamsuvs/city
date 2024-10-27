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
                                <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/${indexurl}/">Tag</a>
                                </li>
                                <li class="breadcrumb-item active" aria-current="page">Post</li>
                            </ol>
                        </nav>
                        <h1>Sentences</h1>

                    </div>

                    <section class="bg-secondary mt-1 mt-md-1 mt-lg-1">
                        <div class="container py-5 py-md-6 py-lg-7">
                            <div class="row tns-carousel-wrapper py-3 py-md-0">
                                <div class="col-md-8">
                                    <div class="tns-carousel-inner" data-carousel-options="{&quot;nav&quot;: false, &quot;gutter&quot;: 20}">
                                        <c:forEach items="${sentences}" var="sentence">
                                            <h1 class="pb-2 mb-4 text-center text-md-start"><span class="fw-light">${sentence.article} ${sentence.entityName} ${sentence.preposition}</span> ${sentence.targetEntityArticle} ${sentence.targetEntityName}</h1>
                                            <%--<blockquote class="blockquote mt-3 mb-0">
                                                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Quis ipsum suspendisse ultrices gravida dignissimos ducimus qui blanditiis praesentium voluptatum.</p>
                                                <p>Mattis enim ut tellus elementum sagittis vitae et leo duis.</p>
                                                <footer class="d-flex align-items-center"><img class="rounded-circle" src="img/testimonials/01.jpg" alt="Emma Brown" width="42">
                                                    <div class="text-heading fs-md fw-medium ps-2 ms-1">Emma Brown</div>
                                                </footer>
                                            </blockquote>--%>
                                        </c:forEach>

                                    </div>
                                </div>
                                <div class="col-lg-3 col-md-4 offset-lg-1">
                                    <div class="tns-carousel-pager d-flex flex-wrap flex-md-column justify-content-center align-items-center align-items-md-start border-start pt-4 mt-4 ps-md-3 pt-md-0 mt-md-0">
                                        <c:forEach items="${sentences}" var="sentence" varStatus="ind">
                                            <a class="swap-image active mx-4 my-3 my-md-4" href="/slaitz/${sentence.entityName}-object" data-goto="${ind.count}">
                                                <img class="rounded-circle mb-2 mb-sm-0 swap-to" src="${sentence.entityImage}" alt="${sentence.entityName}" width="200">
                                                <h1 class="fs-4 text-muted mb-0">...</h1>
                                            </a>
                                        </c:forEach>

                                    </div>
                                </div>
                            </div>
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
                            <ul>

                                <li><a class="widget-link" href="/slaitz/ant-object">Objects</a></li>
                                <li><a class="widget-link" href="/slaitz/phonics">phonics</a></li>
                            </ul>
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

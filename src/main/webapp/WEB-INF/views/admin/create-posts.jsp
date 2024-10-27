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
    <c:import url="../common/header-4a.jsp"/>
    <!-- Page content-->
    <div class="sidebar-enabled sidebar-end">
        <div class="container">
            <div class="row">
                <!-- Content-->
                <div class="col-lg-9 content py-4 mb-2 mb-sm-0 pb-sm-5">
                    <!--banner-->
                    <div class="pb-sm-4 py-3">
                        <div id="ad-lb" class="ad-wrapper">
                            <c:import url="../common/banner2.jsp"/>
                        </div>
                    </div>
                    <div class="pb-4" style="max-width: 38rem;">
                        <nav aria-label="breadcrumb">
                            <ol class="py-1 my-2 breadcrumb">
                                <li class="breadcrumb-item"><a href="index.html">Home</a></li>
                                <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/${indexurl}/">Tag</a>
                                </li>
                                <li class="breadcrumb-item active" aria-current="page">Post</li>
                            </ol>
                        </nav>
                        <h1>List</h1>

                    </div>
                    <!-- Post author + Sharing-->
                    <div class="row position-relative g-0 align-items-center border-top border-bottom mb-4">
                        <div class="col-md-6 py-3 pe-md-3">
                            <div class="d-flex align-items-center justify-content-center justify-content-md-start">
                                <div class="d-flex align-items-center me-grid-gutter"><a class="d-block" href="#"><img class="rounded-circle me-1" src="/img/blog/avatar/06.jpg" alt="Emma Brown" width="64"></a>
                                    <div class="ps-2">
                                        <h6 class="nav-heading mb-1"><a href="#">admin</a></h6>
                                        <%--<div class="text-nowrap">
                                            <div class="meta-link fs-xs"><i class="ai-calendar me-1 align-vertical"></i>&nbsp;Feb 19</div>
                                            &lt;%&ndash;<span class="meta-divider"></span>
                                            <a class="meta-link fs-xs" href="#comments" data-scroll><i class="ai-message-square me-1 align-vertical"></i>&nbsp;3</a>&ndash;%&gt;
                                        </div>--%>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="d-none d-md-block position-absolute border-start h-100" style="top: 0; left: 50%; width: 1px;"></div>
                        <div class="col-md-6 ps-md-3 py-3">
                            <div class="d-flex align-items-center justify-content-center justify-content-md-end">
                                <h6 class="text-nowrap my-2 me-3">Share post:</h6>
                                <a class="btn-social bs-outline bs-facebook ms-2 my-2" href="#">
                                    <i class="ai-facebook"></i></a>
                                <a class="btn-social bs-outline bs-twitter ms-2 my-2" href="#">
                                    <i class="ai-twitter"></i></a>
                                <a class="btn-social bs-outline bs-email ms-2 my-2" href="#"><i class="ai-mail"></i></a>
                            </div>
                        </div>
                    </div>
                    <h4>Backend process running and fine</h4>
                    <!-- Post content-->
                    <%--<div id="content-body">${query.postBody}</div>
                    <h2>Solution in a Nutshell</h2>
                    <div id="content-answer">${query.curatedAnswer}</div>
                    <c:if test="${query.isVersionSpecAnswer eq 'Y'}">
                        <h3>Solution in ${query.version}</h3>
                        <div id="content-ver-answer">${query.versionRelatedAns}</div>
                    </c:if>--%>

                    <div class="pb-sm-4 py-3">
                        <div id="ad-lbs" class="ad-wrapper">
                            <c:import url="../common/googlead/in-article.jsp"/>
                        </div>
                    </div>

                    <!-- Prev / Next post navigation-->
                    <nav class="d-flex justify-content-between pb-4 mb-5" aria-label="Entry navigation">
                        <c:forEach var="post" items="${related}" begin="0" end="0">
                            <a class="entry-nav me-3" href="${post.url}">
                                <h3 class="h5 pb-sm-2">Prev post</h3>
                                <div class="d-flex align-items-start">

                                    <div class="entry-nav-thumb flex-shrink-0 d-none d-sm-block"><img class="rounded" src="${post.thumbImage}" alt="Post thumbnail"></div>
                                    <div class="ps-sm-3">
                                        <h4 class="nav-heading fs-md fw-medium mb-0">${post.title}</h4><span class="fs-xs text-muted">by sp</span>
                                    </div>

                                </div>
                            </a>
                        </c:forEach>

                      <%--  <c:forEach var="post" items="${related}" begin="1" end="1">
                            <a class="entry-nav ms-3" href="${post.url}">
                                <h3 class="h5 pb-sm-2 text-end">Next post</h3>
                                <div class="d-flex align-items-start">
                                    <div class="text-end pe-sm-3">
                                        <h4 class="nav-heading fs-md fw-medium mb-0">${post.title}</h4><span class="fs-xs text-muted">by sp</span>
                                    </div>
                                    <div class="entry-nav-thumb flex-shrink-0 d-none d-sm-block"><img class="rounded" src="${post.thumbImage}" alt="Post thumbnail"></div>
                                </div></a>
                        </c:forEach>--%>
                    </nav>
                    <c:import url="../common/googlead/matched-content.jsp"/>

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

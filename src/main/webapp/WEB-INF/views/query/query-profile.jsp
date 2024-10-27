<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <c:set var="title" value="${fn:replace(fn:toLowerCase(query.enhTitle),'?', '')}"/>

    <c:set var="url" value="https://www.smashvoid.com/${fn:replace(title,' ', '-')}-${query.postId}"/>
    <c:set var="description" value="${query.postTeaser} | insight"/>

    <c:import url="/WEB-INF/views/common/head.jsp">
        <c:param name="title" value=" ${query.enhTitle}" />
        <c:param name="desc" value="${description}" />
    </c:import>

    <meta property="og:url"           content="${url}" />
    <meta property="og:type"          content="website" />
    <meta property="og:title"         content="${query.enhTitle}" />
    <meta property="og:description"   content="${query.postTeaser}" />
    <meta property="og:image"   content="https://www.smashplus.com/img/blog/03.jpg" />
    <meta property="og:image:secure_url"   content="https://www.smashplus.com/img/blog/03.jpg" />
    <meta property="og:image:width" content="450"/>
    <meta property="og:image:height" content="300"/>
    <meta property="og:site_name" content="Smashvoid" />

    <meta name="twitter:card" content="summary"/>
    <meta name="twitter:site" content="@shamsudeen"/>
    <meta name="twitter:creator" content="@shamsudeen"/>
    <meta name="twitter:title" content="${query.enhTitle}"/>
    <meta name="twitter:description" content="${query.postTeaser}"/>
    <meta name="twitter:image" content="https://www.smashplus.com/img/blog/03.jpg"/>
    <c:import url="/WEB-INF/views/common/googlead/autoad.jsp"/>
</head>
<!-- Body-->
<body class="is-sidebar">
<div id="fb-root"></div>
<script async defer crossorigin="anonymous" src="https://connect.facebook.net/en_GB/sdk.js#xfbml=1&version=v14.0" nonce="h8nDR7bG"></script>
<main class="page-wrapper">

    <!-- Navbar (Solid background + shadow)-->
    <!-- Remove "navbar-sticky" class to make navigation bar scrollable with the page.-->
    <c:import url="../common/header-4a.jsp"/>
    <%--<section class="container py-sm-2 py-md-2 pb-2 mb-5" id="book">
        <div class="row mx-0 rounded-3 overflow-hidden" style="background-color: #f3f3f9;">
            <div class="col-lg-6" style="background-color: #f4f4f6;">
                <div class="d-flex align-items-start flex-sm-row flex-column py-lg-2 py-5 px-sm-5 px-4"><img class="me-sm-5 ms-sm-0 mx-auto mb-sm-0 mb-4" src="/img/demo/food-blog/book.png" alt="New recipes book">
                    <div class="align-self-center ps-2 text-sm-start text-center">
                        <h2 class="mb-4">E-Book to learn reading fastly</h2><a class="btn btn-primary" href="#"><i class="ai-download me-1"></i>Download now!</a>
                    </div>
                </div>
            </div>
            <div class="col-lg-6 d-flex align-items-center bg-faded-primary">
                <div class="w-100 py-lg-2 py-5 px-sm-5 px-4">
                    <h2 class="mb-2 text-center">Subscribe our newsletter</h2>
                    <h6 class="mb-4 pb-2 fw-normal text-center">Never miss a post!</h6>
                    <!-- Form subscribe-->
                    <form class="input-group mx-auto" style="max-width: 600px;">
                        <input class="form-control" type="email" placeholder="Enter your email" required>
                        <button class="btn btn-success" type="submit"><i class="ai-send fs-xl"></i></button>
                    </form>
                </div>
            </div>
        </div>
    </section>--%>
    <!-- Page content-->
    <div class="sidebar-enabled sidebar-end">
        <div class="container">
            <div class="row">
                <!-- Content-->
                <div class="col-lg-9 content py-4 mb-2 mb-sm-0 pb-sm-5">
                    <%--<!--banner-->
                    <div class="pb-sm-4 py-3">
                        <div id="ad-lb" class="ad-wrapper">
                            <c:import url="../common/banner2.jsp"/>
                        </div>
                    </div>--%>
                    <div class="pb-4" style="max-width: 38rem;">
                        <nav aria-label="breadcrumb">
                            <ol class="py-1 my-2 breadcrumb">
                                <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/">Home</a></li>
                                <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/questions/${query.category}">${query.category}</a>
                                </li>
                                <li class="breadcrumb-item active" aria-current="page">Post</li>
                            </ol>
                        </nav>
                        <h1 class="h2">${query.enhTitle}</h1>

                    </div>
                    <!-- Post author + Sharing-->
                    <div class="row position-relative g-0 align-items-center border-top border-bottom mb-4">
                        <div class="col-md-4 py-3 pe-md-3">
                            <div class="d-flex align-items-center justify-content-center justify-content-md-start">
                                <div class="d-flex align-items-center me-grid-gutter"><a class="d-block" href="#"><img class="rounded-circle me-1" src="/img/blog/avatar/06.jpg" alt="Emma Brown" width="64"></a>
                                    <div class="ps-2">
                                        <h6 class="nav-heading mb-1"><a href="#">admin</a></h6>

                                    </div>
                                </div>
                            </div>

                        </div>
                        <div class="col-md-4 ps-md-3 py-3">
                            <div class="d-flex align-items-center justify-content-center justify-content-md-end">
                                    <c:forEach var="tag" items="${query.tags}">
                                        <a class="btn-tag me-2 my-2" href="${pageContext.request.contextPath}/questions/${tag}">#${tag}</a>
                                        <%--<a class="btn-tag me-2 my-2" href="${pageContext.request.contextPath}/questions/${query.secondaryTag}">#${query.secondaryTag}</a>--%>
                                    </c:forEach>
                            </div>
                        </div>
                        <%--<div class="d-none d-md-block position-absolute border-start h-100" style="top: 0; left: 66%; width: 1px;"></div>--%>
                        <div class="col-md-4 ps-md-3 py-3">
                            <div class="d-flex align-items-center justify-content-center justify-content-md-end">
                                <h6 class="text-nowrap my-2 me-3">Share post:</h6>
                                <div class="fb-share-button" data-href="https://www.smashvoid.com" data-layout="button" data-size="large"><a target="_blank" href="https://www.facebook.com/sharer/sharer.php?u=https%3A%2F%2Fwww.smashvoid.com%2F&amp;src=sdkpreparse" class="fb-xfbml-parse-ignore">Share</a></div>
                                    <%--<a class="btn-social bs-outline bs-twitter ms-2 my-2" href="#">
                                        <i class="ai-twitter"></i></a>
                                        <a class="btn-social bs-outline bs-email ms-2 my-2" href="#"><i class="ai-mail"></i></a>--%>
                            </div>
                        </div>
                    </div>
                    <!-- Post content-->
                    <p class="callout d-block d-md-none d-lg-block fs-lg text-muted mb-grid-gutter">${query.postTeaser}</p>
                    <div id="content-body">${query.postBody}</div>
                    <!-- Rounded image -->
                    <c:if test="${not empty query.image}"> <img src="${query.image}" class="rounded-3 mb-4" alt="${query.enhTitle}" width="400" c></c:if>

                    <div class="d-flex flex-column bg-light rounded-3 shadow-lg p-4">
                        <h2 class="h3">Solution in a Nutshell</h2>
                        <h3 class="h5 mb-2">${query.curatedAnswerTitle}</h3>
                        <div id="content-answer">${query.curatedAnswer}</div>
                        <c:if test="${query.isVersionSpecAnswer eq 'Y'}">
                            <h3 class="h5 my-2 pe-sm-2 me-4">Solution in ${query.version}</h3>
                            <div id="content-ver-answer">${query.versionRelatedAns}</div>
                        </c:if>
                    </div>



                    <!-- Prev / Next post navigation-->
                    <%--<nav class="d-flex justify-content-between pb-4 mb-5" aria-label="Entry navigation">
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

                        &lt;%&ndash;<c:forEach var="post" items="${related}" begin="1" end="1">
                            <a class="entry-nav ms-3" href="${post.url}">
                            <h3 class="h5 pb-sm-2 text-end">Next post</h3>
                            <div class="d-flex align-items-start">
                                <div class="text-end pe-sm-3">
                                    <h4 class="nav-heading fs-md fw-medium mb-0">${post.title}</h4><span class="fs-xs text-muted">by sp</span>
                                </div>
                                <div class="entry-nav-thumb flex-shrink-0 d-none d-sm-block"><img class="rounded" src="${post.thumbImage}" alt="Post thumbnail"></div>
                            </div></a>
                        </c:forEach>&ndash;%&gt;
                    </nav>--%>

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
                            <c:import url="/WEB-INF/views/common/categories.jsp"/>
                            <c:import url="/WEB-INF/views/common/trending.jsp"/>
                            <%--<!-- Side ad 1-->
                            <c:import url="/WEB-INF/views/common/sky1.jsp"/>--%>

                            <!-- Tag cloud-->
                            <div class="widget mb-5">
                                <h3 class="widget-title pb-1">Tags</h3>

                                    <a class="btn-tag me-2 mb-2" href="${pageContext.request.contextPath}/questions/${query.primaryTag}">#${query.primaryTag}</a>

                                <%--<c:forEach items="${post.labels}" var="tag">
                                    <c:choose><c:when test="${tag eq 'driving' or tag eq 'driving-license' or tag eq 'uaenews' or tag eq 'innovations' }">

                                    </c:when>
                                        <c:otherwise>
                                            <a href="${pageContext.request.contextPath}/${indexurl}/${tag}">
                                                <a class="btn-tag me-2 mb-2" href="${pageContext.request.contextPath}/${indexurl}/${tag}">#${tag}</a>
                                            </a>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>--%>

                            </div>

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
<!-- Back to top button
<a class="btn-scroll-top" href="#top" data-scroll data-fixed-element><span class="btn-scroll-top-tooltip text-muted fs-sm me-2">Top</span><i class="btn-scroll-top-icon ai-arrow-up">   </i></a>-->
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

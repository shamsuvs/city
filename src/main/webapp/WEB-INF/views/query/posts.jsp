<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <c:set var="description" value="${tagref} - smashvoid articles"/>

    <c:import url="/WEB-INF/views/common/head.jsp">
        <c:param name="title" value="${tagref} articles" />
        <c:param name="desc" value="${description}" />
    </c:import>


    <c:import url="/WEB-INF/views/common/googlead/autoad.jsp"/>
<style>

    /* Now here we are just styling the background and centering it to the middle */



</style>
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

                    <div class="pb-4" style="max-width: 38rem;">
                        <nav aria-label="breadcrumb">
                            <ol class="py-1 my-2 breadcrumb">
                                <li class="breadcrumb-item"><a href="/">Home</a></li>
                                <li class="breadcrumb-item active" aria-current="page">${tagref} posts</li>
                            </ol>
                        </nav>
                        <h1>List</h1>

                    </div>
                    <!-- Split section featured-->
                    <section class="bg-secondary">
                        <div class="row g-0">
                            <div class="col-md-4" >
                                <div class="position-relative zindex-5 d-flex flex-column align-items-center justify-content-center h-100 px-3 py-4 py-lg-7">
                                    <img class="d-block mx-auto" src="/img/demo/software-landing/cta-illustration.svg" alt="Illustration"/>
                                </div>
                            </div>
                            <div class="col-md-8 px-3 pe-xl-0 ps-lg-5 ps-xl-6 py-2 py-lg-4">
                                <div class="ms-sm-4 py-5 my-sm-0 py-md-1 py-lg-1" style="max-width: 520px;">
                                    <h2 class="mb-4">Featured</h2>

                                        <c:forEach items="${posts}" var="post" begin="0" end="2">
                                            <c:set var="title" value="${fn:replace(fn:toLowerCase(post.enhTitle),'?', '')}"/>
                                            <div class="d-flex align-items-start pb-1 mb-3 mb-grid-gutter">
                                                <a class="d-block flex-shrink-0" href="${pageContext.request.contextPath}/${fn:replace(title,' ', '-')}-${post.postId}">
                                                    <img class="rounded" src="/img/blog/avatar/06.jpg" alt="Post" width="64">
                                                </a>
                                                <div class="ps-2 ms-1">
                                                    <h3 class="h5 nav-heading mb-1"> <a href="/${fn:replace(title,' ', '-')}-${post.postId}">${post.enhTitle}</a></h3>
                                                    <p class="fs-xs text-muted mb-0">${post.postTeaser}</p>
                                                </div>
                                            </div>
                                            <%--<div class="d-flex align-items-start mb-grid-gutter">
                                            <c:set var="title" value="${fn:replace(fn:toLowerCase(post.enhTitle),'?', '')}"/>
                                                <img class="d-block mt-1 rounded" src="/img/blog/avatar/06.jpg" alt="Icon" width="43">
                                                &lt;%&ndash;<div class="ps-2 ms-1">
                                                    <h4 class="fs-md nav-heading mb-1"><a class="fw-medium" href="${pageContext.request.contextPath}/${fn:replace(title,' ', '-')}-${post.postId}">
                                                            ${post.enhTitle}
                                                    </a></h4>
                                                    <p class="fs-xs text-muted mb-0">by smashvoid</p>
                                                </div>&ndash;%&gt;
                                                <div class="ps-2 ms-1">
                                                    <h3 class="h5 nav-heading mb-1"> <a href="/${fn:replace(title,' ', '-')}-${post.postId}">${post.enhTitle}</a></h3>
                                                    <p class="fs-xs text-muted mb-0">${post.postTeaser}</p>


                                                </div>
                                            </div>--%>
                                        </c:forEach>
                                    </div>

                            </div>
                        </div>
                    </section>

                    <%--<ul>
                        <c:forEach items="${posts}" var="post">

                    </ul>--%>
                    <!-- Post-->
                    <div class="pt-5">
                    <c:forEach items="${posts}" var="post" begin="3" end="${posts.size()}">
                        <c:set var="title" value="${fn:replace(fn:toLowerCase(post.enhTitle),'?', '')}"/>

                        <article class="card card-horizontal card-hover mb-grid-gutter"><a class="card-img-top" href="/${fn:replace(title,' ', '-')}-${post.postId}" style="background-image: url(/img/blog/01.jpg);"></a>
                            <div class="card-body"><a class="meta-link fs-sm mb-2" href="/questions/${tagref}">${tagref}</a>
                                <h2 class="h4 nav-heading mb-4"><a href="/${fn:replace(title,' ', '-')}-${post.postId}">${post.enhTitle}</a></h2>
                                <c:forEach var="tag" items="${post.tags}">
                                    <a class="meta-link fs-sm mb-2 btn-tag" href="/questions/${tag}">#${tag}</a>
                                </c:forEach>

                                <div class="mt-3 text-end text-nowrap"><a class="meta-link fs-xs" href="#"><i class="ai-message-square me-1"></i>&nbsp;6</a><span class="meta-divider"></span><a class="meta-link fs-xs" href="#"><i class="ai-calendar me-1 mt-n1"></i>&nbsp;Feb 19</a></div>
                            </div>
                        </article>
                    </c:forEach>
                    </div>
                    <%--<div class="pt-5">
                    <c:forEach items="${posts}" var="post">

                        <div class="pb-3">

                            <div class="card h-100 border-0 shadow mx-1">&lt;%&ndash;<span class="badge badge-lg badge-floating badge-floating-end bg-success">New</span>&ndash;%&gt;
                                <div class="card-body py-5 px-4">
                                    <div class="d-sm-flex py-sm-4 px-lg-3">
                                        <div class="text-sm-center mt-0 mt-sm-n3">
                                            <img class="d-block mt-1" src="/img/demo/business-consulting/industries/03.jpg" alt="Icon" width="43">
                                            &lt;%&ndash;<span class="d-sm-block text-primary me-2 me-sm-0 mb-n3" style="font-size: 3.75rem;">06</span>
                                            <span class="fs-xl text-muted text-uppercase">Aug</span>&ndash;%&gt;
                                        </div>
                                        <div class="ps-sm-4 ps-lg-5"><a class="meta-link fs-sm mb-2" href="#">${tagref}</a>
                                            <h3 class="h4 nav-heading mb-4"> <a href="/${fn:replace(title,' ', '-')}-${post.postId}">${post.enhTitle}</a></h3>
                                            <a class="meta-link fs-sm mb-2 btn-tag" href="#">#${tagref}</a>
                                            &lt;%&ndash;<a class="d-flex meta-link fs-sm align-items-center pt-2" href="#">
                                                <img class="rounded-circle" src="img/testimonials/02.jpg" alt="Sanomi Smith" width="42">
                                                <div class="ps-2 ms-1 mt-n1"><span class="fw-semibold ms-1"><a class="btn-tag me-2 my-2" href="#">#${tagref}</a></span></div></a>&ndash;%&gt;
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                    </div>--%>
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
                                            <h4 class="nav-heading fs-md fw-medium mb-0">${post.enhTitle}</h4><span class="fs-xs text-muted">by sp</span>
                                        </div>

                                </div>
                            </a>
                        </c:forEach>

                        <c:forEach var="post" items="${related}" begin="1" end="1">
                            <a class="entry-nav ms-3" href="${post.url}">
                            <h3 class="h5 pb-sm-2 text-end">Next post</h3>
                            <div class="d-flex align-items-start">
                                <div class="text-end pe-sm-3">
                                    <h4 class="nav-heading fs-md fw-medium mb-0">${post.enhTitle}</h4><span class="fs-xs text-muted">by sp</span>
                                </div>
                                <div class="entry-nav-thumb flex-shrink-0 d-none d-sm-block"><img class="rounded" src="${post.thumbImage}" alt="Post thumbnail"></div>
                            </div></a>
                        </c:forEach>
                    </nav>

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

                            <%--<!-- Tag cloud-->
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

                            </div>--%>
                            <!-- Side ad 2-->
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

<script src="https://cdn.jsdelivr.net/npm/marked/marked.min.js"></script>
<script>
</script>
</body>
</html>

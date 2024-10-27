<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <c:set var="description" value="${interview.teaser} | smashplus blog post"/>

    <c:import url="/WEB-INF/views/common/head.jsp">
        <c:param name="title" value=" ${interview.title}" />
        <c:param name="desc" value="${description}" />
    </c:import>

    <meta property="og:url"           content="${url}" />
    <meta property="og:type"          content="article" />
    <meta property="og:title"         content="${interview.title}" />
    <meta property="og:description"   content="${interview.teaser}" />
    <meta property="og:image"   content="${interview.image}" />
    <meta property="og:image:secure_url"   content="${interview.image}" />
    <meta property="og:image:width" content="450"/>
    <meta property="og:image:height" content="300"/>

    <meta name="twitter:card" content="summary"/>
    <meta name="twitter:site" content="@shamsudeen"/>
    <meta name="twitter:creator" content="@shamsudeen"/>
    <meta name="twitter:title" content="${interview.title}"/>
    <meta name="twitter:description" content="${description}"/>
    <meta name="twitter:image" content="${interview.image}"/>


    <tags:st-data-post title="${interview.title}" url="${url}" image="${interview.image}" content="${fn:escapeXml(interview.postDesc)}" tag="${interview.tags}" date="${interview.updateDate}"/>
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
                                <li class="breadcrumb-item"><a href="index.html">Home</a></li>
                                <li class="breadcrumb-item"><a href="/all-interview-series/">Interview Series</a>
                                </li>
                                <li class="breadcrumb-item active" aria-current="page">${interview.title}</li>
                            </ol>
                        </nav>
                        <h1>${interview.title}</h1>
                    </div>
                    <!-- Post author + Sharing-->
                    <div class="row position-relative g-0 align-items-center border-top border-bottom mb-4">
                        <div class="col-md-6 py-3 pe-md-3">
                            <div class="d-flex align-items-center justify-content-center justify-content-md-start">
                                <div class="d-flex align-items-center me-grid-gutter"><a class="d-block" href="#"><img class="rounded-circle me-1" src="img/blog/single/author.jpg" alt="Emma Brown" width="64"></a>
                                    <div class="ps-2">
                                        <h6 class="nav-heading mb-1"><a href="#">${interview.author}</a></h6>
                                        <div class="text-nowrap">
                                            <c:forTokens items="${interview.tags}" delims="," var="tag" varStatus="inx">
                                                <a class="btn-tag me-2 my-2" href="#">#${tag}</a>
                                            </c:forTokens>
                                           <%-- <div class="meta-link fs-xs"><i class="ai-calendar me-1 align-vertical"></i>&nbsp;Feb 19</div><span class="meta-divider"></span><a class="meta-link fs-xs" href="#comments" data-scroll><i class="ai-message-square me-1 align-vertical"></i>&nbsp;3</a>
                                       --%> </div>
                                    </div>
                                </div><a class="btn btn-translucent-primary btn-sm" href="https://twitter.com/shamsudeen" target="_blank">Follow</a>
                            </div>
                        </div>
                        <div class="d-none d-md-block position-absolute border-start h-100" style="top: 0; left: 50%; width: 1px;"></div>
                        <div class="col-md-6 ps-md-3 py-3">
                            <div class="d-flex align-items-center justify-content-center justify-content-md-end">
                               <%-- todo <h6 class="text-nowrap my-2 me-3">Share post:</h6><a class="btn-social bs-outline bs-facebook ms-2 my-2" href="#"><i class="ai-facebook"></i></a><a class="btn-social bs-outline bs-twitter ms-2 my-2" href="#"><i class="ai-twitter"></i></a><a class="btn-social bs-outline bs-google ms-2 my-2" href="#"><i class="ai-google"></i></a><a class="btn-social bs-outline bs-email ms-2 my-2" href="#"><i class="ai-mail"></i></a>
                            --%></div>
                        </div>
                    </div>
                    <!-- Post content-->
                    <p class="callout d-block d-md-none d-lg-block fs-lg text-muted mb-grid-gutter">${interview.teaser}</p>
                    <p class="py-3">${interview.postDesc}</p>

                    <c:forEach var="questionAry" items="${interview.intListingQtnMappingsById}" varStatus="ind">
                        <c:set var="question" value="${questionAry.interviewQuestionTblByQtnId}"/>
                        <h3>${question.question}</h3>
                        <p>${question.shortAnswer}</p>
                        <p>${question.answer}</p>
                        <p>Complexity: ${question.complexity}</p>

                    </c:forEach>

                    <c:if test="${not empty interview.youtubeUrl }">
                        <h5>Video Format</h5>
                        <iframe width="420" height="315"
                                                     src="https://www.youtube.com/embed/${interview.youtubeUrl}?autoplay=1" allow="autoplay"
                                                     allowfullscreen >
                        </iframe>
                    </c:if>

                   <!-- Tags + Sharing-->
                    <div class="row g-0 position-relative align-items-center border-top border-bottom my-5">
                        <div class="col-md-6 py-2 py-dm-3 pe-md-3 text-center text-md-start">
                            <c:forTokens items="${interview.tags}" delims="," var="tag" varStatus="inx">
                                <a class="btn-tag me-2 my-2" href="#">#${tag}</a>
                            </c:forTokens>
                        </div>
                        <div class="d-none d-md-block position-absolute border-start h-100" style="top: 0; left: 50%; width: 1px;"></div>
                        <div class="col-md-6 ps-md-3 py-2 py-md-3">
                        </div>
                    </div>

                    <!-- Related posts (carousel)todo-->
                   <%-- <c:if test="${not empty interview.related }">
                    <section class="bg-secondary py-3 py-md-6 py-lg-3 position-relative rounded-3">
                        <div class="container text-center pb-7">
                            <h2 class="mb-5">Related posts</h2>
                            <div class="tns-carousel-wrapper">
                                <div class="tns-carousel-inner" data-carousel-options="{&quot;items&quot;: 2, &quot;controls&quot;: false, &quot;autoHeight&quot;: true, &quot;responsive&quot;: {&quot;0&quot;:{&quot;items&quot;:1, &quot;gutter&quot;: 16},&quot;500&quot;:{&quot;items&quot;:2, &quot;gutter&quot;: 16},&quot;850&quot;:{&quot;items&quot;:3, &quot;gutter&quot;: 16}, &quot;1100&quot;:{&quot;items&quot;:3, &quot;gutter&quot;: 23}}}">
                                    <!-- Article-->
                                    <c:forEach var="rel" items="${interview.related}">
                                        <div class="pb-2">
                                            <article class="card card-hover mx-1">
                                                <div class="card-body">
                                                    <h2 class="h5 nav-heading mb-4"><a href="${rel.link}">${rel.linkText}</a></h2>
                                                    <a class="d-flex meta-link fs-sm align-items-center pt-3" href="${rel.link}">
                                                        <div class="ps-2 ms-1 mt-n1">by<span class="fw-semibold ms-1">Smashplus</span></div>
                                                    </a>
                                                </div>
                                            </article>
                                        </div>
                                    </c:forEach>

                                </div>
                            </div>
                        </div>
                    </section>

                    </c:if>--%>
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
                                <c:forTokens items="${interview.tags}" delims="," var="tag" varStatus="inx">
                                    <a class="btn-tag me-2 my-2" href="#">#${tag}</a>
                                </c:forTokens>

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
</body>
</html>

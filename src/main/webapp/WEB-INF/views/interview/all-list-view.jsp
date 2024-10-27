<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <c:import url="/WEB-INF/views/common/head.jsp">
        <c:param name="title" value="Mock Driving Theory Test | smashplus"></c:param>
        <c:param name="desc" value="We provide mock driving theory test to prepate for the driving licenses globally for the countries UAE, Qatar and Kuwait"></c:param>
        <c:param name="keyword" value="driving mocktest from smashplus, deepdive test"/>
    </c:import>
    <meta property="og:url"           content="https://www.smashplus.com/all-tests/driving" />
    <meta property="og:type"          content="website" />
    <meta property="og:title"         content="Mock Driving Theory Test | smashplus" />
    <meta property="og:description"   content="We provide mock driving theory test to prepate for the driving licenses globally for the countries UAE, Qatar and Kuwait" />
    <meta property="og:image"         content="https://dl.dropboxusercontent.com/s/hin7bvxwiaj4cwi/road.jpeg" />
</head>
<body class="is-sidebar">
<main class="page-wrapper">
    <c:import url="/WEB-INF/views/common/header-4a.jsp"/>
    <!--container start-->
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
                            <li class="breadcrumb-item active">All Courses
                            </li>
                        </ol>
                    </nav>
                    <h1 class="mb-5">
                       Interview Series
                        Available Right Now
                    </h1>
                    <p class="fs-sm">
                        Below are Interview Series, more to come soon, You can enroll now as per your choice!
                    </p>
                    <!-- Blog grid-->
                    <section class="container pt-5 mt-5 mt-md-0 pt-md-6 pt-lg-7">
                            <div class="row pb-1">
                                <!-- Post-->
                                <c:choose>
                                    <c:when test="${not empty interviewSeries}">
                                        <c:forEach var="interview" items="${interviewSeries}">
                                            <c:set var="titleurl" value="${fn:replace(tutor.title,' ', '_')}" />
                                            <c:set var="fullurl" value="/${fn:toLowerCase(interview.url)}-${interview.id}" />

                                            <div class="col-lg-3 col-md-4 col-sm-6 mb-grid-gutter">
                                                <div class="card card-product card-hover">
                                                    <c:if test="${not empty interview.image}">
                                                        <a class="card-img-top" href="${fullurl}">
                                                            <img src="${interview.image}" alt="Product thumbnail">
                                                        </a>
                                                    </c:if>
                                                    <div class="card-body"><a class="meta-link fs-xs mb-1" href="${fullurl}">${interview.teaser}</a>
                                                        <h3 class="fs-md fw-medium mb-2"><a class="meta-link" href="${fullurl}">${interview.title}</a></h3>
                                                    </div>
                                                    <div class="card-footer">
                                                        <div class="star-rating mt-n1"><i class="sr-star ai-star-filled active"></i><i class="sr-star ai-star-filled active"></i><i class="sr-star ai-star-filled active"></i><i class="sr-star ai-star-filled active"></i><i class="sr-star ai-star"></i>
                                                        </div>
                                                        <div class="d-flex align-items-center"><span class="btn-divider"></span><div class="fs-xs"> english</div></div>
                                                    </div>
                                                </div>
                                            </div>
                                        </c:forEach>

                                </c:when>
                                <c:otherwise>
                                    <h3>Not found. Please check later</h3>
                                </c:otherwise>
                                </c:choose>
                        </div>
                    </section>
                    <section class="container pt-md-4 mb-2 pb-5 pb-md-6 mb-md-0">
                        <h2 class="mb-5 text-center">More Links</h2>
                        <div class="row">
                            <div class="col-sm-6">
                                <ul class="list-unstyled">
                                    <li class="d-flex align-items-center border-bottom pb-3 mb-3"><i class="ai-book text-muted me-2"></i><a class="nav-link-style" href="/spring-boot-interview-questions-for-10-years-experience">spring boot interview questions for 10 years of experience</a></li>
                                    <li class="d-flex align-items-center border-bottom pb-3 mb-3"><i class="ai-book text-muted me-2"></i><a class="nav-link-style" href="#">What payment methods do you accept?</a></li>
                                    <li class="d-flex align-items-center border-bottom pb-3 mb-3"><i class="ai-book text-muted me-2"></i><a class="nav-link-style" href="#">Do you ship internationally?</a></li>
                                    <li class="d-flex align-items-center border-bottom pb-3 mb-3"><i class="ai-book text-muted me-2"></i><a class="nav-link-style" href="#">Do I need an account to place an order?</a></li>
                                    <li class="d-flex align-items-center border-bottom pb-3 mb-3"><i class="ai-book text-muted me-2"></i><a class="nav-link-style" href="#">How can I track my order?</a></li>
                                </ul>
                            </div>
                            <div class="col-sm-6">
                                <ul class="list-unstyled">
                                    <li class="d-flex align-items-center border-bottom pb-3 mb-3"><i class="ai-book text-muted me-2"></i><a class="nav-link-style" href="#">What are the product refund conditions?</a></li>
                                    <li class="d-flex align-items-center border-bottom pb-3 mb-3"><i class="ai-book text-muted me-2"></i><a class="nav-link-style" href="#">Do you have discounts for returning customers?</a></li>
                                    <li class="d-flex align-items-center border-bottom pb-3 mb-3"><i class="ai-book text-muted me-2"></i><a class="nav-link-style" href="#">How do your referral program work?</a></li>
                                    <li class="d-flex align-items-center border-bottom pb-3 mb-3"><i class="ai-book text-muted me-2"></i><a class="nav-link-style" href="#">Where I can view and download invoices for my orders?</a></li>
                                    <li class="d-flex align-items-center border-bottom pb-3 mb-3"><i class="ai-book text-muted me-2"></i><a class="nav-link-style" href="#">Do you provide technical support after the purchase?</a></li>
                                </ul>
                            </div>
                        </div>
                    </section>
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

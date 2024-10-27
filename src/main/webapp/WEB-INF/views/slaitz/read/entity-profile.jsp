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
    <!-- Book-->
    <section class="container py-sm-2 py-md-2 pb-2 mb-5" id="book">
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
    </section>

    <!-- Posts with sidebar right-->
    <section class="container pb-2 mb-2">
        <div class="row">
            <!-- Content-->
            <div class="col-lg-9">
                <!-- Post-->
                <article class="card card-horizontal card-hover mb-grid-gutter"><a class="card-img-top" href="#" style="background-image: url(${entity.image});"><span class="badge badge-lg badge-floating text-white" style="background-color: #f74f78;">${entity.subcategoryL1}</span></a>
                    <div class="card-body"><span class="d-inline-block mb-2 pb-1 fs-sm text-muted"><i class="ai-wind fs-base me-2 mt-n1"></i>${entity.category} — ${entity.subcategoryL1}</span>
                        <h2 class="h4 nav-heading text-capitalize mb-3"><a href="#">${entity.entityName}</a></h2>
                        <p class="mb-0 fs-sm text-muted">${entity.description}</p>
                        <div class="mt-3 text-end text-nowrap"><a class="meta-link fs-xs" href="#"><i class="ai-calendar me-1 mt-n1"></i>&nbsp;Oct 29</a><span class="meta-divider"></span><a class="meta-link fs-xs" href="#"><i class="ai-message-square me-1"></i>&nbsp;4</a></div>
                    </div>
                </article>
                <!-- Testimonials-->
                <section class="container pb-5 mb-md-4 pb-md-7">
                    <div class="row align-items-center">
                        <%--<div class="col-md-6 offset-lg-1 order-md-2"><img class="d-block mx-auto" src="${entity.image}" alt="Illustration"></div>--%>
                        <%--<div class="col-md-12 col-lg-5 order-md-1 pt-4 pt-md-0">--%>
                            <h2 class="mt-4 mb-5 text-center text-md-start">Sentences related to ${entity.entityGenName}</h2>
                            <div class="tns-carousel-wrapper">
                                <div class="tns-carousel-inner" data-carousel-options="{&quot;nav&quot;: false, &quot;gutter&quot;: 20}">
                                    <c:forEach begin="0" end="2" varStatus="ind">
                                    <ul class="list-group">
                                        <c:set var="iter" value="${ind.index*3}" />
                                        <c:forEach begin="${iter}" end="${iter+2}" items="${sentenceList}" var="sentence">
                                            <li class="list-group-item d-flex justify-content-between align-items-center">
                                                        <span>
                                                          <i class="ai-message-square text-muted me-2"></i>
                                                            <h1 class="pb-2 mb-4 text-center text-md-start">${sentence.autoPopulatedForObject}</h1>
                                                        </span>
                                                <span class="badge rounded-pill bg-info">${sentence.complexity}</span>
                                            </li>
                                        </c:forEach>

                                    </ul>
                                    </c:forEach>


                                </div>
                            </div>
                        <%--</div>--%>
                    </div>
                </section>


            </div>
            <!-- Sidebar-->
            <aside class="col-lg-3">
                <div class="offcanvas offcanvas-collapse offcanvas-end" id="blog-sidebar">
                    <div class="offcanvas-header navbar-shadow px-4 mb-3">
                        <h5 class="mt-1 mb-0">Sidebar</h5>
                        <button class="btn-close lead" type="button" data-bs-dismiss="offcanvas" aria-label="Close"></button>
                    </div>
                    <div class="offcanvas-body px-4 pt-3 pt-lg-0 pe-lg-0 ps-lg-2 ps-xl-4" data-simplebar>
                        <!-- Categories-->
                        <div class="widget widget-categories mb-5">
                            <h3 class="widget-title">Various types</h3>
                            <ul>
                                <c:forEach var="object" items="${objects}">
                                    <li><a class="widget-link" href="/slaitz/${object.entityGenName}-object">${object.entityName}</a></li>
                                </c:forEach>
                                <li><a class="widget-link" href="/slaitz/sentences">sentences</a></li>
                                <li><a class="widget-link" href="/slaitz/phonics">phonics</a></li>
                            </ul>
                        </div>
                        <!-- Featured posts-->
                        <div class="widget mt-n1 mb-5">
                            <h3 class="widget-title pb-1">Popular recipes</h3>
                            <div class="d-flex align-items-start pb-1 mb-3"><a class="d-block flex-shrink-0" href="#"><img class="rounded" src="/img/demo/food-blog/posts/th/01.jpg" alt="Post" width="64"></a>
                                <div class="ps-2 ms-1">
                                    <h4 class="fs-md nav-heading mb-1"><a class="fw-medium" href="#">Sweet Cream Cupcake</a></h4>
                                    <p class="fs-xs text-muted mb-0">by Amelie Mayer</p>
                                </div>
                            </div>
                            <div class="d-flex align-items-start pb-1 mb-3"><a class="d-block flex-shrink-0" href="#"><img class="rounded" src="/img/demo/food-blog/posts/th/02.jpg" alt="Post" width="64"></a>
                                <div class="ps-2 ms-1">
                                    <h4 class="fs-md nav-heading mb-1"><a class="fw-medium" href="#">Keto Paleo Carb-Free Breakfast</a></h4>
                                    <p class="fs-xs text-muted mb-0">by Amelie Mayer</p>
                                </div>
                            </div>
                            <div class="d-flex align-items-start pb-1 mb-3"><a class="d-block flex-shrink-0" href="#"><img class="rounded" src="/img/demo/food-blog/posts/th/03.jpg" alt="Post" width="64"></a>
                                <div class="ps-2 ms-1">
                                    <h4 class="fs-md nav-heading mb-1"><a class="fw-medium" href="#">Sugar-Free Coconut Yogurt with Mango</a></h4>
                                    <p class="fs-xs text-muted mb-0">by Amelie Mayer</p>
                                </div>
                            </div>
                        </div>
                        <!-- Tag cloud-->
                        <div class="widget mb-5">
                            <h3 class="widget-title pb-1">Popular tags</h3><a class="btn-tag me-2 mb-2" href="#">#bakery</a><a class="btn-tag me-2 mb-2" href="#">#cookbook</a><a class="btn-tag me-2 mb-2" href="#">#cuisine</a><a class="btn-tag me-2 mb-2" href="#">#asian food</a><a class="btn-tag me-2 mb-2" href="#">#tips</a><a class="btn-tag me-2 mb-2" href="#">#recipe</a><a class="btn-tag me-2 mb-2" href="#">#chef</a><a class="btn-tag me-2 mb-2" href="#">#vegetarian</a>
                        </div>

                    </div>
                </div>
            </aside>
        </div>
    </section>
    <!-- Categories-->
    <section class="container">
        <h2 class="h1 mb-4 pb-3 text-center">Popular categories</h2>
        <div class="pb-4" data-simplebar data-simplebar-auto-hide="false">
            <div class="d-flex justify-content-between">
                <c:forEach var="object" items="${objects}">
                    <a class="nav-link-style" href="/slaitz/${object.entityGenName}-object" style="min-width: 120px;">
                        <img class="d-block mx-auto mb-4" src="${object.image}" alt="Healthy" style="max-width: 150px;">
                        <p class="mb-0 text-center">${object.entityName}</p>
                    </a>
                </c:forEach>

            </div>
        </div>
    </section>
    <!-- Videos-->
    <section class="container py-5 mb-4 my-sm-0 py-sm-6 py-md-7">
        <h2 class="h1 text-center">New video recipes every Sunday</h2>
        <p class="mx-auto mb-5 text-muted text-center" style="max-width: 600px;">Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam eaque ipsa quae</p>
        <!-- Carousel-->
        <div class="tns-carousel-wrapper">
            <div class="tns-carousel-inner" data-carousel-options="{&quot;navAsThumbnails&quot;: true, &quot;controls&quot;: false, &quot;responsive&quot;: {&quot;0&quot;:{&quot;items&quot;:1, &quot;gutter&quot;: 16},&quot;768&quot;:{&quot;items&quot;:2, &quot;gutter&quot;: 30}}}">
                <!-- Carousel item-->
                <div>
                    <div class="gallery"><a class="gallery-item gallery-video rounded-3" href="https://www.youtube.com/watch?v=JzJsUW4xV7k&amp;ab_channel=HealthNutNutrition" data-sub-html="&lt;h6 class=&quot;fs-sm text-light&quot;&gt;Gallery video caption&lt;/h6&gt;"><img src="/img/demo/food-blog/videos/01.jpg" alt="Gallery thumbnail"><span class="gallery-caption">Gallery video caption</span></a></div>
                </div>
                <!-- Carousel item-->
                <div>
                    <div class="gallery"><a class="gallery-item gallery-video rounded-3" href="https://www.youtube.com/watch?v=JzJsUW4xV7k&amp;ab_channel=HealthNutNutrition" data-sub-html="&lt;h6 class=&quot;fs-sm text-light&quot;&gt;Gallery video caption&lt;/h6&gt;"><img src="/img/demo/food-blog/videos/02.jpg" alt="Gallery thumbnail"><span class="gallery-caption">Gallery video caption</span></a></div>
                </div>
                <!-- Carousel item-->
                <div>
                    <div class="gallery"><a class="gallery-item gallery-video rounded-3" href="https://www.youtube.com/watch?v=JzJsUW4xV7k&amp;ab_channel=HealthNutNutrition" data-sub-html="&lt;h6 class=&quot;fs-sm text-light&quot;&gt;Gallery video caption&lt;/h6&gt;"><img src="/img/demo/food-blog/videos/03.jpg" alt="Gallery thumbnail"><span class="gallery-caption">Gallery video caption</span></a></div>
                </div>
            </div>
        </div>
    </section>
    <!-- About-->
    <section class="container">
        <div class="row align-items-center">
            <div class="col-md-5 mb-md-0 mb-grid-gutter"><img class="rounded-3" src="/img/demo/food-blog/author.jpg" alt="Amelie"></div>
            <div class="col-lg-6 offset-lg-1 col-md-7">
                <h2 class="mb-2">Hi! I am Amelie</h2>
                <h3 class="h6 mb-3 text-muted">Amateur chef and creator of this blog</h3>
                <p class="mb-4 pb-2 text-muted">At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio.</p><a class="btn btn-primary" href="#">Get to know me better</a>
            </div>
        </div>
    </section>
    <!-- Instagram-->
    <section class="container-fluid py-5 my-4 my-sm-0 pt-sm-6 pt-md-7">
        <h2 class="mb-5 text-center">Follow <a href='#' class='d-inline-block p-2 bg-faded-primary rounded text-primary text-decoration-none'>@amelie_chef</a> on Instagram</h2>
        <!-- Carousel-->
        <div class="tns-carousel-wrapper">
            <div class="tns-carousel-inner" data-carousel-options="{&quot;navAsThumbnails&quot;: true, &quot;controls&quot;: false, &quot;responsive&quot;: {&quot;0&quot;:{&quot;items&quot;:2, &quot;gutter&quot;: 15}, &quot;576&quot;:{&quot;items&quot;:3}, &quot;768&quot;:{&quot;items&quot;:4, &quot;gutter&quot;: 30}, &quot;992&quot;:{&quot;items&quot;:5}, &quot;1200&quot;:{&quot;items&quot;:6}}}">
                <!-- Carousel item-->
                <div><img src="/img/demo/food-blog/instagram/01.jpg" alt="01"></div>
                <!-- Carousel item-->
                <div><img src="/img/demo/food-blog/instagram/02.jpg" alt="02"></div>
                <!-- Carousel item-->
                <div><img src="/img/demo/food-blog/instagram/03.jpg" alt="03"></div>
                <!-- Carousel item-->
                <div><img src="/img/demo/food-blog/instagram/04.jpg" alt="04"></div>
                <!-- Carousel item-->
                <div><img src="/img/demo/food-blog/instagram/05.jpg" alt="05"></div>
                <!-- Carousel item-->
                <div><img src="/img/demo/food-blog/instagram/06.jpg" alt="06"></div>
            </div>
        </div>
    </section>
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

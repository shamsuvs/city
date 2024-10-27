<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<header class="default-header header-scrolled">
    <nav class="navbar navbar-expand-lg  navbar-light">
        <div class="container">
            <a class="navbar-brand" href="index.html">
                <img src="/resources/img/sp2.JPG" alt="" width="220px">
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="lnr lnr-menu"></span>
            </button>

            <div class="collapse navbar-collapse justify-content-end align-items-center" id="navbarSupportedContent">
                <ul class="navbar-nav">
                    <li><a href="/">Home</a></li>
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-close-others="false" data-delay="0" data-hover=
                                "dropdown" data-toggle="dropdown" href="#">Transportation
                        </a>

                        <div class="dropdown-menu">
                                <a class="dropdown-item" href="${pageContext.request.contextPath}/transportation/driving-license">Driving License Resources</a>
                                <a class="dropdown-item" href="${pageContext.request.contextPath}/transportation/driving">Refresh Drive</a>
                                <a class="dropdown-item" href="${pageContext.request.contextPath}/transportation/innovations">Innovations</a>
                                <a class="dropdown-item" href="${pageContext.request.contextPath}/transportation/uaenews">UAE News</a>
                        </div>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-close-others="false" data-delay="0" data-hover=
                                "dropdown" data-toggle="dropdown" href="#">Mock - Tests 
                        </a>

                        <div class="dropdown-menu">
                                <a class="dropdown-item" href="${pageContext.request.contextPath}/mock-exam/driving/index" tabindex="-1">Test Home</a>
                                <a class="dropdown-item" href="${pageContext.request.contextPath}/mock-exam/rta-theorytest/home" tabindex="-1">RTA Theory Tests</a>
                                <a class="dropdown-item" href="${pageContext.request.contextPath}/qatar-theory-test" tabindex="-1">Qatar Theory Test</a>
                                <a class="dropdown-item"  href="${pageContext.request.contextPath}/mock-exam/drv-parking/home" tabindex="-1">Parking Knowledge Test</a>
                                <a class="dropdown-item" href="${pageContext.request.contextPath}/mock-exam/driving-final/home" tabindex="-1">Deep dive assessment test</a>
                                <a class="dropdown-item" href="${pageContext.request.contextPath}/mock-exam/umrah/home">Umrah Quiz</a>
                                <a class="dropdown-item" href="${pageContext.request.contextPath}/mock-exam/school-kg/home">Kindergarten School</a>
                        </div>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-close-others="false" data-delay="0" data-hover=
                                "dropdown" data-toggle="dropdown" href="#"> Courses & Videos  <span class="badge badge-pill badge-danger">new</span>
                        </a>

                        <div class="dropdown-menu">
                                <a class="dropdown-item" href="${pageContext.request.contextPath}/courses">Course Home</a>
                                <a class="dropdown-item" href="${pageContext.request.contextPath}/videos">Videos</a>
                        </div>

                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-close-others="false" data-delay="0" data-hover=
                                "dropdown" data-toggle="dropdown" href="#">Lifestyle 
                        </a>

                        <div class="dropdown-menu">
                                <a class="dropdown-item" href="${pageContext.request.contextPath}/stories/index/popular_stories-islam">Popular Posts</a>
                                <a class="dropdown-item" href="${pageContext.request.contextPath}/stories/index/islam">Islam Articles</a>
                                <a class="dropdown-item" href="${pageContext.request.contextPath}/stories/index/umrah">Umrah Articles</a>
                                <a class="dropdown-item" href="${pageContext.request.contextPath}/stories/index/umrah">Enrich</a>
                                <a class="dropdown-item" href="${pageContext.request.contextPath}/mock-exam/umrah/home">Umrah Quiz</a>
                                <a class="dropdown-item" href="${pageContext.request.contextPath}/blog/technology">Technology</a>
                        </div>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-close-others="false" data-delay="0" data-hover=
                                "dropdown" data-toggle="dropdown" href="#">About Us
                        </a>

                        <div class="dropdown-menu">
                                <a class="dropdown-item" href="${pageContext.request.contextPath}/about-us">Who we are</a>
                                <a class="dropdown-item" href="${pageContext.request.contextPath}/contact">Contact Us</a>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="search-input" id="search-input-box" style="display: none;">
        <div class="container">
            <form class="d-flex justify-content-between">
                <input type="text" class="form-control" id="search-input" placeholder="Search Here">
                <button type="submit" class="btn"></button>
                <span class="lnr lnr-cross" id="close-search" title="Close Search"></span>
            </form>
        </div>
    </div>
</header>
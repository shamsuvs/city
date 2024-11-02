<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Navbar. Remove 'fixed-top' class to make the navigation bar scrollable with the page-->
<header class="navbar navbar-expand-lg fixed-top bg-light">
    <div class="container"><a class="navbar-brand pe-sm-3" href="/"><span class="text-primary flex-shrink-0 me-2">
              <svg version="1.1" width="35" height="32" viewBox="0 0 36 33" xmlns="http://www.w3.org/2000/svg">
                <path fill="currentColor" d="M35.6,29c-1.1,3.4-5.4,4.4-7.9,1.9c-2.3-2.2-6.1-3.7-9.4-3.7c-3.1,0-7.5,1.8-10,4.1c-2.2,2-5.8,1.5-7.3-1.1c-1-1.8-1.2-4.1,0-6.2l0.6-1.1l0,0c0.6-0.7,4.4-5.2,12.5-5.7c0.5,1.8,2,3.1,3.9,3.1c2.2,0,4.1-1.9,4.1-4.2s-1.8-4.2-4.1-4.2c-2,0-3.6,1.4-4,3.3H7.7c-0.8,0-1.3-0.9-0.9-1.6l5.6-9.8c2.5-4.5,8.8-4.5,11.3,0L35.1,24C36,25.7,36.1,27.5,35.6,29z"></path>
              </svg></span>Sulthan Bathery</a>
        <div class="form-check form-switch mode-switch order-lg-2 me-3 me-lg-4 ms-auto" data-bs-toggle="mode">
            <input class="form-check-input" type="checkbox" id="theme-mode">
            <label class="form-check-label" for="theme-mode"><i class="ai-sun fs-lg"></i></label>
            <label class="form-check-label" for="theme-mode"><i class="ai-moon fs-lg"></i></label>
        </div>
        <%--<a class="btn btn-primary btn-sm fs-sm order-lg-3 d-none d-sm-inline-flex" href="https://themes.getbootstrap.com/product/around-multipurpose-template-ui-kit/" target="_blank" rel="noopener"><i class="ai-cart fs-xl me-2 ms-n1"></i>Buy now</a>--%>
        <button class="navbar-toggler ms-sm-3" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"><span class="navbar-toggler-icon"></span></button>
        <nav class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav navbar-nav-scroll me-auto" style="--ar-scroll-height: 520px;">
                <li class="nav-item dropdown"><a class="nav-link dropdown-toggle" href="#" data-bs-toggle="dropdown" aria-expanded="false">Explore</a>
                    <div class="dropdown-menu overflow-hidden p-0">
                        <div class="d-lg-flex">

                            <div class="mega-dropdown-column pb-2 pt-lg-3 pb-lg-4">

                                    <ul class="nav flex-column mb-0">
                                        <c:forEach var="category" items="${categoryDto}">
                                            <c:set value="${category.value}" var="dto"/>
                                            <li><a class="dropdown-item" href="${dto.url}-in--sulthan-bathery">${dto.categoryTitle}</a><span class="mega-dropdown-column position-absolute top-0 end-0 h-100 bg-size-cover bg-repeat-0 zindex-2 opacity-0" style="background-image: url(https://res.cloudinary.com/dw8him6rb/image/upload/v1663933000/cld-sample-4.jpg);"></span></li>
                                        </c:forEach>

                                    </ul>

                            </div>
                            <div class="mega-dropdown-column position-relative border-start zindex-3"></div>
                        </div>
                    </div>
                </li>
                <li class="nav-item dropdown"><a class="nav-link dropdown-toggle" href="#" data-bs-toggle="dropdown" aria-expanded="false">Blog</a>
                    <div class="dropdown-menu overflow-hidden p-0">
                        <div class="d-lg-flex">


                                <ul class="list-unstyled mb-0">
                                    <li><a class="dropdown-item" href="/city--sb/all">All</a></li>
                                    <li><a class="dropdown-item" href="/city--sb/wayanad">Wayanad</a></li>
                                </ul>

                    </div>
                </li>
            </ul>
            <%--<div class="d-sm-none p-3 mt-n3">
                <a class="btn btn-primary w-100  mb-1" href="https://themes.getbootstrap.com/product/around-multipurpose-template-ui-kit/" target="_blank" rel="noopener">
                    <i class="ai-cart fs-xl me-2 ms-n1"></i>Buy now</a>
            </div>--%>
        </nav>
    </div>
</header>

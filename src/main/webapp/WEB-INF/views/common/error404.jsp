<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <c:import url="../common/head.jsp"/>
  </head>
  <!-- Body-->
  <body>
    <main class="page-wrapper d-flex flex-column">
      <!-- Navbar (Solid background)-->
      <!-- Remove "navbar-sticky" class to make navigation bar scrollable with the page.-->
      <c:import url="header-4a.jsp"/>
      <!-- Page content-->
      <div class="container d-flex flex-column justify-content-center pt-5 mt-n6" style="flex: 1 0 auto;">
        <div class="pt-7 pb-5">
          <div class="text-center mb-2 pb-4">
            <h1 class="mb-grid-gutter">
              <img class="d-inline-block" src="/img/404/404-illustration.svg" alt="Error 404"><span class="visually-hidden">Error 404</span>
              <span class="d-block pt-3 fs-sm fw-semibold text-danger">Error code: 404</span>
            </h1>
            <p><c:if test="${not empty errorMessage}">
              <c:out value="${errorMessage}"/>
            </c:if></p>
            <h2>Page not found!</h2>
            <p class="pb-2">It seems we can’t find the page you are looking for.</p>
            <a class="btn btn-translucent-primary me-3" href="/">Go to homepage</a><span>Or try search below</span>
          </div>
          <script async src="https://cse.google.com/cse.js?cx=72867606a2c10e585"></script>
          <div class="input-group mx-auto search-row" style="max-width: 390px;">

           <%--
            <input class="form-control rounded" type="text" placeholder="Search" required>--%>

             <i class="ai-search position-absolute top-50 start-0 translate-middle-y ms-3"></i>
              <div class="gcse-search"></div>


          </div>
        </div>
      </div>
    </main>
    <!-- Footer-->
    <c:import url="/WEB-INF/views/common/footer-min.jsp">
      <c:param name="type" value="bg-dark"/>
    </c:import>
    <!-- Back to top button-->
    <a class="btn-scroll-top" href="#top" data-scroll data-fixed-element><span class="btn-scroll-top-tooltip text-muted fs-sm me-2">Top</span><i class="btn-scroll-top-icon ai-arrow-up">   </i></a>
  </body>
</html>

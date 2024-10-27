<%--
  Created by IntelliJ IDEA.
  User: shamsudeen
  Date: 16/09/22
  Time: 4:41 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Footer-->
<footer class="footer pt-lg-5 pt-4 pb-5">
  <div class="container">
    <div class="row gy-md-5 gy-4 mb-md-5 mb-4 pb-lg-2">
      <div class="col-lg-3"><a class="navbar-brand d-inline-flex align-items-center mb-lg-4 mb-3" href="/"><span class="text-primary flex-shrink-0 me-2">
                <svg version="1.1" width="35" height="32" viewBox="0 0 36 33" xmlns="http://www.w3.org/2000/svg">
                  <path fill="currentColor" d="M35.6,29c-1.1,3.4-5.4,4.4-7.9,1.9c-2.3-2.2-6.1-3.7-9.4-3.7c-3.1,0-7.5,1.8-10,4.1c-2.2,2-5.8,1.5-7.3-1.1c-1-1.8-1.2-4.1,0-6.2l0.6-1.1l0,0c0.6-0.7,4.4-5.2,12.5-5.7c0.5,1.8,2,3.1,3.9,3.1c2.2,0,4.1-1.9,4.1-4.2s-1.8-4.2-4.1-4.2c-2,0-3.6,1.4-4,3.3H7.7c-0.8,0-1.3-0.9-0.9-1.6l5.6-9.8c2.5-4.5,8.8-4.5,11.3,0L35.1,24C36,25.7,36.1,27.5,35.6,29z"></path>
                </svg></span><span class="text-nav">Sultan Bathery</span></a>
        <p class="mb-4 pb-lg-3 fs-xs text-muted" style="max-width: 306px;">${cityObject.teaser}</p>
        <%--<div class="mt-n3 ms-n3"><a class="btn btn-secondary btn-icon btn-sm btn-instagram rounded-circle mt-3 ms-3" href="#"><i class="ai-instagram"></i></a><a class="btn btn-secondary btn-icon btn-sm btn-facebook rounded-circle mt-3 ms-3" href="#"><i class="ai-facebook"></i></a><a class="btn btn-secondary btn-icon btn-sm btn-linkedin rounded-circle mt-3 ms-3" href="#"><i class="ai-linkedin"></i></a></div>--%>
      </div>
      <div class="col-xl-8 offset-xl-1 col-lg-9">
        <div class="row row-cols-sm-4 row-cols-1">
          <div class="col">
            <ul class="nav flex-column mb-0">
              <li class="nav-item mb-2"><a class="nav-link p-0" href="/">Home</a></li>
            </ul>
          </div>
          <div class="col">
            <ul class="nav flex-column mb-0">
              <li class="nav-item mb-2"><a class="nav-link p-0" href="${categoryDto.get('hotel').url}">Hotels</a></li>
              <li class="nav-item mb-2"><a class="nav-link p-0" href="${categoryDto.get('hospital').url}">Hospitals</a></li>
              <li class="nav-item mb-2"><a class="nav-link p-0" href="${categoryDto.get('textile').url}">Textiles</a></li>
              <li class="nav-item mb-2"><a class="nav-link p-0" href="${categoryDto.get('school').url}">Schools</a></li>
          <%--    <li class="nav-item mb-2"><a class="nav-link p-0" href="${categoryDto.get('super-market').url}">Super Markets</a></li>--%>
 <%--             <li class="nav-item mb-2"><a class="nav-link p-0" href="/software-companies">Software Companies </a></li>--%>
            </ul>
          </div>
          <div class="col">
            <ul class="nav flex-column mb-0">
              <li class="nav-item mb-2"><a class="nav-link p-0" href="https://www.smashplus.com/">Smashplus Home</a></li>
            </ul>
          </div>
          <div class="col">
            <ul class="nav flex-column mb-0">
              <li class="nav-item mb-2"><a class="nav-link p-0 text-primary" href="https://www.smashplus.com/contact">contact</a></li>
              <li class="nav-item mb-2"><a class="nav-link p-0" href="https://www.smashplus.com/privacy-policy-web">Privacy policy</a></li>
            </ul>
          </div>
        </div>
      </div>
    </div>
    <div class="fs-sm text-muted">&copy; All rights reserved. Made by <a href='https://www.smashplus.com' target='_blank' rel='noopener' class='text-dark text-decoration-none opacity-90'>Smashplus</a></div>
    <div class="pt-4 pt-lg-0"></div>
  </div>
</footer>

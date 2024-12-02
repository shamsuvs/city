<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta charset="utf-8">
<!-- SEO Meta Tags-->
<c:set var="title" value="Sultan Bathery - Cleanest City in Kerala"/>
<c:set var="description" value="Clean city in India - Sultan Bathery"/>

<c:if test="${not empty param['title']}">
    <c:set var="title" value="${param['title']}" />
</c:if>
<c:if test="${not empty param['desc']}">
    <c:set var="description" value="${param['desc']}" />
</c:if>
<title>${title}</title>
<meta name="description" content="${description}">
<meta name="author" content="shams">
<c:set var="keyword" value="smashplus, deep dive tests, mock tests, software programing, search engine optimization"/>
<c:if test="${not empty param['desc']}">
    <c:set var="keyword" value="${description}" />
</c:if>
<c:if test="${not empty param['kw']}">
    <c:set var="keyword" value="${param['kw']}" />
</c:if>
<meta name="keywords" content="${keyword}">

<!-- Viewport-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<%--<!-- Favicon and Touch Icons-->
<link rel="apple-touch-icon" sizes="180x180" href="apple-touch-icon.png">
<link rel="icon" type="image/png" sizes="32x32" href="favicon-32x32.png">
<link rel="icon" type="image/png" sizes="16x16" href="favicon-16x16.png">
<link rel="manifest" href="site.webmanifest">
<link rel="mask-icon" color="#5bbad5" href="safari-pinned-tab.svg">--%>
<link rel="icon" href="/img/icons/favicon.png" type='image/x-icon'/>
<meta name="msapplication-TileColor" content="#766df4">
<meta name="theme-color" content="#ffffff">

<c:if test="${param['completeStyles'] ne false}">
    <!-- Vendor Styles-->
    <link rel="stylesheet" media="screen" href="/css/vendor/simplebar/simplebar.min.css"/>
    <link rel="stylesheet" media="screen" href="/css/vendor/tiny-slider/dist/tiny-slider.css"/>
    <link rel="stylesheet" media="screen" href="/css/vendor/lightgallery.js/dist/css/lightgallery.min.css"/>

    <!-- Vendor Styles-->
</c:if>
<!-- Main Theme Styles + Bootstrap-->
<link rel="stylesheet" media="screen" href="/css/theme4.min.css">

<!-- Google tag (gtag.js) -->
<script async src="https://www.googletagmanager.com/gtag/js?id=G-XE691G51F6"></script>
<script>
    window.dataLayer = window.dataLayer || [];
    function gtag(){dataLayer.push(arguments);}
    gtag('js', new Date());

    gtag('config', 'G-XE691G51F6');
</script>
<meta property="fb:app_id" content="851036458272763" />
<meta property="fb:admins" content="618528519"/>
<script async src="https://pagead2.googlesyndication.com/pagead/js/adsbygoogle.js?client=ca-pub-7940172394749608"
        crossorigin="anonymous"></script>

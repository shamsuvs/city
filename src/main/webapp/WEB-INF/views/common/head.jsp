<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta charset="utf-8">
<!-- SEO Meta Tags-->
<c:set var="title" value="Technology Insight"/>
<c:set var="description" value="Your Technology Friend helps you with articles on various day to day coding challenges"/>

<c:if test="${not empty param['title']}">
    <c:set var="title" value="${param['title']} - Smashvoid" />
</c:if>
<c:if test="${not empty param['desc']}">
    <c:set var="description" value="${param['desc']}" />
</c:if>
<title>${title}</title>
<meta name="description" content="${description}">
<meta name="author" content="smashplus">
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
<link rel="stylesheet" media="screen" href="/css/theme.min.css">
<!-- Global site tag (gtag.js) - Google Analytics GA4 implemented on 21-May-2022-->
<script async src="https://www.googletagmanager.com/gtag/js?id=G-F202MLPHZQ"></script>
<script>
    window.dataLayer = window.dataLayer || [];
    function gtag(){dataLayer.push(arguments);}
    gtag('js', new Date());

    gtag('config', 'G-F202MLPHZQ');
</script>
<meta property="fb:app_id" content="851036458272763" />
<meta property="fb:admins" content="618528519"/>
<!--to use for Google search console-->
<meta name="google-site-verification" content="ZVFfM0C-Zqqtm2agZOnEXfJ4VtEiIstAVpjtawEQU68" />

    <meta charset="utf-8">
    <!-- Viewport-->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Favicon and Touch Icons-->
    <link rel="apple-touch-icon" sizes="180x180" href="assets/favicon/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="assets/favicon/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="assets/favicon/favicon-16x16.png">
    <link rel="manifest" href="assets/favicon/site.webmanifest">
    <link rel="mask-icon" color="#6366f1" href="assets/favicon/safari-pinned-tab.svg">
    <meta name="msapplication-TileColor" content="#080032">
    <meta name="msapplication-config" content="assets/favicon/browserconfig.xml">
    <meta name="theme-color" content="white">
    <!-- Theme mode-->
    <script>
        let mode = window.localStorage.getItem('mode'),
            root = document.getElementsByTagName('html')[0];
        if (mode !== undefined && mode === 'dark') {
            root.classList.add('dark-mode');
        } else {
            root.classList.remove('dark-mode');
        }


    </script>
    <!-- Page loading styles-->
    <style>
        .page-loading {
            position: fixed;
            top: 0;
            right: 0;
            bottom: 0;
            left: 0;
            width: 100%;
            height: 100%;
            -webkit-transition: all .4s .2s ease-in-out;
            transition: all .4s .2s ease-in-out;
            background-color: #fff;
            opacity: 0;
            visibility: hidden;
            z-index: 9999;
        }
        .dark-mode .page-loading {
            background-color: #121519;
        }
        .page-loading.active {
            opacity: 1;
            visibility: visible;
        }
        .page-loading-inner {
            position: absolute;
            top: 50%;
            left: 0;
            width: 100%;
            text-align: center;
            -webkit-transform: translateY(-50%);
            transform: translateY(-50%);
            -webkit-transition: opacity .2s ease-in-out;
            transition: opacity .2s ease-in-out;
            opacity: 0;
        }
        .page-loading.active > .page-loading-inner {
            opacity: 1;
        }
        .page-loading-inner > span {
            display: block;
            font-family: 'Inter', sans-serif;
            font-size: 1rem;
            font-weight: normal;
            color: #6f788b;
        }
        .dark-mode .page-loading-inner > span {
            color: #fff;
            opacity: .6;
        }
        .page-spinner {
            display: inline-block;
            width: 2.75rem;
            height: 2.75rem;
            margin-bottom: .75rem;
            vertical-align: text-bottom;
            background-color: #d7dde2;
            border-radius: 50%;
            opacity: 0;
            -webkit-animation: spinner .75s linear infinite;
            animation: spinner .75s linear infinite;
        }
        .dark-mode .page-spinner {
            background-color: rgba(255,255,255,.25);
        }
        @-webkit-keyframes spinner {
            0% {
                -webkit-transform: scale(0);
                transform: scale(0);
            }
            50% {
                opacity: 1;
                -webkit-transform: none;
                transform: none;
            }
        }
        @keyframes spinner {
            0% {
                -webkit-transform: scale(0);
                transform: scale(0);
            }
            50% {
                opacity: 1;
                -webkit-transform: none;
                transform: none;
            }
        }

    </style>
    <!-- Page loading scripts-->
    <script>
        (function () {
            window.onload = function () {
                const preloader = document.querySelector('.page-loading');
                preloader.classList.remove('active');
                setTimeout(function () {
                    preloader.remove();
                }, 1500);
            };
        })();

    </script>
    <!-- Import Google Font-->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&amp;display=swap" rel="stylesheet" id="google-font">
    <!-- Vendor styles-->
    <link rel="stylesheet" media="screen" href="/js/vendor/swiper/swiper-bundle.min.css"/>
    <!-- Main Theme Styles + Bootstrap-->
    <link rel="stylesheet" media="screen" href="/css/theme.min.css">


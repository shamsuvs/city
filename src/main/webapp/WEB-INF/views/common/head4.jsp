    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <meta charset="utf-8">
    <c:set var="title" value="smashplus"/>
    <c:set var="description" value="driving Articles helps you to crack RTA Test in Dubai, regional and islam related topics and much more"/>

    <c:if test="${not empty param['title']}">
        <c:set var="title" value="${param['title']}" />
    </c:if>
    <c:if test="${not empty param['desc']}">
        <c:set var="description" value="${param['desc']}" />
    </c:if>
    <title>${title}</title>
    <meta name="description" content="${description}">
    <meta name="author" content="smashplus">
    <c:if test="${not empty param['kw']}">
        <c:set var="description" value="${param['kw']}" />
    </c:if>
    <meta name="keywords" content="${description}">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">

    <%--<link rel="icon" href="https://www.smashplus.com/resources/img/link-icon.png" type='image/x-icon'/>--%>
    <link rel="icon" href="/resources/img/icons/favicon.png" type='image/x-icon'/>


    <!--
    CSS
    =============================================
    -->
    <link href="${pageContext.request.contextPath}/css/bootstrap411.min.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/css/course/course-style.css" rel="stylesheet"/>
    <link rel="stylesheet" type="text/css" href="/css/course/slick/slick.css"/>

    <link rel="stylesheet" type="text/css" href="/css/course/slick/slick-theme.css"/>
    <style>
        .slider {
            width: 50%;
            margin: 100px auto;
        }

        .slick-prev:before,
        .slick-next:before {
            color: black;
        }
        .slick-slide {
            margin: 0px 20px;
        }
    </style>


    <!--external resources/css-->
    <link href="${pageContext.request.contextPath}/resources/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />

    <link href='https://fonts.googleapis.com/css?family=Lato' rel='stylesheet' type='text/css'>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 tooltipss and media queries -->
    <!--[if lt IE 9]>
    <script src="${pageContext.request.contextPath}/resources/js-old/html5shiv.js">
    </script>
    <script src="${pageContext.request.contextPath}/resources/js-old/respond.min.js">
    </script>
    <![endif]-->
    <script>
        (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
            (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
                m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
        })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

        ga('create', 'UA-58082818-1', 'auto');
        ga('send', 'pageview');

    </script>
    <meta property="fb:app_id" content="851036458272763" />
    <meta property="fb:admins" content="618528519"/>

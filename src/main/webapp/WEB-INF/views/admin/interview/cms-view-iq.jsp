<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<jsp:useBean id="random" class="java.util.Random" scope="application" />
<!DOCTYPE html>
<html lang="en">
<head>
    <c:import url="/WEB-INF/views/admin/common/admin-head.jsp"/>
</head>
<body>
    <c:import url="/WEB-INF/views/admin/common/admin-header.jsp"/>

    <!--breadcrumbs start-->
    <div class="breadcrumbs">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 col-sm-12">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="/admin/cms/">Admin Home</a></li>
                            <li class="breadcrumb-item active" aria-current="page"><a href="/admin/interview-question/all/">All</a></li>
                            <li class="breadcrumb-item active" aria-current="page">view</li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </div>
    <!--container start-->
    <div class="container">
        <div class="row">
            <!--blog start-->
            <div class="col-lg-9">
                <c:if test="${not empty message}">
                    <div class="alert alert-success" role="alert">${message}<br>
                    </div>
                </c:if>
                <h2 class="form-general-heading">View Details </h2>
                <div class="login-wrap">
                    <p>Title: ${interview.question}</p>
                    <p>Teaser: ${interview.shortAnswer}</p>
                    <p>Teaser: ${interview.answer}</p>

                    <a href="${pageContext.request.contextPath}/admin/interview-question/create" class="btn btn-danger">Add New</a>
                    <a href="${pageContext.request.contextPath}/admin/interview-question/edit/${interview.id}" class="btn btn-danger">Edit</a>
                </div>
            </div>
            <div class="col-lg-3">
                <div class="blog-side-item">

                </div>
            </div>
        </div>
    </div>
    <!--container end-->
        <!--footer start-->
        <c:import url="/WEB-INF/views/admin/common/admin-footer.jsp"/>
        </body>
        </html>

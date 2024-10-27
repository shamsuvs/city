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
                            <li class="breadcrumb-item active" aria-current="page"><a href="/admin/all-est/">All</a></li>
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
                    <p>Title: ${establishment.estName}</p>
                    <p>Teaser: ${establishment.teaser}</p>
                    <p>About: ${establishment.about}</p>
                    <c:forEach items="${establishment.specialityTblsById}" var="spec" varStatus="rli">
                        <div class="card overflow-hidden">
                            <div class="row g-0">
                                <div class="col-sm-4 bg-repeat-0 " style="background-image: url(${spec.thumbNail});"></div>
                                <div class="col-sm-8">
                                    <div class="card-body">
                                        <h4 class="card-title">${spec.name}</h4>
                                        <p class="card-text">${spec.speciality}</p>
                                        <p class="card-text">${spec.degree}</p>
                                        <a href="#" class="btn btn-primary">Details</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>

                    <a href="${pageContext.request.contextPath}/admin/establishment/create" class="btn btn-danger">Add New</a>
                    <a href="${pageContext.request.contextPath}/admin/establishment/edit/${establishment.id}" class="btn btn-danger">Edit</a>
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

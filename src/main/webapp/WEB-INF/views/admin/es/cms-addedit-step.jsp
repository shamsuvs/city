<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:useBean id="random" class="java.util.Random" scope="application" />

<!DOCTYPE html>
<html lang="en">
<head>
    <c:import url="/WEB-INF/views/admin/common/admin-head.jsp">
        <c:param name="title" value="Add New steps"/>
    </c:import>

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
                                <li class="breadcrumb-item active" aria-current="page"><a href="/admin/all-steps/">steps</a></li>
                                <li class="breadcrumb-item active" aria-current="page">Add /Edit step</li>
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
                        <c:if test="${not empty message}">
                            <div class="alert alert-success" role="alert">${message}<br></div>
                        </c:if>
<form:form method="POST"
           action="${pageContext.request.contextPath}/admin/create-step" modelAttribute="step" id="step" name="step" >

                        <h2 class="form-general-heading">Add New step</h2>
                        <div class="login-wrap">
                            <p>Enter Details</p>
                            <form:hidden path="id"/>
                            <div class="col-md-6 mb-3">
                                <label for="title" class="col-sm-2 col-form-label">step Title</label>

                                    <form:input type="text" path="title" cssClass="form-control"/>
                            </div>
                            <div class="col-md-6 mb-3">
                                <label for="stepDesc" class="col-sm-2 col-form-label">Description</label>

                                    <form:textarea path="stepDesc" cssClass="form-control" rows="5"/>
                            </div>
                            <div class="col-md-6 mb-3">
                                <label for="blogpostLink" class="col-sm-2 col-form-label">blogpostLink</label>

                                    <form:input type="text" path="blogpostLink" cssClass="form-control"/>
                            </div><div class="col-md-6 mb-3">
                                <label for="ytCode" class="col-sm-2 col-form-label">Youtube Code</label>

                                    <form:input type="text" path="ytCode" cssClass="form-control"/>
                            </div><div class="col-md-6 mb-3">
                                <label for="screenShots" class="col-sm-2 col-form-label">screenShots</label>
                                    <p class="fs-xs text-muted">ensure on cludinary this prfix: https://res.cloudinary.com/dw8him6rb/image/upload/v1660221041/es_technology/screenshots/ and enter last part, comma seperated if more screen</p>
                                    <form:input type="text" path="screenShots" cssClass="form-control"/>
                            </div>


                            <div class="col-md-6 mb-3">
                                <label for="contentType" class="col-sm-2 col-form-label">Content Type</label>

                                <form:select  path="contentType" cssClass="form-control">
                                    <form:option value="" label="select"/>
                                    <form:option value="post" label="Post"/>
                                    <form:option value="both" label="Video & Post"/>
                                </form:select>

    </div>

                            </div>
                            <div class="col-md-6 mb-3">
                                <label for="tags" class="col-sm-2 col-form-label">step Tags</label>

                                    <form:input type="text" path="tags" cssClass="form-control"/>

                            </div>
                            <div class="col-md-6 mb-3">
                                <label for="category" class="col-sm-2 col-form-label">Category</label>

                                        <form:select  path="category" cssClass="form-control">
                                            <form:option value="" label="select"/>
                                            <form:option value="technology" label="Technology"/>
                                        </form:select>

                            </div>
                            <div class="col-md-6 mb-3">
                                <label for="category" class="col-sm-2 col-form-label">Category</label>

                                <form:select  path="subcategory" cssClass="form-control">
                                    <form:option value="" label="select"/>
                                    <form:option value="java" label="java"/>
                                    <form:option value="jpa" label="jpa"/>
                                    <form:option value="aws" label="aws"/>
                                </form:select>

                            </div>

                            <hr>

                            <button class="btn btn-lg btn-primary" type="submit">Submit</button>
                            <button class="btn btn-lg btn-primary" type="cancel" id="cancel">Cancel</button>

                    </form:form>
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
        <script src="https://cdn.tiny.cloud/1/ti6zupmgyiwydm7xjzadzrndxft19cbz3otm4vyw0oymzz4i/tinymce/5/tinymce.min.js" referrerpolicy="origin"></script>
        <script>tinymce.init({ selector: 'textarea',
            height: 200,
            plugins: [
                'advlist autolink lists link image charmap print preview anchor',
                'searchreplace visualblocks code fullscreen',
                'insertdatetime media table contextmenu paste code'
            ],
            toolbar: 'insertfile undo redo | styleselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link image',
            toolbar2: 'print preview media | forecolor backcolor emoticons',
            content_css: [
                '//fast.fonts.net/cssapi/e6dc9b99-64fe-4292-ad98-6974f93cd2a2.css',
                '//www.tinymce.com/css/codepen.min.css'
            ] });
        </script>
</body>
</html>



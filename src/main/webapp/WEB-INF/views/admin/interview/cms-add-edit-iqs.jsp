<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:useBean id="random" class="java.util.Random" scope="application" />

<!DOCTYPE html>
<html lang="en">
<head>
    <c:import url="/WEB-INF/views/admin/common/admin-head.jsp">
        <c:param name="title" value="Add New Interviw Question"/>
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
                                <li class="breadcrumb-item active" aria-current="page"><a href="/admin/interview-questions-list/all">Interview Questions List</a></li>
                                <li class="breadcrumb-item active" aria-current="page">Add /Edit Int Question List</li>
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
           action="${pageContext.request.contextPath}/admin/interview-questions-list/" modelAttribute="iqsList" id="iqsList" name="iqsList" >

                        <h2 class="form-general-heading">Add New IQ Series</h2>
                        <div class="login-wrap">
                            <p>Enter Details</p>
                            <form:hidden path="id"/>
                            <div class="col-md-6 mb-3">
                                <label for="title" class="col-sm-2 col-form-label">title</label>

                                    <form:input type="text" path="title" cssClass="form-control"/>
                            </div>
                            <div class="col-md-6 mb-3">
                                <label for="Teaser" class="col-sm-2 col-form-label">Teaser</label>

                                <form:textarea path="Teaser" cssClass="form-control" rows="2"/>
                            </div>
                            <div class="col-md-6 mb-3">
                                <label for="postDesc" class="col-sm-2 col-form-label">postDesc</label>

                                    <form:textarea path="postDesc" cssClass="form-control" rows="5"/>
                            </div>
                            <div class="col-md-6 mb-3">
                                <label for="youtubeUrl" class="col-sm-2 col-form-label">Youtube Code</label>

                                    <form:input type="text" path="youtubeUrl" cssClass="form-control"/>
                            </div><div class="col-md-6 mb-3">
                                <label for="image" class="col-sm-2 col-form-label">image</label>
                                    <p class="fs-xs text-muted">ensure on cloudinary this prfix: https://res.cloudinary.com/dw8him6rb/image/upload/v1660221041/interview_question/images/ and enter last part</p>
                                    <form:input type="text" path="image" cssClass="form-control"/>
                            </div>



                            <div class="col-md-6 mb-3">
                                <label for="tags" class="col-sm-2 col-form-label"> Tags</label>

                                    <form:input type="text" path="tags" cssClass="form-control"/>

                            </div>
                            <div class="col-md-6 mb-3">
                                <label for="tags" class="col-sm-2 col-form-label"> Year of experience in comma seperated</label>

                                <form:input type="text" path="targetExperience" cssClass="form-control"/>

                            </div>
                            <div class="col-md-6 mb-3">
                                <label for="tags" class="col-sm-2 col-form-label">url</label>

                                <form:input type="text" path="url" cssClass="form-control"/>

                            </div>
                            <div class="col-md-6 mb-3">
                                <label for="tags" class="col-sm-2 col-form-label"> Technology</label>

                                <form:input type="text" path="technology" cssClass="form-control"/>

                            </div>
                            <div class="col-md-6 mb-3">
                                <label for="category" class="col-sm-2 col-form-label">Category</label>

                                        <form:select  path="category" cssClass="form-control">
                                            <form:option value="" label="select"/>
                                            <form:option value="technology" label="Technology"/>
                                        </form:select>

                            </div>
                            <div class="col-md-6 mb-3">
                                <label for="Subcategory" class="col-sm-2 col-form-label">Sub Category</label>

                                <form:select  path="subcategory" cssClass="form-control">
                                    <form:option value="" label="select"/>
                                    <form:option value="java" label="java"/>
                                    <form:option value="jpa" label="jpa"/>
                                    <form:option value="aws" label="aws"/>
                                    <form:option value="spring-boot" label="Spring Boot"/>
                                </form:select>

                            </div>
                            <div class="form-check">

                                <form:checkbox class="form-check-input" id="customSwitch2"  path="publish" label="publish"/>

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



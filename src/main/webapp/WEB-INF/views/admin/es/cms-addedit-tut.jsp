<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:useBean id="random" class="java.util.Random" scope="application" />

<!DOCTYPE html>
<html lang="en">
<head>
    <c:import url="/WEB-INF/views/admin/common/admin-head.jsp">
        <c:param name="title" value="Add New Course"/>
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
                        <li class="breadcrumb-item"><a href="/admin/all-tutorials/">All tut</a></li>
                        <li class="breadcrumb-item active" aria-current="page">Tutorial</li>
                    </ol>
                </nav>
            </div>
        </div>
    </div>
</div>

<!--breadcrumbs end-->

<!--container start-->
<div class="container">

    <div class="row">
        <!--blog start-->
        <div class="col-lg-9">
            <c:if test="${not empty message}">
                <div class="alert alert-success" role="alert">${message}<br>
                </div>
            </c:if>
            <form:form method="post" name="tutorial" id="tutorial" action="${pageContext.request.contextPath}/admin/create-tutorial/" modelAttribute="tutorial">
                <h2 class="form-general-heading">Entry form</h2>


                <div class="login-wrap">
                    <p>Enter details</p>
                    <div class="col-md-6 mb-3">
                        <form:hidden path="id"/>
                        <form:input type="text" cssClass="form-control" autofocus="" placeholder=" Title" path="title"/>
                    </div>
                    <div class="col-md-12 mb-3">
                        <label for="tutDescription">Tutorial Description</label>
                        <form:textarea path="tutDescription" cssClass="form-control" rows="10"/>

                    </div>
                    <hr>
                    <div class="col-md-12 mb-3">
                        <label for="teaser">Teaser</label>
                        <form:input type="text" path="teaser" cssClass="form-control"/>

                    </div>
                    <div class="col-md-12 mb-3">
                        <label for="teaser">Topic</label>
                        <form:input type="text" path="topic" cssClass="form-control"/>

                    </div>
                    <div class="col-md-12 mb-3">
                        <label for="teaser">Author</label>
                        <form:input type="text" path="author" cssClass="form-control"/>

                    </div>
                    <div class="col-md-12 mb-3">
                        <label for="teaser">Image</label>
                        <form:input type="text" path="image" cssClass="form-control"/>

                    </div>
                    <div class="col-md-12 mb-3">
                        <label for="techList">techList</label>
                        <form:input type="text" path="techList" cssClass="form-control"/>

                    </div>
                    <div class="col-md-12 mb-3">
                        <label for="techList">tags</label>
                        <form:input type="text" path="tags" cssClass="form-control"/>

                    </div>
                    <div class="col-md-12 mb-3">
                        <label for="techList">codeLink</label>
                        <form:input type="text" path="codeLink" cssClass="form-control"/>

                    </div>
                    <div class="col-md-12 mb-3">
                        <label for="techList">codeNotes</label>
                        <form:input type="text" path="codeNotes" cssClass="form-control"/>

                    </div>
                    <div class="col-md-12 mb-3">
                        <label for="tutReference">tutReference</label>
                        <form:input type="text" path="tutReference" cssClass="form-control"/>

                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="tutCategory" class="col-sm-2 col-form-label">Category</label>

                        <form:select  path="tutCategory" cssClass="form-control">
                            <form:option value="" label="select"/>
                            <form:option value="technology" label="Technology"/>
                        </form:select>

                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="tutSubcategory" class="col-sm-2 col-form-label">tutSubcategory</label>

                        <form:select  path="tutSubcategory" cssClass="form-control">
                            <form:option value="" label="select"/>
                            <form:option value="java" label="java"/>
                            <form:option value="jpa" label="jpa"/>
                            <form:option value="aws" label="aws"/>
                        </form:select>

                    </div>

                    <div class="form-check">

                        <form:checkbox class="form-check-input" id="customSwitch2"  path="publish"/>

                    </div>

                    <button class="btn btn-lg btn-primary" type="submit">Submit</button>
                    <button class="btn btn-lg btn-primary" type="cancel" id="cancel">Cancel</button>


                </div>
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
$(document).ready(function() {
    $("#cancel").click(function (e) {
        e.preventDefault();
        window.location.replace("/admin/all-courses/");
    });
});


</script>
</body>
</html>



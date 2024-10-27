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
<!--container start-->
<div class="container">

    <div class="row">
        <!--blog start-->


        <div class="col-lg-9">
            <h3>City Manager</h3>
            <ul>
                <li><a href="${pageContext.request.contextPath}/admin/all-est/">List All Establishments</a></li>
                <li><a href="${pageContext.request.contextPath}/admin/establishment/create">Create New Establishment</a></li>
                <li><a href="${pageContext.request.contextPath}/admin/edit-est/">edit establishment</a></li>

            </ul>
            <h3>Create Course</h3>
            <ul>
                <li><a href="${pageContext.request.contextPath}/admin/create-course/">Create New Course</a></li>
                <li><a href="${pageContext.request.contextPath}/admin/all-courses/">List All Courses</a></li>
                <li><a href="${pageContext.request.contextPath}/admin/create-chapter/">Create Course Chapters</a></li>
                <li><a href="${pageContext.request.contextPath}/admin/all-chapters/">List All Chapters</a></li>

            </ul>
            <h3>Example Series</h3>
            <ul>
                <li><a href="${pageContext.request.contextPath}/admin/create-tutorial/">Create Example Type</a></li>
                <li><a href="${pageContext.request.contextPath}/admin/all-es-articles/">List All Example Series</a></li>
                <li><a href="${pageContext.request.contextPath}/admin/create-step">Create Example Steps</a></li>
                <li><a href="${pageContext.request.contextPath}/admin/all-steps">List All Example Steps</a></li>
                <li><a href="http://ec2-13-40-90-152.eu-west-2.compute.amazonaws.com/admin/technology/all-es-articles">prod</a></li>

            </ul>
            <hr>
            <h3>Questions</h3>
            <ul>
                <li><a href="${pageContext.request.contextPath}/admin/add-question/">Add Question</a></li>
                <li><a href="${pageContext.request.contextPath}/admin/question-list">View all questions</a></li>
            </ul>
            <h3>Locations</h3>
            <ul>
                <li><a href="${pageContext.request.contextPath}/admin/create-location/">Create Location</a></li>
                <li><a href="${pageContext.request.contextPath}/admin/view-all-locations/">View all locations</a></li>
            </ul>
            <h3>Interview Questions</h3>
            <ul>
                <li><a href="${pageContext.request.contextPath}/admin/interview-question/create/">Create </a></li>
                <li><a href="${pageContext.request.contextPath}/admin/interview-question/all">View all </a></li>
                <li><a href="${pageContext.request.contextPath}/admin/interview-questions-list/">Create LIST</a></li>
                <li><a href="${pageContext.request.contextPath}/admin/interview-series/all">View all LIST </a></li>

            </ul>
            <h3>Exam</h3>
            <ul>
                <li><a href="${pageContext.request.contextPath}/admin/create-exam/">Create Exam</a></li>
                <li><a href="${pageContext.request.contextPath}/admin/view-all-exams/all">View all exam</a></li>
            </ul>

            <hr>

            <h3>Entity</h3>
            <ul>
                <li><a href="${pageContext.request.contextPath}/admin/add-entity-obj">Add Entity</a></li>
                <li><a href="${pageContext.request.contextPath}/admin/add-entity-obj">View all entities</a></li>
            </ul>
            <h3>Post</h3>
            <ul>
                <li><a href="${pageContext.request.contextPath}/admin/create-list-post">Create New List Post </a></li>
                <li><a href="${pageContext.request.contextPath}/admin/view-list-post/all">View all List Posts</a></li>
            </ul>
            <h3>Traffic Signs</h3>
            <ul>
                <li><a href="${pageContext.request.contextPath}/admin/add-traffic-sign/">Add traffic sign</a></li>
                <li><a href="${pageContext.request.contextPath}/admin/view-traffic-signs">View signs</a></li>
            </ul>
            <h3>Story master - Chained story</h3>
            <ul>
                <li><a href="${pageContext.request.contextPath}/admin/add-master-post">Create new master post </a></li>
                <li><a href="${pageContext.request.contextPath}/admin/add-child-post">Create new seq posts</a></li>
            </ul>
            <hr>
            <h3>Blogger Services</h3>
            <ul>
                <li><a href="${pageContext.request.contextPath}/admin/create-blogpost-entry/">Add Blog post</a></li>
                <li><a href="${pageContext.request.contextPath}/admin/all-posts/">All Blog post</a></li>
            </ul>
            <ul>
                <li><a href="${pageContext.request.contextPath}/admin/all-weblogs/">All WebBlog</a></li>
                <li><a href="${pageContext.request.contextPath}/admin/add-weblog/">Add WebBlog post</a></li>
            </ul>

            <h3>Photo Gallery</h3>
            <ul>
                <li><a href="${pageContext.request.contextPath}/admin/add-image-to-gallery/">Add Image to Gallery</a></li>
                <li><a href="${pageContext.request.contextPath}/admin/view-gallery">View Gallery</a></li>
            </ul>

            <h3>Knowledge Corner(small posts)</h3>
            <ul>
                <li><a href="${pageContext.request.contextPath}/admin/enrich/">Write KC post</a></li>
            </ul>

            <h3> Cache Management</h3>
            <ul>
                <li><a href="${pageContext.request.contextPath}/clearAllCaches">Clear All</a></li>
            </ul>
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
<script src="//cdn.tinymce.com/4/tinymce.min.js"></script>
<script>tinymce.init({ selector: 'textarea',
    height: 125,
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
    ] });</script>
</body>
</html>



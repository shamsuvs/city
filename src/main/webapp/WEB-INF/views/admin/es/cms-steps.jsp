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
                            <li class="breadcrumb-item active" aria-current="page">steps</li>
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

            <div class="col-lg-12">

                <h2> All  </h2>
                <p><a href="${pageContext.request.contextPath}/admin/create-step/" class="btn btn-danger">Add New</a></p>
                <hr>

                <div class="bs-chapterple" id="EntityListTable">
                    <table class="table table-hover">
            <thead>
            <tr>
                <th>
                    <INPUT type="checkbox" onchange="checkAll(this)" name="entity[]" />
                </th>

                <th colspan="2">
                    Title
                </th>
                <th>
                  Lock Type
                </th>
                <th>
                    Type
                </th>
                
                <th>

                </th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="chapter" items="${chapterList}" varStatus="i">
                <tr>
                    <td>
                        <input type="checkbox" name="entityId" value="${chapter.id}">
                    </td>

                    <td colspan="2">
                            <a href="${pageContext.request.contextPath}/admin/view-step/${chapter.id}">${chapter.title}</a>
                        </td>
                    <td>
                       ${chapter.contentType}
                    </td><td>
                       ${chapter.stepDesc}
                    </td>
                  <td>
                        <a href="${pageContext.request.contextPath}/admin/edit-step/${chapter.id}" class="btn btn-info">edit</a></td><td>
                        <a href="#" postId="${chapter.id}" class="deleteChapter btn btn-danger">delete</a>
                    </td>
                </tr>
            </c:forEach>

            </tbody>
        </table>                                                                            
                    <hr>
                </div>
            </div>
        </div>
    </div>
    <c:import url="/WEB-INF/views/admin/common/admin-footer.jsp"/>
    <script>
        $(".deleteChapter").click(function() {
            var decise = confirm("Do you want to delete? Cannot undo!");
            if (decise == true) {
                var $this    = $(this)
                var id= $this.attr("postId");

                var url="${pageContext.request.contextPath}/admin/delete-step/"+id;
                console.log(url);
                var elem = "successMsg";
                processAjaxForm(url, elem, null);
                window.location.reload();
            }
        });
    </script>
    </body>
</html>

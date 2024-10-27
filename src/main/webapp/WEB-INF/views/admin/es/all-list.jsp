<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<jsp:useBean id="random" class="java.util.Random" scope="application" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <c:import url="/WEB-INF/views/common/head.jsp"/>
</head>

<body>
<c:import url="/WEB-INF/views/common/header-4a.jsp"/>
<!--container start-->
<div class="container">

    <div class="row">
        <!--blog start-->

        <a href="${pageContext.request.contextPath}/admin/add-weblog/" class="btn btn-primary">Add New Weblog</a>
        <div class="col-lg-12">
            <div id="successMsg"></div>
            <div class="bs-example" id="EntityListTable">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>
                            <INPUT type="checkbox" onchange="checkAll(this)" name="entity[]" />
                        </th>

                        <th>
                            Title
                        </th>
                        <th>

                        </th><th>
                        teaser
                    </th><th>
                        category
                    </th>
                        <th>
                            subCategory
                        </th>
                        <th>
                            type
                        </th>
                        <th>
                            location
                        </th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="tut" items="${examples}">
                        <tr>
                            <td>
                                <input type="checkbox" name="entityId" value="${tut.id}">
                            </td>

                            <td colspan="2">
                                <a href="${pageContext.request.contextPath}/admin/view-tutorial/${tut.id}">${tut.title}</a>
                            </td>
                            <td>
                                    ${tut.teaser}
                            </td>

                            <td>
                                <a href="${pageContext.request.contextPath}/admin/edit-tutorial/${tut.id}" class="nav-link-style"><div class="ai-edit"></div></a></td><td>
                            <a href="#" esid="${eslog.id}" class="delEntity nav-link-style text-danger" data-bs-toggle="tooltip" title="" data-bs-original-title="Remove">
                                <div class="ai-trash-2"></div></a>
                        </td>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
            </div></div></div></div>
<c:import url="/WEB-INF/views/common/footer.jsp"/>
<script>
    $(".delEntity").click(function() {
        var $this    = $(this)
        let id= $this.attr("weblogId");

        let url="${pageContext.request.contextPath}/admin/delete-weblog/"+id;
        console.log(url);
        let elem = "successMsg";
        processAjaxForm(url, elem, null);

    });

</script>
</body>
</html>

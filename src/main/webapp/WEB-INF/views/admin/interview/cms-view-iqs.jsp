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
                            <li class="breadcrumb-item active" aria-current="page"><a href="/admin/interview-questions-list/all/">All</a></li>
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
                    <p>Title: ${iqsList.title}</p>
                    <p>Teaser: ${iqsList.teaser}</p>
                    <p>Teaser: ${iqsList.postDesc}</p>

                    <a href="${pageContext.request.contextPath}/admin/interview-questions-list/" class="btn btn-danger">Add New</a>
                    <a href="${pageContext.request.contextPath}/admin/interview-questions-list/edit/${iqsList.id}" class="btn btn-danger">Edit</a>
                </div>
                <div>
                    <h5>Already Mapped Questions</h5>
                </div>
                <div id="successMsg"></div>
                <c:import url="selQtns.jsp"/>
                <hr>



                <form
                        method="post" name="questionMap" id="questionMap" action="${pageContext.request.contextPath}/admin/interview-list/add-questions/">

                    <h5>Map Question to the List</h5>
                    <input type="hidden" id="intListId" name="intListId" value="${iqsList.id}"/>
                    <div class="row">
                        <div class="col-md-4 mb-3">
                            <label for="category">Question Category</label>
                            <select id="category" autofocus="" class="form-control">
                                <option value="">select</option>
                                <option value="technology" label="Technology"/>
                            </select>
                        </div>
                        <div class="col-md-4 mb-3">
                            <div class="form-group col-md-6">
                                <label for="subCategory">Sub Category</label>
                                <select id="subCategory" name="subCategory" autofocus="" class="form-control form-control-sm">
                                    <option value="">Select</option>
                                    <option value="java">Java</option>
                                    <option value="spring-boot">Spring Boot</option>
                                    <option value="aws">AWS</option>
                                </select>
                            </div>
                        </div>
                    </div>

                    <p>

                        <input type="button" id="searchbtn" name="searchbtn" value="search" class="btn btn-primary"/>

                    </p>
                    <c:import url="questions.jsp"/>


                </form>
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
    <script>
        $category = $('#category');
        $subcategory = $('#subCategory');
        $search = $('#searchbtn');
        let lid=$('#intListId').val();
        $search.click (

            function() {
                $.ajax({
                    type: "GET",
                    url: "/admin/interview-questions-list/list-int-questions",
                    data: {'category':$category.val(),'subCategory':$subcategory.val(),'listId':lid
                    },
                    success: function(data){

                        $("#EntityListTable").html(data)
                    }
                });
            }

        );
        $(".delEntityMap").click(function() {
            let $this    = $(this)
            let id= $this.attr("qtnId");
            let listId= $("#intListId").val();


            var url="${pageContext.request.contextPath}/admin/remove-intquest-mapping/"+listId+"/"+id;
            console.log(url);
            let elem = "successMsg";
            processAjaxForm(url, elem, null);
            location.reload(true);

        });
    </script>
        </body>
        </html>

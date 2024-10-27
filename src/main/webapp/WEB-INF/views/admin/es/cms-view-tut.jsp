<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<jsp:useBean id="random" class="java.util.Random" scope="application" />

<!DOCTYPE html>
<html lang="en">
<head>
    <c:import url="/WEB-INF/views/admin/common/admin-head.jsp">
        <c:param name="title" value="view course module ${course.title}"/>
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
                        <li class="breadcrumb-item"><a href="/admin/all-tutorials/">All</a></li>
                        <li class="breadcrumb-item active" aria-current="page">View</li>
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
        <div class="col-lg-9">
            <c:if test="${not empty message}">
                <div class="alert alert-success" role="alert">${message}<br>
                </div>
            </c:if>
            <a href="${pageContext.request.contextPath}/admin/create-tutorial/" class="btn btn-danger">Add New</a>
            <h2 class="form-general-heading"> Details</h2>
            <div class="login-wrap">
                <p><span class="badge badge-primary"> details</span></p>
                <p>Title: ${tutorial.title}</p>
                <p>Description: ${tutorial.tutDescription}</p>
                <p>Teaser: ${tutorial.teaser}</p>


                <a href="${pageContext.request.contextPath}/admin/edit-tutorial/${tutorial.id}" class="btn btn-info">Edit</a>
                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#moduleModal">
                        Assign Modules
                    </button>
                <h4>Currently assigned modules</h4>
                <div class="successMsg"> </div>
                <div class="bs-example">
                    <div class="accordion" id="accordionExample">
                        <c:forEach var="module" items="${tutorial.tutorialModuleTblEntities}" varStatus="ind">
                            <div class="card">
                                <div class="card-header" id="headingOne">
                                    <c:set var="cls" value="show"/>
                                    <h2 class="mb-0">
                                        <button type="button" class="btn btn-link" data-toggle="${cls}" data-target="#collapseOne${ind.count}"><i class="fa fa-plus"></i> ${module.title} :: order ${module.moduleOrder} </button>
                                    </h2>
                                    <p> <c:if test="${fn:length(module.tutStepsModuleMappingTblsById)>0}"><span class="badge badge-success">${fn:length(module.tutStepsModuleMappingTblsById)} chapters</span></c:if></p>
                                    <button type="button" class="btn btn-sm btn-primary open-chapterevent" data-toggle="modal" data-target="#addChapterModal" data-id="${module.id}">
                                        Add Chapter
                                    </button>
                                    <button type="button" class="btn btn-sm btn-danger deleteModule" data-id="${module.id}">
                                        delete module
                                    </button>
                                    <button type="button" class="btn btn-sm btn-primary identifyingClass" data-toggle="modal" data-target="#moduleModal"
                                            data-name="${module.title}" data-id="${module.id}" data-desc="${module.teaser}" data-order="${module.moduleOrder}">
                                        edit module
                                    </button>
                                </div>
                                <div id="collapseOne${ind.count}" class="${cls}" aria-labelledby="headingOne" data-parent="#accordionExample">
                                    <div class="card-body">
                                        <table class="table table-hover">
                                        <tbody>
                                            <c:forEach var="step" items="${module.tutStepsModuleMappingTblsById}" varStatus="indx">
                                                <tr class="active">
                                                    <td>
                                                            ${indx.count}
                                                    </td>
                                                    <td>
                                                            ${step.tutorialStepsTblByStepId.title}
                                                    </td>
                                                    <td>
                                                            ${step.tutorialStepsTblByStepId.contentType}
                                                    </td>
                                                    <td>

                                                            <a href="/admin/edit-step/${step.tutorialStepsTblByStepId.id}"  class=" btn btn-sm btn-danger">edit</a>
                                                            <a href="#" moduleId="${module.id}" stepId="${step.tutorialStepsTblByStepId.id}" class="deleteChapterFromModule btn btn-sm btn-danger">delete</a>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                        </table>
                                        <hr>

                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>



        </div>
        <div class="col-lg-3">
            <div class="blog-side-item">
            </div>
        </div>


    </div>

</div>



<!-- Modal -->
<div class="modal fade" id="moduleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Add/Edit Module</h5>

                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form  method="post" name="tutModule" id="tutModule" action="${pageContext.request.contextPath}/admin/tutorial/add-module">
                <div class="modal-body">
                    <p>Tutorial Name : ${tutorial.title}</p>
                    <input type="hidden" id="tutId" name="tutId" value="${tutorial.id}">
                    <input type="hidden" id="id" name="id" >
                    <div class="form-group">
                        <label for="title">Module Name</label>
                        <input type="text" class="form-control" placeholder="Module name" autofocus="" id="title" name="title">
                    </div>
                    <div class="form-group">
                        <label for="teaser">Module Name</label>
                        <input type="text" class="form-control" placeholder="Module Description" autofocus="" id="teaser" name="teaser" >
                    </div>
                    <div class="form-group">
                        <label for="moduleOrder">Module Order</label>
                        <select id="moduleOrder" name="moduleOrder" autofocus="" class="form-control">
                            <option value="">select</option>
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                            <option value="6">6</option>
                            <option value="7">7</option>
                        </select>
                    </div>



                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">submit</button>
                </div>
            </form>
        </div>
    </div>
</div><!--Add Chapter Modal -->
<div class="modal fade bd-example-modal-lg" id="addChapterModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="addChapterModalTitle">Add Step To The Module</h5>

                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>

            <form method="post" name="addChapterToModule" id="addChapterToModule" action="${pageContext.request.contextPath}/admin/es/add-steps-module">
                <div class="modal-body">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-md-6">
                                <input type="text" id="chapterTitle" name="chapterTitle" placeholder="Chapter Title" class="form-control form-control-sm"/>
                                <input type="hidden" id="tutId" name="tutId" value="${tutorial.id}"/>
                                <input type="hidden" id="moduleId" name="moduleId"/>
                            </div>
                            <div class="col-md-4">
                                <select id="contentType" name="contentType" autofocus="" class="form-control form-control-sm">
                                    <option value="both">both</option>
                                    <option value="video">video</option>
                                    <option value="post">post</option>
                                </select>
                            </div>
                            <div class="col-md-2">
                                <button class="btn btn-primary search-chapter" type="button">search</button>
                            </div>
                            <div id="chapterResults" class="col-md-12">
                                <table class="table" id="chresult">
                                    <tbody>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">submit</button>
                </div>
            </form>
        </div>
    </div>
</div>
</div>
<c:import url="/WEB-INF/views/admin/common/admin-footer.jsp"/>
    <script>
        $(document).ready(function(){
            // Add minus icon for collapse element which is open by default
            $(".collapse.show").each(function(){
                $(this).prev(".card-header").find(".fa").addClass("fa-minus").removeClass("fa-plus");
            });

            // Toggle plus minus icon on show hide of collapse element
            $(".collapse").on('show.bs.collapse', function(){
                $(this).prev(".card-header").find(".fa").removeClass("fa-plus").addClass("fa-minus");
            }).on('hide.bs.collapse', function(){
                $(this).prev(".card-header").find(".fa").removeClass("fa-minus").addClass("fa-plus");
            });

            $(document).on("click", ".search-chapter", function () {
                let title = $('#chapterTitle').val();
                let type = $('#contentType').val();
                let tutId = $('#tutId').val();
                $.ajax({
                    url: "/admin/es/get-steps?title="+title+"&type="+type+"&tutId="+tutId,
                    type: "GET",
                    headers : {
                        'Content-Type' : 'application/json'
                    },
                    success: function(response)
                    {
                        console.log("sucess!");
                        let tableBody = $('#chresult').find('tbody');
                        tableBody.empty();
                        var count = Object.keys(response).length;
                        console.log(count);
                        console.log(response);
                        if(count==0){
                            tableBody.append("<tr>"
                                +"<td><b>No Entry Found with the search criteria</b></td>"
                                +"</tr>");
                        }else{
                        $.each(response, function (index, obj) {
                            let typeIcon = "<i class='fa fa-hand-paper-o'> </i>";
                            if(obj.contentType == 'video'){
                                typeIcon = "<i class='fa fa-youtube'> </i>";
                            }
                            let added="";
                            let dis="";
                            if(obj.addedToCourse==true){
                                added = "<td><i class='fa fa-check-circle'> </i></td>";
                                dis = "disabled";
                            }
                            tableBody.append(
                                "<tr>"
                                +"<td><input type='checkbox' name='chaptersSel' id='chaptersSel' "+dis+" value='"+obj.id+"'></td>"
                                +"<td><select id='stepOrder' name='stepOrder' class='form-control form-control-sm'>"
                                +"<option value=''>select</option>"
                                +"<option value='1-"+obj.id+"'>1</option>   "
                                +"<option value='2-"+obj.id+"'>2</option>   "
                                +"<option value='3-"+obj.id+"'>3</option>     "
                                +"<option value='4-"+obj.id+"'>4</option>     "
                                +"<option value='5-"+obj.id+"'>5</option></select> "
                                +"<td>"+obj.title+"</td>"
                                +"<td>"+obj.contentType+"</td>"
                                +"<td>"+added+"</td>"
                                +"</tr>");
                               /* if(obj.addedToCourse==true){
                                    tableBody.append("<td><i class='fa fa-check-circle'> </i></td>");
                                }
                                tableBody.append("</tr>" );*/

                        });
                        }
                    },
                    error: function(e){
                        console.log("ERROR: ", e);
                    }
                });
               
            });
            $(document).on("click", ".open-chapterevent", function () {
                let moduleId = $(this).data('id');
                $('#moduleId').val( moduleId );
            });
            $(".deleteChapterFromModule").click(function() {
                let decise = confirm("Do you want to delete? Cannot undo!");
                if (decise == true) {
                    const $this    = $(this);
                    const moduleId= $this.attr("moduleId");
                    const stepId= $this.attr("stepId");
                    const url="${pageContext.request.contextPath}/admin/es/delete-step-from-module/?moduleId="+moduleId+"&stepId="+stepId;
                    console.log(url);
                    const elem = "successMsg";
                    processAjaxForm(url, elem, null);
                    alert("Deleted successfully");
                    location.reload();
                }
            });
            $(".deleteModule").click(function() {
                const decise = confirm("Do you want to delete? Cannot undo!");
                if (decise == true) {
                    const moduleId = $(this).data('id');
                    const url="${pageContext.request.contextPath}/admin/es/delete-module/?moduleId="+moduleId;
                    console.log(url);
                    let elem = "successMsg";
                    processAjaxForm(url, elem, null);
                    location.reload();//
                    window.location.reload();
                }
            });

            $('#moduleModal').on('show.bs.modal', function (event) {
                let moduleName = $(event.relatedTarget).data('name');
                $(this).find('.modal-body #title').val(moduleName);
                let id = $(event.relatedTarget).data('id');
                $(this).find('.modal-body #id').val(id);
                let teaser = $(event.relatedTarget).data('desc');
                $(this).find('.modal-body #teaser').val(teaser);
                let order = $(event.relatedTarget).data('order');
                $(this).find('.modal-body #moduleOrder').val(order);
            });


          /*  $(".identifyingClass").click(function () {
                let my_id_value = $(this).data('name');
                console.log(my_id_value);
            });*/

        });
    </script>
</body>
</html>




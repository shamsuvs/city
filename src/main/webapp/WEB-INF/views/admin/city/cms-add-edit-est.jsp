<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:useBean id="random" class="java.util.Random" scope="application" />

<!DOCTYPE html>
<html lang="en">
<head>
    <c:import url="/WEB-INF/views/admin/common/admin-head.jsp">
        <c:param name="title" value="Add New"/>
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
                                <li class="breadcrumb-item active" aria-current="page"><a href="/admin/all-est/">Establishment</a></li>
                                <li class="breadcrumb-item active" aria-current="page">Add /Edit </li>
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
                        action="${pageContext.request.contextPath}/admin/establishment/create" modelAttribute="establishment" id="establishment" name="establishment" >

                        <h2 class="form-general-heading">Add New Establishment</h2>
                        <p>Enter Details</p>
                        <form:hidden path="id"/>
                        <div class="row">
                            <div class="col-md-4 mb-3">
                                <form:label path="estName" cssClass="form-label" >Name</form:label>
                                <form:input type="text" path="estName" cssClass="form-control"/>
                            </div>
                            <div class="col-md-4 mb-3">
                                <label class="form-label">Address</label>
                                <form:input type="text" path="address" cssClass="form-control"/>
                            </div>
                            <div class="col-md-4 mb-3">
                                <label class="form-label">District</label>
                                <form:input type="text" path="district" cssClass="form-control" />
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-4 mb-3">
                                <label  class="form-label">City</label>
                                <form:select  path="city" cssClass="form-control">
                                    <form:option value="" label="select"/>
                                    <form:option value="5" label="Sultan Bathery"/>
                                </form:select>
                            </div>
                            <div class="col-md-4 mb-3">
                                <label class="form-label">Youtube URL</label>
                                <form:input type="text" path="youtubeUrl" cssClass="form-control"/>
                            </div>
                            <div class="col-md-4 mb-3">
                                <label class="form-label">State</label>
                                <form:input type="text" path="state" cssClass="form-control" />
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-4 mb-3">
                                <form:label path="mobile" cssClass="form-label" >mobile</form:label>
                                <form:input type="text" path="mobile" cssClass="form-control"/>
                            </div>
                            <div class="col-md-4 mb-3">
                                <label class="form-label">Phone</label>
                                <form:input type="text" path="phone" cssClass="form-control"/>
                            </div>
                            <div class="col-md-4 mb-3">
                                <form:label path="website" cssClass="form-label" >website</form:label>
                                <form:input type="text" path="website" cssClass="form-control" />
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6 mb-3">
                                <label class="form-label">About</label>
                                <form:textarea path="about" cssClass="form-control" rows="5"/>
                            </div>
                            <div class="col-md-6 mb-3">
                                <label class="form-label">Features (CSV)</label>
                                <form:textarea path="features" cssClass="form-control" rows="5"/>
                            </div>
                        </div>
                        <div class="row">
                            <p class="fs-xs text-muted">ensure full url</p>

                            <div class="col-md-4 mb-3">
                                <label  class="form-label">Image 1</label>
                                <form:input type="text" path="image1" cssClass="form-control"/>
                            </div>
                            <div class="col-md-4 mb-3">
                                <label class="form-label">Image2</label>
                                <form:input type="text" path="image2" cssClass="form-control"/>
                            </div>
                            <div class="col-md-4 mb-3">
                                <label class="form-label">Image3</label>
                                <form:input type="text" path="image3" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="row">

                            <div class="col-md-4 mb-3">
                                <label  class="form-label">Tags(CSV)</label>
                                <form:input type="text" path="tags" cssClass="form-control"/>
                            </div>
                            <div class="col-md-4 mb-3">
                                <label class="form-label">teaser</label>
                                <form:input type="text" path="teaser" cssClass="form-control"/>
                            </div>
                            <div class="col-md-4 mb-3">
                                <label class="form-label">specialNote</label>
                                <form:input type="text" path="specialNote" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="row">

                            <div class="col-md-4 mb-3">
                                <label  class="form-label">Category</label>
                                <form:select  path="category" cssClass="form-control">
                                    <form:option value="" label="select"/>
                                    <form:option value="technology" label="Technology"/>
                                    <form:option value="hotel" label="Hotel"/>
                                    <form:option value="hospital" label="Hospital"/>
                                    <form:option value="school" label="School"/>
                                    <form:option value="college" label="College"/>
                                    <form:option value="textile" label="Textiles"/>
                                    <form:option value="tourist-attraction" label="Tourist Attractions"/>
                                    <form:option value="temple" label="Temple"/>
                                    <form:option value="church" label="Church"/>
                                    <form:option value="mosque" label="Mosque/Masjid"/>
                                    <form:option value="shopping" label="Shopping/Mall"/>
                                    <form:option value="super-market" label="Super Market"/>
                                    <form:option value="government-office" label="Government Office"/>
                                    <form:option value="social-service" label="Social Service"/>
                                </form:select>
                            </div>
                            <div class="col-md-4 mb-3">
                                <label class="form-label">SubCategory</label>
                                <form:select  path="subCategory" cssClass="form-control">
                                    <form:option value="" label="select"/>
                                    <form:option value="restaurant" label="Restaurant"/>
                                    <form:option value="bakery" label="Bakery"/>
                                    <form:option value="multi-hos" label="Multispeciality Hospital"/>
                                    <form:option value="dental" label="Dental Care"/>
                                </form:select>
                            </div>
                            <div class="col-md-4 mb-3">
                                <label class="form-label">url</label>
                                <form:input type="text" path="url" cssClass="form-control"/>
                                <a href="#" id="genUrl" >generate</a>
                            </div>
                            <div class="col-md-4 mb-3">
                                <label class="form-label">Likes</label>
                                <form:input type="text" path="likes" cssClass="form-control"/>
                                <a href="#" id="genUrl" >generate</a>
                            </div>
                        </div>
                        <h3>Specialities</h3>
                        <c:if test="${empty id}">
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="checkbox" id="no-spec" name="no-spec">
                                <label class="form-check-label" for="no-spec">No Speciality to add</label>
                            </div>
                        <c:if test="${establishment.specialityTblsById.size() == 0}">
                                <c:set var="rlindx" value="0"/>
                                <div class="row" id="relrow0" uid="0">
                                    <div class="col-md-3 mb-3">
                                        <label class="form-label" >Name</label>
                                        <form:input type="text" path="specialityTblsById[0].name" cssClass="form-control showname" placeholder="Name"/>
                                    </div>
                                    <div class="col-md-4 mb-3">
                                        <label class="form-label" >Degree </label>
                                        <form:input type="text" path="specialityTblsById[0].degree" cssClass="form-control showd" placeholder="degree"/>

                                    </div>
                                    <div class="col-md-4 mb-3">
                                        <label class="form-label" >Speciality </label>
                                        <form:select  path="specialityTblsById[0].speciality" cssClass="form-control showsp">
                                            <form:option value="" label="select"/>
                                            <form:option value="paediatrics" label="Paediatrics"/>
                                            <form:option value="general-medicine" label="General Medicine"/>
                                            <form:option value="gynaecology" label="Obstetrics and Gynaecology"/>
                                            <form:option value="ent" label="E N T"/>
                                            <form:option value="Orthopaedics" label="Orthopaedics"/>
                                            <form:option value="Infertility" label="Infertility"/>
                                            <form:option value="Nephrologist" label="Nephrologist"/>
                                            <form:option value="Radiologist" label="Radiologist"/>
                                            <form:option value="Anesthesiology" label="Anesthesiology"/>
                                            <form:option value="Dermatology" label="Dermatology"/>
                                            <form:option value="Neurologist" label="Neurologist"/>
                                            <form:option value="Dental-Surgeon" label="Dental Surgeon"/>
                                            <form:option value="Internal-Medicine" label="Internal Medicine"/>
                                            <form:option value="Ophthalmologist" label="Ophthalmologist"/>
                                            <form:option value="Diabetologist" label="Diabetologist"/>
                                        </form:select>
                                    </div>

                                </div>
                            </c:if>
                            </c:if>


                        <c:if test="${not empty id}">
                            <c:if test="${establishment.specialityTblsById.size() > 0}">
                            <c:forEach items="${establishment.specialityTblsById}" var="spec" varStatus="rli">
                                <c:set var="rlindx" value="${rli.index}"/>

                                <div class="row" id="relrow${rlindx}" uid="0">
                                    <div class="col-md-4 mb-3">
                                        <label class="form-label" >Name${establishment.specialityTblsById.size()}</label>
                                        <form:input type="hidden" path="specialityTblsById[${rlindx}].id" cssClass="form-control showid"/>
                                        <form:input type="text" path="specialityTblsById[${rlindx}].name" cssClass="form-control showname"/>
                                    </div>
                                    <div class="col-md-4 mb-3">
                                        <label class="form-label" >Degree </label>
                                        <form:input type="text" path="specialityTblsById[${rlindx}].degree" cssClass="form-control showd"/>

                                    </div>
                                    <div class="col-md-4 mb-3">
                                        <label class="form-label" >Speciality </label>
                                        <form:select  path="specialityTblsById[${rlindx}].speciality" cssClass="form-control showsp">
                                            <form:option value="" label="select"/>
                                            <form:option value="paediatrics" label="Paediatrics"/>
                                            <form:option value="general-medicine" label="General Medicine"/>
                                            <form:option value="gynaecology" label="Gynaecology"/>
                                            <form:option value="ent" label="E N T"/>
                                            <form:option value="Orthopaedics" label="Orthopaedics"/>
                                            <form:option value="Infertility" label="Infertility"/>
                                            <form:option value="Nephrologist" label="Nephrologist"/>
                                            <form:option value="Radiologist" label="Radiologist"/>
                                            <form:option value="Anesthesiology" label="Anesthesiology"/>
                                            <form:option value="Dermatology" label="Dermatology"/>
                                            <form:option value="Neurologist" label="Neurologist"/>
                                            <form:option value="Dental-Surgeon" label="Dental Surgeon"/>
                                            <form:option value="Internal-Medicine" label="Internal Medicine"/>
                                            <form:option value="Ophthalmologist" label="Ophthalmologist"/>
                                            <form:option value="Diabetologist" label="Diabetologist"/>
                                        </form:select>

                                    </div>

                                    <a href="#"  class="remv" uid="${rlindx}">remove</a>

                                </div>
                            </c:forEach>
                            </c:if>
                        </c:if>

                        <a href="#"  id="add-spec-row" uid="0">Add New Row</a>
                        <div id="relrownew"></div>
                        <div class="row">

                            <div class="col-md-4 mb-3">
                                <form:checkbox class="form-check-input" id="customSwitch2"  path="publish"/>
                                <label class="form-check-label">Publish</label>
                            </div>
                        </div>

                            <hr>

                            <button class="btn btn-lg btn-primary" type="submit">Submit</button>
                            <button class="btn btn-lg btn-primary" type="cancel" id="cancel">Cancel</button>

                    </form:form>
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

        var cloneCount = 1;
        <c:if test="${rlindx>0}">
        cloneCount = ${rlindx + 1};
        </c:if>
        $("#add-spec-row").click(function() {
            var clone = $("#relrow0").clone();
            clone.attr("id", cloneCount);



            clone.find('.showname').attr("id",'specialityTblsById'+cloneCount+'.name');
            clone.find('.showname').attr("name",'specialityTblsById['+cloneCount+'].name');
            clone.find('.showname').attr("val",'');

            clone.find('.showd').attr("id",'specialityTblsById'+cloneCount+'.degree');
            clone.find('.showd').attr("name",'specialityTblsById['+cloneCount+'].degree');
            clone.find('.showd').attr("val",'');

            clone.find('.showsp').attr("id",'specialityTblsById'+cloneCount+'.speciality');
            clone.find('.showsp').attr("name",'specialityTblsById['+cloneCount+'].speciality');

            $('#relrownew').append(clone);


            cloneCount =cloneCount+1;

            $('html, body').animate({
                scrollTop: $("#add-spec-row").offset().top
            }, 2000);


        });

        $(".remv").click(function() {
            let id= $(this).attr("uid");
            $('#relrow'+id).find('.showname').attr("value",'todelete');

        })
        $('#genUrl').click(function(event) {
            event.preventDefault();
            let urlTxt = $("#estName").val();
            urlTxt = urlTxt.replaceAll(" ","-");
            $("#url").val($("#category").val()+"-"+urlTxt.toLowerCase());
        })
        </script>
</body>
</html>



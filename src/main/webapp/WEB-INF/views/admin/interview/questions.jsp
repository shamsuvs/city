<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: shamsudeen
  Date: 15/08/22
  Time: 12:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="bs-example" id="EntityListTable">
    <c:choose>
        <c:when test="${not empty questionList}">

        <table class="table table-hover">
            <thead>
            <thead>
            <th>
                <INPUT type="checkbox" onchange="checkAll(this)" name="entity[]" />
            </th>
            <th></th>
            <th>
                Qtn
            </th>
            <th>
                Short Answer
            </th>

            <th></th>
            <th>
                 ID
            </th>
            <th>
                action
            </th>
            </tr>
            </thead>
            </thead>
            <tbody>
            <h3>Number of items:${questionList.size()}</h3>
            <h4>Search Criteria: ${searchCriteria}</h4>
            <c:forEach var="question" items="${questionList}" varStatus="ind">

                <tr>
                    <td><input type="checkbox" name="qtnId" value="${question.id}"></td>

                    <td>
                            ${ind.count}</td>

                    <td>
                            ${question.question}


                    </td>

                    <td>
                            ${question.shortAnswer}
                    </td>
                    <td>
                            ${question.answer}
                    </td>

                    <td>
                            ${question.topic}

                    </td>


                    <td>
                        <a href="${pageContext.request.contextPath}/admin/interview-question/edit/${question.id}">edit</a>|
                        <a href="${pageContext.request.contextPath}/admin/interview-question/view/${question.id}">view</a>|
                        <a href="#" postId="${question.id}" class="deleteQuestion">delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <hr>
        <p>Select the required question from above list and click on Execute Mapping</p>
        <button class="btn btn-sm  btn-info" id="executeMapping" type="submit">Execute Mapping</button>
    </c:when>
    <c:otherwise>
        <h4>Search Criteria: ${searchCriteria}</h4>
        <div class="alert alert-danger" role="alert">

            No questions found as per your selection which not mapped(You cannot add the questions already mapped)
        </div>

    </c:otherwise>
    </c:choose>


</div>

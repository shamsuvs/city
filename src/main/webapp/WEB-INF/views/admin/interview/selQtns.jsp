<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: shamsudeen

  Time: 12:09 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<c:if test="${not empty selEntityList}">
<div class="bs-example" id="EntityListSelectedTable">
    <h3>Number of items:${selEntityList.size()}</h3>
    <table class="table table-hover">
        <tbody>
        <c:forEach var="question" items="${selEntityList}" varStatus="ind">
            <tr>
                <td>${ind.count}</td>
                <td>
                    ${question.id}
                </td>
                <td colspan="2">
                    ${question.question}
                </td>
                <td>
                   ${question.shortAnswer}
                </td>
                <td>
                   ${question.topic}
                </td>  <td>
                <c:if test="${not empty question.image and question.image ne 'not provided'}" >

                       <img src="${question.image}" width="70px" height="40px"/>

                </c:if>   </td>
                <td>
                    <a href="${pageContext.request.contextPath}/admin/interview-question/edit/${question.id}"><i class="fa fa-edit"></i> </a>
                </td><td><a href="#" qtnId="${question.id}" class="delEntityMap nav-link-style text-danger" data-bs-toggle="tooltip" title="" data-bs-original-title="Remove">
                <div class="ai-trash-2"></div></a></td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>
</c:if>

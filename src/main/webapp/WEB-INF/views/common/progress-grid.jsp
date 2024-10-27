<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: shamsudeen
  Date: 2019-09-28
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<style>
    .thumbimg{
        height: 25px;

    }
</style>
<div class="wrapper">

    <c:set var="cq" value="${sessionScope.currentExam.currentQuestion}"/>
    <c:forEach varStatus="ind" end="${totalQuest-1}" begin="0" var="questions" items="${sessionScope.currentExam.questionList}">
    <div class="box <c:if test="${ind.count eq cq}">box-current</c:if> ">
            <c:choose>
                <c:when test="${ind.count lt cq && questions.correctOptionIndex eq questions.userSelected }"><img src="/img/icons/ans-right.png" class="thumbimg"/></c:when>
                <c:when test="${ind.count lt cq && questions.correctOptionIndex ne questions.userSelected}"><img src="/img/icons/wrong.png" class="thumbimg"/></c:when>
                <c:otherwise>${ind.count}</c:otherwise>
            </c:choose>

    </div>
    </c:forEach>

</div>



<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
    <c:when test="${isMobile}">
        <c:import url="/WEB-INF/views/common/googlead/resp-banner.jsp"/>
    </c:when>
    <c:otherwise>
        <script async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
        <!-- banner -->
        <ins class="adsbygoogle"
             style="display:inline-block;width:728px;height:90px"
             data-ad-client="ca-pub-7940172394749608"
             data-ad-slot="1714975745"></ins>
        <script>
            (adsbygoogle = window.adsbygoogle || []).push({});
        </script>

    </c:otherwise>
</c:choose>




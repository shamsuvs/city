<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    track-progressa {
        margin: 0;
        padding: 0;
        overflow: hidden;
    }

    .track-progressa li {
        list-style-type: none;
        display: inline-block;

        position: relative;
        margin: 0;
        padding: 0;

        text-align: center;
        line-height: 30px;
        height: 30px;

        background-color: #f0f0f0;
    }
    
    .track-progressa[data-steps="6"] li { width: 25%; }


    .track-progressa li > span {
        display: block;

        color: #999;
        /*font-weight: bold;
        text-transform: uppercase;*/
    }

    .track-progressa li.done > span {
        color: #666;
        background-color: #71c0ff;
    }
    .track-progressa li.current > span {
        color: #666;
        background-color: #bed7ff;
    }
    .track-progressa li.current + li > span:before {
        border-left-color: #bed7ff;
    }
    .track-progressa li > span:after,
    .track-progressa li > span:before {
        content: "";
        display: block;
        width: 0px;
        height: 0px;

        position: absolute;
        top: 0;
        left: 0;

        border: solid transparent;
        border-left-color: #f0f0f0;
        border-width: 15px;
    }

    .track-progressa li > span:after {
        top: -5px;
        z-index: 1;
        border-left-color: white;
        border-width: 20px;
    }

    .track-progressa li > span:before {
        z-index: 2;
    }
    .track-progressa li.done + li > span:before {
        border-left-color: #71c0ff;
    }

    .track-progressa li:first-child > span:after,
    .track-progressa li:first-child > span:before
    
    
    {
        display: none;
    }
    .track-progressa li:first-child i,
    .track-progressa li:last-child i
    {
        display: block;
        height: 0;
        width: 0;

        position: absolute;
        top: 0;
        left: 0;

        border: solid transparent;
        border-left-color: white;
        border-width: 15px;
    }

    .track-progressa li:last-child i {
        left: auto;
        right: -15px;

        border-left-color: transparent;
        border-top-color: white;
        border-bottom-color: white;
    }
    a.theory:hover {
        color: orangered;
    }

</style>
<%--<ul id="progressq">
    <li>Open RTA file</li>
    <li class="active">RTA Theory test</li>
    <li>Parking Test</li>
    <br>
    <li>Assessment Test</li>
    <li>Final Test</li>
    <li>Owning Car</li>
</ul>--%>

Click on each topic to explore more
<ol class="track-progressa" data-steps="6">
    <li class="done">
        <span>1. Open RTA File</span>
        <i></i>
    </li><!--
--><li <c:if test="${categoryall eq 'driving-final' || categoryall eq 'drv-parking'}">class="done"</c:if>>
    <span>
        <a  href="/mock-exam/rta-theorytest/home" class="theory" >2. RTA Theory Test</a></span>
</li><!--
--><li <c:if test="${categoryall eq 'driving-final'}">class="done"</c:if> <c:if test="${categoryall eq 'drv-parking'}">class="current"</c:if>>
    <span > <a  href="/mock-exam/drv-parking/home" class="theory" >3. Parking Test</a></span>
    <i></i>
</li><li <c:if test="${categoryall eq 'driving-final'}">class="done"</c:if>>
    <span> <a  href="/mock-exam/driving-final/home" class="theory" >4. Assessment Test</a></span>
    <i></i>
</li><li>
    <span> <a  href="/mock-exam/driving-final/home" class="theory" >5. Final Test</a></span>
    <i></i>
</li><li>
    <span> <a  href="/blog/post/3494399274693059971/Owning_a_Car_in_dubai_-_Essential_Guide" class="theory" >6. Owning Car</a></span>
    <i></i>
</li>
</ol>
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">
                    Opened RTA file
                    
                </h5>

                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>Congratulation on your first step of opening RTA file. We have consolidated lot of resources to smooth your driving license journey
                    All the best.</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
            </div>
        </div>
    </div>
</div>


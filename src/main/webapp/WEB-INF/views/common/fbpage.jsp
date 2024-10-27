<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="blog-post">

        <p class="text-center">
        <ul class="social-link-footer list-unstyled">
            <div id="fb-root">
            </div>
            <script>(function(d, s, id) {
                var js, fjs = d.getElementsByTagName(s)[0];
                if (d.getElementById(id)) return;
                js = d.createElement(s); js.id = id;
                js.src = "//connect.facebook.net/en_US/sdk.js#xfbml=1&appId=851036458272763&version=v2.0";
                fjs.parentNode.insertBefore(js, fjs);
            }(document, 'script', 'facebook-jssdk'));</script>
            <div class="fb-like-box" data-colorscheme="light" data-header="true" data-href="https://www.facebook.com/smashplus4u" data-show-border="true" data-show-faces="false" data-stream="false">
            </div>
        </ul>
        </p>
</div>


<script>
    window.fbAsyncInit = function() {
        FB.init({
            appId      : '554874832817624',
            cookie     : true,
            xfbml      : true,
            version    : '{api-version}'
        });

        FB.AppEvents.logPageView();

    };

    (function(d, s, id){
        var js, fjs = d.getElementsByTagName(s)[0];
        if (d.getElementById(id)) {return;}
        js = d.createElement(s); js.id = id;
        js.src = "https://connect.facebook.net/en_US/sdk.js";
        fjs.parentNode.insertBefore(js, fjs);
    }(document, 'script', 'facebook-jssdk'));
</script>

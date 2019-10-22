index = {

};
$(function () {
    $('#my-dropdown').sSelect('');
    $('#my-dropdownCountries').sSelect({ddMaxHeight: '300px'});

    function MM_jumpMenu(targ, selObj, restore) { //v3.0
        eval("window.open('" + selObj.options[selObj.selectedIndex].value + "')");
        $("#my-dropdown option").eq(0).attr("selected", "selected");
    }

    window.onload = window.onresize = window.onscroll = function () {
        var oBox = document.getElementById("divQQbox");
        var oLine = document.getElementById("divOnline");
        var iScrollTop = document.documentElement.scrollTop || document.body.scrollTop;
        setTimeout(function () {
            clearInterval(oBox.timer);
            var iTop = parseInt((document.documentElement.clientHeight - oBox.offsetHeight) / 2) + iScrollTop;
            oBox.timer = setInterval(function () {
                var iSpeed = (iTop - oBox.offsetTop) / 8;
                iSpeed = iSpeed > 0 ? Math.ceil(iSpeed) : Math.floor(iSpeed);
                oBox.offsetTop == iTop ? clearInterval(oBox.timer) : (oBox.style.top = oBox.offsetTop + iSpeed + "px");
            }, 30)
        }, 100)
    };

    function CloseQQ() {
        divQQbox.style.display = "none";
        return true;
    }
});
var basePath = "/gyd/";
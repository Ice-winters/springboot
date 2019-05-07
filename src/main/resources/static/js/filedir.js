window.onload = function (ev) {
    var lookupdir = document.getElementById("lookUpDira");
    var textpath = lookupdir.innerText;
    lookupdir.onclick = function (ev) {
        // window.open("file:///"+textpath.trim());
        // window.location.href = "";
        window.location="http://localhost/users";
    }
}

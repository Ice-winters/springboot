var lookupdir = document.getElementById("lookUpDir");
lookupdir.onclick = function (ev) {
    window.open("file:///"+lookupdir.text,"target");
}
window.onload = function (ev) {

    var btn_submit = document.getElementById("btn_submit");
    btn_submit.addEventListener("click", function (ev1) {


        var formEle = document.getElementById("mul_form");

        var formData = new FormData(formEle);

        var httpRequest = new XMLHttpRequest();
        httpRequest.open("POST", "/file/upload_2");

        httpRequest.onload = function (ev2) {
            if (httpRequest.status == 200) {
                console.log(httpRequest.responseText);


            } else {

            }

        }
        httpRequest.send(formData);


    })

}
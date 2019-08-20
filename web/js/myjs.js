function validForm() {
    var n = document.forms["loginform"]["USERNAME"].value;
    var p = document.forms["loginform"]["PASSWORD"].value;
    if (n == "") {
        alert("USERNAME cannot be blank");
        return false;
    }
    if (p == "") {
        alert("Password cannot be blank");
        return false;
    }
}
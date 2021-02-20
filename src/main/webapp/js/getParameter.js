function getParameter(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = location.search.slice(1).match(reg);

    if (r != null) return (r[2]);
    return null;
}
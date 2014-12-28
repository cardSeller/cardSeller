function pagination(result, total, pagesize) {
    var pageIndex = $("#pageIndex").val();
    var pageNumber = total / pagesize;
    if (pageNumber > 1) {
        pageNumber = Math.ceil(pageNumber);
    } else {
        pageNumber = Math.floor(pageNumber);
    }
    if (pageNumber > 1) {
        var prevstr = "";
        var nextstr = "";
        var pagestr = "";
        if (pageNumber == pageIndex) {
            prevstr = "<li><a href='javascript:void(0)' onclick='prev()'><span class='glyphicon glyphicon-chevron-left'></span></a></li>";
            nextstr = "<li class=\"disabled\"><a href=\"javascript:void(0);\"><span class='glyphicon glyphicon-chevron-right'></span></a></li>";
        } else if (pageIndex == 1) {
            prevstr = "<li class=\"disabled\"><a href=\"javascript:void(0);\"><span class='glyphicon glyphicon-chevron-left'></span></a></li>";
            nextstr = "<li><a href='javascript:void(0)' onclick='next()'><span class='glyphicon glyphicon-chevron-right'></span></a></li>";
        } else {
            prevstr = "<li><a href='javascript:void(0)' onclick='prev()'><span class='glyphicon glyphicon-chevron-left'></span></a></li>";
            nextstr = "<li><a href='javascript:void(0)' onclick='next()'><span class='glyphicon glyphicon-chevron-right'></span></a></li>";
        }
        if (pageNumber > 8) {
            var pagetemp = "";
            for (var i = 1; i <= pageNumber; i++) {
                if (i == pageIndex) {
                    pagetemp += "<li class=\"active\"><a href=\"javascript:void(0)\">" + i + "<span class=\"sr-only\">(current)</span></a></li>";
                } else if (i < pageIndex) {
                    var count = 2;
                    if (pageIndex == pageNumber) {
                        count = 3;
                    }
                    if (pageIndex - i < count) {
                        pagetemp += "<li><a href='javascript:void(0)' onclick='currentPage(" + i + ")'>" + i + "</a></li>";
                    }
                } else {
                    var count = 2;
                    if (pageIndex == 1) {
                        count = 3;
                    }
                    if (i - pageIndex < count) {
                        pagetemp += "<li><a href='javascript:void(0)' onclick='currentPage(" + i + ")'>" + i + "</a></li>";
                    }
                }
            }
            if (pageIndex <= 3) {
                if (pageIndex == 3) {
                    pagetemp = "<li><a href='javascript:void(0)' onclick='currentPage(1)'>" + 1 + "</a></li>" + pagetemp;
                }
                pagestr += pagetemp + "<li><a href='javascript:void(0)'>......</a></li>" + "<li><a href='javascript:void(0)' onclick='currentPage(" + (pageNumber - 1) + ")'>" + (pageNumber - 1) + "</a></li>" + "<li><a href='javascript:void(0)' onclick='currentPage(" + pageNumber + ")'>" + pageNumber + "</a></li>";
            } else if (pageIndex > pageNumber - 3) {
                if (pageIndex == pageNumber - 2) {
                    pagetemp += "<li><a href='javascript:void(0)' onclick='currentPage(" + pageNumber + ")'>" + pageNumber + "</a></li>";
                }
                pagestr += "<li><a href='javascript:void(0)' onclick='currentPage(1)'>" + 1 + "</a></li>" + "<li><a href='javascript:void(0)' onclick='currentPage(2)'>" + 2 + "</a></li>" + "<li><a href='javascript:void(0)'>......</a></li>" + pagetemp;
            } else {
                pagestr += "<li><a href='javascript:void(0)' onclick='currentPage(1)'>" + 1 + "</a></li>" + "<li><a href='javascript:void(0)'>...</a></li>" + pagetemp + "<li><a href='javascript:void(0)'>...</a></li>" + "<li><a href='javascript:void(0)' onclick='currentPage(" + pageNumber + ")'>" + pageNumber + "</a></li>";
            }
        } else {
            for (var i = 1; i <= pageNumber; i++) {
                if (i == pageIndex) {
                    pagestr += "<li class=\"active\"><a href=\"javascript:void(0)\">" + i + "<span class=\"sr-only\">(current)</span></a></li>";
                } else {
                    pagestr += "<li><a href='javascript:void(0)' onclick='currentPage(" + i + ")'>" + i + "</a></li>";
                }
            }
        }
        var inputSearch = "<div class='page-number-search left'><input class='form-control' type=\"text\" id=\"inputSearchNumber\"/></div><a class='btn btn-primary' href=\"javascript:inputSearch(" + pageNumber + ");\">确&nbsp;定</a>";
        $("#pager").html("<ul class=\"pagination left\">" + prevstr + pagestr + nextstr + "</ul>" + inputSearch);
    }
    if (result != null && result.length > 0) {
        var sInnerHtml = [];
        for (var i = 0; i < result.length; i++) {
            sInnerHtml.push("<tr class=\"\" id=\"tr_" + i + "\">");
            for (var j = 0; j < result[i].length; j++) {
                if (j == 0) {
                    sInnerHtml.push("<td id='td_key_" + i + "'>");
                } else {
                    sInnerHtml.push("<td>");
                }
                sInnerHtml.push(result[i][j]);
                sInnerHtml.push("</td>");
            }
            sInnerHtml.push("</tr>");
        }
        $("#resultList").html(sInnerHtml.join(""));
        $("#totalNumberMsg").show();
    }
}

function prev() {
    var pageIndex = $("#pageIndex").val();
    $("#pageIndex").val(Number(pageIndex) - Number(1));
    search();
}

function next() {
    var pageIndex = $("#pageIndex").val();
    $("#pageIndex").val(Number(pageIndex) + Number(1));
    search();
}

function currentPage(currentNum) {
    $("#pageIndex").val(currentNum);
    search();
}

function inputSearch(pageNumber) {
    var inputSearchNumber = $("#inputSearchNumber").val();
    if (inputSearchNumber == '' || !/^[0-9]*$/.test(inputSearchNumber) || Number(inputSearchNumber) > Number(pageNumber)) {
        return;
    }
    $("#pageIndex").val(inputSearchNumber);
    search();
}

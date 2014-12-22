function format(time, format) {
    var arr = {
        "M+": time.getMonth() + 1, //month
        "d+": time.getDate(), //day
        "h+": time.getHours(), //hour
        "m+": time.getMinutes(),
        "s+": time.getSeconds()
    };
    if (/(y+)/.test(format)) {
        format = format.replace(RegExp.$1, (time.getFullYear() + "").substr(4 - RegExp.$1.length));
    }
    for (var k in arr) {
        if (new RegExp("(" + k + ")").test(format)) {
            format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? arr[k] : ("00" + arr[k]).substr(("" + arr[k]).length));
        }
    }
    return format;
}

String.prototype.toDate = function () {
    var temp = this.toString();

    temp = temp.replace(/-/g, "/");

    var date = new Date(Date.parse(temp));

    return date;
}

String.prototype.toDateTime = function () {
    var date = eval('new Date(' + this.replace(/\d+(?=-[^-]+$)/,
        function (a) {
            return parseInt(a, 10) - 1;
        }).match(/\d+/g) + ')');
    return date;
}

String.prototype.trim = function () {
    return this.replace(/(^\s*)|(\s*$)/g, "");
}
String.prototype.ltrim = function () {
    return this.replace(/(^\s*)/g, "");
}
String.prototype.rtrim = function () {
    return this.replace(/(\s*$)/g, "");
}

jQuery(function ($) {
    $.datepicker.regional['zh-CN'] = {
        clearText: '清除',
        clearStatus: '清除已选日期',
        closeText: '关闭',
        closeStatus: '不改变当前选择',
        prevText: '<上月',
        prevStatus: '显示上月',
        prevBigText: '<<',
        prevBigStatus: '显示上一年',
        nextText: '下月>',
        nextStatus: '显示下月',
        nextBigText: '>>',
        nextBigStatus: '显示下一年',
        currentText: '今天',
        currentStatus: '显示本月',
        monthNames: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月'],
        monthNamesShort: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月'],
        monthStatus: '选择月份',
        yearStatus: '选择年份',
        weekHeader: '周',
        weekStatus: '年内周次',
        dayNames: ['星期日', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六'],
        dayNamesShort: ['周日', '周一', '周二', '周三', '周四', '周五', '周六'],
        dayNamesMin: ['日', '一', '二', '三', '四', '五', '六'],
        dayStatus: '设置 DD 为一周起始',
        dateStatus: '选择 m月 d日, DD',
        dateFormat: 'yy-mm-dd',
        firstDay: 1,
        initStatus: '请选择日期',
        isRTL: false};
    $.datepicker.setDefaults($.datepicker.regional['zh-CN']);
});


function viewCityByCountryId(object, citySelect) {
    var id = $(object).val();
    var cityBox = $("#" + citySelect).closest(".city-box");
    if (id == "") {
        cityBox.find(".city-list").html("<li class='null-city-list'>请先选择国家</li>");
        cityBox.find(".city-name").text("请选择城市");
        $("#" + citySelect).val("");
        return;
    }
    $.ajax({
        type: "POST",
        url: golbalRootUrl + "/common/getCityList",
        data: "countryId=" + id,
        async: false,
        success: function (data) {
            cityBox.find(".city-list").html("");
            $("#" + citySelect).val("");
            var cityList = data.cityList;
            if (cityList.length > 0) {
                cityBox.find(".city-name").text("请选择城市");
                for (var i = 0; i < cityList.length; i++) {
                    cityBox.find(".city-list").append("<li onclick='selectMyCity(this)' id='city_" + cityList[i].id + "' value='" + cityList[i].id + "'>" + cityList[i].chineseName + "</li>");
                }
            } else {
                cityBox.find(".city-list").html("<li class='null-city-list'>请先选择国家</li>");
                cityBox.find(".city-name").text("请选择城市");
                $("#" + citySelect).val("");
            }

        }
    });
}

function viewCountryByContinentId(object, countrySelect, citySelect) {
    var id = $(object).val();
    var cityBox = $("#" + citySelect).closest(".city-box");
    if (id == "") {
        $("#" + countrySelect).find("option").remove();
        cityBox.find(".city-list").html("<li class='null-city-list'>请先选择国家</li>")
        cityBox.find(".city-name").text("请选择城市");
        $("<option id='country_0' value=''>请选择国家</option>").appendTo("#" + countrySelect);
        return;
    }
    $.ajax({
        type: "POST",
        url: golbalRootUrl + "/common/getCountryList",
        data: "continentId=" + id,
        async: false,
        success: function (data) {
            var countryList = data.countryList;
            $("#" + countrySelect).find("option").remove();
            $("<option id='country_0' value=''>请选择国家</option>").appendTo("#" + countrySelect);
            cityBox.find(".city-list").html("<li class='null-city-list'>请先选择国家</li>")
            cityBox.find(".city-name").text("请选择城市");
            $("#" + citySelect).val("");
            if (countryList.length > 0) {
                for (var i = 0; i < countryList.length; i++) {
                    $("<option id='country_" + countryList[i].id + "' value='" + countryList[i].id + "'>" + countryList[i].chineseName + "</option>").appendTo("#" + countrySelect);
                }
            }

        }
    });
}

function viewCityByCountryIdForConsumerTerminal(object, citySelect) {
    var id = $(object).val();
    var cityBox = $("#" + citySelect).closest(".city-box");
    cityBox.find(".city-name").text("请选择城市");
    if (id == "") {
        cityBox.find(".city-list").html("<li class='null-city-list'>请先选择国家</li>")
        cityBox.find(".city-name").text("请选择城市");
        $("#" + citySelect).val("");
        return;
    }
    $.ajax({
        type: "POST",
        url: golbalRootUrl + "/common/getCityList",
        data: "countryId=" + id,
        async: false,
        success: function (data) {
            var cityList = data.cityList;
            cityBox.find(".city-list").html("");
            $("#" + citySelect).val("");
            if (cityList.length > 0) {
                for (var i = 0; i < cityList.length; i++) {
                    cityBox.find(".city-list").append("<li onclick='selectMyCity(this)' id='city_" + cityList[i].id + "' value='" + cityList[i].id + "'>" + cityList[i].chineseName + "</li>");
                }
            }
        }
    });
}

function viewItemCountryByContinentId() {
    var id = $("#continentId").val();
    $.ajax({
        type: "POST",
        url: golbalRootUrl + "/common/getItemCountryList",
        data: "continentId=" + id,
        async: false,
        success: function (data) {
            var countryList = data.countryList;
            $("#countryId").find("option").remove();
            $("<option value=''>无</option>").appendTo("#countryId");
            for (var i = 0; i < countryList.length; i++) {
                $("<option value='" + countryList[i].id + "'>" + countryList[i].chineseName + "</option>").appendTo("#countryId");
            }
            var cityList = data.cityList;
            $("#cityId").find("option").remove();
            $("<option value=''>无</option>").appendTo("#cityId");
            for (var i = 0; i < cityList.length; i++) {
                $("<option value='" + cityList[i].id + "'>" + cityList[i].chineseName + "</option>").appendTo("#cityId");
            }
        }
    });
}

function viewItemCityByContinentId() {
    var continentId = $("#continentId").val();
    var countryId = $("#countryId").val();
    $.ajax({
        type: "POST",
        url: golbalRootUrl + "/common/getItemCityListForContinent",
        data: {continentId: continentId, countryId: countryId},
        async: false,
        success: function (data) {
            var cityList = data.cityList;
            $("#cityId").find("option").remove();
            $("<option value=''>无</option>").appendTo("#cityId");
            for (var i = 0; i < cityList.length; i++) {
                $("<option value='" + cityList[i].id + "'>" + cityList[i].chineseName + "</option>").appendTo("#cityId");
            }
        }
    });
}

function viewItemCityByCountryId() {
    var id = $("#countryId").val();
    $.ajax({
        type: "POST",
        url: golbalRootUrl + "/common/getItemCityList",
        data: "countryId=" + id,
        async: false,
        success: function (data) {
            var cityList = data.cityList;
            $("#cityId").find("option").remove();
            $("<option value=''>无</option>").appendTo("#cityId");
            for (var i = 0; i < cityList.length; i++) {
                $("<option value='" + cityList[i].id + "'>" + cityList[i].chineseName + "</option>").appendTo("#cityId");
            }
        }
    });
}

function selectMyCity(object) {
    $(object).closest(".city-box").find("div.error-msg").remove();
    $(object).closest(".city-box").find("input").val($(object).val());
    $(object).closest(".city-box").find(".city-name").text($(object).text());
    $(object).addClass("selected").siblings().removeClass("selected");
}

String.prototype.replaceAll = function (reallyDo, replaceWith, ignoreCase) {
    if (!RegExp.prototype.isPrototypeOf(reallyDo)) {
        return this.replace(new RegExp(reallyDo, (ignoreCase ? "gi" : "g")), replaceWith);
    } else {
        return this.replace(reallyDo, replaceWith);
    }
}

String.prototype.endsWith = function (suffix) {
    return  this.indexOf(suffix, this.length - suffix.length) != -1;
};

function processData(object) {
    if (object == null) {
        return "";
    }
    return object;
}

function checkUploadInfo(uploadObject, messageObject, type, message) {
    var uploadInfo = uploadObject.val();
    if (uploadInfo == null || uploadInfo == '') {
        messageObject.html("请上传文件").addClass("error-msg");
//        messageObject.parent().find(".upload-files-hint").removeAttr("style").html("请上传文件");
        return false;
    }
    if (type == "excel") {
        if (null != uploadInfo && (".xls" != uploadInfo.substring(uploadInfo.length - 4) && ".xlsx" != uploadInfo.substring(uploadInfo.length - 5))) {
            messageObject.html(message).addClass("error-msg");
            return false;
        }
    }
    if (type == "word") {
        if (null != uploadInfo && (".doc" != uploadInfo.substring(uploadInfo.length - 4) && ".docx" != uploadInfo.substring(uploadInfo.length - 5))) {
            messageObject.html(message).addClass("error-msg");
            return false;
        }
    }
    if (type == "jpg") {
        if (null != uploadInfo && (".jpg" != uploadInfo.substring(uploadInfo.length - 4) && ".jpeg" != uploadInfo.substring(uploadInfo.length - 5))) {
            messageObject.html(message).addClass("error-msg");
            return false;
        }
    }
    if (type == "pdf") {
        if (null != uploadInfo && (".pdf" != uploadInfo.substring(uploadInfo.length - 4))) {
            messageObject.html(message).addClass("error-msg");
            return false;
        }
    }
    return true;
}

function getAllCheckedValue(id) {
    return $(id + ' input:checkbox:checked').map(function () {
        return this.value;
    }).get();
}

function delayURL(url, time) {
    setTimeout("top.location.href = '" + url + "'", time);
}

function viewFile(fileName, fileUrl) {
    if (fileName.endsWith(".pdf") || fileUrl.endsWith(".pdf")) {
        BasisFixedSizePopupWindow(900, 700, fileUrl, true, null, '', '', ' contract-pdf-box')
    } else if (fileName.endsWith(".jpg") || fileName.endsWith(".jpeg") || fileUrl.endsWith(".jpg")) {
        BasisImagePopupWindow(fileUrl, 800, '', true)
    } else {
        var suffix = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length);
        alertErrorMsgPopups("不能预览 " + suffix + " 类型文件");
    }
}
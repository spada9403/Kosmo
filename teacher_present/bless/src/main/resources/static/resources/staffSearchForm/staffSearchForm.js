var sortId;
$(document).ready(function () {
  $("[name=staffGender]").change(function () {
    $(this).siblings(":checked").prop("checked", false);
  });
  $("body").keydown(function (e) {
    if (e.keyCode == 13) {
      e.preventDefault();
      search();
    }
  });
  $(".search").click(function () {
    search();
  });
  $(".allSearch").click(function () {
    $(".reset").click();
    $(".sort").val("");
    search();
  });
  $(".insert").click(function () {
    location.replace("/staff_input_form.do");
  });
  $(".rowCntPerPage").change(function () {
    $("[name=selectPage]").val("1");
    search();
  });
  $(".reset").click(function () {
    var option = `<option value=""></option>`;
    var gradDay1 = $("[name=staffGradDay_start]");
    var gradDay2 = $("[name=staffGradDay_end]");
    gradDay1.not(":eq(0)").html(option);
    gradDay2.not(":eq(0)").html(option);
    gradDay1.not(":eq(0)").prop("disabled", true);
    gradDay2.not(":eq(0)").prop("disabled", true);
  });
  var gradDayObj = $("[name^=staffGradDay]");
  gradDayObj.change(function () {
    var obj = $(this);
    if (obj.index() == 0 || obj.index() == 3) {
      var yearObj = obj;
      var monthObj = yearObj.next();
      if (obj.index() == 0) {
        gradDayObj.eq(1).prop("disabled", false);
        gradDayObj.eq(2).prop("disabled", false);
      }
      if (obj.index() == 3) {
        gradDayObj.eq(4).prop("disabled", false);
        gradDayObj.eq(5).prop("disabled", false);
      }
      setGradMonth(yearObj, monthObj);
      monthObj.find("option").eq(1).prop("selected", true);
      setGradDay(yearObj, monthObj);
    }
    if (obj.index() == 1 || obj.index() == 4) {
      var monthObj = obj;
      var yearObj = monthObj.prev();
      setGradDay(yearObj, monthObj);
    }
  });
  if ($(".staffList").length > 0) {
    successSearchEvent();
  }
});
function setGradMonth(yearObj, monthObj) {
  var option = "<option value='' ></option>";
  for (var i = 0; i < 12; i++) {
    var value = i + 1;
    if (value < 10) {
      value = `0${value}`;
    }
    option += `<option value="${value}" >${value}</option>`;
  }
  monthObj.html(option);
  setGradDay(yearObj, monthObj);
}
function setGradDay(yearObj, monthObj) {
  var option = "<option value='' ></option>";
  var gradDayObj = monthObj.next();
  var year = yearObj.val();
  year = parseInt(year, 10);
  var month = monthObj.val();
  month = parseInt(month, 10);
  var date = new Date(year, month);
  date.setDate(date.getDate() - 1);
  var max_index = date.getDate();
  for (var i = 0; i < max_index; i++) {
    var value = i + 1;
    if (value < 10) {
      value = `0${value}`;
    }
    option += `<option value="${value}" >${value}</option>`;
  }
  gradDayObj.html(option);
}
function search() {
  $.ajax({
    url: "/staff_search_form.do",
    type: "post",
    data: $("[name=staffSearchForm]").serialize(),
    success: function (responseHTML) {
      var msg = $.trim($(responseHTML).filter(".msg").text());
      if (msg != null && msg.length > 0) {
        alert(msg);
        return;
      }
      $(".staffListBox").html($(responseHTML).find(".staffListBox").html());
      successSearchEvent();
    },
    error: function (e) {
      alert("에러 발생! 서버관리자에게 문의하세요.");
    },
  });
}
function successSearchEvent() {
  $(".pointer").click(function () {
    var id = $(this).attr("id");
    $("[ name=selectPage]").val(id);
    search();
  });
  $(".upDelButton").click(function () {
    var id = $(this).attr("id");
    $("[name=staffNo]").val(id);
    document.staffUpDelForm.submit();
  });
  sortRow();
  var sort = $(".sort").val();
  if (sort == `${sortId} asc`) {
    $(`#${sortId}`).append("▲");
  } else if (sort == `${sortId} desc`) {
    $(`#${sortId}`).append("▼");
  }
}
function sortRow() {
  $(".selectPageNo").val(1);
  $(".sortRow").css("cursor", "pointer");
  $(".sortRow").click(function () {
    var obj = $(this);
    var text = $.trim(obj.text());
    sortId = $.trim(obj.attr("id"));
    if (text.indexOf("▲") >= 0) {
      $(".sort").val("");
    } else if (text.indexOf("▼") >= 0) {
      $(".sort").val(`${sortId} asc`);
    } else {
      $(".sort").val(`${sortId} desc`);
    }
    search();
  });
}

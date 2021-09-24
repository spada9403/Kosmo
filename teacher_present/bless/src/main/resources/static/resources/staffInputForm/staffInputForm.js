$(document).ready(function () {
  $(".confirm").click(function () {
    validData();
  });
  $("[name=staffSchool]").click(function () {
    $(this).siblings().prop("checked", false);
  });
  $(".toList").click(function () {
    location.replace("/staff_search_form.do");
  });
  var gradDayObj = $("[name=staffGradDay]");
  gradDayObj.change(function () {
    var obj = $(this);
    if (obj.index() == 0) {
      var yearObj = obj;
      var monthObj = yearObj.next();
      gradDayObj.eq(1).prop("disabled", false);
      gradDayObj.eq(2).prop("disabled", false);
      setGradMonth(yearObj, monthObj);
      monthObj.find("option").eq(1).prop("selected", true);
      setGradDay(yearObj, monthObj);
    }
    if (obj.index() == 1) {
      var monthObj = obj;
      var yearObj = monthObj.prev();
      setGradDay(yearObj, monthObj);
    }
  });
  $(".reset").click(function () {
    var option = `<option value="">`;
    var gradDayObj = $("[name=staffGradDay]");
    gradDayObj.not(":first-child").html(option);
    gradDayObj.not(":first-child").prop("disabled", true);
  });
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
  for (var i = 0; i < date.getDate(); i++) {
    var value = i + 1;
    if (value < 10) {
      value = `0${value}`;
    }
    option += `<option value="${value}" >${value}</option>`;
  }
  gradDayObj.html(option);
}
function validData() {
  var staffName = $("[name=staffName]");
  var staffJumin_no = $("[name=jumin_no]");
  var religion = $("[name=religion]");
  var staffSchool = $("[name=staffSchool]");
  var staffSkill = $("[name=staffSkill]").filter(":checked");
  var staffGradDay = $("[name=staffGradDay]");
  if (isEmpty(staffName.val()) || regExp(staffName.val(), /[가-힣]{2,10}/) == false) {
    alert("이름은 한글만 작성 가능합니다.");
    staffName.val("");
    staffName.focus();
    return;
  }
  var jumin1 = staffJumin_no.eq(0);
  var jumin2 = staffJumin_no.eq(1);
  if ((jumin1.val() == "" && jumin1.val().length == 0) || (jumin2.val() == "" && jumin2.val().length == 0)) {
    alert("주민번호를 입력해 주세요.");
    jumin1.focus();
    return;
  }
  if (regExp(jumin1.val(), /\d{2}([0]\d|[1][0-2])([0][1-9]|[1-2]\d|[3][0-1])/) == false) {
    alert("잘못된 주민번호 입니다");
    jumin1.val("");
    jumin2.val("");
    jumin1.focus();
    return;
  }
  if (regExp(jumin2.val(), /[1-4]\d{6}/) == false) {
    alert("잘못된 주민번호 입니다");
    jumin2.val("");
    jumin2.focus();
    return;
  }
  var date = new Date();
  var jumin_year = "";
  var jumin_no2FirstNo = jumin2.val().substring(0, 1);
  if (jumin_no2FirstNo == "1" || jumin_no2FirstNo == "2") {
    if (parseInt(jumin1.val().substring(0, 2), 10) < 100) {
      alert("잘못된 주민번호 입니다");
      jumin1.val("");
      jumin2.val("");
      jumin1.focus();
    }
    jumin_year = "19" + jumin1.val().substring(0, 2);
  } else if (jumin_no2FirstNo == "3" || jumin_no2FirstNo == "4") {
    if (parseInt(jumin1.val().substring(0, 2), 10) > 0) {
      alert("잘못된 주민번호 입니다");
      jumin1.val("");
      jumin2.val("");
      jumin1.focus();
    }
    jumin_year = "20" + jumin1.val().substring(0, 2);
  } else {
    alert("잘못된 주민번호 입니다");
    jumin1.val("");
    jumin2.val("");
    jumin1.focus();
    return;
  }
  var sysYear = date.getFullYear();
  if (sysYear < parseInt(jumin_year, 10)) {
    alert("잘못된 주민번호 입니다");
    jumin1.val("");
    jumin2.val("");
    jumin1.focus();
    return;
  } else if (sysYear - parseInt(jumin_year, 10) > 80) {
    alert("잘못된 주민번호 입니다");
    jumin1.val("");
    jumin2.val("");
    jumin1.focus();
    return;
  } else if (sysYear - parseInt(jumin_year, 10) > 21) {
    alert("우리 회사는 미성년자를 받지 않습니다.");
    jumin1.val("");
    jumin1.focus();
  }
  if (isEmpty(religion.val())) {
    alert("종교를 선택해 주세요.");
    religion.focus();
    return;
  }
  if (staffSchool.filter(":checked").length == 0) {
    alert("학력을 선택해 주세요.");
    return;
  }
  if (staffSkill.filter(":checked").length == 0) {
    alert("기술 중 1개 이상을 선택해주세요.");
    return;
  }
  for (var i = 0; i < staffGradDay.length; i++) {
    var gardDay = staffGradDay.eq(i).val();
    if (isEmpty(gardDay)) {
      alert("졸업 년 / 월 / 일 을 입력해 주세요.");
      return;
    }
  }
  if (confirm("정말 등록 하시겠습니까?")) {
    insert();
  }
}
function regExp(str, reg) {
  var regExp = new RegExp(reg);
  return regExp.test(str);
}
function isEmpty(str) {
  var flag = false;
  if (str == null || str.split(" ").join("") == "") {
    flag = true;
  }
  return flag;
}
function insert() {
  $.ajax({
    URL: "/staff_insert_Form.do",
    type: "post",
    data: $("[name=staffInputForm]").serialize(),
    success: function (json) {
      var msg = json.msg;
      if (msg != null && msg.length > 0) {
        alert(msg);
        return;
      }
      alert("등록 성공!");
      if (confirm("목록으로 이동하시겠습니까?")) {
        location.replace("/staff_search_form.do");
      }
    },
    error(e) {
      alert("에러 발생!!");
      console.log(e);
    },
  });
}

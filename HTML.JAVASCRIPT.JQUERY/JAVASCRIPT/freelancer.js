function checkForm() {
  var table = document.freerancerForm;
  var resume_year = table.resume_year.value;
  var resume_month = table.resume_month.value;
  var resume_day = table.resume_day.value;
  var name = table.name.value;
  var gender = table.gender;
  var birthday_year = table.birthday_year.value;
  var phone_num = table.phone_num.value;
  var email = table.email.value;
  var Addr_city = table.Addr_city.value;
  var Addr_city2 = table.Addr_city2.value;
  var finalSchool = table.finalSchool;
  var freeDevExp_year = table.freeDevExp_year.value;
  var freeDevExp_month = table.freeDevExp_month.value;
  var minSalary = table.minSalary.value;
  var maxSalary = table.maxSalary.value;
  var parleyLater = table.parleyLater;
  var qualifications = table.qualifications;
  var endOfProject_year = table.endOfProject_year.value,
    endOfProject_month = table.endOfProject_month.value,
    endOfProject_day = table.endOfProject_day.value,
    endOfProject_confirm = table.endOfProject_confirm;
  var description = table.description.value;
  var doNotDev = table.doNotDev;
  var devSkill = table.devSkill;
  var expField = table.expField;

  if (resume_year == "" || resume_month == "" || resume_day == "") {
    alert("이력서 등록일을 선택해주세요");
    return;
  }
  if (isEmpty(name)) {
    alert("이름을 입력해주세요");
    return;
  }
  if (checked(gender) < 1) {
    alert("성별을 선택해주세요.");
    return;
  }
  if (isEmpty(birthday_year)) {
    alert("출생년도를 선택해주세요");
    return;
  }
  if (regexp(/^01([0|1|6|7|8|9])([0-9]{3,4})([0-9]{4})$/, phone_num)) {
    alert("핸드폰 번호를 '-'없이 입력해주세요.");
    return;
  }
  if (regexp(/^[0-9a-zA-Z]*\@[0-9a-zA-Z]*\.[a-z]{2,3}$/, email)) {
    alert("이매일을 입력해주세요.");
    return;
  }
  if (isEmpty(Addr_city) || isEmpty(Addr_city2)) {
    alert("거주지를 입력해주세요.");
    return;
  }
  if (checked(finalSchool) < 1) {
    alert("학력을 선택해주세요");
    return;
  }
  if (isEmpty(freeDevExp_month) || isEmpty(freeDevExp_year)) {
    alert("개발 경력을 선택해주세요.");
    return;
  }
  if (checked(parleyLater) < 1) {
    if (isEmpty(minSalary) || isEmpty(maxSalary)) {
      alert("원하시는 연봉을 선택해주세요");
      return;
    }
  }
  if (checked(qualifications) < 1) {
    alert("자격증을 1개 이상 선택해 주세요");
    return;
  }
  if (!endOfProject_confirm.checked) {
    if (isEmpty(endOfProject_year) || isEmpty(endOfProject_month) || isEmpty(endOfProject_day)) {
      alert("프로젝트 종료일을 선택해 주세요.");
      return;
    }
  }
  if (checked(devSkill) < 1 || checked(expField) < 1) {
    alert("소유스킬 및 경험분야를 각각 1개 이상 선택해주세요");
    return;
  }
  if (description.length > 900) {
    alert("참고사항은 900자 이내로 적어주세요");
    return;
  }
  if (doNotDev.checked) {
    alert("???");
    return;
  }
}
function isEmpty(str) {
  var flag = false;
  if (str.split(" ").join("") == "") {
    flag = true;
  }
  return flag;
}
function checked(Obj) {
  var leng = Obj.length;
  if (leng == undefined) {
    if (Obj.checked) {
      return 1;
    } else {
      return 0;
    }
  }
  var cnt = 0;
  for (var i = 0; i < leng; i++) {
    if (Obj[i].checked) {
      cnt++;
    }
  }
  return cnt;
}
function regexp(regex, str) {
  var reg = new RegExp(regex);
  if (reg.test(str) == false) {
    return true;
  }
  return false;
}

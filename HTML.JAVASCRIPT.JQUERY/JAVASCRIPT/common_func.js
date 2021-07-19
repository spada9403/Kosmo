function isEmpty(str) {
  var flag = false;
  if (str.split(" ").join("") == "") {
    flag = true;
  }
  return flag;
}

function checkNameReg(str) {
  var flag = false;
  var regExp = new RegExp(/^[가-힣]{2,20}$/);
  if (regExp.test(str)) {
    return flag;
  }
  flag = true;
  return flag;
}

function isValidPattern(regexp, RegStr) {
  var regExp = new RegExp(regexp);
  return regExp.test(RegStr);
}

function getCheckedCnt(Obj) {
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

function isEmail(email) {
  var regExp = new RegExp(/^([a-zA-z0-9_-]+)@([a-z]+)(\.[0-9a-zA-Z_-]+){1,2}$/);
  return regExp.test(email);
}

function getTodayWeek() {
  var today = new Date();
  var weekNo = today.getDay();
  var week = "일요일";
  if (weekNo == 1) {
    week = "월요일";
  } else if (weekNo == 2) {
    week = "화요일";
  } else if (weekNo == 3) {
    week = "수요일";
  } else if (weekNo == 4) {
    week = "목요일";
  } else if (weekNo == 5) {
    week = "금요일";
  } else if (weekNo == 6) {
    week = "토요일";
  }
  return week;
}
//아래와 같이 줄일수 있따.
/*
  function getTodayWeek() {
    return["일요일","월요일","화요일","수요일","목요일","금요일","토요일"][new Date().getDay()];
  }
*/

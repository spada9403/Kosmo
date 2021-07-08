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

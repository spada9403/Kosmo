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
function isEmail(email) {
  var regExp = new RegExp(/^([a-zA-z0-9_-]+)@([a-z]+)(\.[0-9a-zA-Z_-]+){1,2}$/);
  return regExp.test(email);
}

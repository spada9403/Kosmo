export function isEmpty(str) {
  let dataType = typeof str;
  let result = false;
  if (dataType === "string" && (str === "" || str.split(" ").join("") === "")) {
    result = true;
  }

  return result;
}
export function is_from_arr(targetArr, keywordStr) {
  let result = false;
  if (targetArr !== null) {
    if (targetArr.includes(keywordStr)) {
      result = true;
    }
  }

  return result;
}
export function del_dupl(targetArr) {
  if (targetArr != null) {
    for (let i = 0; i < targetArr.length - 1; i++) {
      for (let j = i + 1; j < targetArr.length; j++) {
        if (targetArr[i] === targetArr[j]) {
          targetArr.splice(j, 1);
        }
      }
    }
  }
}

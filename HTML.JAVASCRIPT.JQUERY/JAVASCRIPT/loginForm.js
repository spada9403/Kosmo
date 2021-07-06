function checkForm() {
  //const id = document.getElementsByName("uid")[0].value;
  const id = $("[name=uid]").val();
  const pwd = document.loginForm.pwd.value;
  if (id.split(" ").join("") == "") {
    alert("아이디를 입력해주세요.");
    return;
  } else if (pwd.split(" ").join("") == "") {
    alert("비밀번호를 입력해주세요.");
    return;
  } else {
    document.loginForm.submit();
  }
}

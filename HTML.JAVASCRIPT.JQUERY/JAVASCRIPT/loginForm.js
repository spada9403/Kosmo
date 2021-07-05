function checkForm() {
  //const id = document.getElementsByName("uid")[0].value;
  const id = document.loginForm.uid.value;
  const pwd = document.loginForm.pwd.value;
  if (id.split(" ").join("") == "") {
    alert("아이디를 입력해주세요.");
    return;
  } else if (pwd.split(" ").join("") == "") {
    alert("비밀번호를 입력해주세요.");
    return;
  } else {
    loginDB.
    //document.loginForm.submit();
  }
}

const loginDB = {
  1: {
    id: "abc",
    pwd: "1234",
  },
  2: {
    id: "abc",
    pwd: "1234",
  },
  3: {
    id: "abc",
    pwd: "1234",
  },
  4: {
    id: "abc",
    pwd: "1234",
  },
};

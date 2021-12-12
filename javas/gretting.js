const form = document.querySelector(".js-form"),
    input = form.querySelector("input"),
    greeting = document.querySelector(".js-greetings");
const user_ls = "currentUser",
      showing = "showing";

function saveName(text){
  localStorage.setItem(user_ls, text);
}

function handleSubmit(event){
  event.preventDefault();
  const currentValue = input.value;
  paintGreeting(currentValue);
  saveName(currentValue);
}

function askForName(){
  form.classList.add(showing);
  form.addEventListener("submit", handleSubmit);
}

function paintGreeting(text){
  form.classList.remove(showing);
  greeting.classList.add(showing);
  greeting.innerText = `Hello ${text}`;
}

function loadName(){
  const currentUser = localStorage.getItem(user_ls);
  if(currentUser == null){
    askForName();
  }else{
    paintGreeting(currentUser);
  }
}

function init(){
  loadName();
}
init();

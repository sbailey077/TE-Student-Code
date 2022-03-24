const colors = document.getElementById("colors");
colors.addEventListener("click", event => {
	console.log(event.target.getAttribute('id'));
  if (event.target.nodeName.toLowerCase() === "li") {
    event.target.style.backgroundColor = event.target.innerText;
  }
});

const colors2 = document.getElementById("colors2");
colors2.addEventListener("click", event => {
	console.log(event.target);
  if (event.target.nodeName.toLowerCase() === "li") {
    event.target.style.backgroundColor = event.target.innerText;
  }
});

function addOrange() {
	const orange = document.createElement('li');
	orange.innerText = 'Orange';
	colors.appendChild(orange);
}

document.addEventListener('DOMContentLoaded', () => {
	const button = document.getElementById('btnAddOrange');
	button.addEventListener('click', addOrange);
});
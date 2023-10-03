openMenu.addEventListener('click', () => {
	menu.style.display = "flex"
	menu.style.right = (menu.offsetWidth * -1) + 'px'
	setTimeout(()=> {
		menu.style.opacity = '1'
		menu.style.right = "0"
		openMenu.style.display = 'none'
	}, 10);
})


closeMenu.addEventListener('click', () => {
	menu.style.opacity = '0'
	menu.style.right = (menu.offsetWidth * -1) + 'px'
	setTimeout(()=> {
		menu.removeAttribute('style')
		openMenu.removeAttribute('style')
	}, 200);
})



/**
 * botao de concluir a producao
 */

let btnConcluir = document.querySelectorAll(".btn-success");

btnConcluir.forEach(function(btn) {
    btn.addEventListener("click", concluirProducao);
});

function concluirProducao(event) {
    var qntProduzir = parseFloat(event.target.closest("tr").querySelector(".qntProduzir").textContent);
    var valorProduzido = event.target.closest("tr").querySelector(".valorProduzido");

    console.log(qntProduzir);
    console.log(valorProduzido.value);
    var subt = qntProduzir - parseFloat(valorProduzido.value);
    console.log(subt);
    
    if (subt <= 0) {
        valorProduzido.disabled = true;
    }
}

/**
 * botao de editar a producao
 */
let btnEditar = document.querySelectorAll(".btn-warning");
btnEditar.forEach(function(btn) {
	btn.addEventListener("click", function() {
		var valorProduzido = btn.closest("tr").querySelector(".valorProduzido");
		valorProduzido.disabled = false;
	});
});

/**
 * botao de excluir a producao
 */
var btnDanger = document.querySelectorAll(".btn-danger");
btnDanger.forEach(function(button) {
    button.addEventListener("click", function() {
        var row = this.closest("tr");
        row.remove();
    });
});
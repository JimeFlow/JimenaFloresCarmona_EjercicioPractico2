/* La siguiente función se utiliza para activar la cantidad de elementos seleccionados
 * En las compras utilizando un llamado "ajax" */
function addCard(formulario) {
    var valor = formulario.elements[0].value;
    var url = '/compras/agregar';
    url = url + '/' + valor;
    $("#resultsBlock").load(url);
}

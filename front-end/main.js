document.addEventListener('DOMContentLoaded', function() {
    var elems = document.querySelectorAll('.collapsible');
    var instance = M.Collapsible.init(elems);
  });
  document.addEventListener('DOMContentLoaded', function() {
    var elems = document.querySelectorAll('.materialboxed');
    var instances = M.Materialbox.init(elems);
  });
  document.addEventListener('DOMContentLoaded', function() {
      M.updateTextFields();
  });

    
  function setValue(){
    var value = document.querySelector(".money").value;
    console.log(value);
    const budget = JSON.parse(value);
  }
  
    const item1 = '{ "name":"Cadeira de Madeira", "id": "1"}';
    const item2 = '{ "name":"Mesa de Madeira", "id": "2"}';
    const item3 = '{ "name":"Armario de Madeira", "id": "3"}';
    const item4 = '{ "name":"Cama de Madeira", "id": "4"}';
    const item5 = '{ "name":"Cabeçeira de Madeira", "id": "5"}';
    const item6 = '{ "name":"Bancada de Madeira", "id": "6"}';
    const item7 = '{ "name":"Adega de Madeira", "id": "7"}';
    const item8 = '{ "name":"Nicho de Madeira", "id": "8"}';
    const item9 = '{ "name":"Mesa de Madeira de ambiente externo", "id": "9"}';
    const item10 = '{ "name":"Cadeira de Madeira de ambiente externo", "id": "10"}';

    const obj1 = JSON.parse(item1);
    const obj2 = JSON.parse(item2);
    const obj3 = JSON.parse(item3);
    const obj4 = JSON.parse(item4);
    const obj5 = JSON.parse(item5);
    const obj6 = JSON.parse(item6);
    const obj7 = JSON.parse(item7);
    const obj8 = JSON.parse(item8);
    const obj9 = JSON.parse(item9);
    const obj10 = JSON.parse(item10);
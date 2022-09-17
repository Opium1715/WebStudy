// const vue = new Vue({
//     "el": "#nav-bar",
//     "data": {
//         "Name": "",
//         "lPrice": undefined,
//         "hPrice": undefined,
//         "Type": undefined,
//         "Table": undefined
//     },
//     "methods": {
//         "showValue": function () {
//             vue.Type = document.getElementById("Type").value;
//         },
//         "search": function () {
//             vue.Table=document.getElementById("Table").value;
//             axios({
//                 "method": "post",
//                 "url": "Goods.do?operate=DisplayGoods",
//                 "params": {
//                     "Name": vue.Name,
//                     "lPrice": vue.lPrice,
//                     "hPrice": vue.hPrice,
//                     "Type": vue.Type,
//                     "Table": vue.Table,
//                     "option": "search"
//                 }
//             }).then(function (value) {
//                 console.log(value);
//             }).catch(function (error) {
//                 console.log(error);
//             })
//         }
//     }
// });







let Type = "";
document.getElementById("Type").addEventListener("click",function () {
    Type = document.getElementById("Type").value;
    // if (Type==0) { Type=""; }
})

let order = "";
document.getElementById("Order").addEventListener("click",function () {
    order = "notnull"
})

function search() {
    let Name = document.getElementById("Name").value;
    let Table = document.getElementById("Table").value;
    let LPrice = document.getElementById("lPrice").value;
    let HPrice = document.getElementById("hPrice").value;
    window.location.href="Goods.do?operate=DisplayGoods&Table="+Table+"&Name="+Name+"&lPrice="+LPrice+"&hPrice="+HPrice+
        "&type="+Type+"&option=search"+"&Order="+order;
}

function judge(goodsNo){
   let Bean = getServletPath();
   let Choice = document.getElementById("judge").value;
   // alert(Choice);
   // alert(Bean+".do?operate=Update"+Bean+"&"+Bean+"No="+goodsNo+"&State="+Choice);
   window.location.href=Bean+".do?operate=Update"+Bean+"&"+Bean.toLowerCase()+"No="+goodsNo+"&State="+Choice+"&Table=unjudgedGoods";
}


function getServletPath() {
   let pathname = window.location.pathname;
    return pathname.substring(23, pathname.lastIndexOf(".do"));
}

function remove(ObjectNo){
    let Bean = getServletPath();
    // alert(Bean+".do?operate=Delete"+Bean+"&"+Bean.toLowerCase()+"No="+ObjectNo+"&Table=Goods");
    window.location.href=Bean+".do?operate=Delete"+Bean+"&"+Bean.toLowerCase()+"No="+ObjectNo+"&Table=Goods";
}

function ChangeState(orderNo){
    let State = document.getElementById("State").value;
    window.location.href="Orders.do?operate=UpdateOrder&orderNo="+orderNo+"&orderState="+State;
}

function SearchOrder(){
    let OrderNo = document.getElementById("OrderNo").value;
    window.location.href="Orders.do?option=search&keyword="+OrderNo;
}
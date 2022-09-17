// window.onload=function () {
//     const vue = new Vue({
//         "el": "#Img",
//         "data":{
//             "List":[
//                 {"SrcImg": RenderImg.toString()}
//             ]
//
//         },
//         // "methods": {
//         //     "getSrc": function () {
//         //         axios({
//         //             "method": "post",
//         //             "url": "Goods.do?operate=RenderImg",
//         //             "params": {
//         //                 "ImgSrc": RenderImg(),
//         //             }
//         //         }).then(function (value) {
//         //             console.log(value);
//         //             vue.SrcImg = value.data.ImgSrc;
//         //         }).catch(function (error) {
//         //             console.log(error);
//         //         })
//         //     }
//         // }
//     });
// }
//
// function RenderImg() {
//     let ImgPath=document.getElementById("ImgS").value;
//     alert(ImgPath);
//     return ImgPath;
// }
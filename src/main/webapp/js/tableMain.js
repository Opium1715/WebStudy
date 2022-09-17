function DelUser(No) {
    if(confirm("是否确认删除？")){
        window.location.href="User.do?No="+No+"&operate=DeleteUser";
    }
}

function ModifyUser(No){
    let path = window.location.pathname;
    window.location.href=path+"?No="+No+"&operate=EditUser";
}

function AddUser(){
    window.location.href="User.do?operate=EditUser";
}

function Page(PageNo){
    let path=window.location.pathname;
    window.location.href=path+"?PageNo="+PageNo;
}

function PageInto(TotalPage){
    let inputs = document.getElementById("TurnIntoPage").value;
    console.log(inputs);
    if(inputs > TotalPage){
        alert("超出页面范围！")
        Page(TotalPage);
    }
    else {
        Page(inputs);
    }
}

function Search(){
    let Name = document.getElementById("UserName").value;
    window.location.href="User.do?option=search&keyword="+Name;
}

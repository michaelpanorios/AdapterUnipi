function downloadData(contentType,data,filename){
    var link=document.createElement("A");
    link.setAttribute("href",encodeURI("data:"+contentType+","+data));
    link.setAttribute("style","display:none");
    link.setAttribute("download",filename);
    document.body.appendChild(link); //needed for firefox
    console.log(link.outerHTML);
    link.click();
    setTimeout(function(){
        document.body.removeChild(link);
    },1000);
}

function formToXml(form){
    var xmldata=['<?xml version="1.0" encoding="UTF-8"?>'];
    const elNames = ["author", "title", "genre", "price", "publish_date", "description"];
    xmldata.push("<book>");
    var inputs=form.elements;
    for(var i=0;i<inputs.length;i++){
        var el=document.createElement(elNames[i]);
        if (inputs[i].name){
            el.innerHTML = inputs[i].value;
            xmldata.push(el.outerHTML);
        }
    }
    xmldata.push("</book>");
    return xmldata.join("\n");
}


function download(form){
    var data=formToXml(form);
    console.log(data);
    downloadData("text/xml",data,"book-order.xml");
}


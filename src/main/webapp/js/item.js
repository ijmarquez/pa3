/**
 * Created by Calvin on 4/14/2017.
 */

var idPicked;

function sizeSelect(sizeClick) {
    var sizeID = [document.getElementById("xxs"), document.getElementById("xs"), document.getElementById("s"),
        document.getElementById("m"), document.getElementById("l"), document.getElementById("xl"), document.getElementById("xxl")];
    var id = document.getElementById(sizeClick);
    idPicked = id;
    for(i = 0; i < 7;++i)
    {
        if(sizeID[i] == idPicked)
        {
            id.style.borderColor="red";
            id.style.backgroundColor="yellow";
        }
        else
        {
            sizeID[i].style.borderColor="black";
            sizeID[i].style.backgroundColor="#b0e5f4";
        }
    }
}

function buyItem(img, shirt) {
    if(idPicked==undefined)
        alert("Pick a shirt size");
    else {
        localStorage.setItem('item', shirt);
        localStorage.setItem('size', idPicked.title);
        localStorage.setItem('img', img);
        localStorage.setItem('cost', "10");
        window.location.assign("buyItem.php");
        window.location.href = "index.php?page=buyItem";
    }
}

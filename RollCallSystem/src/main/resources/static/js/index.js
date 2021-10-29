var allName = [
    '张宇航',
    '杨基达',
    '廖荣律',
    '黄祥龙',
    '王浩霖',
    '钟城清',
    '黄晓林',
    '李传杰',
    '王景永',
    '谢智林',
    '陈明瑶',
    '张皓博',
    '张德深',
    '江育杰',
    '何鼎',
    '熊世杰',
    '陈博文',
    '植东海',
    '杨东林',
    '陈冠名',
    '王丽萍',
    '林松疆',
    '胡天健',
    '杨景财',
    '袁暄懿',
    '梁冬乔',
    '林堉鑫',
    '李嘉伟',
    '张嘉可',
    '单仁杰',
    '钱思贤',
    '陈慧锋',
    '黄剑浩',
    '于晴晴'
];

var number = 0;

function runit(){
    number = Math.floor(Math.random() * allName.length);
    var name = document.getElementById('name');
    var btn = document.getElementById('btn');

    name.innerHTML = allName[number];
}

var myTime;
var n = 1;


function start(){
    if(n == 1){
        document.getElementById("states").style.display = "none";
        myTime = setInterval("runit()",80);
        n = 0;
    }
}

function end(){
    if(n == 0){
        alert("请" + number + "号同学" + allName[number] + "同学签到");
        n = 1;

        clearInterval(myTime);
        document.getElementById("states").style.display = "block";
    }
    // location.reload();
}

function tijiao(){
    var state = document.getElementById("state").value;
    if(state != null){
        alert(state);
        document.getElementById("states").style.display = "none";
    }

    $.ajax({
        type: 'POST',
        contentType: 'application/json;charset=utf-8', // 此处注意，不能漏
        url: "/sendDataToMySqlController",
        processData: false, // 这个无所谓，不写的话，后台也一样能正常接收到map
        dataType: 'json',
        data: "id=" + number + "name=" + allName[number] + "state=" + state,
        success: function (data) {
            console.log(data);
        },
        error: function () {
        }
    });

}


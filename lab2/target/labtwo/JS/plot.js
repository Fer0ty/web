setPoints();
function setPoints() {
    let plot = document.getElementById("image"),
        dataSet = document.getElementById("dataSet").innerHTML.split(/\s+/),
        i = 0;
    while (i < dataSet.length - 3) {
        let x = parseFloat(dataSet[i+1]), y = parseFloat(dataSet[i+2]), r = parseFloat(dataSet[i+3]);
         let pointX = 200 + x/r*160, pointY = 200 - y/r*160;
        image.insertAdjacentHTML('beforeend', "<g class = \" point\" transform=\"matrix(1 0 0 1 " + pointX + " " + pointY + ")\"   >" +
            "<path vector-effect=\"non-scaling-stroke\" " +
            "transform=\" translate(-2.54, -2.54)\" " +
            "d=\"M 2.53879 0 C 3.9402 0 5.07758 1.13738 5.07758 2.53879 C 5.07758 3.9402 3.9402 5.07758 2.53879 5.07758 C 1.13738 5.07758 0 3.9402 0 2.53879 C 0 1.13738 1.13738 0 2.53879 0 z\" " +
            "stroke-linecap=\"round\" /> " +
            "</g>");
        i += 3;
    }
}

const array = ['Australia','South Africa','Canada','Switzerland','Denmark','EU','Great Britain','Hong Kong','Croatia','Hungary','Japan','Norway','New Zealand','Poland','Romania','Sweden','Tunisia','Turkey','USA','Bulgaria'];

function setIcon() {
        for(let i = 1; i < 21; i++) {
            var img = document.createElement('img');
            img.src = '/img/'+array[i-1]+'.png';
            var child = document.getElementsByTagName('tr')[i].firstChild;
            document.getElementsByTagName('tr')[i].prepend(img);
        }
}

setIcon();
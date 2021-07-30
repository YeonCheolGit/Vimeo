const requestInit = {
    method: 'GET',
    headers: {
        'Content-Type': 'application/json'
    },
    mode: 'no-cors'
};

const baseUrl = "http://localhost:8080/api/v1/oembed?url="; // spring 서버 핸들러 주소 입니다.

const content = document.getElementById('list'); // 목록 들어갈 위치 입니다.

let extras = ""; // json key, value 목록 임시 저장 변수 입니다.

let getValueInput = () => {
    let inputVimeoUrl = document.getElementById('input-vimeo-url').value

    fetch(baseUrl + inputVimeoUrl, requestInit) // spring 서버 핸들러로 요청 합니다.
        .then(function (response) {
            return response.json();
        })
        .then(function (myJson) {
            let key = Object.keys(myJson.data); // json key
            let value = Object.values(myJson.data); // json value

            for (let i = 0; i < key.length; i++) {
                extras += "<li>" + key[i] + " : " + value[i] + "</li>"
            }
            content.innerHTML = extras;
        })
        .catch(() => {
            alert("올바른 Vimeo 주소를 입력해주세요");
        });
}


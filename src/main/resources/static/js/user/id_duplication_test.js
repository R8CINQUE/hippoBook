{
    function checkLoginId() {
        const userLoginId = document.getElementById('userLoginId').value;
        fetch(`/checkLoginId/${userLoginId}`)
            .then(response => response.json())
            .then(data => {
                if(data.isDuplicate){
                    document.getElementById('result').innerText = '이미 사용중인 아이디입니다.';
                } else {
                    document.getElementById('message').innerText = '사용 가능한 아이디입니다.'
                }
            })
            .catch(error => console.error('에러 발생 : ', error));
    }
}
/**
 * member.js
 * /member/signup.html
 */

window.addEventListener('DOMContentLoaded', function () {
    // 아이디 중복 체크
    const usernameInput = document.querySelector('#username');
    const okDiv = document.querySelector('#ok');
    const nokDiv = document.querySelector('#nok');
    const btnSubmit = document.querySelector('#btnSubmit');
    
    usernameInput.addEventListener('change', function () {
        const username = usernameInput.value;
        axios
        .get('/member/checkid?username=' + username) // GET Ajax 요청 보냄.
        .then(response => {
            console.log(response);
        })
        .catch(err => {
            console.log(err);
        });
        
    });
    
});

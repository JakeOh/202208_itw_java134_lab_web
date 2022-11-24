/**
 * reply.js
 * 댓글 관련 Ajax 기능 구현.
 * /post/detail.html 에 포함됨.
 */
window.addEventListener('DOMContentLoaded', () => {
    // HTML의 Document Object들이 모두 로딩 끝난 후에 코드들이 실행될 수 있도록 하기 위해서.
    readAllReplies(); // 포스트 상세 페이지가 로딩된 후 댓글 목록 화면 출력.
    
    // btnReplyRegister 버튼을 찾고 이벤트 리스너를 등록.
    const btnReplyRegister = document.querySelector('#btnReplyRegister');
    btnReplyRegister.addEventListener('click', registerNewReply);
    
    // 댓글 작성 함수
    function registerNewReply() {
        // 포스트 글 번호 찾음.
        const postId = document.querySelector('#id').value;
        // 댓글 작성자 아이디 찾음.
        const writer = document.querySelector('#writer').value;
        // 댓글 내용 찾음.
        const replyText = document.querySelector('#replyText').value;
        
        // 댓글 작성자와 내용은 비어있으면 안됨.
        if (writer == '' || replyText == '') {
            alert('댓글 내용은 반드시 입력!')
            return; // 메서드 종료
        }
        
        // 댓글 등록 Ajax POST 요청을 보낼 때 서버로 보내는 데이터 작성.
        const data = {
            postId: postId, // 댓글이 달릴 포스트 아이디(번호)
            replyText: replyText, // 댓글 내용
            writer: writer // 댓글 작성자
        }; // JavaScript Object
        
        // Axios 라이브러리를 사용해서 Ajax POST 요청을 보냄.
        axios.post('/api/reply', data) // Ajax Post 요청 보냄.
            .then(response => { // 성공 응답(response)이 도착했을 때 실행할 콜백
                console.log(response);
                alert('#' + response.data + ' 댓글 등록 성공');
                clearInputs(); // 댓글 작성자, 내용에 작성된 문자열을 삭제.
                readAllReplies(); // 댓글 목록을 다시 요청, 갱신.
            })
            .catch(error => { // 실패 응답(error)이 도착했을 때 실행할 콜백
                console.log(error);
            });
        
    }
    
    function clearInputs() {
        document.querySelector('#writer').value = '';
        document.querySelector('#replyText').value = '';
    }
    
    function readAllReplies() {
        const postId = document.querySelector('#id').value; // 댓글이 달려 있는 글 번호
        
        axios
        .get('/api/reply/all/' + postId) // Ajax GET 요청 보냄.
        .then(response => { updateReplyList(response.data) })
        .catch(err => { console.log(err) });
    }
    
    function updateReplyList(data) {
        // 댓글들의 배열(data)을 HTML 영역에 보일 수 있도록 html 코드 작성.
        const divReplies = document.querySelector('#replies');
        
        let str = ''; // div 안에 들어갈 HTML 코드
        for (let r of data) {
            str += '<div class="card my-2">'
                + '<div class="card-header">'
                + '<h5>' + r.writer + '</h5>'
                + '</div>'
                + '<div class="card-body">'
                + '<p>' + r.replyText + '</p>'
                + '<p> 작성 시간: ' + r.createdTime + '</p>'
                + '<p> 수정 시간: ' + r.modifiedTime + '</p>'
                + '</div>'
                + '<div class="card-footer">'
                + `<button type="button" class="btnModifies btn btn-outline-primary" data-rid="${r.replyId}">수정</button>`
                + '</div>'
                + '</div>';
        }
        divReplies.innerHTML = str;
    }
    
});

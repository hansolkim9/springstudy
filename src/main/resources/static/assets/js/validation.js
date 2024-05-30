
// 회원가입 입력 검증 처리

// 계정 중복검사 비동기 요청 보내기
async function fetchDuplicateCheck(type, keyword) {

    const res = await fetch(`http://localhost:8383/members/check?type=${type}&keyword=${keyword}`)

    const flag = await res.json();

    if (type === "account") idFlag = flag;
    else if (type === 'email') emailFlag = flag;

}

// 계정 입력 검증
const $idInput = document.getElementById('user_id');
let idFlag = false;

$idInput.addEventListener('keyup', async e => {

    // 아이디 검사 정규표현식
    const accountPattern = /^[a-zA-Z0-9]{4,14}$/;

    // 입력값 읽어오기
    const idValue = $idInput.value;
    // console.log(idValue);

    // 검증 메시지를 입력할 span
    const $idChk = document.getElementById('idChk');

    if (idValue.trim() === '') {
        $idInput.style.borderColor = 'red';
        $idChk.innerHTML = '<b class="warning">[아이디는 필수값입니다.]</b>';
    } else if (!accountPattern.test(idValue)) {
        $idInput.style.borderColor = 'red';
        $idChk.innerHTML = '<b class="warning">[아이디는 4~14글자 사이 영문, 숫자를 입력하세요.]</b>';
    } else {

        // 아이디 중복검사
        await fetchDuplicateCheck('accout', idValue);

        if (idFlag) {
            $idInput.style.borderColor = 'red';
            $idChk.innerHTML = '<b class="warning">[중복된 아이디 입니다.]</b>';
        } else {
            $idInput.style.borderColor = 'skyblue';
            $idChk.innerHTML = '<b class="success">[사용 가능한 아이디입니다.]</b>';
        }
    }
});


// 패스워드 입력 검증
const $pwInput = document.getElementById('password');


$pwInput.addEventListener('keyup', e => {

    // 패스워드 검사 정규표현식
    // const passwordPattern = /^([a-zA-Z0-9].*[!,@,#,$,%,^,&,*,?,_,~])|([!,@,#,$,%,^,&,*,?,_,~].*[a-zA-Z0-9]).{8,20}$/;
    const passwordPattern = /^(?=.*[a-zA-Z0-9])(?=.*[!,@,#,$,%,^,&,*,?,_,~]).{8,20}$/;


    // 입력 값 읽어오기
    const pwValue = $pwInput.value;
    // 검증 메시지를 입력할 span
    const $pwChk = document.getElementById('pwChk');

    if (pwValue.trim() === '') {
        $pwInput.style.borderColor = 'red';
        $pwChk.innerHTML = '<br><b class="warning">[비밀번호는 필수 입력값 입니다.]</b>';
    } else if (!passwordPattern.test(pwValue)) {
        $pwInput.style.borderColor = 'red';
        $pwChk.innerHTML = '<br><b class="warning">[비밀번호는 영문과 숫자를 포한 최소 8자리를 입력해주세요.]</b>';
    } else {
        $pwInput.style.borderColor = 'skyblue';
        $pwChk.innerHTML = '<br><b class="success">[사용 가능한 비밀번호입니다.]</b>';
    }

});

// 패스워드 확인 검증
const $pwCheckInput = document.getElementById('password_check');

$pwCheckInput.addEventListener('keyup', e => {

    // 입력 값 읽어오기
    const pwCheckValue = $pwCheckInput.value;
    // 검증 메시지 입력할 span
    const $pwChk2 = document.getElementById('pwChk2');

    if (pwCheckValue !== $pwInput.value) {
        $pwCheckInput.style.borderColor = 'red';
        $pwChk2.innerHTML = '<br><b class="warning">[비밀번호가 일치하지 않습니다.]</b>';
    } else {
        $pwCheckInput.style.borderColor = 'skyblue';
        $pwChk2.innerHTML = '<br><b class="success">[비밀번호가 일치합니다.]</b>';
    }
});

// 이름 검사
const $nameInput = document.getElementById('user_name');

$nameInput.addEventListener('keyup', e => {

    const userNameValue = $nameInput.value;
    const $userNameChk = document.getElementById('nameChk');
    const namePattern = /^[가-힣]{2,6}$/;

    if (userNameValue.trim() === '') {
        $nameInput.style.borderColor = 'red';
        $userNameChk.innerHTML = '<br><b class="warning">[이름은 필수 입력값 입니다.]</b>';
    } else if (!namePattern.test(userNameValue)) {
        $nameInput.style.borderColor = 'red';
        $userNameChk.innerHTML = '<br><b class="warning">[이름은 2~6글자 사이 한글을 입력하세요.]</b>';
    } else {
        $nameInput.style.borderColor = 'skyblue';
        $userNameChk.innerHTML = '<br><b class="success">[사용 가능한 이름입니다.]</b>';
    }
});

//

// 이메일 검사
const $emailInput = document.getElementById('user_email');
let eamilFlag = false;

$emailInput.addEventListener('keyup', async e => {

    // 이메일 검사 정규표현식
    const emailPattern = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;

    const userEmailValue = $emailInput.value;

    const $userEmailchk = document.getElementById('emailChk');

    if (userEmailValue.trim() === '') {
        $emailInput.style.borderColor = 'red';
        $userEmailchk.innerHTML = '<br><b class="warning">[이메일은 필수 입력값 입니다.]</b>'
    } else if (!emailPattern.test(userEmailValue)) {
        $emailInput.style.borderColor = 'red';
        $userEmailchk.innerHTML = '<br><b class="warning">[올바른 이메일을 입력해 주세요]</b>'
    } else {
        await fetchDuplicateCheck('email', userEmailValue);
        if (emailFlag) {
            $emailInput.style.borderColor = 'red';
            $userEmailchk.innerHTML = '<b class="warning">[중복된 이메일 입니다.]</b>';
        } else {
            $emailInput.style.borderColor = 'skyblue';
            $userEmailchk.innerHTML = '<b class="success">[사용 가능한 이메일입니다.]</b>';
        }
    }
});



//
// import { BASE_URL } from "./reply.js";
//
// // 댓글 삭제 함수
// export async function deleteReply(replyId) {
//     const res = await fetch(`${BASE_URL}/${replyId}`, {
//         method: 'DELETE'
//     });
//
//     if (res.ok) {
//         fetchReplies();
//     } else {
//         alert('댓글 삭제에 실패했습니다.');
//     }
// }
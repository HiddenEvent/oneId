# 사용자 1
INSERT INTO oneid.users (id, createdAt, entityVersion, modifiedAt, address, roleType, sub)
VALUES ('7dad52ce-0f9b-4071-88d0-2fc551f09131', '2023-10-16 23:05:35.698717', 0, '2023-10-16 23:05:35.698717', '서울시',
        null, '7dad52ce-0f9b-4071-88d0-2fc551f09131');
# 사용자 2
INSERT INTO oneid.users (id, createdAt, entityVersion, modifiedAt, address, roleType, sub)
VALUES ('ab3bf2d6-d968-470b-9c54-21bda10caaa8', '2023-10-08 00:05:08.604177', 0, '2023-10-08 00:05:08.604177', '서울시',
        'ANONYMOUS', null);

# 게시판 1
INSERT INTO oneid.boards (id, createdAt, entityVersion, modifiedAt, content, delYn, notiAt, recommendCnt, title, useYn,
                          createdBy, modifiedBy)
VALUES ('1', '2023-10-24 21:56:25.000000', 1, '2023-10-24 21:56:23.000000', '내용', 'N', '2023-10-24 21:56:46', null,
        '제목', 'Y', '7dad52ce-0f9b-4071-88d0-2fc551f09131', '7dad52ce-0f9b-4071-88d0-2fc551f09131');

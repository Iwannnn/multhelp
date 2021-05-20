import request from '@/utils/request'

// 查询用户聊天列表
export function listChat(query) {
  return request({
    url: '/multhelp/chat/list',
    method: 'get',
    params: query
  })
}

// 查询用户聊天详细
export function getChat(chatid) {
  return request({
    url: '/multhelp/chat/' + chatid,
    method: 'get'
  })
}

// 新增用户聊天
export function addChat(data) {
  return request({
    url: '/multhelp/chat',
    method: 'post',
    data: data
  })
}

// 修改用户聊天
export function updateChat(data) {
  return request({
    url: '/multhelp/chat',
    method: 'put',
    data: data
  })
}

// 删除用户聊天
export function delChat(chatid) {
  return request({
    url: '/multhelp/chat/' + chatid,
    method: 'delete'
  })
}

// 导出用户聊天
export function exportChat(query) {
  return request({
    url: '/multhelp/chat/export',
    method: 'get',
    params: query
  })
}
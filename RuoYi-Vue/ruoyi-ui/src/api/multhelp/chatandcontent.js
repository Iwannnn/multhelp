import request from '@/utils/request'

// 查询聊天会话连接列表
export function listChatandcontent(query) {
  return request({
    url: '/multhelp/chatandcontent/list',
    method: 'get',
    params: query
  })
}

// 查询聊天会话连接详细
export function getChatandcontent(chatid) {
  return request({
    url: '/multhelp/chatandcontent/' + chatid,
    method: 'get'
  })
}

// 新增聊天会话连接
export function addChatandcontent(data) {
  return request({
    url: '/multhelp/chatandcontent',
    method: 'post',
    data: data
  })
}

// 修改聊天会话连接
export function updateChatandcontent(data) {
  return request({
    url: '/multhelp/chatandcontent',
    method: 'put',
    data: data
  })
}

// 删除聊天会话连接
export function delChatandcontent(chatid) {
  return request({
    url: '/multhelp/chatandcontent/' + chatid,
    method: 'delete'
  })
}

// 导出聊天会话连接
export function exportChatandcontent(query) {
  return request({
    url: '/multhelp/chatandcontent/export',
    method: 'get',
    params: query
  })
}
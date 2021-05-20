import request from '@/utils/request'

// 查询消息界面列表
export function listMessage(query) {
  return request({
    url: '/multhelp/message/list',
    method: 'get',
    params: query
  })
}

// 查询消息界面详细
export function getMessage(chatid) {
  return request({
    url: '/multhelp/message/' + chatid,
    method: 'get'
  })
}

// 新增消息界面
export function addMessage(data) {
  return request({
    url: '/multhelp/message',
    method: 'post',
    data: data
  })
}

// 修改消息界面
export function updateMessage(data) {
  return request({
    url: '/multhelp/message',
    method: 'put',
    data: data
  })
}

// 删除消息界面
export function delMessage(chatid) {
  return request({
    url: '/multhelp/message/' + chatid,
    method: 'delete'
  })
}

// 导出消息界面
export function exportMessage(query) {
  return request({
    url: '/multhelp/message/export',
    method: 'get',
    params: query
  })
}
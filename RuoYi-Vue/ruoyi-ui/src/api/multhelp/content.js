import request from '@/utils/request'

// 查询聊天内容列表
export function listContent(query) {
  return request({
    url: '/multhelp/content/list',
    method: 'get',
    params: query
  })
}

// 查询聊天内容详细
export function getContent(contentid) {
  return request({
    url: '/multhelp/content/' + contentid,
    method: 'get'
  })
}

// 新增聊天内容
export function addContent(data) {
  return request({
    url: '/multhelp/content',
    method: 'post',
    data: data
  })
}

// 修改聊天内容
export function updateContent(data) {
  return request({
    url: '/multhelp/content',
    method: 'put',
    data: data
  })
}

// 删除聊天内容
export function delContent(contentid) {
  return request({
    url: '/multhelp/content/' + contentid,
    method: 'delete'
  })
}

// 导出聊天内容
export function exportContent(query) {
  return request({
    url: '/multhelp/content/export',
    method: 'get',
    params: query
  })
}
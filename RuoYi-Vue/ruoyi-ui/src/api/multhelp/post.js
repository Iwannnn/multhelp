import request from '@/utils/request'

// 查询发布帮助列表
export function listPost(query) {
  return request({
    url: '/multhelp/post/list',
    method: 'get',
    params: query
  })
}

// 查询发布帮助详细
export function getPost(postid) {
  return request({
    url: '/multhelp/post/' + postid,
    method: 'get'
  })
}

// 新增发布帮助
export function addPost(data) {
  return request({
    url: '/multhelp/post',
    method: 'post',
    data: data
  })
}

// 修改发布帮助
export function updatePost(data) {
  return request({
    url: '/multhelp/post',
    method: 'put',
    data: data
  })
}

// 删除发布帮助
export function delPost(postid) {
  return request({
    url: '/multhelp/post/' + postid,
    method: 'delete'
  })
}

// 导出发布帮助
export function exportPost(query) {
  return request({
    url: '/multhelp/post/export',
    method: 'get',
    params: query
  })
}
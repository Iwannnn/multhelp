import request from '@/utils/request'

// 查询登陆验证列表
export function listLogin(query) {
  return request({
    url: '/multhelp/login/list',
    method: 'get',
    params: query
  })
}

// 查询登陆验证详细
export function getLogin(session3rd) {
  return request({
    url: '/multhelp/login/' + session3rd,
    method: 'get'
  })
}

// 新增登陆验证
export function addLogin(data) {
  return request({
    url: '/multhelp/login',
    method: 'post',
    data: data
  })
}

// 修改登陆验证
export function updateLogin(data) {
  return request({
    url: '/multhelp/login',
    method: 'put',
    data: data
  })
}

// 删除登陆验证
export function delLogin(session3rd) {
  return request({
    url: '/multhelp/login/' + session3rd,
    method: 'delete'
  })
}

// 导出登陆验证
export function exportLogin(query) {
  return request({
    url: '/multhelp/login/export',
    method: 'get',
    params: query
  })
}
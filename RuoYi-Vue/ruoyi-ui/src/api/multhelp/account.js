import request from '@/utils/request'

// 查询用户账号列表
export function listAccount(query) {
  return request({
    url: '/multhelp/account/list',
    method: 'get',
    params: query
  })
}

// 查询用户账号详细
export function getAccount(openid) {
  return request({
    url: '/multhelp/account/' + openid,
    method: 'get'
  })
}

// 新增用户账号
export function addAccount(data) {
  return request({
    url: '/multhelp/account',
    method: 'post',
    data: data
  })
}

// 修改用户账号
export function updateAccount(data) {
  return request({
    url: '/multhelp/account',
    method: 'put',
    data: data
  })
}

// 删除用户账号
export function delAccount(openid) {
  return request({
    url: '/multhelp/account/' + openid,
    method: 'delete'
  })
}

// 导出用户账号
export function exportAccount(query) {
  return request({
    url: '/multhelp/account/export',
    method: 'get',
    params: query
  })
}
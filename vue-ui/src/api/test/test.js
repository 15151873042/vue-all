import request from '@/utils/request'

// 查询字典数据列表
export function test(params) {
    return request({
        url: '/test/test',
        method: 'get',
        params: params
    })
}

export function error(params) {
    return request({
        url: '/test/error',
        method: 'get',
        params: params
    })
}

export function dataForm(data) {
    return request({
        url: '/test/data/form',
        method: 'post',
        data: data,
    })
}

export function dataJson(data) {
    return request({
        url: '/test/data/json',
        method: 'post',
        data: data,
    })
}

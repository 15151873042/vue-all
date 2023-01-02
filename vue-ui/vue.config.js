console.log(process.env.port)
console.log(process.env.VUE_APP_TITLE)
console.log(process.env.VUE_APP_BASE_API)

const port = process.env.port  || 80
const backEndUrl = process.env.VUE_APP_BACK_END_URL

module.exports = {
    lintOnSave: true, //关闭语法检查（不然导入一个变量不使用也会提示错误）
    devServer: {
        port: port,
        proxy: {
            [process.env.VUE_APP_BASE_API] : {
                target: backEndUrl,
                changeOrigin: true, // changeOrigin设置为true时，服务器收到的请求头中的host为：localhost:7777（测试后发现无效，但是浏览器显示正确）
                pathRewrite: {
                    ['^' + process.env.VUE_APP_BASE_API]: '' // url中重写，类似nginx，去除前缀
                }
            }
        }
    },

}